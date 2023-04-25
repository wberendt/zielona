package com.zielona.tesla.model.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    public Account() {
    }

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getDebitCount() {
        return debitCount;
    }

    public void incDebitCount() {
        this.debitCount++;
    }

    public int getCreditCount() {
        return creditCount;
    }

    public void incCreditCount() {
        this.creditCount++;
    }

    public BigDecimal getBalance() {
        return balance;
    }

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
