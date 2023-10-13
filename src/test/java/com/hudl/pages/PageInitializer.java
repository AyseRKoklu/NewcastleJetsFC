package com.hudl.pages;

import com.hudl.utilities.Driver;

public class PageInitializer extends Driver {

    public static LoginPage loginPage;

    public static void initialize() {
        loginPage = new LoginPage();
    }

}
