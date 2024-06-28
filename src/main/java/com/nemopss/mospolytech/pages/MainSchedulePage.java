package com.nemopss.mospolytech.pages;

import com.nemopss.BasePage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.util.List;

public class MainSchedulePage extends BasePage {

    @FindBy(xpath = "//h4")
    private WebElement title;

    @FindBy(xpath = "//input[@class='groups']")
    private WebElement input;

    @FindBy(xpath = "//div[contains(@class,'group') and @id]")
    private List<WebElement> scheduleButtons;

    @FindBy(xpath = "//div[@class = 'schedule']")
    private WebElement schedule;

    @FindBy(xpath = "//div[contains(@class,'schedule-day__title')]")
    private List<WebElement> scheduleDays;

    @Step("Title comparison")
    public MainSchedulePage checkTitle() {
        Assert.assertEquals("❌ Titles are nod equal", "Расписание занятий", title.getText());
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Page loaded");
        return pageManager.getMainSchedulePage();
    }

    @Step("Group ID insertion")
    public MainSchedulePage insertGroupID(String groupNumber) {
        waitUntilElementToBeClickable(input);
        fillInput(input, groupNumber);
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Group ID inserted");
        return pageManager.getMainSchedulePage();
    }

    @Step("Group selection")
    public MainSchedulePage selectGroup(String groupNumber) {
        for (WebElement groupButton : scheduleButtons) {
            if (groupButton.getText().equals(groupNumber)) {
                scrollToElement(groupButton);
                buttonClick(groupButton);
                break;
            }
        }
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Group selected");
        return pageManager.getMainSchedulePage();
    }

    @Step("Check group schedule existance")
    public MainSchedulePage checkGroupSelected() {
        waitSeconds(1);
        Assert.assertTrue("❌ Расписание для группы не найдено!", schedule.getAttribute("style").isEmpty());
        System.out.print(LocalDateTime.now() + " ");
        System.out.println("✅ Found group schedule");
        return pageManager.getMainSchedulePage();
    }

    @Step("Check today colored")
    public MainSchedulePage checkDayColored() {
        String today = getTodayDate();
        for (WebElement scheduleDay : scheduleDays) {
            if (scheduleDay.getText().toLowerCase().equals(today)) {
                String parentClass = scheduleDay.findElement(By.xpath("./..")).getAttribute("class");
                Assert.assertTrue("❌ Текущий день не выделен цветом", parentClass.contains("today"));
                System.out.print(LocalDateTime.now() + " ");
                System.out.println("✅ Today is colored");
                break;
            }
        }
        return pageManager.getMainSchedulePage();
    }
}
