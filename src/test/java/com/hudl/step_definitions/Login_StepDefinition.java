package com.hudl.step_definitions;

import com.hudl.pages.PageInitializer;
import com.hudl.utilities.ConfigurationReader;
import com.hudl.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinition extends PageInitializer {

    @Given("the user is on the main Hudl page")
    public void theUserIsOnTheMainHudlPage() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @And("the user clicks on the Hudl login button")
    public void theUserClicksOnTheHudlLoginButton() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.loginButton.click();
        loginPage.hudlLogin.click();
    }

    @And("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        String currentUrl = driver.getCurrentUrl();
        String expectedEndPoint = "/login";
        Assert.assertTrue("url does not contain " + expectedEndPoint, currentUrl.contains(expectedEndPoint));
        Assert.assertTrue(loginPage.emailInputBox.isDisplayed());
    }

    @When("the user enters valid {string} username and {string} password")
    public void theUserEntersValidUsernameAndPassword(String email, String password) {
        loginPage.emailInputBox.click();
//        assert loginPage.emailInputBox.isDisplayed();
        loginPage.emailInputBox.sendKeys(email);
        loginPage.passwordInputBox.click();
        loginPage.passwordInputBox.sendKeys(password);
    }

    @And("clicks on the login button")
    public void clicksOnTheLoginButton() {
        loginPage.loginButton.click();
    }

    @And("clicks on the continue button")
    public void clicksOnTheContinueButton() {
        loginPage.continueButton.click();
    }

    @Then("verify the home page is displayed")
    public void verifyTheHomePageIsDisplayed() {
        String currentUrl = driver.getCurrentUrl();
        String expectedEndPoint = "/home";
        Assert.assertTrue("url does not contain " + expectedEndPoint, currentUrl.contains(expectedEndPoint));
        Assert.assertTrue(loginPage.pageHeaderNewcastleJets.isDisplayed());
    }

    @When("the user enters invalid {string} username and {string} password")
    public void theUserEntersInvalidUsernameAndPassword(String email, String password) {
        loginPage.emailInputBox.click();
        loginPage.emailInputBox.sendKeys(email);
        loginPage.passwordInputBox.click();
        loginPage.passwordInputBox.sendKeys(password);
    }

    @Then("verify error messages with {string} error type")
    public void verifyErrorMessagesWithErrorType(String errorType) {

        switch (errorType) {
            case "We don't recognize that email and/or password":
                Assert.assertTrue(loginPage.errorMessage.isDisplayed());
                break;
            case "email required":
                Assert.assertTrue(loginPage.emailRequiredErrorMessage.isDisplayed());

                break;
            case "password required":
                Assert.assertTrue(loginPage.passwordRequiredErrorMessage.isDisplayed());
                break;
            default:
                System.out.println("Invalid error type");
        }
    }
}
