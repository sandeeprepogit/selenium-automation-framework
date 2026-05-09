package checkTrainAvailibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class cnfTicketElements {

    WebDriver driver;

    // Constructor
    public cnfTicketElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public By sourceStation = By.xpath("//label[@for='source-station']/parent::div");
//    public By destinationStation = By.xpath("//label[@for='destination-station']/parent::div");
//    public By dateOfJourney = By.xpath("//label[@for='dateOfJourney']/parent::div");
//    public By searchBtn = By.id("searchtrains");
//    public By dates = By.xpath("//button[contains(@class,'react-calendar__tile') and not(@disabled)]");

//     Locators using @FindBy
    @FindBy(xpath = "//*[contains(text(),'From')]/parent::div/parent::div")
    WebElement sourceStation;

    @FindBy(xpath = "//*[contains(text(),'To')]/parent::div/parent::div")
    WebElement destinationStation;

    @FindBy(xpath = "//div[@id='station-search']//div[contains(@class,'cursor-pointer')]")
    WebElement selectStn;

    @FindBy(xpath = "//label[@for='dateOfJourney']/parent::div | //p[contains(text(),'Departure Date')]/parent::div/parent::div")
    WebElement dateOfJourney;

    @FindBy(xpath = "//button[contains(text(),'SEARCH')]")
    WebElement searchBtn;

    @FindBy(xpath = "//button[contains(@class,'react-calendar__tile') and not(@disabled)]")
    List<WebElement> dates;

    @FindBy(xpath = "//div[@role='dialog']//button[contains(text(),'Not now')]")
    WebElement notNow;

    @FindBy(xpath = "//div[text()='Available']/parent::div/parent::div/parent::div/parent::div[@data-key='SL']")
    List<WebElement> availableTicket;

    @FindBy(xpath = "//button[@role='option']")
    List<WebElement> dateOnMainPage;

    @FindBy(xpath = "//div[text()='Available']/parent::div/parent::div/parent::div/parent::div[@data-key='SL']/parent::div/preceding-sibling::div//span[@class='mr-5']")
    List<WebElement> trainNumbers;

    @FindBy(xpath = "//input")
    WebElement enterStnName;


}