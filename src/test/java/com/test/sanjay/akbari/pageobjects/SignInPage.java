package com.test.sanjay.akbari.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {



    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//form[@id='login_form']//input[preceding-sibling::label[text()='Email address']]")
    WebElement signInEmailAddressBox;

    @FindBy(xpath = "//form[@id='login_form']//input[@id='passwd']")
    WebElement signInPassword;

    @FindBy(xpath = "//form[@id='login_form']//button[@type='submit']")
    WebElement signInSubmitButton;

    public void setEmailAddressForSignIn(String value) {
        signInEmailAddressBox.sendKeys(value);
    }

    public void setPasswordForSignIn(String value) {
        signInPassword.sendKeys(value);
    }

    public void submit() {
        signInSubmitButton.click();
    }


}
