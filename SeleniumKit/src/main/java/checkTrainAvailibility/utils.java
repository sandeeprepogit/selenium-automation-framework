package checkTrainAvailibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class utils {

    WebDriverWait wait;


    public void clickOnElement(WebElement element) throws InterruptedException {
        element.click();
        Thread.sleep(2000);
    }
}