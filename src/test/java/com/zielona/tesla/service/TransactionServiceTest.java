package com.zielona.tesla.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zielona.tesla.model.transactions.Account;
import com.zielona.tesla.model.transactions.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

class TransactionServiceTest {

    private ObjectMapper mapper = new ObjectMapper();
    private TransactionService transactionService = new TransactionServiceHashImpl();

    @Test
    void report() throws IOException {
        List<Transaction> transactions = getRequest("/transactions/example_request.json");
        List<Account> accounts = getResponse("/transactions/example_response.json");

        var result = transactionService.report(transactions);
        Assertions.assertArrayEquals(accounts.toArray(), result.toArray());
    }

    private List<Account> getResponse(String jsonFile) throws IOException {
        InputStream isResponse = Account.class.getResourceAsStream(jsonFile);
        List<Account> accounts = Arrays.asList(mapper.readValue(isResponse, Account[].class));
        isResponse.close();
        return accounts;
    }

    private List<Transaction> getRequest(String jsonFile) throws IOException {
        InputStream isRequest = Transaction.class.getResourceAsStream(jsonFile);
        List<Transaction> transactions = Arrays.asList(mapper.readValue(isRequest, Transaction[].class));
        isRequest.close();
        return transactions;
    }
}