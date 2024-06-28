package com.nemopss.yandex.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nemopss.BasePage;

import java.util.List;

public class FavoritesPage extends BasePage {

    @FindBy(xpath = "//div[@data-auto-themename='quick']")
    private List<WebElement> favoriteProduct;

    @FindBy(xpath = "//button[@title='Удалить из избранного']")
    private WebElement removeFromFavoritesButton;

    @FindBy(xpath = "//div[@data-auto='notification']")
    private WebElement successNotification;

    @FindBy(xpath = "//div[@data-auto='emptyState']//span")
    private WebElement loginMessage;

    private String firstProductTitle;
    private String firstProductPrice;

    public FavoritesPage(String title, String price) {
        this.firstProductTitle = title;
        this.firstProductPrice = price;

    }

    @Step("Check favourites")
    public FavoritesPage verifyAddedProductInFavorites() {
        WebElement firstProduct = favoriteProduct.get(0);
        String title = firstProduct.findElement(By.xpath(".//h3")).getText();
        String price = firstProduct.findElement(By.xpath(".//span[@data-auto='snippet-price-current']/span[1]"))
                .getText();
        Assert.assertEquals("Unexpected title", firstProductTitle, title);
        Assert.assertEquals("Unexpected price", firstProductPrice, price);
        System.out.println("Item " + firstProductTitle + " is located at" + firstProductPrice);
        return this;
    }

    @Step("Delete from favourites")
    public FavoritesPage removeFromFavorites() {
        moveToElement(removeFromFavoritesButton);
        removeFromFavoritesButton.click();
        System.out.println("Deleted from favourites");
        wait.until(ExpectedConditions.visibilityOf(successNotification));
        return this;
    }

    @Step("Check if deleted from favourites")
    public FavoritesPage verifyRemovedFromFavorites() {
        waitUntilElementToBeVisible(successNotification);
        Assert.assertTrue("No pop-up about deletion",
                successNotification.isDisplayed());
        System.out.println("Notification popped up");
        Assert.assertFalse("Item wasn't deleted from favourites",
                favoriteProduct.stream()
                        .anyMatch(product -> product.getText().contains(firstProductTitle)));
        System.out.println("Item successfully deleted from favourites");
        return this;
    }

    @Step("Login window check")
    public FavoritesPage verifyLoginMessage() {
        Assert.assertTrue("No login window",
                loginMessage.isDisplayed());
        System.out.println("Login window is presented");
        return this;
    }
}
