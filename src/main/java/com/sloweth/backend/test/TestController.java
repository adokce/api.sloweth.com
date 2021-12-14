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

    public Mono<String> getEtherBalance(){



        String apiKey = "secret";

        String tempUri = "/api?module=account&action=balance&address=0xde0b295669a9fd93d5f28d9ec85e40f4cb697bae&tag=latest&apiKey="+apiKey;

        return webClientBuilder.baseUrl("https://api.etherscan.io").build()
                .get()
                .uri(tempUri)
                .retrieve().bodyToMono(String.class);
    }



    // To get tokens balance of an account, we first need to find every ERC20 token balance form an account
    // https://docs.etherscan.io/api-endpoints/accounts#get-a-list-of-erc20-token-transfer-events-by-address

    // Then we need to query each token that appeared in a list of transactions to get each token balance of the owner's account
    // https://docs.etherscan.io/api-endpoints/tokens#get-erc20-token-account-balance-for-tokencontractaddress
}

