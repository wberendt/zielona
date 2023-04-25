package com.zielona.tesla.api;

import com.zielona.tesla.model.transactions.Account;
import com.zielona.tesla.model.transactions.Transaction;
import com.zielona.tesla.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionsApiController implements TransactionsApi {

    private final TransactionService transactionService;

    @Autowired
    public TransactionsApiController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<List<Account>> report(List<Transaction> transaction) {
        return ResponseEntity.ok().body(transactionService.report(transaction));
    }
}
