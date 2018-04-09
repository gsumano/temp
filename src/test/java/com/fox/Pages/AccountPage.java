package com.fox.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private By signIn = By.xpath("/html/body/div[1]/div/div/div[2]/div/div[4]/button[2]");
    private By signinEmail = By.name("signinEmail");
    private By signinPassword = By.name("signinPassword");
    private By signInBtn = By.xpath("(//button[text()='Sign In'])[1]");
    private By siginProfiContainer = By.xpath("//*[contains(@class,'Account_signinCreateProfileContainer')]");

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public void clickOnSignIn(){
        clickOn(signIn);
    }

    public void enterUsername(String username){
        enterText(signinEmail, username);
    }

    public void enterPassword(String password){
        enterText(signinPassword, password);
    }
    public HomePage singInToAccount(){
        clickOn(signInBtn);
        sleepSeconds(4);
        return new HomePage(driver);
    }

}
