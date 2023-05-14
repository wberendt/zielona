package com.zielona.tesla.model.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Account
 */
public class Account {

    /**
     * Constructor
     */
    public Account() {
    }

    /**
     * Constructor
     * @param account
     * @param debitCount
     * @param creditCount
     * @param balance
     */
    public Account(String account, int debitCount, int creditCount, BigDecimal balance) {
        this.accountNumber = account;
        this.debitCount = debitCount;
        this.creditCount = creditCount;
        this.balance = balance;
    }

    @JsonProperty("account")
    private String accountNumber;

    @JsonProperty("debitCount")
    private int debitCount;

    @JsonProperty("creditCount")
    private int creditCount;

    @JsonProperty("balance")
    private BigDecimal balance;


    /**
     * Get account number
     * @return accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Set account number
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Number of debit transactions
     * @return debitCount
     */
    public int getDebitCount() {
        return debitCount;
    }

    /**
     * Increment number of debit transactions
     */
    public void incDebitCount() {
        this.debitCount++;
    }

    /**
     * Number of credit transactions
     * @return creditCount
     */
    public int getCreditCount() {
        return creditCount;
    }

    /**
     * Increment number of credit transactions
     */
    public void incCreditCount() {
        this.creditCount++;
    }

    /**
     * Get balance
     * @return balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Set balance
     * @param balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return Objects.equals(accountNumber, account1.accountNumber) && Objects.equals(debitCount, account1.debitCount) && Objects.equals(creditCount, account1.creditCount) && Objects.equals(balance, account1.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, debitCount, creditCount, balance);
    }
}
