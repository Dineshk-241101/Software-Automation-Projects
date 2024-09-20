package NewTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class newadslot {

    public static void main(String[] args) {
        // Set the path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application");

        // File containing the list of URLs
        String filePath = "C:/Users/Dinesh/Documents/predchampallseriesurls.txt";

        // Read URLs from file
        List<String> urls = readUrlsFromFile(filePath);

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Iterate over each URL and check for data-ad-slot
            for (String url : urls) {
                driver.get(url);
                boolean isAdSlotPresent = isDataAdSlotPresent(driver);
                System.out.println(STR."URL: \{url} - Is data-ad-slot present: \{isAdSlotPresent}");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static List<String> readUrlsFromFile(String filePath) {
        List<String> urls = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                urls.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;
    }

    public static boolean isDataAdSlotPresent(WebDriver driver) {
        // Find elements with the data-ad-slot attribute
        try {
            WebElement adSlotElement = driver.findElement(By.cssSelector("[data-ad-slot]"));
            // If element is found, return true
            return adSlotElement != null;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // If element is not found, return false
            return false;
        }
    }
}
