package main;

import myMarket.MyMarket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    private static WebDriver driver;
    private String deodorantMyMarket = "Dove advanced care coconut spray";
    private static String shampooMyMarket = "wash & go Σαμπουάν classic 650ml";

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void main(String[] args) {
        setup();
        MyMarket myMarket = new MyMarket(driver);
        myMarket.getHomePage();
        System.out.println(myMarket.getProductText(shampooMyMarket) + ": " + myMarket.getProductPrice(shampooMyMarket));
    }
}
