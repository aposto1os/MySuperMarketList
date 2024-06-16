package sklavenitis;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Sklavenitis {

    private WebDriver driver;
    private String homepageUrl = "https://www.sklavenitis.gr/";
    private By consentCookiesButton = By.cssSelector(".consent-give");
    private By searchBar = By.id("search");


    public Sklavenitis(WebDriver driver) {
        this.driver = driver;
    }

    public void getHomePage(){
        driver.get(homepageUrl);
        /*driver.manage().window().maximize();
        driver.findElement(consentCookiesButton).click();*/
    }

    public ResultsPageSklavenitis searchFor(String product){
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(product + Keys.ENTER);
        return new ResultsPageSklavenitis(driver);
    }
}
