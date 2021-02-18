package com.savagepotatoes.vwrsampleapp.services;

import org.springframework.stereotype.Service;

@Service
public class ApplicationStatusService {

    private boolean doServe = true;


    public boolean canServe() {
        return doServe;
    }

    public String overloadApplication(Integer seconds) {

        if (!doServe) {
            return "Application is already overloaded";
        }

        if (seconds > 60) {
            return "Not allowed to overload for more then a minute";
        }

        if (doServe) {

            doServe = false;

            Thread thread = new Thread(() -> {
                try {

                    Thread.sleep(seconds * 1000);
                    doServe = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            thread.start();
            return "Application locked for " + seconds + " seconds";
        }

        return "Unknown status";
    }
}
