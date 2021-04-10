package com.test.sanjay.akbari.stepdefinitions;

import com.test.sanjay.akbari.drivers.DriverManager;
import com.test.sanjay.akbari.pageobjects.HomePage;
import com.test.sanjay.akbari.pageobjects.OrderPage;
import com.test.sanjay.akbari.pageobjects.SignInPage;
import com.test.sanjay.akbari.utils.ConfigProvider;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SeleniumStepDef {

    private DriverManager driverManager = new DriverManager();
    private HomePage homePage = new HomePage(driverManager.getDriver());
    private SignInPage signInPage = new SignInPage(driverManager.getDriver());
    private OrderPage orderPage = new OrderPage(driverManager.getDriver());

    @Given("User launches the Application")
    public void userLaunchesTheApplication() {
        driverManager.launchApplication();
    }

    @Given("do the SignIn")
    public void doTheSignIn() {
        homePage.signIn();
        signInPage.setEmailAddressForSignIn(ConfigProvider.getProperty("username"));
        signInPage.setPasswordForSignIn(ConfigProvider.getProperty("password"));
        signInPage.submit();
    }

    @When("user adds tShirt into the cart")
    public void userAddsTShirtIntoTheCart() {
        homePage.selectTShirts();
        homePage.addTShirtToCart();
    }

    @When("checkout the order")
    public void checkoutTheOrder() {
        homePage.clickProceedToCheckout();
        orderPage.clickProceedToCheckoutAtSummaryScreen();
        orderPage.clickProceedToCheckoutAtAddressScreen();
        orderPage.selectCheckBoxAtShippingScreen();
        orderPage.clickProceedToCheckoutAtShippingScreen();
        orderPage.doPaymentByWire();
        orderPage.confirmOrder();
        orderPage.backToOrders();
    }

    @Then("verify order is present in order history")
    public void verifyOrderIsPresentInOrderHistory() {
        orderPage.assertOrderIsPresentInOrderHistory();
    }

    @When("user clicks my personal information")
    public void userClicksMyPersonalInformation() {
        homePage.clickMyPersonalInformation();
    }

    @When("update the first name")
    public void updateTheFirstName() {
        homePage.setFirstName(ConfigProvider.getProperty("firstName"));
    }

    @When("update password")
    public void updatePassword() {
        homePage.setOldPassword(ConfigProvider.getProperty("password"));
        homePage.setNewPassword(ConfigProvider.getProperty("password"));
        homePage.setConfirmation(ConfigProvider.getProperty("password"));
        homePage.clickSaveButton();
    }

    @Then("verify personal information has successfully updated message")
    public void verifyPersonalInformationHasSuccessfullyUpdatedMessage() {
        Assert.assertEquals("Your personal information has been successfully updated.", homePage.getConfirmationMessage());
    }

    @After
    public void cleanup() {
        if (driverManager.getDriver() != null)
            driverManager.getDriver().close();
    }
}
