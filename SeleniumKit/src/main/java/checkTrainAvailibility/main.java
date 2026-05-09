package checkTrainAvailibility;

public class main {
    public static void main(String[] args) throws InterruptedException {
        CheckTrainAvaStatus check= new CheckTrainAvaStatus();

        check.launchBrowser();
        check.openCnfTicket();
        check.selectDestinationAndSourceStn("Hyderabad", "Visakhapatnam");
        check.selectDate();
        System.out.println("Available Trains"+check.getTrainsWithSleeperAvailable());
    }
}
