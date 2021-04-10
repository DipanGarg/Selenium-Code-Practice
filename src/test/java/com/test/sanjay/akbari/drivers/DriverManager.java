package com.test.sanjay.akbari.drivers;

import com.test.sanjay.akbari.utils.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private WebDriver driver;

    public WebDriver getDriver() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return driver;
        }
        return driver;
    }

    public void launchApplication() {
        getDriver().get(ConfigProvider.getProperty("url"));
    }

}
