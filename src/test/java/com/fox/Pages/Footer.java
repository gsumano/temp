package com.fox.Pages;

import org.openqa.selenium.By;

public interface Footer {

    By pagefooter = By.xpath("(//div[contains(@class, 'Footer_listsContainer')])[2]");

    public void scrollToPageFooter();
}
