package com.nemopss.lambda.pages;

import com.nemopss.BasePage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.LocalDateTime;

import java.util.List;

public class MainLambdaPage extends BasePage {

    @FindBy(xpath = "//h2")
    private WebElement pageName;

    @FindBy(xpath = "//span[@class='ng-binding']")
    private WebElement remainingText;

    @FindBy(xpath = "//input[@name]/../span")
    private List<WebElement> items;

    @FindBy(xpath = "//input[@name]")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//input[@id=\"sampletodotext\"]")
    private WebElement addInput;

    @FindBy(xpath = "//input[@id='addbutton']")
    private WebElement addButton;

    @Step("Title comparison")
    public MainLambdaPage checkTitle() {
        Assert.assertEquals("❌ Unequal titles!", "LambdaTest Sample App", pageName.getText());
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Titles are equal");
        return pageManager.getLambdaPage();
    }

    @Step("Remaining text comparison")
    public MainLambdaPage checkRemainingCount(int notEndCounter, int itemCounter) {
        Assert.assertEquals("❌ Text not equal!", notEndCounter + " of " + itemCounter + " remaining",
                remainingText.getText());
        System.out.print(LocalDateTime.now().toString() + " ");
        System.out.println("✅ Remaining text is equal");
        return pageManager.getLambdaPage();
    }

    @Step("'{itemNo}' not crossed check")
    public MainLambdaPage checkItemNotCrossed(int itemNo) {
        WebElement item = items.get(itemNo - 1);
        Assert.assertEquals("❌ Element crossed!", "done-false", item.getAttribute("class"));
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Element " + itemNo + " found and not crossed");
        return pageManager.getLambdaPage();
    }

    @Step("Check box and check crossing of '{itemNo}'")
    public MainLambdaPage clickItemCheckbox(int itemNo) {
        WebElement item = items.get(itemNo - 1);
        WebElement itemCheckbox = checkboxes.get(itemNo - 1);
        itemCheckbox.click();
        Assert.assertTrue("❌ Element " + itemNo + " not checked!", item.getAttribute("class").equals("done-true"));
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Element " + itemNo + " checked");
        checkRemainingCount(items.size() - itemNo, items.size());
        return pageManager.getLambdaPage();
    }

    @Step("New item creation")
    public MainLambdaPage createItem() {
        fillInput(addInput, "Manual new item");
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Item name inserted");
        buttonClick(addButton);
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Button pressed");
        return pageManager.getLambdaPage();
    }

    @Step("Element visibility check")
    public MainLambdaPage checkItemVisibility(int itemNo) {
        WebElement item = items.get(itemNo - 1);
        Assert.assertTrue("❌ Element not visible!", item.isDisplayed());
        Assert.assertEquals("❌ Element crossed!", "done-false", item.getAttribute("class"));
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Element 6 created and not crossed");
        return pageManager.getLambdaPage();
    }
}
