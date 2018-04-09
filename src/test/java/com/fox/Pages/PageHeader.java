package com.fox.Pages;

import org.openqa.selenium.WebDriver;

public class PageHeader extends BasePage implements IpageHeader {

    public PageHeader(WebDriver driver){
        super(driver);
    }


    @Override
    public FxPage navigateFxPage() {
        scrollIntoView(driver.findElement(fx_tab));
        clickOn(fx_tab);
        return new FxPage(driver);
    }

    @Override
    public NationalGeographicPage navigateNationalGeographicPage() {
        scrollIntoView(driver.findElement(nationalGeographic_tab));
        clickOn(nationalGeographic_tab);
        return new NationalGeographicPage(driver);
    }

    @Override
    public FoxSportsPage navigateFoxSportsPage() {
        scrollIntoView(driver.findElement(foxsports_tab));
        clickOn(foxsports_tab);
        return new FoxSportsPage(driver);
    }

    @Override
    public AllShowsPage navigateAllShowsPage() {
        scrollIntoView(driver.findElement(allShows_tab));
        clickOn(allShows_tab);
        return new AllShowsPage(driver);
    }
}
