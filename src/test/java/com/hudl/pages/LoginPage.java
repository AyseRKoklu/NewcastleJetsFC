package com.hudl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPageElements {

    @FindBy(xpath = "//a[@class='mainnav__item mainnav__item--expandable']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@data-qa-id='login-hudl']")
    public WebElement hudlLogin;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "logIn")
    public WebElement continueButton;

    @FindBy(xpath = "//p[.=\"We don't recognize that email and/or password\"]")
    public WebElement dontRecogniseEmailOrPasswordErrorMessage;

    @FindBy(xpath = "//p[.=\"Please fill in all of the required fields\"]")
    public WebElement pleaseFillAllFieldsErrorMessage;

    @FindBy(id = "username-helptext")
    public WebElement usernameHelpText;

    @FindBy(xpath = "//div[@id=\"username-container\"]//span[.=\"Required\"]")
    public WebElement emailRequiredErrorMessage;

    @FindBy(xpath = "//div[@id=\"password-container\"]//span[.=\"Required\"]")
    public WebElement passwordRequiredErrorMessage;

    @FindBy(xpath = "//span[.=\"Newcastle Jets FC\"]")
    public WebElement pageHeaderNewcastleJets;

    @FindBy(id = "forgot-password")
    public WebElement forgotPasswordButton;
}
