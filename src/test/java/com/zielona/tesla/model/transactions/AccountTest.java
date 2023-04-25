package com.zielona.tesla.model.transactions;

import com.zielona.tesla.model.onlinegame.Clan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AccountTest {

    @Test
    void getAccountNumber() {
        var account = new Account();
        account.setAccountNumber("31074318698137062235845814");
        Assertions.assertEquals("31074318698137062235845814", account.getAccountNumber());
    }

    @Test
    void incDebitCount() {
        var account = new Account();
        account.incDebitCount();
        Assertions.assertEquals(1, account.getDebitCount());
        account.incDebitCount();
        Assertions.assertEquals(2, account.getDebitCount());
    }

    @Test
    void incCreditCount() {
        var account = new Account();
        account.incCreditCount();
        Assertions.assertEquals(1, account.getCreditCount());
        account.incCreditCount();
        Assertions.assertEquals(2, account.getCreditCount());
    }

    @Test
    void getBalance() {
        var account = new Account();
        account.setBalance(new BigDecimal("12.34"));
        Assertions.assertEquals("12.34", account.getBalance().toString());
    }

    @Test
    void testEquals() {
        var account1 = new Account();
        account1.setAccountNumber("31074318698137062235845814");
        account1.setBalance(new BigDecimal("11.22"));

        var account2 = new Account();
        account2.setAccountNumber("31074318698137062235845814");
        account2.setBalance(new BigDecimal("11.22"));

        Assertions.assertEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    void testHashCode() {
        var account1 = new Account();
        account1.setAccountNumber("31074318698137062235845814");
        account1.setBalance(new BigDecimal("22.11"));

        var account2 = new Account();
        account2.setAccountNumber("31074318698137062235845814");
        account2.setBalance(new BigDecimal("22.11"));

        Assertions.assertEquals(account1.hashCode(), account2.hashCode());
    }
}