package myMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyMarket {

    private WebDriver driver;
    private String homepageUrl = "https://www.mymarket.gr/";
    private By declineCookiesButton = By.id("CybotCookiebotDialogBodyButtonDecline");
    private By searchBar = By.id("main-search");
    private String deodorant = "Dove advanced care coconut spray";

    public MyMarket(WebDriver driver) {
        this.driver = driver;
    }

    public void getHomePage(){
        driver.get(homepageUrl);
        driver.manage().window().maximize();
        driver.findElement(declineCookiesButton).click();
    }

    public double getDeodorantPrice(){
        return searchFor(deodorant).getFirstResultPrice();
    }

    public String getDeodorantText(){
        return searchFor(deodorant).getFirstResultText();
    }

    private ResultsPage searchFor(String product){
        driver.findElement(searchBar).sendKeys(product + Keys.ENTER);
        return new ResultsPage(driver);
    }
}
