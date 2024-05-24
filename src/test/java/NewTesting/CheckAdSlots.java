package NewTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckAdSlots {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
    //    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Specify the path to the directory containing the URLs file
            String urlsFilePath = "C:\\Users\\Dinesh\\IdeaProjects\\First project\\src\\test\\java\\NewTesting\\predchampallseriesurls.txt";
            BufferedReader reader = new BufferedReader(new FileReader(urlsFilePath));
            String url;

            // Read each URL from the file
            while ((url = reader.readLine()) != null) {
                // Visit the URL
                driver.get(url);

                // Check if the page contains an element with data-ad-slot attribute
                boolean hasAdSlot = !driver.findElements(By.cssSelector("[data-ad-slot]")).isEmpty();

                // Print the result
                System.out.println(url + ", " + hasAdSlot);
            }

            // Close the reader
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
