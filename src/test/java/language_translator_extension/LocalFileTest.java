package language_translator_extension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class LocalFileTest {
    ChromeDriver driver = new ChromeDriver();
    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");

    }

    @Test
    public void testLocalFile() {
        // Load the local HTML file
        driver.get("file:///C:/Users/Dinesh/Downloads/Language%20translator%20new-interface/popup.html");

        // Example: Find an element by its ID and assert its text
//        WebElement exampleElement = driver.findElement(By.id("exampleElementId"));
//        String elementText = exampleElement.getText();
//        Assert.assertEquals(elementText, "Expected Text", "Element text does not match!");

        // Perform other interactions and assertions as needed
    }

//    @AfterClass
//    public void tearDown() {
//        // Close the browser
//        if (driver != null) {
////            driver.quit();
//        }
//    }
}
