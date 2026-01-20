package seleniumWebDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LaunchBrowser {

    static void playVideo(String videoName) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.findElement(By.name("search_query")).sendKeys(videoName);
        driver.findElement(By.xpath("//button[@title='Search']")).click();
        Thread.sleep(3000);
        List<WebElement> webElements = driver.findElements(By.tagName("ytd-video-renderer"));
        webElements.get(0).click();


    }

    public static void main(String[] args) throws InterruptedException {
        playVideo("");
    }

}
