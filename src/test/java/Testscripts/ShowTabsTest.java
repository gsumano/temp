package Testscripts;

import TestData.Userdata;
import com.fox.Pages.*;
import com.fox.excel.ExcelWriter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ShowTabsTest extends BaseTest {

    ExcelWriter excelWriter;
    ShowsPage showsPage;

    @BeforeTest
    public void loginToFoxWebsite(){
        homePage = new HomePage(driver);
        AccountPage account = homePage.navigateToUserAccounts();
        account.clickOnSignIn();
        account.enterUsername(Userdata.username);
        account.enterPassword(Userdata.password);
        account.singInToAccount();

        writeShowTitlesToExcel();
    }
    public void writeShowTitlesToExcel(){
        showsPage = homePage.navigateShowsTab();
        ArrayList<String> titles = showsPage.getShowTitles(showsPage.getLastShows(4));
        excelWriter = new ExcelWriter();
        excelWriter.WriteToExcelSheet(titles);

    }


    @Test
    public void Verify_last_4_shows_on_FX_page() throws IOException {
        ArrayList<String> expectedTitles = excelWriter.ReadFromExcelSheet();
        ArrayList<String> actualTitles;

        FxPage fxPage = showsPage.pageHeader.navigateFxPage();
        actualTitles = fxPage.getShowTitles(fxPage.getLastShows(4));

        Assert.assertEquals(expectedTitles, actualTitles, "Shows did not match");

    }
    @Test
    public void Verify_last_4_shows_on_National_Geographic_page() throws IOException {
        ArrayList<String> expectedTitles = excelWriter.ReadFromExcelSheet();
        ArrayList<String> actualTitles;
        NationalGeographicPage nationalGeographicPage = showsPage.pageHeader.navigateNationalGeographicPage();
        actualTitles = nationalGeographicPage.getShowTitles(nationalGeographicPage.getLastShows(4));

        Assert.assertEquals(expectedTitles, actualTitles, "Shows did not match");

    }
    @Test
    public void Verify_last_4_shows_on_Fox_Sports_page() throws IOException {
        ArrayList<String> expectedTitles = excelWriter.ReadFromExcelSheet();
        ArrayList<String> actualTitles;
        FoxSportsPage foxSportsPage = showsPage.pageHeader.navigateFoxSportsPage();
        actualTitles = foxSportsPage.getShowTitles(foxSportsPage.getLastShows(4));

        Assert.assertEquals(expectedTitles, actualTitles, "Shows did not match");

    }
    @Test
    public void Verify_last_4_shows_on_All_Shows_page() throws IOException {
        ArrayList<String> expectedTitles = excelWriter.ReadFromExcelSheet();
        ArrayList<String> actualTitles;
        AllShowsPage allShowsPage = showsPage.pageHeader.navigateAllShowsPage();
        actualTitles = allShowsPage.getShowTitles(allShowsPage.getLastShows(4));

        Assert.assertEquals(expectedTitles, actualTitles, "Shows did not match");

    }
}


