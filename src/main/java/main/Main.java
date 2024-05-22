package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sklavenitis.Sklavenitis;

public class Main {

    private static WebDriver driver;
    private static String deodorantMyMarket = "Dove advanced care coconut spray";
    private static String deodorantSklavenitis = "Dove advanced care coconut";
    private static String shampooMyMarket = "wash & go Σαμπουάν classic 650ml";

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void main(String[] args) {
        setup();
        Sklavenitis sklavenitis = new Sklavenitis(driver);
        sklavenitis.getHomePage();
        System.out.println(sklavenitis.getProductText(deodorantSklavenitis) + ": " + sklavenitis.getProductPrice(deodorantSklavenitis));
        /*MyMarket myMarket = new MyMarket(driver);
        myMarket.getHomePage();
        System.out.println(myMarket.getProductText(shampooMyMarket) + ": " + myMarket.getProductPrice(shampooMyMarket));*/
    }
}
