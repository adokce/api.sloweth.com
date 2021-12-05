package com.sloweth.backend.Etherscan;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EtherscanService {

    private final WebClient webClient;

    public EtherscanService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://example.org").build();
    }

    public Mono<String> someRestCall(String name) {
        return this.webClient.get().uri("/{name}/details", name)
                .retrieve().bodyToMono(String.class);
    }
}
