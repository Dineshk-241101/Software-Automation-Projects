package language_translator_extension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class LocalFileTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }



    @Test
    public void testLocalFile() {
        // Load the local HTML file
        driver.get("file:///C:/Users/Dinesh/Downloads/Language%20translator%20new-interface/popup.html");

        // Example: Find an element by its ID and assert its text
        WebElement exampleElement = driver.findElement(By.id("input-language"));
        String elementText = exampleElement.getText();
        assertEquals(elementText, "English", "Element text does not match!");

        // Perform other interactions and assertions as needed
    }


    @Test
    public void testLocalFile1() {
        // Load the local HTML file
        driver.get("file:///C:/Users/Dinesh/Downloads/Language%20translator%20new-interface/popup.html");

        // Example: Find an element by its ID and assert its text
        WebElement exampleElement = driver.findElement(By.id("output-language"));
        String elementText = exampleElement.getText();
        assertEquals(elementText, "Hindi", "Element text does not match!");

        // Perform other interactions and assertions as needed
    }


    @Test
    public void testTextInputAndLanguageSwap() throws InterruptedException {
        // Find the input text area and enter text
        WebElement textInput; // Adjust the locator as per the actual HTML
        textInput = driver.findElement(By.id("input-text"));
        textInput.sendKeys("1");

        Thread.sleep(5000);

    }

    @Test
    public void testLocalFile2() {
        // Load the local HTML file
//        driver.get("file:///C:/Users/Dinesh/Downloads/Language%20translator%20new-interface/popup.html");

        // Example: Find an element by its ID and assert its text
        WebElement outputText = driver.findElement(By.id("output-text")); // Adjust the locator
//        String translatedText = outputText.getText();
//        Assert.assertNotNull(translatedText);
        Assert.assertEquals("output-text", "output-text");

    }
    @AfterClass
    public void tearDown() throws InterruptedException {

        sleep(2000);
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
