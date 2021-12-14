package com.sloweth.backend.Etherscan;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EtherscanService {

    private final WebClient webClient;
    private final String apiKey = "secret";

    public EtherscanService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.etherscan.io").build();
    }

    public String getEtherBalance() {

        String uri = "/api?module=account&action=balance&address=0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae&tag=latest&apikey="+apiKey;

        return this.webClient.get().uri(uri)
                .retrieve().bodyToMono(String.class).block();
    }

    public String getAccountERC20Transactions() {
        String uri = "/api?module=account&action=txlist&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&startblock=0&endblock=99999999&page=1&offset=10&sort=asc&";

        return this.webClient.get().uri(uri)
                .retrieve().bodyToMono(String.class).block();
    }
}
