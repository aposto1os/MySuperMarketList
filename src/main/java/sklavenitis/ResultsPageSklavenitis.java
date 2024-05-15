package sklavenitis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPageSklavenitis {

    private WebDriver driver;
    private By result = By.cssSelector("h4 a");
    private By resultPrice = By.cssSelector(".price");

    public ResultsPageSklavenitis(WebDriver driver) {
        this.driver = driver;
    }
}
