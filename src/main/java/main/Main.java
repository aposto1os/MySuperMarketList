package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

//TODO: ADD PARMESAN, CHEESES
//TODO: ADD TESTING
//TODO: EQUAL PRODUCTS
//TODO: PRICES HISTORY



public class Main {

    private static WebDriver driver;
    private static Scanner scanner = new Scanner(System.in);

    private static void setup(){
        //Doesn't need setProperty because Selenium 4.20 contains Selenium Manager.
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().minimize();
    }

    private static void teardown(){
        driver.quit();
        scanner.close();
    }

    public static void main(String[] args) {
        setup();
        Menu mainMenu = new Menu(scanner, driver);
        mainMenu.menu();
        teardown();
    }
}
