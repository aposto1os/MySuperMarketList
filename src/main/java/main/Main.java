package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import sklavenitis.Sklavenitis;

public class Main {

    private static WebDriver driver;
    private static String deodorantMyMarket = "Dove advanced care coconut spray";
    private static String deodorantSklavenitis = "Dove advanced care coconut";
    private static String shampooMyMarket = "wash & go Σαμπουάν classic 650ml";
    private static String toastBreadMyMarket = "ψωμί τοστ Παπαδοπούλου γευση2 σταρένιο 700gr";
    private static String mayoMyMarket = "hellmann's light Μαγιονέζα 450ml";
    private static final String noodlesMyMarket = "Μαggi noodles cup Κάρυ";
    private static String butterMyMarket = "βούτυρο lurpak soft 225gr";
    private static String laundryCapsMyMarket = "ariel κάψουλες 54τεμ";
    private static String dishwasherCapsMyMarket = "fairy caps";
    private static String riceMyMarket = "ρύζι parboiled ben's 500gr";
    private static String tunaMyMarket = "Rio Mare Τόνος Σε Ελαιόλαδο 2x160gr";
    //private static String nounouGoudaCheese = "nounou gouda φραντζόλα";

    private static List<String> allProducts = Arrays.asList(tunaMyMarket, riceMyMarket, dishwasherCapsMyMarket, laundryCapsMyMarket
    , butterMyMarket, noodlesMyMarket, mayoMyMarket, toastBreadMyMarket, shampooMyMarket, deodorantMyMarket);

    private static void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    private static void teardown(){
        driver.quit();
    }

    public static void main(String[] args) {
        double totalPrice = 0;
        setup();
        Sklavenitis sklavenitis = new Sklavenitis(driver);
        sklavenitis.getHomePage();
        System.out.println(sklavenitis.getProductText(deodorantSklavenitis) + ": " + sklavenitis.getProductPrice(deodorantSklavenitis));
        /*MyMarket myMarket = new MyMarket(driver);
        myMarket.getHomePage();
        System.out.println(myMarket.getProductText(shampooMyMarket) + ": " + myMarket.getProductPrice(shampooMyMarket));*/
    }
}
