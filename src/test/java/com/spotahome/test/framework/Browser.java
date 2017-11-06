package com.spotahome.test.framework;

import com.spotahome.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;

    public Browser() {
        initialize();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void close() {
        driver.close();
    }

    public <T> T getPage(Class<T> classType) {
        try {
            T page = classType.getConstructor().newInstance();
            ((BasePage) page).setBrowser(this);
            PageFactory.initElements(driver, page);

            return page;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void initialize() {
        driver = CreateChromeDriver(); //Choose desired webdriver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private WebDriver CreateChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/webdrivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //Setup desired options here

        return new ChromeDriver(options);
    }

    private WebDriver CreateFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        //Setup desired options here

        return new FirefoxDriver(options);
    }
}
