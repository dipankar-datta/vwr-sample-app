package com.savagepotatoes.vwrsampleapp.web.controller;

import com.savagepotatoes.vwrsampleapp.services.ApplicationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApplicationStatusController {

    @Autowired
    private ApplicationStatusService service;

    @GetMapping("/can_serve")
    public boolean getStressCheck() {
        return service.canServe();
    }

    @PostMapping("/overload")
    public String overloadApplication(@RequestBody Integer seconds) {
        return service.overloadApplication(seconds);
    }

}
