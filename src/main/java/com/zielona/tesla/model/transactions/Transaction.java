package com.zielona.tesla.model.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Transaction
 */
public class Transaction {

    @JsonProperty("debitAccount")
    private String debitAccount;

    @JsonProperty("creditAccount")
    private String creditAccount;

    @JsonProperty("amount")
    private BigDecimal amount;

    /**
     * Get debit account
     * @return debitAccount
     */
    public String getDebitAccount() {
        return debitAccount;
    }

    /**
     * Set debit account
     * @param debitAccount
     */
    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }

    /**
     * Get credit account
     * @return creditAccount
     */
    public String getCreditAccount() {
        return creditAccount;
    }

    /**
     * Set credit account
     * @param creditAccount
     */
    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }

    /**
     * Get amount
     * @return amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Set amount
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
