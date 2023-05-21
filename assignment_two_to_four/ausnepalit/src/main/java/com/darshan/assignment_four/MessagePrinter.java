package com.darshan.assignment_four;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MessagePrinter {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                System.out.println("Current time: " + currentTime + " - This is a message.");

            }
        };

        timer.schedule(task, 0,  (2 * 60 * 1000));  // Schedule the task to run every 2 minutes (2 * 60 * 1000 milliseconds)
    }
}