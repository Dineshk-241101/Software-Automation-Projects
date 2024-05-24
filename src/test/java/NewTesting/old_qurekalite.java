
// WITH DEPLOYMENT

package NewTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class old_qurekalite
{

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        ChromeDriver qureka = new ChromeDriver();
        qureka.manage().deleteAllCookies();

        qureka.get("http://play01.qureka.com");  // fetching the URLs
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='option option_1_A']")).click();  // Sample question-1
        Thread.sleep(2000);

//		qureka.findElement(By.xpath("//*[@class='text-white close-btn']")).click();
//		Thread.sleep(2000);

        qureka.navigate().refresh(); // refresh the page
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='option option_1_B']")).click();  // Sample question-2
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='loginbtn']")).click();  // Let's go
        Thread.sleep(2000);

        qureka.navigate().refresh();  // refresh the page
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='loginbtn']")).click();  // Let's go
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='dashwin dash-anchor']")).click();  // recent winners
        Thread.sleep(2000);

        qureka.manage().window().fullscreen();  // to remove ad
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='userlivebtnwin']")).click();	// going inside the winners list
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='quizhead']")).click(); // going back to all winners list
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='quizhead']")).click();  // clicking on play now quiz
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//div[@class='userlivebtnwin']")).click();  // clicking on start now
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='coin-eligble2 startbtn2']")).click();
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-1
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-2
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-3
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-4
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-5
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='quit']")).click();  //taking exit
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//button[@class='yes']")).click();  //redirecting to the score screen
        Thread.sleep(2000);

        qureka.manage().window().fullscreen();
        Thread.sleep(2000);

//		qureka.findElement(By.xpath("(//div[@class='userlivebtnwin'])[2]")).click();
//		Thread.sleep(2000);
//
//		qureka.findElement(By.xpath("//a[@class='coin-eligble2 startbtn2']")).click();   // clicking on the start now button
//		Thread.sleep(2000);
//
//		qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-1
//		Thread.sleep(2000);
//
//		qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-2
//		Thread.sleep(2000);
//
//		qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-3
//		Thread.sleep(2000);
//
//		qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-4
//		Thread.sleep(2000);
//
//		qureka.findElement(By.xpath("//a[@class='option1']")).click();  // answering q-5
//		Thread.sleep(2000);
//
//		qureka.findElement(By.xpath("//a[@class='quit']")).click();  //taking exit
//		Thread.sleep(2000);
//
//		qureka.findElement(By.xpath("//button[@class='yes']")).click();  //clicking on yes to exit
//		Thread.sleep(2000);
//
//		qureka.manage().window().fullscreen();
//		Thread.sleep(2000);

        qureka.findElement(By.xpath("//*[@id='app-backbtn']")).click(); // clicking on the back button
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//*[@id='fartuneBtn']")).click();
        Thread.sleep(2000);

        qureka.manage().window().fullscreen();
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//span[@id='fortuneClose']")).click();
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//a[@class='earningtext earningtext1 text-yellow']")).click();
        Thread.sleep(2000);

        qureka.manage().window().fullscreen();
        Thread.sleep(2000);

        qureka.findElement(By.xpath("//*[@class='close']")).click();
        Thread.sleep(2000);

        //qureka.quit();

    }

}


