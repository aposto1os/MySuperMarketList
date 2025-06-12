package ab;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AB {

    private WebDriver driver;
    private String homepageUrl = "https://www.ab.gr/";
    private By declineCookiesButton = By.xpath("//button[@data-testid='cookie-popup-reject']");
    private By searchBar = By.cssSelector("header form input");

    public AB(WebDriver driver) {
        this.driver = driver;
    }

    public void getHomePage(){
        driver.get(homepageUrl);
        driver.manage().window().maximize();
        driver.findElement(declineCookiesButton).click();
    }

    public ResultsPageAb searchFor(String product){
        driver.findElement(searchBar).sendKeys(product + Keys.ENTER);
        return new ResultsPageAb(driver);
    }
}
