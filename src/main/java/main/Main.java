package main;
//TODO: SPECIFY QUANTITIES
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Main {

    private static WebDriver driver;
    private static Scanner scanner = new Scanner(System.in);
    private static String laundryCapsMyMarket = "ariel κάψουλες 54τεμ";
    private static String dishwasherCapsMyMarket = "fairy caps";
    private static String riceMyMarket = "ρύζι parboiled ben's 500gr";
    //private static String nounouGoudaCheese = "nounou gouda φραντζόλα";

    private static void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().minimize();
    }

    private static void teardown(){
        driver.quit();
        scanner.close();
    }

    public static void main(String[] args) {
        setup();
        Menu menu = new Menu(scanner, driver);
        menu.menu();
        teardown();
    }
}
