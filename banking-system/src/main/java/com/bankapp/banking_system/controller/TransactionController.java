package com.bankapp.banking_system.controller;

import com.bankapp.banking_system.dto.TransferRequestDTO;
import com.bankapp.banking_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Endpoint POST /transactions/transfer
    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequestDTO request) {
        transactionService.transferMoney(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getAmount()
        );
        return "Transfer successful";
    }
}
