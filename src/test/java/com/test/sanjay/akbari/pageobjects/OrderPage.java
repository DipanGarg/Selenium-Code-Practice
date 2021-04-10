package com.test.sanjay.akbari.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage {

    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private String orderReferenceNumber;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutAtSummaryScreen;

    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement proceedToCheckoutAtAddressScreen;

    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement proceedToCheckoutAtShippingScreen;

    @FindBy(xpath = "//div[@class='order_carrier_content box']//input[@type='checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//p[@class='payment_module']//a[@class='bankwire']")
    WebElement paymentByWire;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']//span[contains(text(),'confirm')]")
    WebElement confirmOrder;

    @FindBy(xpath = "//a[@title='Back to orders']")
    WebElement backToOrders;

    @FindBy(xpath = "//div[@id='center_column']/div")
    WebElement wireDetails;

    @FindBy(xpath = "//table[@id='order-list']/tbody//a[@class='color-myaccount']")
    List<WebElement> orderReferencesList;


    public void clickProceedToCheckoutAtSummaryScreen() {
        proceedToCheckoutAtSummaryScreen.click();
    }

    public void clickProceedToCheckoutAtAddressScreen() {
        proceedToCheckoutAtAddressScreen.click();
    }

    public void selectCheckBoxAtShippingScreen() {
        if (!checkbox.isSelected())
            checkbox.click();
    }

    public void clickProceedToCheckoutAtShippingScreen() {
        proceedToCheckoutAtShippingScreen.click();
    }

    public void doPaymentByWire() {
        paymentByWire.click();
    }

    public void confirmOrder() {
        confirmOrder.click();
    }

    private void getOrderReferenceNumber() {
        orderReferenceNumber = wireDetails.getText().split("-")[5].split("reference")[1].split("in")[0].trim();
    }

    public void backToOrders() {
        getOrderReferenceNumber();
        backToOrders.click();
    }

    public void assertOrderIsPresentInOrderHistory() {
        boolean isOrderPresentInOrderHistoryTable = orderReferencesList.stream().map(WebElement::getText).anyMatch(s -> s.equals(orderReferenceNumber));
        Assert.assertTrue("Order is not present in order history table", isOrderPresentInOrderHistoryTable);
    }

}
