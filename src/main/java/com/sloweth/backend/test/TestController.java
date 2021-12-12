package com.sloweth.backend.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/test")
    public Mono<String> test(){

        String tempUri = "/api?module=account&action=txlist&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&startblock=0&endblock=99999999&page=1&offset=10&sort=asc&";

        return webClientBuilder.baseUrl("https://api.etherscan.io").build()
                .get()
                .uri(tempUri)
                .retrieve().bodyToMono(String.class);
    }
}

