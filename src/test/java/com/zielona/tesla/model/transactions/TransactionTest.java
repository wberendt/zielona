package com.zielona.tesla.model.transactions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void getDebitAccount() {
        var transaction = new Transaction();
        transaction.setDebitAccount("32309111922661937852684864");
        Assertions.assertEquals("32309111922661937852684864", transaction.getDebitAccount());
    }

    @Test
    void getCreditAccount() {
        var transaction = new Transaction();
        transaction.setCreditAccount("66105036543749403346524547");
        Assertions.assertEquals("66105036543749403346524547", transaction.getCreditAccount());
    }

    @Test
    void getAmount() {
        var transaction = new Transaction();
        transaction.setAmount(new BigDecimal("22.33"));
        Assertions.assertEquals("22.33", transaction.getAmount().toString());
    }
}