package sklavenitis;

import main.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPageSklavenitis {

    private WebDriver driver;
    private By result = By.cssSelector("h4 a");
    private By resultPrice = By.cssSelector(".price");
    private By offerLocator = By.cssSelector(".inner");

    public ResultsPageSklavenitis(WebDriver driver) {
        this.driver = driver;
    }

    public Product getFirstResultProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        String price = driver.findElement(resultPrice).getText();
        price = price.replaceAll("[^0-9,]", "");
        price = price.replace(',','.');
        try {
            if (driver.findElement(offerLocator).getText().contains("1+1")){
                return new Product(driver.findElement(result).getText(), Double.parseDouble(price) / 2);
            }else {
                return new Product(driver.findElement(result).getText(), Double.parseDouble(price));
            }
        }catch (Exception e){
            return new Product(driver.findElement(result).getText(), Double.parseDouble(price));
        }
    }
}
