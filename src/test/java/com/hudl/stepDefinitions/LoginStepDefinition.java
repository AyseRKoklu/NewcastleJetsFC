package com.hudl.stepDefinitions;

import com.hudl.utilities.CommonSteps;
import com.hudl.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonSteps {

    @Given("user is on the main Hudl page")
    public void userIsOnTheMainHudlPage() {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, ConfigurationReader.get("url"));
    }

    @And("user clicks on the Hudl login button")
    public void userClicksOnTheHudlLoginButton() {
        clickWithJS(loginPage.hudlLogin);
    }

    @And("user is on the login page")
    public void userIsOnTheLoginPage() {
        waitForVisible(loginPage.emailInputBox, 20);
        String currentUrl = driver.getCurrentUrl();
        String expectedEndPoint = "/login";
        Assert.assertTrue("url does not contain " + expectedEndPoint, currentUrl.contains(expectedEndPoint));
        assert loginPage.emailInputBox.isDisplayed();
        assert loginPage.forgotPasswordButton.isEnabled();
    }

    @When("user enters {string} username and {string} password")
    public void userEntersUsernameAndPassword(String email, String password) {
        clickWithJS(loginPage.emailInputBox);
        loginPage.emailInputBox.sendKeys(email);
        clickWithJS(loginPage.passwordInputBox);
        loginPage.passwordInputBox.sendKeys(password);
    }

    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        waitForClickable(loginPage.loginButton, 20);
        clickWithJS(loginPage.loginButton);
    }

    @And("user clicks on the continue button")
    public void userClicksOnTheContinueButton() {
        clickWithJS(loginPage.continueButton);
    }

    @Then("verify the home page is displayed")
    public void verifyTheHomePageIsDisplayed() {
        waitForVisible(loginPage.pageHeaderNewcastleJets, 10);
        String currentUrl = driver.getCurrentUrl();
        String expectedEndPoint = "/home";
        Assert.assertTrue("url does not contain " + expectedEndPoint, currentUrl.contains(expectedEndPoint));
        assert loginPage.pageHeaderNewcastleJets.isDisplayed();
    }

    @Then("verify error messages with {string} error type")
    public void verifyErrorMessagesWithErrorType(String errorType) {
        assert loginPage.continueButton.isEnabled();
        clickWithJS(loginPage.continueButton);
        switch (errorType) {
            case "invalid credentials":
                waitForVisible(loginPage.dontRecogniseEmailOrPasswordErrorMessage, 10);
                assert loginPage.dontRecogniseEmailOrPasswordErrorMessage.isDisplayed();
                break;
            case "email required":
                waitForVisible(loginPage.pleaseFillAllFieldsErrorMessage, 10);
                Assert.assertFalse(loginPage.continueButton.isEnabled());
                assert loginPage.emailRequiredErrorMessage.isDisplayed();
                assert loginPage.pleaseFillAllFieldsErrorMessage.isDisplayed();
                Assert.assertFalse(loginPage.usernameHelpText.isDisplayed());
                break;
            case "password required":
                waitForVisible(loginPage.pleaseFillAllFieldsErrorMessage, 10);
                Assert.assertFalse(loginPage.continueButton.isEnabled());
                assert loginPage.passwordRequiredErrorMessage.isDisplayed();
                assert loginPage.pleaseFillAllFieldsErrorMessage.isDisplayed();
                break;
            default:
                System.out.println("Invalid error type");
        }
    }
}
