// WITHOUT DEPLOYMENT
package NewTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class predchamp {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver predchamp = new ChromeDriver();
        predchamp.manage().deleteAllCookies();

        predchamp.get("https://1049.win.predchamp.com");
        predchamp.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        predchamp.findElement(By.xpath("//a[@id='optionA']")).click();  // SAMPLE Q-1
        Thread.sleep(3000);
        predchamp.findElement(By.id("claimButton")).click();
        Thread.sleep(3000);
        predchamp.navigate().refresh();
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("//a[@id='optionA']")).click();  // SAMPLE Q-1
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("//a[@class='close-button']")).click();  // earn coin pop up
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("(//a[@id='optionA'])[2]")).click();   // SAMPLE Q-2
        Thread.sleep(2000);
        predchamp.navigate().refresh();
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("//a[@class='continue-btn']")).click();
        Thread.sleep(2000);
        predchamp.navigate().refresh();
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("//a[@class='continue-btn']")).click();
        Thread.sleep(2000);
        predchamp.findElement(By.id("celebrityLetBtn")).click();
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("//p[@class='option']")).click();   // QUESTION SET-1
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("//p[@class='option']")).click();   // QUESTION SET-2
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("(//p[@class='option'])[2]")).click();   // QUESTION SET-3
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("(//p[@class='option'])[2]")).click();   // QUESTION SET-4
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("//a[@class='next-button']")).click();  // NEXT
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("//button[@class='join-now-btn joinNowButton']")).click();
        Thread.sleep(2000);
        predchamp.findElement(By.xpath("//div[@class='start-prediction-button']")).click();
        Thread.sleep(2000);

        predchamp.quit();

    }
}
