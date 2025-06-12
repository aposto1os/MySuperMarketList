package ab;

import main.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPageAb {

    private WebDriver driver;
    private By result = By.xpath("//a[@title='ΔΕΛΤΑ Γάλα Φρέσκο Καθημερινά Πλήρες 1lt']");
    private By resultPriceInt = By.xpath("(//span[text()='Γάλα Φρέσκο Καθημερινά Πλήρες 1lt']/parent::a/parent::h3/parent::div//following-sibling::div//div[@data-testid='product-block-price']/div)[2]");
    private By resultPriceDec = By.xpath("//span[text()='Γάλα Φρέσκο Καθημερινά Πλήρες 1lt']/parent::a/parent::h3/parent::div//following-sibling::div//div[@data-testid='product-block-price']/sup");

    public ResultsPageAb(WebDriver driver) {
        this.driver = driver;
    }

    public Product getFirstResultProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        String price = driver.findElement(resultPriceInt).getText() + "," + driver.findElement(resultPriceDec).getText();
        price = price.replaceAll("[^0-9,]", "");
        price = price.replace(',','.');
        return new Product(driver.findElement(result).getText(), Double.parseDouble(price));
    }
}
