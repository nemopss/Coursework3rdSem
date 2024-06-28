package com.nemopss.yandex.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nemopss.BasePage;

import java.util.List;

public class XboxPage extends BasePage {

    @FindBy(xpath = "//div[@data-auto-themename='listDetailed']")
    private List<WebElement> productList;

    @FindBy(xpath = "//button[@title='Добавить в избранное']")
    private WebElement addToFavoritesButton;

    @FindBy(xpath = "//div[@data-baobab-name='favorites']")
    private WebElement favoritesButton;

    @FindBy(xpath = "//div[@data-auto='notification']")
    private WebElement successNotification;

    private String firstProductTitle;
    private String firstProductPrice;

    @Step("Log first 5 items")
    public XboxPage logProducts() {
        for (int i = 0; i < 5; i++) {
            WebElement product = productList.get(i);
            moveToElement(product);

            String name = product.findElement(By.xpath(".//h3")).getText();
            String price = product.findElement(By.xpath(".//span[@data-auto='snippet-price-current']/span[1]"))
                    .getText();
            System.out.println("Title: " + name + "; Price: " + price);
        }
        return this;
    }

    @Step("Remember first 5 items")
    public XboxPage rememberFirstProduct() {
        WebElement firstProduct = productList.get(0);
        firstProductTitle = firstProduct.findElement(By.xpath(".//h3")).getText();
        firstProductPrice = firstProduct.findElement(By.xpath(".//span[@data-auto='snippet-price-current']/span[1]"))
                .getText();
        System.out.println("Remembered title: " + firstProductTitle + "; Price: " + firstProductPrice);
        return this;
    }

    @Step("Add first item to favourites")
    public XboxPage addToFavorites() {
        moveToElement(addToFavoritesButton);
        addToFavoritesButton.click();
        return this;
    }

    @Step("Pop-up notification check")
    public XboxPage verifyAddToFavoritesSuccess() {
        waitUntilElementToBeVisible(successNotification);
        Assert.assertTrue("No pop-up window",
                successNotification.isDisplayed());
        System.out.println("Pop-up is visible");
        return this;
    }

    @Step("Go to favourites")
    public FavoritesPage goToFavorites() {
        waitUntilElementToBeClickable(favoritesButton);
        buttonClick(favoritesButton);
        return pageManager.getFavoritesPage(firstProductTitle, firstProductPrice);
    }

}
