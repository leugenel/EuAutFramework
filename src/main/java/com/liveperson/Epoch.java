package com.liveperson;
import com.liveperson.automation.ui.core.annotations.LoadableView;
import com.liveperson.automation.ui.web.view.WebPageView;


/**
 * Created by eugenel on 10/10/16.
 */
@LoadableView("/epoch.yaml")
public class Epoch extends WebPageView {

    public String getEpochData() {

        return text("Clock").content();
    }

    public void clickTimeStamp(){

        button("Timestamp").click();
    }

    public String getGMT() {

        return text("GMT").content();
    }

    public String getTimeZone(){
        return text("TimeZone").content();
    }

    //Get current date 01/01/2016 00:00
    public String getDate(){

        return " Year: "+textField("Year").getText()+
               " Month: "+textField("Month").getText()+
               " Day: "+textField("Day").getText()+
               " Hour: "+textField("Hour").getText()+
               " Minutes: "+textField("Min").getText()+
               " Seconds: "+textField("Sec").getText();
    }

    //Clear all the data from the page
    public void clear(){
        link("Clear").click();
    }

    //Set 2016 year beginning
    public void setDate(){
        textField("Year").type("2016");
        textField("Month").type("01");
        textField("Day").type("01");
        textField("Hour").type("00");
        textField("Min").type("00");
        textField("Sec").type("00");
    }

    //Receive timestamp of the 2016 beginning
    public String getTimeStamp(){
        button("ToTimestamp").click();
        return text("Timestamp2016").content();
    }
}
