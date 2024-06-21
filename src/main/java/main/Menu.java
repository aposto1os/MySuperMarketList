package main;

import ab.AB;
import kritikos.Kritikos;
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
    private Kritikos kritikos;

    private List<String> myList = new ArrayList<>();
    private ArrayList<Double> quantities = new ArrayList<>();
    private ArrayList<Product> myMarketList = new ArrayList<>();
    private ArrayList<Product> sklavenitisList = new ArrayList<>();
    private ArrayList<Product> aBList = new ArrayList<>();
    private ArrayList<Product> kritikosList = new ArrayList<>();
    private ArrayList<Product> myMarketCheapestList = new ArrayList<>();
    private ArrayList<Product> sklavenitisCheapestList = new ArrayList<>();
    private ArrayList<Product> aBCheapestList = new ArrayList<>();
    private ArrayList<Product> kritikosCheapestList = new ArrayList<>();

    private double totalOfCheapest = 0;

    private static String deodorant = "Dove advanced care coconut";
    private static String shampoo = "wash & go Σαμπουάν classic 650ml";
    private static String toastBread = "ψωμί τοστ Παπαδοπούλου γευση2 σταρένιο 700gr";
    private static String milk = "Δέλτα Καθημερινά Φρέσκο Γάλα Πλήρες 2 lt";
    private static final String noodlesCurry = "Μαggi noodles cup Κάρυ";
    private static String butter = "βούτυρο lurpak soft 225gr";
    private static String tuna = "Rio Mare Τόνος Σε Ελαιόλαδο 2x160gr";
    private static String rice = "ρύζι parboiled ben's σακουλακι";
    private static String toothpaste = "colgate οδοντοκρεμα triple action";
    private static String mexicanRice = "Ρύζι Μεξικάνικο";
    //private static String dishwasherCaps = "fairy caps";
    //anonymous list = {mayo marata, makaronia lidl}
    private static List<String> allProducts = Arrays.asList(deodorant, shampoo, toastBread, milk, noodlesCurry,
            butter, tuna, rice, mexicanRice, toothpaste);

    public Menu(Scanner scanner, WebDriver driver) {
        this.scanner = scanner;
        this.driver = driver;
        myMarket = new MyMarket(driver);
        sklavenitis = new Sklavenitis(driver);
        ab = new AB(driver);
        kritikos = new Kritikos(driver);
    }

    public void menu(){
        selectProducts();
        calculateListForEachSuperMarket();
        cheapestSolution();
        printResults();
    }

    private void selectProducts(){
        int selection = 0;
        while (true){
            if (selection!=12){
                System.out.println("Please select a product (By number)");
                System.out.println("1. Deodorant");
                System.out.println("2. Shampoo");
                System.out.println("3. Toast Bread");
                System.out.println("4. Milk");
                System.out.println("5. Noodles Curry");
                System.out.println("6. Butter");
                System.out.println("7. Tuna");
                System.out.println("8. Rice");
                System.out.println("9. Mexican Rice (Or Chinese from MyMarket)");
                System.out.println("10. Toothpaste");
                System.out.println("11. All Products");
                System.out.println("12. List Completed");
                System.out.print("Selection: ");
                selection = scanner.nextInt();
                switch (selection){
                    case 1:
                        quantities.add(quantityOfProduct());
                        myList.add(deodorant);
                        System.out.println("Deodorant added to list");
                        System.out.println();
                        break;
                    case 2:
                        quantities.add(quantityOfProduct());
                        myList.add(shampoo);
                        System.out.println("Shampoo added to list");
                        System.out.println();
                        break;
                    case 3:
                        quantities.add(quantityOfProduct());
                        myList.add(toastBread);
                        System.out.println("Toast bread added to list");
                        System.out.println();
                        break;
                    case 4:
                        quantities.add(quantityOfProduct());
                        myList.add(milk);
                        System.out.println("Milk added to list");
                        System.out.println();
                        break;
                    case 5:
                        quantities.add(quantityOfProduct());
                        myList.add(noodlesCurry);
                        System.out.println("Noodles Curry added to list");
                        System.out.println();
                        break;
                    case 6:
                        quantities.add(quantityOfProduct());
                        myList.add(butter);
                        System.out.println("Butter added to list");
                        System.out.println();
                        break;
                    case 7:
                        quantities.add(quantityOfProduct());
                        myList.add(tuna);
                        System.out.println("Tuna added to list");
                        System.out.println();
                        break;
                    case 8:
                        quantities.add(quantityOfProduct());
                        myList.add(rice);
                        System.out.println("rice added to list");
                        System.out.println();
                        break;
                        case 9:
                        quantities.add(quantityOfProduct());
                        myList.add(mexicanRice);
                        System.out.println("Mexican rice added to list");
                        System.out.println();
                        break;
                    case 10:
                        quantities.add(quantityOfProduct());
                        myList.add(toothpaste);
                        System.out.println("toothpaste added to list");
                        System.out.println();
                        break;
                    case 11:
                        myList = allProducts;
                        break;
                }
            }else break;
        }
    }

    private void calculateListForEachSuperMarket(){
        calculateTotalForMyMarket();
        calculateTotalForSklavenitis();
        calculateTotalForAB();
        calculateTotalForKritikos();
    }

    private double quantityOfProduct(){
        System.out.print("Quantity: ");
        return scanner.nextDouble();
    }

    private ArrayList<Product> calculateTotalForMyMarket(){

        for (String product: myList) {
            myMarket.getHomePage();
            if (product.equals("Dove advanced care coconut")){
                product = "Dove advanced care coconut spray";
            }
            if (product.equals(mexicanRice)){
                product = "Ben's Original Ρύζι Κινέζικο";
            }
            myMarketList.add(myMarket.searchFor(product).getFirstResultProduct());
        }
        return myMarketList;
    }

    private ArrayList<Product> calculateTotalForKritikos(){

        for (String product: myList) {
            kritikos.getHomePage();
            if (product.equals(noodlesCurry)){
                product = "Μαggi curry";
            }
            if (product.equals(tuna)){
                product = "Rio Mare Τόνος Σε Ελαιόλαδο";
            }
            if (product.equals(rice)){
                product = "Parboiled σακουλακι";
            }
            if (product.equals(milk)){
                product = "Γάλα Φρέσκο 2L";
            }
            if (product.equals(deodorant)){
                ab.getHomePage();
                kritikosList.add(new Product("deodorant MISSING", ab.searchFor(product).getFirstResultProduct().getProductPrice()));
                continue;
            }
            if (product.equals(mexicanRice)){
                ab.getHomePage();
                kritikosList.add(new Product("Mexican rice MISSING", ab.searchFor(product).getFirstResultProduct().getProductPrice()));
                continue;
            }
            kritikosList.add(kritikos.searchFor(product).getFirstResultProduct());
        }
        return kritikosList;
    }

    private ArrayList<Product> calculateTotalForAB(){

        for (String product: myList) {
            ab.getHomePage();
            if (product.equals(shampoo)){
                product = "Σαμπουάν και Conditioner 2σε1 Classic 650ml";
            }
            if (product.equals(noodlesCurry)){
                product = "Noodle Cup Magic Asia Κάρυ 63g";
            }
            aBList.add(ab.searchFor(product).getFirstResultProduct());
        }
        return aBList;
    }

    /**
     * if a product is missing then, gets adds the word MISSING to the product name and
     * gets the price from MyMarket.
     */
    private ArrayList<Product> calculateTotalForSklavenitis(){
        //ArrayList<Product> sklavenitisList = new ArrayList<>();

        for (String product: myList) {
            sklavenitis.getHomePage();
            if (product.equals("ψωμί τοστ Παπαδοπούλου γευση2 σταρένιο 700gr")){
                product = "ψωμί τοστ παπαδοπουλου 700gr";
            }
            if (product.equals(milk)){
                product = "ΔΕΛΤΑ Καθημερινά Φρέσκο Γάλα Πλήρες 2lt";
            }
            if (product.equals("Μαggi noodles cup Κάρυ")){
                myMarket.getHomePage();
                sklavenitisList.add(new Product("Noodles MISSING", myMarket.searchFor(product).getFirstResultProduct().getProductPrice()));
                continue;
            }
            sklavenitisList.add(sklavenitis.searchFor(product).getFirstResultProduct());
        }
        return sklavenitisList;
    }

    private void cheapestSolution(){

        for (int i = 0; i < myMarketList.size(); i++) {
            ArrayList<Double> prices = new ArrayList<>();
            prices.add(myMarketList.get(i).getProductPrice());
            prices.add(sklavenitisList.get(i).getProductPrice());
            prices.add(aBList.get(i).getProductPrice());
            prices.add(kritikosList.get(i).getProductPrice());
            Double minValue = Collections.min(prices);
            Integer minIndex = prices.indexOf(minValue);

            switch (minIndex){
                case 0:
                    myMarketCheapestList.add(myMarketList.get(i));
                    break;
                case 1:
                    sklavenitisCheapestList.add(sklavenitisList.get(i));
                    break;
                case 2:
                    aBCheapestList.add(aBList.get(i));
                    break;
                case 3:
                    kritikosCheapestList.add(kritikosList.get(i));
                    break;
            }
        }
    }



    private void printResults(){
        System.out.println("My Market");
        printShoppingList(myMarketList);
        System.out.println();
        System.out.println("Sklavenitis");
        printShoppingList(sklavenitisList);
        System.out.println();
        System.out.println("AB");
        printShoppingList(aBList);
        System.out.println("Kritikos");
        printShoppingList(kritikosList);
        System.out.println("My Market Cheapest");
        printShoppingList(myMarketCheapestList);
        System.out.println();
        System.out.println("Sklavenitis Cheapest");
        printShoppingList(sklavenitisCheapestList);
        System.out.println();
        System.out.println("AB Cheapest");
        printShoppingList(aBCheapestList);
        System.out.println();
        System.out.println("Kritikos Cheapest");
        printShoppingList(kritikosCheapestList);
        for (Product product:myMarketCheapestList) {
            totalOfCheapest += product.getProductPrice();
        }
        for (Product product:sklavenitisCheapestList) {
            totalOfCheapest += product.getProductPrice();
        }
        for (Product product:aBCheapestList) {
            totalOfCheapest += product.getProductPrice();
        }
        for (Product product:kritikosCheapestList) {
            totalOfCheapest += product.getProductPrice();
        }

        System.out.println("CHEAPEST SOLUTION TOTAL: " + totalOfCheapest);
    }


    private void printShoppingList(ArrayList<Product> list){
        double total = 0.0;
        System.out.println("-".repeat(125));
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("| %-99s : %-4.2f x %-4.2f = %-4.2f |%n",list.get(i).getProductName(), list.get(i).getProductPrice(), quantities.get(i), list.get(i).getProductPrice() * quantities.get(i));
            total += list.get(i).getProductPrice()*quantities.get(i);
        }
        System.out.println("=".repeat(125));
        System.out.printf("| %-113s : %-5.2f |%n","Total price: " , total);
        System.out.println("-".repeat(125));
    }
}
