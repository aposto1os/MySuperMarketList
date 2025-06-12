package myMarketTests;

import myMarket.MyMarket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMyMarket{

    private WebDriver driver = new ChromeDriver();

    @Test
    public void testDeodorant(){
        String returnedProductName = getProductName("Dove advanced care coconut spray");
        Assert.assertEquals(returnedProductName, "Dove Αποσμητικό Σωμ. Spray Advanced Care Coconut 150ml", "Incorrect product returned!");
    }

    @Test
    public void testShampoo(){
        String returnedProductName = getProductName("wash & go Σαμπουάν classic 650ml");
        Assert.assertEquals(returnedProductName, "Wash & Go 2in1 Σαμπουάν Classic 650 ml", "Incorrect product returned!");
    }

    @Test
    public void testToast(){
        String returnedProductName = getProductName("ψωμί τοστ Παπαδοπούλου γευση2 σταρένιο 700gr");
        Assert.assertEquals(returnedProductName, "Παπαδοπούλου Ψωμί Τοστ Γεύση2 Σταρένιο 700gr", "Incorrect product returned!");
    }

    @Test
    public void testMilk(){
        String returnedProductName = getProductName("ΔΕΛΤΑ Καθημερινά Φρέσκο Γάλα Πλήρες 1lt");
        Assert.assertEquals(returnedProductName, "Δέλτα Καθημερινά Φρέσκο Γάλα Πλήρες 2 lt", "Incorrect product returned!");
    }

    @Test
    public void testNoodles(){
        String returnedProductName = getProductName("Μαggi noodles cup Κάρυ");
        Assert.assertEquals(returnedProductName, "Maggi Noodles Cup Με Κάρυ 63gr", "Incorrect product returned!");
    }

    @Test
    public void testButter(){
        String returnedProductName = getProductName("βούτυρο lurpak soft 225gr");
        Assert.assertEquals(returnedProductName, "Lurpak Soft Ανάλατο Σκαφάκι 225gr", "Incorrect product returned!");
    }

    @Test
    public void testTuna(){
        String returnedProductName = getProductName("Rio Mare Τόνος Σε Ελαιόλαδο 2x160gr");
        Assert.assertEquals(returnedProductName, "Rio Mare Τόνος Σε Ελαιόλαδο 2x160gr", "Incorrect product returned!");
    }

    @Test
    public void testRice(){
        String returnedProductName = getProductName("ρύζι parboiled ben's σακουλακι");
        Assert.assertEquals(returnedProductName, "Uncle Ben's Original Ρύζι Parboiled Σε Σακκουλάκι 10λεπτο Ισπανίας 500gr", "Incorrect product returned!");
    }
    @Test
    public void testChineseRice(){
        String returnedProductName = getProductName("Ben's Original Ρύζι Κινέζικο");
        Assert.assertEquals(returnedProductName, "Ben's Original Ρύζι Κινέζικο Σε 2' Λεπτά 220gr", "Incorrect product returned!");
    }

    @Test
    public void testCoffee(){
        String returnedProductName = getProductName("ΛΟΥΜΙΔΗΣ ΠΑΠΑΓΑΛΟΣ Παραδοσιακός Ελληνικός Καφές 194gr");
        Assert.assertEquals(returnedProductName, "ΛΟΥΜΙΔΗΣ ΠΑΠΑΓΑΛΟΣ Παραδοσιακός Ελληνικός Καφές 194gr", "Incorrect product returned!");
    }

    @Test
    public void testToothpaste(){
        String returnedProductName = getProductName("COLGATE Total Fresh");
        Assert.assertEquals(returnedProductName, "Colgate Total Active Fresh Οδοντόκρεμα 75ml", "Incorrect product returned!");
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
