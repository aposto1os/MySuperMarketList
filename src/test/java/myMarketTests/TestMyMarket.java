package myMarketTests;

import myMarket.MyMarket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMyMarket{

    private WebDriver driver;

    public TestMyMarket() {
        driver = new ChromeDriver();
    }

    @Test
    public void testDeodorant(){
        String returnedProductName = getProductName("Dove advanced care coconut spray");
        Assert.assertEquals(returnedProductName, "Dove Αποσμητικό Σωμ. Spray Advanced Care Coconut 150ml", "Incorrect product returned!");
    }

    @Test
    private void testShampoo(){
        String returnedProductName = getProductName("wash & go Σαμπουάν classic 650ml");
        Assert.assertEquals(returnedProductName, "Wash & Go 2in1 Σαμπουάν Classic 650 ml", "Incorrect product returned!");
    }

    private String getProductName(String product){
        MyMarket myMarket = new MyMarket(driver);
        myMarket.getHomePage();
        String returnedProductName = myMarket.
                searchFor(product).
                getFirstResultProduct().
                getProductName();
        return returnedProductName;
    }
}
