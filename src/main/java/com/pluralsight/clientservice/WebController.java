package com.pluralsight.clientservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class WebController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/")
    public Mono<List<TollStation>> getTollStations(){
        
        Mono<List<TollStation>> response = this.webClient.get()
            .uri("http://localhost:8082/api/tollStations")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<List<TollStation>>() {});
        return response;
    }
}
