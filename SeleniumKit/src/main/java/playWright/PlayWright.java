package playWright;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;


public class PlayWright {

    void playMyVideo(String nameOfVideo){

        Playwright pr = Playwright.create();
        Browser browser = pr.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https://www.youtube.com/");
//        System.out.println("youtube launched");
////        String videoName ="";
//        page.locator("input[name='search_query']").fill(nameOfVideo);
//        System.out.println("page.locator(\"input[name='search_query']\").fill(nameOfVideo)");
//        page.keyboard().press("Enter");
//
//        page.waitForSelector("ytd-video-renderer");
//        page.locator("ytd-video-renderer").first().click();
//        page.waitForTimeout(5000);
    }


    public static void main(String[] args) {
        PlayWright play = new PlayWright();
        play.playMyVideo("selenium");
    }

}
