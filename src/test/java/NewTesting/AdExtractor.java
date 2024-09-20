package NewTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static NewTesting.predchampnew.sleepThread;

public class AdExtractor {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
       /* System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");*/

        // Initialize Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Absolute path to the file
        String filePath = "C:\\Users\\Dinesh\\Documents\\predchampallseriesurls.txt";

        try {
            // Read URLs from the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String url;

            while ((url = reader.readLine()) != null) {
                // Ensure the URL has the correct protocol
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "https://" + url; // Assuming https if no protocol is specified
                }

                // Open the URL
                driver.get(url);

                // Find all elements with the class 'adsbygoogle'
                List<WebElement> ads = driver.findElements(By.className("adsbygoogle"));

                for (WebElement ad : ads) {
                    // Get the data-ad-status and data-ad-slot attributes
                    String adStatus = ad.getAttribute("data-ad-status");
                    sleepThread();
                    String adSlot = ad.getAttribute("data-ad-slot");
                    sleepThread();

                    // Print the URL and attribute values
                    System.out.println("URL: " + url);
                    System.out.println("data-ad-status: " + adStatus);
                    System.out.println("data-ad-slot: " + adSlot);
                    System.out.println("------------------------------");
                }
            }

            reader.close();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
