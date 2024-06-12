package ab;

import myMarket.ResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AB {

    private WebDriver driver;
    private String homepageUrl = "https://www.ab.gr/";
    //private By declineCookiesButton = By.id("CybotCookiebotDialogBodyButtonDecline");
    private By searchBar = By.cssSelector("header form input");
    /*private String deodorant = "Dove advanced care coconut spray";
    private String shampoo = "wash & go Σαμπουάν classic";*/

    public AB(WebDriver driver) {
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

    private ResultsPage searchFor(String product){
        driver.findElement(searchBar).sendKeys(product + Keys.ENTER);
        return new ResultsPage(driver);
    }
}
