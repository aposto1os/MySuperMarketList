package myMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyMarket {

    private WebDriver driver;
    private String homepageUrl = "https://www.mymarket.gr/";
    private By declineCookiesButton = By.id("CybotCookiebotDialogBodyButtonDecline");

    public MyMarket(WebDriver driver) {
        this.driver = driver;
    }

    public void getHomePage(){
        driver.get(homepageUrl);
        driver.manage().window().maximize();
        driver.findElement(declineCookiesButton).click();
    }
}
