package com.fox.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShowsPage extends BasePage {

    public PageHeader pageHeader;

    public ShowsPage(WebDriver driver){
        super(driver);
        pageHeader = new PageHeader(driver);
    }



}
