package NewTesting;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class predchampnew {
    public static WebDriver predchampnew = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        predchampnew.get("https://play01.predchamp.com");
        predchampnew.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //predchampnew.findElement(By.className("bottom-redirect-content")).click();
        System.out.println(isClickable(predchampnew.findElement(By.id("optionA"))));
        predchampnew.findElement(By.id("optionA")).click();
        Thread.sleep(3000);
        /*predchampnew.findElement(By.id("claimButton")).click();
        Thread.sleep(11000);
        predchampnew.findElement(By.id("dismiss-button-element")).click();
        predchampnew.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));*/
        predchampnew.findElement(By.className("close-button")).click();
        Thread.sleep(3000);
//        predchampnew.findElement(By.id("optionB")).click();
//        Thread.sleep(3000);
        /*predchampnew.findElement(By.className("close-button")).click();
        Thread.sleep(3000);*/
        predchampnew.findElement(By.xpath("//div[@id='2']//a[@id='optionA']")).click();
        Thread.sleep(3000);
        predchampnew.findElement(By.className("continue-btn")).click();
        Thread.sleep(2000);
        predchampnew.navigate().refresh();
        Thread.sleep(2000);
        predchampnew.findElement(By.className("continue-btn")).click();
        sleepThread();
        predchampnew.findElement(By.id("celebrityLetBtn")).click();
        sleepThread();
        predchampnew.findElement(By.className("option")).click();
        sleepThread();
        predchampnew.findElement(By.className("option")).click();
        sleepThread();
        predchampnew.findElement(By.className("option")).click();
        sleepThread();
        predchampnew.findElement(By.className("option")).click();
        sleepThread();
        predchampnew.findElement(By.className("next-button")).click();
        predchampnew.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    private static boolean isClickable(WebElement optionA) {
        return false;
    }

    static void sleepThread() throws InterruptedException {
        Thread.sleep(2000);
    }
}