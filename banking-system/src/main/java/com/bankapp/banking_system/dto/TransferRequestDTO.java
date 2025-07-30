package com.bankapp.banking_system.dto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequestDTO {
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;

}
