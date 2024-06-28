package com.nemopss.managers;

import org.openqa.selenium.Cookie;

import com.nemopss.lambda.pages.MainLambdaPage;
import com.nemopss.mospolytech.pages.MainMospolytechPage;
import com.nemopss.mospolytech.pages.MainSchedulePage;
import com.nemopss.mospolytech.pages.ScheduleMospolytechPage;
import com.nemopss.yandex.pages.FavoritesPage;
import com.nemopss.yandex.pages.XboxPage;
import com.nemopss.yandex.pages.MainYandexPage;

public class PageManager {

    private static PageManager INSTANCE;

    private MainLambdaPage mainLambdaPage;

    private MainMospolytechPage mainMospolytechPage;
    private ScheduleMospolytechPage scheduleMospolytechPage;
    private MainSchedulePage mainSchedulePage;

    private MainYandexPage mainYandexPage;
    private FavoritesPage favoritesPage;
    private XboxPage xboxPage;

    private static DriverManager driverManager = DriverManager.getInstance();

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public MainLambdaPage getLambdaPage() {
        if (mainLambdaPage == null) {
            mainLambdaPage = new MainLambdaPage();
        }
        return mainLambdaPage;
    }

    public MainMospolytechPage getMainMospolytechPage() {
        if (mainMospolytechPage == null) {
            mainMospolytechPage = new MainMospolytechPage();
        }
        return mainMospolytechPage;
    }

    public ScheduleMospolytechPage getScheduleMospolytechPage() {
        if (scheduleMospolytechPage == null) {
            scheduleMospolytechPage = new ScheduleMospolytechPage();
        }
        return scheduleMospolytechPage;
    }

    public MainSchedulePage getMainSchedulePage() {
        if (mainSchedulePage == null) {
            mainSchedulePage = new MainSchedulePage();
        }
        return mainSchedulePage;
    }

    public MainYandexPage getMainYandexPage() {
        if (mainYandexPage == null) {
            mainYandexPage = new MainYandexPage();
        }
        return mainYandexPage;
    }

    public XboxPage getXboxPage() {
        if (xboxPage == null) {
            xboxPage = new XboxPage();
        }
        return xboxPage;
    }

    public FavoritesPage getFavoritesPage(String title, String price) {
        if (favoritesPage == null) {
            favoritesPage = new FavoritesPage(title, price);
        }
        return favoritesPage;
    }
}
