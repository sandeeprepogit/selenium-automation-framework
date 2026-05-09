package checkTrainAvailibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckTrainAvaStatus {
    WebDriver driver;
    String cnfUrl = "https://www.confirmtkt.com/";

    cnfTicketElements elements;
    utils util;

    public CheckTrainAvaStatus() {
    }

    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        elements = new cnfTicketElements(driver);
        util = new utils();
    }

    public void openCnfTicket() {
        driver.get(cnfUrl);
    }

    public void selectDestinationAndSourceStn(String stnNameSource, String stnNameDest) throws InterruptedException {
        util.clickOnElement(elements.sourceStation);

        Thread.sleep(5000);
        util.clickOnElement(elements.sourceStation);
        elements.enterStnName.sendKeys(stnNameSource);
        Thread.sleep(3000);
        util.clickOnElement(elements.selectStn);
        util.clickOnElement(elements.destinationStation);
        elements.enterStnName.sendKeys(stnNameDest);
        Thread.sleep(3000);
        util.clickOnElement(elements.selectStn);
    }

    public void selectDate() throws InterruptedException {
        util.clickOnElement(elements.dateOfJourney);
        util.clickOnElement(elements.dates.get(2));
        util.clickOnElement(elements.searchBtn);
        Thread.sleep(5000);
        util.clickOnElement(elements.notNow);
    }


    public List<String> getTrainsWithSleeperAvailable() {
        List<String> availableTrains = new ArrayList<>();
        if(elements.dateOnMainPage.get(0).isDisplayed()) {
            int size = 30;
            for (int i = 0; i<= size; i++) {
                try {
                    Thread.sleep(3000);
                    boolean slAvailable;
                    try{
                        slAvailable=elements.trainNumbers.get(0).isDisplayed();
                    }catch (Exception e){
                        slAvailable=false;
                    }
                    if (slAvailable) {
                        int sizeTrain = elements.trainNumbers.size();
                        for (int j =0;j<=sizeTrain;j++) {
                            // Get train name
                            String trainName = elements.trainNumbers.get(j).getText();
                            availableTrains.add(trainName);
                        }
                    }else {
                        util.clickOnElement(elements.dateOnMainPage.get(i));
                        int sizeTrain = elements.trainNumbers.size();
                        for (int j =0;j<=sizeTrain;j++) {
                            // Get train name
                            String trainName = elements.trainNumbers.get(j).getText();
                            availableTrains.add(trainName);
                        }
                    }

                } catch (Exception e) {
                    // Optional: log exception
                    System.out.println("Error processing train: " + e.getMessage());
                }
            }
        }else{
            System.out.println("No Available trains are available for dates ");
        }
        return availableTrains;
    }

}
