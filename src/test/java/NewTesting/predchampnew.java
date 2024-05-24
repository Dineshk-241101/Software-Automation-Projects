package NewTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class predchampnew {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://play01.predchamp.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //driver.findElement(By.className("bottom-redirect-content")).click();
        System.out.println(isClickable(driver.findElement(By.id("optionA"))));
        driver.findElement(By.id("optionA")).click(); 
        Thread.sleep(3000);
        driver.findElement(By.id("claimButton")).click();
        Thread.sleep(11000);
        driver.findElement(By.id("dismiss-button-element")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.id("optionA")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("close-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='2']//a[@id='optionA']")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("continue-btn")).click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.className("continue-btn")).click();
        sleepThread();
        driver.findElement(By.id("celebrityLetBtn")).click();
        sleepThread();
        driver.findElement(By.className("option")).click();
        sleepThread();
        driver.findElement(By.className("option")).click();
        sleepThread();
        driver.findElement(By.className("option")).click();
        sleepThread();
        driver.findElement(By.className("option")).click();
        sleepThread();
        driver.findElement(By.className("next-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    static void sleepThread() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static boolean isClickable(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}