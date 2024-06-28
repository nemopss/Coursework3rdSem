package com.nemopss.managers;

import com.nemopss.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private WebDriver driver;

    private static final TestPropertiesManager testPropertiesManager = TestPropertiesManager.getInstance();

    private static DriverManager INSTANCE;

    private DriverManager(){
    }

    public static DriverManager getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver(){
        if (driver == null){
            initDriver();
        }
        return driver;
    }

    private void initDriver(){
        System.setProperty("webdriver.chrome.driver", testPropertiesManager.getProperty(Constants.PATH_CHROME_DRIVER_MAC)); //Подключаем веб-драйвер chrome
        driver = new ChromeDriver();
    }

    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
