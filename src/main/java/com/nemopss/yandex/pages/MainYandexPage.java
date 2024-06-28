package com.nemopss.yandex.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nemopss.BasePage;

import java.util.List;

public class MainYandexPage extends BasePage {

    @FindBy(xpath = "//link[contains(@rel,'canonical')]")
    private WebElement link;

    @FindBy(xpath = "//div[@data-baobab-name='catalog']/button")
    private WebElement catalogButton;

    @FindBy(xpath = "//li[@data-zone-name='category-link']/a")
    private List<WebElement> categoryList;

    @FindBy(xpath = "//div[@data-zone-name='link']/a")
    private List<WebElement> subcategoryList;

    @FindBy(xpath = "//ul[@data-autotest-id]//li//a")
    private List<WebElement> menuItemList;

    @Step("Page opening check")
    public MainYandexPage checkOpenPage() {
        waitSeconds(15);
        Assert.assertTrue("Page not opened!", link.getAttribute("href").contains("market.yandex"));
        System.out.println("✅ Page opened!");
        return pageManager.getMainYandexPage();
    }

    @Step("Open catalog")
    public MainYandexPage clickOnCatalog() {
        waitUntilElementToBeClickable(catalogButton);
        buttonClick(catalogButton);
        System.out.println("✅ Catalog is opened");
        return this;
    }

    @Step("Move to '{category}'")
    public MainYandexPage moveToCategory(String category) {
        for (WebElement element : categoryList) {
            waitUntilElementToBeVisible(element);
            moveToElement(element);
            if (element.findElement(By.xpath("./span")).getText().equals(category)) {
                System.out.println("✅ Moved to '" + category + "'");
                return this;
            }
        }
        Assert.fail("No category '" + category + "'");
        return this;
    }

    @Step("Move to'{subcategory}' and open '{menuItem}'")
    public XboxPage moveToSubcategoryAndClickMenuItem(String subcategory, String menuItem) {
        for (WebElement element : subcategoryList) {
            waitUntilElementToBeVisible(element);
            moveToElement(element);
            if (element.getText().equals(subcategory)) {
                System.out.println("✅ Moved to '" + subcategory + "'");
                int count = 0;
                for (WebElement item : menuItemList) {
                    waitUntilElementToBeVisible(item);
                    if (item.getText().equals(menuItem)) {
                        count++;
                        if (count == 2) {
                            moveToElement(item);
                            buttonClick(item);
                            System.out.println("✅ Menu item '" + menuItem + "' opened");
                            return pageManager.getXboxPage();
                        }
                    }
                }
                Assert.fail("No subcategory item '" + menuItem + "' in '" + subcategory
                        + "'");
            }
        }
        Assert.fail("No subcategory '" + subcategory + "'");
        return pageManager.getXboxPage();
    }

}
