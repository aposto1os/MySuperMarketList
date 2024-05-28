package main;

import myMarket.MyMarket;
import org.openqa.selenium.WebDriver;
import sklavenitis.Sklavenitis;

import java.util.*;

public class Menu {
    private Scanner scanner;
    private WebDriver driver;
    private MyMarket myMarket;
    private Sklavenitis sklavenitis;
    private List<String> myList = new ArrayList<>();
    private static List<String> allProducts = Arrays.asList("tunaMyMarket, riceMyMarket, dishwasherCapsMyMarket, laundryCapsMyMarket" +
            ", butterMyMarket, noodlesMyMarket, mayoMyMarket, toastBreadMyMarket, shampooMyMarket, deodorantMyMarket");
    private static String deodorant = "Dove advanced care coconut";
    private static String shampoo = "wash & go Σαμπουάν classic 650ml";
    private static String toastBread = "ψωμί τοστ Παπαδοπούλου γευση2 σταρένιο 700gr";

    public Menu(Scanner scanner, WebDriver driver) {
        this.scanner = scanner;
        this.driver = driver;
        myMarket = new MyMarket(driver);
        sklavenitis = new Sklavenitis(driver);
    }

    public void menu(){
        int selection = 0;
        while (true){
            if (selection!=5){
                System.out.println("Please select a product (By number)");
                System.out.println("1. Deodorant");
                System.out.println("2. Shampoo");
                System.out.println("3. Toast Bread");
                System.out.println("4. All Products");
                System.out.println("5. List Completed");
                System.out.print("Selection: ");
                selection = scanner.nextInt();
                switch (selection){
                    case 1:
                        myList.add(deodorant);
                        System.out.println("Deodorant added to list");
                        System.out.println();
                        break;
                    case 2:
                        myList.add(shampoo);
                        System.out.println("Shampoo added to list");
                        System.out.println();
                        break;
                    case 3:
                        myList.add(toastBread);
                        System.out.println("Toast bread added to list");
                        System.out.println();
                    case 4:
                        myList = allProducts;
                }
            }else break;
        }
        cheapestSolution();
        /*System.out.println("MYMARKET:");
        calculateTotalForMyMarket();
        System.out.println();
        System.out.println("SKLAVENITIS:");
        calculateTotalForSklavenitis();*/
    }

    private ArrayList<Product> calculateTotalForMyMarket(){
        //double totalPrice = 0;
        ArrayList<Product> myMarketList = new ArrayList<>();

        myMarket.getHomePage();
        for (String product: myList) {
            if (product.equals("Dove advanced care coconut")){
                product = "Dove advanced care coconut spray";
            }
            myMarketList.add(new Product(myMarket.getProductText(product), myMarket.getProductPrice(product)));
            //System.out.println(myMarket.getProductText(product) + ": " + myMarket.getProductPrice(product));
            //totalPrice += myMarket.getProductPrice(product);
            myMarket.getHomePage();
        }
        /*System.out.println("=".repeat(80));
        System.out.println("Total price for MyMarket: " + totalPrice);*/
        return myMarketList;
    }

    private ArrayList<Product> calculateTotalForSklavenitis(){
        //double totalPrice = 0;
        ArrayList<Product> sklavenitisList = new ArrayList<>();
        sklavenitis.getHomePage();
        for (String product: myList) {
            sklavenitisList.add(new Product(sklavenitis.getProductText(product), sklavenitis.getProductPrice(product)));
            //System.out.println(sklavenitis.getProductText(product) + ": " + sklavenitis.getProductPrice(product));
            //totalPrice += sklavenitis.getProductPrice(product);
            sklavenitis.getHomePage();
        }
        /*System.out.println("=".repeat(80));
        System.out.println("Total price for Sklavenitis: " + totalPrice);*/
        return sklavenitisList;
    }

    private void cheapestSolution(){
        ArrayList<Product> myMarketList = calculateTotalForMyMarket();
        ArrayList<Product> sklavenitisList = calculateTotalForSklavenitis();
        ArrayList<Product> myMarketCheapestList = new ArrayList<>();
        ArrayList<Product> sklavenitisCheapestList = new ArrayList<>();
        //System.out.println(myMarketList);
        //System.out.println(sklavenitisList);
        for (int i = 0; i < myMarketList.size(); i++) {
            if (myMarketList.get(i).getProductPrice() < sklavenitisList.get(i).getProductPrice()){
                myMarketCheapestList.add(myMarketList.get(i));
            }else {
                sklavenitisCheapestList.add(sklavenitisList.get(i));
            }
        }
        System.out.println("My Market");
        System.out.println(myMarketList);
        System.out.println();
        System.out.println("Sklavenitis");
        System.out.println(sklavenitisList);
        System.out.println();
        System.out.println("My Market Cheapest");
        System.out.println(myMarketCheapestList);
        System.out.println();
        System.out.println("Sklavenitis Cheapest");
        System.out.println(sklavenitisCheapestList);
        /*ArrayList<String> myMarketList = new ArrayList<>();
        ArrayList<String> sklavenitisList = new ArrayList<>();
        for (String product: myList) {
            if (myMarket.getProductPrice(product) < sklavenitis.getProductPrice(product)){
                myMarketList.add(product);
            }else {
                sklavenitisList.add(product);
            }
        }
        System.out.println(myMarketList);
        System.out.println(sklavenitisList);*/
    }
}
