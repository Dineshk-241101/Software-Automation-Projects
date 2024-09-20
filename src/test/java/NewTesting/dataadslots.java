package NewTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class dataadslots {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to your chromedriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // List of URLs to check
        List<String> urls = new ArrayList<>();
        urls.add("https://473.win.predchamp.com");
        Thread.sleep(5000);
        urls.add("https://474.win.predchamp.com");
        Thread.sleep(5000);
        urls.add("https://475.win.predchamp.com");
        Thread.sleep(5000);
        urls.add("https://476.win.predchamp.com");
        Thread.sleep(5000);
        urls.add("https://420.win.predchamp.com");
        Thread.sleep(5000);
        urls.add("https://400.win.predchamp.com");
        Thread.sleep(5000);



        // Add more URLs as needed...

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Iterate over each URL and check for data-ad-slot
            for (String url : urls) {
                driver.get(url);
                boolean isAdSlotPresent = isDataAdSlotPresent(driver);
                System.out.println("URL: " + url + " - Is data-ad-slot present: " + isAdSlotPresent);
                Thread.sleep(5000);
            }
        } finally {
            // Close the browser
//            driver.quit();
        }
    }

    public static boolean isDataAdSlotPresent(WebDriver driver) {
        // Find elements with the data-ad-slot attribute
        try {
            driver.findElement(By.cssSelector("[data-ad-slot]"));
            // If element is found, return true
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // If element is not found, return false
            return false;
        }
    }
}
