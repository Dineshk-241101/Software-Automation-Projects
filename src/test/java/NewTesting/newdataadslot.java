package NewTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class newdataadslot {
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://play01.predchamp.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        driver.findElement(By.className("bottom-redirect-content")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement adElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("google_vignette")));
            System.out.println("Ad detected.");

            // Find and click the close button on the ad
            // Adjust the locator to match the close button's actual locator
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='toprow' and @role='button']")));
            System.out.println("Ad closed.");
        } catch (Exception e) {
            System.out.println("Ad not detected or failed to close.");
        }

        System.out.println("Sample Question-1");
        WebElement element = driver.findElement(By.xpath("//*[@class='intro-question-ads']/ins"));
        String adslotvalue = element.getAttribute("data-ad-slot");
        System.out.println( " data-ad-slot = " + adslotvalue );
        String adstatusvalue = element.getAttribute("data-ad-status");
        System.out.println("data-ad-status = "+adstatusvalue);
        System.out.println("----------------------------------------");

//        System.out.println(isClickable(driver.findElement(By.id("optionA"))));
//        driver.findElement(By.id("optionA")).click();
//        driver.findElement(By.id("claimButton")).click();
//        Thread.sleep(5000);
//        driver.navigate().refresh();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.id("optionA")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("close-button")).click();
        Thread.sleep(3000);

        System.out.println("Sample Question-2");
        WebElement element1 = driver.findElement(By.xpath("//*[@class='intro-question-ads']/ins"));
        String adslotvalue1 = element1.getAttribute("data-ad-slot");
        System.out.println( " data-ad-slot = " + adslotvalue1 );
        String adstatusvalue1 = element1.getAttribute("data-ad-status");
        System.out.println("data-ad-status = "+adstatusvalue1);
        System.out.println("----------------------------------------");

        driver.findElement(By.xpath("//div[@id='2']//a[@id='optionA']")).click();
        Thread.sleep(3000);

        driver.findElement(By.className("continue-btn")).click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        System.out.println("Continue screen A-1");
        WebElement element2 = driver.findElement(By.xpath("//*[@class='intro-success-ads']/ins"));
        String adslotvalue2 = element2.getAttribute("data-ad-slot");
        System.out.println( " data-ad-slot = " + adslotvalue2);
        String adstatusvalue2 = element2.getAttribute("data-ad-status");
        System.out.println("data-ad-status = "+ adstatusvalue2);
        System.out.println("----------------------------------------");


        driver.findElement(By.className("continue-btn")).click();
        sleepThread();
        element1 = driver.findElement(By.xpath("//*[@class='intro-question-ads']/ins"));
         adslotvalue1 = element1.getAttribute("data-ad-slot");
        System.out.println( " data-ad-slot = " + adslotvalue1 );
        adstatusvalue1 = element1.getAttribute("data-ad-status");
        System.out.println("data-ad-status = "+adstatusvalue1);
        System.out.println("----------------------------------------");

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

        element = driver.findElement(By.xpath("//ins[@data-ad-slot]"));
        adslotvalue = element.getAttribute("data-ad-slot");

        System.out.println("data-ad-slot = "+adslotvalue);

        //7467684411
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