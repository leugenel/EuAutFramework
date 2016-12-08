package com.liveperson;
import com.liveperson.automation.ui.web.WebBrowser;
import com.liveperson.automation.ui.webdriver.builder.WebDriverBrowserBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class);

        WebBrowser webBrowser = new WebDriverBrowserBuilder().withRemoteWebDriver(new FirefoxDriver()).build();

        Epoch epochPage = webBrowser.render(Epoch.class);

        //Read the epoch time
        logger.info("Current Unix epoch time is "+ epochPage.getEpochData());

        //Lets try to take GMT before it shown
        //Read the epoch time
        logger.info("GMT still not shown "+ epochPage.getGMT());

        //Click on the converter
        epochPage.clickTimeStamp();

        //Read the epoch time
        logger.info("Current "+ epochPage.getGMT());

        //Read Time Zone
        logger.info("Your time Zone: "+ epochPage.getTimeZone());

        //Get date
        logger.info("Current date: " + epochPage.getDate());

        epochPage.clear();

        epochPage.setDate();

        epochPage.getTimeStamp();

        logger.info("The timestamp of 01/01/2016: " + epochPage.getTimeStamp());

    }
}
