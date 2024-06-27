package myMarketTests;

import myMarket.MyMarket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMyMarket {
    private WebDriver driver = new ChromeDriver();


    @Test
    public void testDeodorant(){
        MyMarket myMarket = new MyMarket(driver);
        myMarket.getHomePage();
        String returnedProductName = myMarket.
                searchFor("Dove advanced care coconut spray").
                getFirstResultProduct().
                getProductName();
        Assert.assertEquals(returnedProductName, "Dove Αποσμητικό Σωμ. Spray Advanced Care Coconut 150ml", "Incorrect product returned!");
    }
}
