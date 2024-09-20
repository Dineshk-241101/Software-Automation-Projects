package language_translator_extension;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class LanguageTranslatorTest {

private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your WebDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        driver = new ChromeDriver();

        // Open the target HTML file
        driver.get("file:///C:/Users/Dinesh/Downloads/Language%20translator%20new-interface/popup.html");
    }

    @Test
    public void testTextInputAndLanguageSwap() {
        // Find the input text area and enter text
        WebElement textInput; // Adjust the locator as per the actual HTML
        textInput = By.id("textInput").findElement(driver);
        textInput.sendKeys("Hello, world!");

        // Find the language dropdowns and swap languages
        WebElement sourceLanguageDropdown = driver.findElement(By.id("sourceLanguage")); // Adjust the locator
        WebElement targetLanguageDropdown = driver.findElement(By.id("targetLanguage")); // Adjust the locator

        Select sourceLanguageSelect = new Select(sourceLanguageDropdown);
        Select targetLanguageSelect = new Select(targetLanguageDropdown);

        sourceLanguageSelect.selectByVisibleText("English");
        targetLanguageSelect.selectByVisibleText("Hindi");


        // Trigger the translation (assuming there's a button to translate)
        WebElement translateButton ;
        translateButton = driver.findElement(By.id("translateButton")); // Adjust the locator
        translateButton.click();

        // Verify translation output
        WebElement outputText = driver.findElement(By.id("outputText")); // Adjust the locator
        String translatedText = outputText.getText();
        Assert.assertNotNull(translatedText);
        Assert.assertFalse(translatedText.isEmpty());
    }

    @Test
    public void testCopyAndPasteFunctionality() {
        // Copy the translated text
        WebElement copyButton; // Adjust the locator
        copyButton = driver.findElement(By.id("copyButton"));
        copyButton.click();

        // Open a new tab and paste the copied content
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get("about:blank");
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.CONTROL + "v");

        // Verify pasted content
        String pastedContent = body.getText();
        Assert.assertEquals(pastedContent, driver.findElement(By.id("outputText")).getText());
    }

    @Test
    public void testVoiceInput() {
        // Find the voice input button and click it
        WebElement voiceInputButton; // Adjust the locator
        voiceInputButton = driver.findElement(By.id("voiceInputButton"));
        voiceInputButton.click();

        // Simulate voice input (Note: This step might require a more advanced setup, depending on the implementation)
        // Here, we assume the voice input automatically translates to text after a delay
        try {
            Thread.sleep(5000); // Wait for the voice input to process
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify the input text area has text
        WebElement textInput = driver.findElement(By.id("textInput")); // Adjust the locator as per the actual HTML
        String voiceInputText = textInput.getAttribute("value");
        Assert.assertNotNull(voiceInputText);
        Assert.assertFalse(voiceInputText.isEmpty());
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
