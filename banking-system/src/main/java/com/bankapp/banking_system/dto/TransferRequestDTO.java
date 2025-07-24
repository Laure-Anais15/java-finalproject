// TransferRequestDTO.java (à mettre dans un package dto)
package com.bankapp.banking_system.dto;

public class TransferRequestDTO {
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;

    // Getters & setters
    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
