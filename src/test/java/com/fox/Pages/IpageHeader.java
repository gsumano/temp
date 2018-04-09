package com.fox.Pages;

import org.openqa.selenium.By;

public interface IpageHeader {

    By fx_tab = By.xpath("//a[@role='button' and text()='FX']");
    By nationalGeographic_tab = By.xpath("//a[@role='button' and text()='National Geographic']");
    By foxsports_tab = By.xpath("//a[@role='button' and text()='FOX Sports']");
    By allShows_tab = By.xpath("//a[@role='button' and text()='All Shows']");


    public FxPage navigateFxPage();

    public NationalGeographicPage navigateNationalGeographicPage();

    public FoxSportsPage navigateFoxSportsPage();

    public AllShowsPage navigateAllShowsPage();


}
