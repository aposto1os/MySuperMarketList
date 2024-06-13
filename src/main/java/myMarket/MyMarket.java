package myMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyMarket {

    private WebDriver driver;
    private String homepageUrl = "https://www.mymarket.gr/";
    private By declineCookiesButton = By.id("CybotCookiebotDialogBodyButtonDecline");
    private By searchBar = By.id("main-search");
    /*private String deodorant = "Dove advanced care coconut spray";
    private String shampoo = "wash & go Σαμπουάν classic";*/

    public MyMarket(WebDriver driver) {
        this.driver = driver;
    }

    public void getHomePage(){
        driver.get(homepageUrl);
        driver.manage().window().maximize();
        //driver.findElement(declineCookiesButton).click();
    }

    public double getProductPrice(String product){
        return searchFor(product).getFirstResultPrice();
    }

    public String getProductText(String product){
        return searchFor(product).getFirstResultText();
    }

    private ResultsPageMyMarket searchFor(String product){
        driver.findElement(searchBar).sendKeys(product + Keys.ENTER);
        return new ResultsPageMyMarket(driver);
    }
}
