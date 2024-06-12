package main;

import ab.AB;
import myMarket.MyMarket;
import org.openqa.selenium.WebDriver;
import sklavenitis.Sklavenitis;

import java.util.*;

public class Menu {
    private Scanner scanner;
    private WebDriver driver;
    private MyMarket myMarket;
    private Sklavenitis sklavenitis;
    private AB ab;
    private List<String> myList = new ArrayList<>();
    private static String deodorant = "Dove advanced care coconut";
    private static String shampoo = "wash & go Σαμπουάν classic 650ml";
    private static String toastBread = "ψωμί τοστ Παπαδοπούλου γευση2 σταρένιο 700gr";
    private static String mayo = "hellmann's light Μαγιονέζα 450ml";
    private static final String noodlesCurry = "Μαggi noodles cup Κάρυ";
    private static String butter = "βούτυρο lurpak soft 225gr";
    private static String tuna = "Rio Mare Τόνος Σε Ελαιόλαδο 2x160gr";
    private static String rice = "ρύζι parboiled ben's σακουλακι";
    private static String toothpaste = "colgate οδοντοκρεμα triple action";
    //private static String dishwasherCaps = "fairy caps";
    private static List<String> allProducts = Arrays.asList("tuna, riceMyMarket, dishwasherCapsMyMarket, laundryCapsMyMarket" +
            ", butter, noodlesCurry, mayo, toastBread, shampoo, deodorant");

    public Menu(Scanner scanner, WebDriver driver) {
        this.scanner = scanner;
        this.driver = driver;
        myMarket = new MyMarket(driver);
        sklavenitis = new Sklavenitis(driver);
        ab = new AB(driver);
    }

    public void menu(){
        int selection = 0;
        while (true){
            if (selection!=11){
                System.out.println("Please select a product (By number)");
                System.out.println("1. Deodorant");
                System.out.println("2. Shampoo");
                System.out.println("3. Toast Bread");
                System.out.println("4. Mayo");
                System.out.println("5. Noodles Curry");
                System.out.println("6. Butter");
                System.out.println("7. Tuna");
                System.out.println("8. Rice");
                System.out.println("9. Toothpaste");
                System.out.println("10. All Products");
                System.out.println("11. List Completed");
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
                        break;
                    case 4:
                        myList.add(mayo);
                        System.out.println("Mayo added to list");
                        System.out.println();
                        break;
                    case 5:
                        myList.add(noodlesCurry);
                        System.out.println("Noodles Curry added to list");
                        System.out.println();
                        break;
                    case 6:
                        myList.add(butter);
                        System.out.println("Butter added to list");
                        System.out.println();
                        break;
                    case 7:
                        myList.add(tuna);
                        System.out.println("Tuna added to list");
                        System.out.println();
                        break;
                    case 8:
                        myList.add(rice);
                        System.out.println("rice added to list");
                        System.out.println();
                        break;
                    case 9:
                        myList.add(toothpaste);
                        System.out.println("toothpaste added to list");
                        System.out.println();
                        break;
                    case 10:
                        myList = allProducts;
                        break;
                }
            }else break;
        }
        cheapestSolution();
    }

    private ArrayList<Product> calculateTotalForMyMarket(){
        ArrayList<Product> myMarketList = new ArrayList<>();

        myMarket.getHomePage();
        for (String product: myList) {
            if (product.equals("Dove advanced care coconut")){
                product = "Dove advanced care coconut spray";
            }
            myMarketList.add(new Product(myMarket.getProductText(product), myMarket.getProductPrice(product)));
            myMarket.getHomePage();
        }
        return myMarketList;
    }

    /**
     * if a product is missing then, gets adds the word MISSING to the product name and
     * gets the price from MyMarket.
     */
    private ArrayList<Product> calculateTotalForSklavenitis(){
        ArrayList<Product> sklavenitisList = new ArrayList<>();
        sklavenitis.getHomePage();
        for (String product: myList) {
            if (product.equals("ψωμί τοστ Παπαδοπούλου γευση2 σταρένιο 700gr")){
                product = "ψωμί τοστ παπαδοπουλου 700gr";
            }
            if (product.equals("Μαggi noodles cup Κάρυ")){
                myMarket.getHomePage();
                sklavenitisList.add(new Product("Noodles MISSING", myMarket.getProductPrice(product)));
                sklavenitis.getHomePage();
                continue;
            }
            sklavenitisList.add(new Product(sklavenitis.getProductText(product), sklavenitis.getProductPrice(product)));
            sklavenitis.getHomePage();
        }
        return sklavenitisList;
    }

    private void cheapestSolution(){
        double totalOfCheapest = 0;
        ArrayList<Product> myMarketList = calculateTotalForMyMarket();
        ArrayList<Product> sklavenitisList = calculateTotalForSklavenitis();
        ArrayList<Product> myMarketCheapestList = new ArrayList<>();
        ArrayList<Product> sklavenitisCheapestList = new ArrayList<>();
        for (int i = 0; i < myMarketList.size(); i++) {
            if (myMarketList.get(i).getProductPrice() <= sklavenitisList.get(i).getProductPrice()){
                myMarketCheapestList.add(myMarketList.get(i));
            }else {
                sklavenitisCheapestList.add(sklavenitisList.get(i));
            }
        }
        System.out.println("My Market");
        printShoppingList(myMarketList);
        System.out.println();
        System.out.println("Sklavenitis");
        printShoppingList(sklavenitisList);
        System.out.println();
        System.out.println("My Market Cheapest");
        printShoppingList(myMarketCheapestList);
        System.out.println();
        System.out.println("Sklavenitis Cheapest");
        printShoppingList(sklavenitisCheapestList);
        System.out.println();
        for (Product product:myMarketCheapestList) {
            totalOfCheapest += product.getProductPrice();
        }
        for (Product product:sklavenitisCheapestList) {
            totalOfCheapest += product.getProductPrice();
        }
        System.out.println("CHEAPEST SOLUTION TOTAL: " + totalOfCheapest);
    }

    private void printShoppingList(ArrayList<Product> list){
        double total = 0.0;
        System.out.println("-".repeat(99));
        for (Product product : list) {
            System.out.printf("| %-85s : %-7.2f |%n",product.getProductName(),product.getProductPrice());
            total += product.getProductPrice();
        }
        System.out.println("=".repeat(99));
        System.out.printf("| %-85s : %-7.2f |%n","Total price: " , total);
        System.out.println("-".repeat(99));
    }
}
