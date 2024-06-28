package com.nemopss.mospolytech.pages;

import com.nemopss.BasePage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.util.List;

public class MainMospolytechPage extends BasePage {

    @FindBy(xpath = "//div[@class='navigation-menu__left-nav']//a[contains(@href,'/')]")
    private List<WebElement> leftMenu;

    @FindBy(xpath = "//h1")
    private WebElement title;

    @Step("Titles comparison")
    public MainMospolytechPage checkTitle(String expectedTitle) {
        Assert.assertEquals("❌ Titles are not equal!", expectedTitle, title.getText());
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Page loaded");
        return pageManager.getMainMospolytechPage();
    }

    @Step("Pressing schedule button")
    public ScheduleMospolytechPage clickLeftMenuButton(String buttonName) {
        for (WebElement button : leftMenu) {
            if (button.getAttribute("title").contains(buttonName)) {
                button.click();
                break;
            }
        }
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Button pressed");
        return pageManager.getScheduleMospolytechPage();
    }
}
