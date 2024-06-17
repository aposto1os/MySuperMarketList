package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

//TODO: SPECIFY QUANTITIES
//TODO: resolve 1+1 offers (sklavenitis)
//TODO: ADD PARMESAN, CHEESES ETC
//TODO: ADD TESTING
//TODO: ADD SELENIUM MANAGER
//TODO: EQUAL PRODUCTS
//TODO: REFACTOR MENU.CHEAPESTSOLUTION


public class Main {

    private static WebDriver driver;
    private static Scanner scanner = new Scanner(System.in);

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
        Menu mainMenu = new Menu(scanner, driver);
        mainMenu.menu();
        teardown();
    }
}
