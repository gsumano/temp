package com.fox.Pages;

import org.openqa.selenium.WebDriver;

public class FxPage extends BasePage {
    public PageHeader pageHeader;

    public FxPage(WebDriver driver){
        super(driver);
        pageHeader = new PageHeader(driver);
    }


}
