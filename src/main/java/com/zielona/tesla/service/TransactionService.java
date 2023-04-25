package com.zielona.tesla.service;

import com.zielona.tesla.model.transactions.Account;
import com.zielona.tesla.model.transactions.Transaction;

import java.util.List;

public interface TransactionService {
    List<Account> report(List<Transaction> transaction);

}
