package com.savagepotatoes.vwrsampleapp.services;

import org.springframework.stereotype.Service;

@Service
public class ApplicationStatusService {

    private short counter = 0;

    public boolean canServe() {
        return counter == 0;
    }

    public String overloadApplication(short secondsDuration) {

        if (secondsDuration <= 0 || secondsDuration > 60) {
            return "<h2>Invalid overload period. Please provide period between 1 and 60</h2>";
        }

        if (counter > 0) {
            return "<h2>Application is already overloaded for " + counter + " seconds </h2>";
        }

        counter = secondsDuration;

        Thread thread = new Thread(() -> {
            while (counter > 0) {
                try {
                    Thread.sleep(1000);
                    counter -= 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        return "<h2>Application overloaded for " + secondsDuration + " seconds</h2>";
    }
}
