package com.sloweth.backend.WalletEthereum;

import com.sloweth.backend.Etherscan.EtherscanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletEthereumController {

    private final EtherscanService etherscanService;

    public WalletEthereumController(EtherscanService etherscanService) {
        this.etherscanService = etherscanService;
    }

    @GetMapping("/account-balance")
    public String test() {
        String etherBalance = etherscanService.getEtherBalance();
        String accountERC20Transactions = etherscanService.getAccountERC20Transactions();

        return "Testing";
    }

}
