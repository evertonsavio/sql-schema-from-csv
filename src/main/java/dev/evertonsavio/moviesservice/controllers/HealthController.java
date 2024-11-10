package dev.evertonsavio.moviesservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping(value = "/", produces = "application/json")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    public String health() {
        return "{\"status\": \"Service is up and running\"}";
    }
}
