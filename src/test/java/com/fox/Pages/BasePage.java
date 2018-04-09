package com.fox.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage implements Header, Footer{

    private final int TIMEOUT = 10;
    public WebDriver driver;

    private By showElements = By.xpath("//div[contains(@class, 'Tile_info')]");


    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOn(By locator){
        waitOnElement(locator).click();
    }

    public void enterText(By locator, String text){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }

    public WebElement waitOnElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }
    public void waitOnElementNot(By locator){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(locator)));
    }
    public void sleepSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AccountPage navigateToUserAccounts(){
        clickOn(user_icon);
        return new AccountPage(driver);
    }

    @Override
    public ShowsPage navigateShowsTab(){
        clickOn(shows_tab);
        return new ShowsPage(driver);
    }

    @Override
    public void scrollToPageHeader() {
        scrollIntoView(driver.findElement(header));
    }

    public List<WebElement> getAllShows(){
        sleepSeconds(3);
        scrollToPageFooter();
        List<WebElement> all = driver.findElements(showElements);
        return all;
    }

    public List<WebElement> getLastShows(int howmany){
        List<WebElement> all = getAllShows();
        if(all.size() > howmany){
            return all.subList(all.size()-howmany, all.size());
        }else {
            return null;
        }
    }
    public ArrayList<String> getShowTitles(List<WebElement> shows){
        ArrayList<String> titles = new ArrayList<String>();
        for(WebElement show : shows){
            titles.add(show.getText());
        }
        return titles;
    }

    @Override
    public void scrollToPageFooter(){
        scrollIntoView(driver.findElement(pagefooter));
    }

    public void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element );
        sleepSeconds(2);
    }
}
