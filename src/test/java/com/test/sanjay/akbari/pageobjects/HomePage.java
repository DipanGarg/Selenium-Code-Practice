package com.test.sanjay.akbari.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private Actions actions;

    public HomePage(WebDriver driver) {
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signIn;

    @FindBy(xpath = "//a[@title='Information']")
    WebElement myPersonalInformation;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstNameBox;

    @FindBy(xpath = "//input[@name='old_passwd']")
    WebElement oldPassword;

    @FindBy(xpath = "//input[@name='passwd']")
    WebElement newPassword;

    @FindBy(xpath = "//input[@name='confirmation']")
    WebElement confirmation;

    @FindBy(xpath = "//button[@name='submitIdentity']")
    WebElement saveButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement confirmationMessage;

    @FindBy(xpath = "//li[preceding-sibling::li//a[@title='Dresses']]//a[@title='T-shirts']")
    WebElement tshirts;

    @FindBy(xpath = "//div[@class='product-container']")
    WebElement tShirtBox;

    @FindBy(xpath = "//a[@title='Add to cart']")
    WebElement addToCart;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckout;

    public void signIn() {
        signIn.click();
    }

    public void selectTShirts() {
        tshirts.click();
    }

    public void addTShirtToCart() {
        actions.moveToElement(tShirtBox).click(addToCart).build().perform();
    }

    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }

    public void clickMyPersonalInformation() {
        myPersonalInformation.click();
    }

    public String getFirstName() {
        return firstNameBox.getAttribute("value");
    }

    public void setFirstName(String firstName) {
        firstNameBox.clear();
        firstNameBox.sendKeys(firstName);
    }

    public void setOldPassword(String value) {
        oldPassword.sendKeys(value);
    }

    public void setNewPassword(String value) {
        newPassword.sendKeys(value);
    }

    public void setConfirmation(String value) {
        confirmation.sendKeys(value);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

}
