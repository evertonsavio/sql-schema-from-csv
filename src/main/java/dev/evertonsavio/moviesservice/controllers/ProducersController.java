package dev.evertonsavio.moviesservice.controllers;

import dev.evertonsavio.moviesservice.models.ProducerResponse;
import dev.evertonsavio.moviesservice.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducersController {

    @Autowired
    private ProducerService producerService;

    @GetMapping(value = "/v1/producers", produces = "application/json")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    public ProducerResponse getProducers() {
        return producerService.getProducersAwardsInterval();
    }
}
