package com.nemopss.mospolytech.pages;

import com.nemopss.BasePage;
import io.qameta.allure.Step;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScheduleMospolytechPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//a[@href='https://rasp.dmami.ru/']")
    private WebElement openSiteButton;

    @Step("Title comparison")
    public ScheduleMospolytechPage checkTitle(String expectedTitle) {
        Assert.assertEquals("❌ Titles are not equal", expectedTitle, title.getText());
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Page loaded");
        return pageManager.getScheduleMospolytechPage();
    }

    @Step("Scrolling to schedule button and clicking it")
    public MainSchedulePage clickOpenSiteButton() {
        scrollToElement(openSiteButton);
        buttonClick(openSiteButton);
        selectLastTab();
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Button pressed");
        return pageManager.getMainSchedulePage();
    }
}
