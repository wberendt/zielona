package com.zielona.tesla.service;

import com.zielona.tesla.model.transactions.Account;
import com.zielona.tesla.model.transactions.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionServiceHashImpl implements TransactionService {
    @Override
    public List<Account> report(List<Transaction> transaction) {
        Map<String, Account> accounts = new HashMap<>();

        var it = transaction.iterator();
        while (it.hasNext()) {
            var el = it.next();
            var creditAccount = accounts.get(el.getCreditAccount());
            if (creditAccount == null) {
                creditAccount = new Account(el.getCreditAccount(), 0, 1, new BigDecimal(String.valueOf(el.getAmount())));
                accounts.put(el.getCreditAccount(), creditAccount);
            } else {
                creditAccount.incCreditCount();
                creditAccount.setBalance(creditAccount.getBalance().add(el.getAmount()));
            }

            var debitAccount = accounts.get(el.getDebitAccount());
            if (debitAccount == null) {
                debitAccount = new Account(el.getDebitAccount(), 1, 0, (new BigDecimal(String.valueOf(el.getAmount()))).negate());
                accounts.put(el.getDebitAccount(), debitAccount);
            } else {
                debitAccount.incDebitCount();
                debitAccount.setBalance(debitAccount.getBalance().subtract(el.getAmount()));
            }
        }

        return accounts.values().stream().sorted((e1, e2) -> e1.getAccountNumber().compareTo(e2.getAccountNumber())).toList();
    }
}
