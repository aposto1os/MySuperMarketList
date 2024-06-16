package kritikos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Kritikos {

    private WebDriver driver;
    private String homepageUrl = "https://kritikos-sm.gr/";
    private By declineCookiesButton = By.cssSelector(".Buttons_secondaryButton__ruBI_");
    private By searchBar = By.cssSelector(".SearchBar_input__eMa_Q");

    public Kritikos(WebDriver driver) {
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

    private ResultsPageKritikos searchFor(String product){
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(product + Keys.ENTER);
        return new ResultsPageKritikos(driver);
    }
}
