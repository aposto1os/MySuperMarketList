package kritikos;

import main.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPageKritikos {

    private WebDriver driver;
    private By result = By.xpath("//p[text()='ΔΕΛΤΑ Καθημερινά Πλήρες 3,5%']");
    private By resultPrice = By.xpath("//p[text()='ΔΕΛΤΑ Καθημερινά Πλήρες 3,5%']/ancestor::a/following-sibling::div//p");

    public ResultsPageKritikos(WebDriver driver) {
        this.driver = driver;
    }

    public Product getFirstResultProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        String price = driver.findElement(resultPrice).getText();
        price = price.replaceAll("[^0-9,.]", "");
        price = price.replace(',','.');
        return new Product(driver.findElement(result).getText(), Double.parseDouble(price));
    }
}
