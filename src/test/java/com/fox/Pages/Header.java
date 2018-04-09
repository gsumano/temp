package com.fox.Pages;

import org.openqa.selenium.By;

public interface Header {
    By header = By.tagName("header");
    By user_icon = By.id("path-1");
    By shows_tab = By.xpath("//div[contains(@class, 'Header_navLinks')]/a[text()='Shows']");


    public AccountPage navigateToUserAccounts();
    public ShowsPage navigateShowsTab();
    public void scrollToPageHeader();

}