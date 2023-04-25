package com.zielona.tesla.api;

import com.zielona.tesla.model.transactions.Account;
import com.zielona.tesla.model.transactions.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TransactionsApi {

    /**
     * POST /transactions/report
     * Execute report
     *
     * @param transaction  (required)
     * @return Successful operation (status code 200)
     */
    @PostMapping(value = "/transactions/report",
            produces = "application/json",
            consumes = "application/json")
    ResponseEntity<List<Account>> report(@RequestBody List<Transaction> transaction);

}
