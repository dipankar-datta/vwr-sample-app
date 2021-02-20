package com.savagepotatoes.vwrsampleapp.web.controller;

import com.savagepotatoes.vwrsampleapp.services.ApplicationStatusService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApplicationStatusController {

    private ApplicationStatusService service;

    public ApplicationStatusController(ApplicationStatusService service) {
        this.service = service;
    }

    @CrossOrigin("*")
    @GetMapping("/can_serve")
    public boolean getStressCheck() {
        return service.canServe();
    }

    @PostMapping("/overload")
    public String overloadApplication(@RequestBody short seconds) {
        return service.overloadApplication(seconds);
    }

    @GetMapping("/overload/{duration}")
    public String overloadApplicationGet(@PathVariable short duration) {
        return service.overloadApplication(duration);
    }

}
