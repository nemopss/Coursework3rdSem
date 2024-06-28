package com.nemopss.managers;

import java.time.Duration;

import static com.nemopss.utils.Constants.IMPLICITLY_WAIT;
import static com.nemopss.utils.Constants.PAGE_LOAD_TIMEOUT;

public class InitManager {
    private static final TestPropertiesManager props = TestPropertiesManager.getInstance();
    private static final DriverManager driverManager = DriverManager.getInstance();

    public static void initFramework(){
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT))));
        driverManager.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT))));
    }

    public static void quitFramework(){
        driverManager.quitDriver();
    }
}
