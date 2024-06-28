package com.nemopss.managers;

import com.nemopss.lambda.pages.MainLambdaPage;
import com.nemopss.mospolytech.pages.MainMospolytechPage;
import com.nemopss.mospolytech.pages.MainSchedulePage;
import com.nemopss.mospolytech.pages.ScheduleMospolytechPage;

public class PageManager {

    private static PageManager INSTANCE;

    private MainLambdaPage mainLambdaPage;

    private MainMospolytechPage mainMospolytechPage;
    private ScheduleMospolytechPage scheduleMospolytechPage;
    private MainSchedulePage mainSchedulePage;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public MainLambdaPage getMainLambdaPage() {
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
}
