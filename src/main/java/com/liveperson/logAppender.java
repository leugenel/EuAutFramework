/**
 *
 * Created by eugenel on 10/18/16.
 */
package com.liveperson;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;

public class logAppender extends ConsoleAppender {

    private static final int NORMAL = 0;
    private static final int FOREGROUND_BLACK = 30;
    private static final int FOREGROUND_GREEN = 32;

    private static final String PREFIX = "\u001b[";
    private static final String SUFFIX = "m";
    private static final char SEPARATOR = ';';
    private static final String END_COLOUR = PREFIX + SUFFIX;

    private static final String INFO_COLOUR = PREFIX
            + NORMAL+ SEPARATOR + FOREGROUND_BLACK + SUFFIX;

    /**
     * Wraps the ANSI control characters around the
     * output from the super-class Appender.
     */
    protected void subAppend(LoggingEvent event)
    {
        try {
            if (event.fqnOfCategoryClass.compareTo("org.apache.log4j.Category")==0){
                this.qw.write(FOREGROUND_GREEN);
                super.subAppend(event);
                this.qw.write(END_COLOUR);
            }
            else {
                super.subAppend(event);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        if(this.immediateFlush)
        {
            this.qw.flush();
        }
    }

}
