package com.zielona.tesla.service;

import com.zielona.tesla.model.transactions.Account;
import com.zielona.tesla.model.transactions.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public List<Account> report(List<Transaction> transactions) {
        Map<String, Account> accounts = new HashMap<>(closestPowerOf2(transactions.size()));

        transactions.forEach(
            tr -> {
                var creditAccount = accounts.get(tr.getCreditAccount());
                if (creditAccount == null) {
                    creditAccount = new Account(tr.getCreditAccount(), 0, 1, new BigDecimal(String.valueOf(tr.getAmount())));
                    accounts.put(tr.getCreditAccount(), creditAccount);
                } else {
                    creditAccount.incCreditCount();
                    creditAccount.setBalance(creditAccount.getBalance().add(tr.getAmount()));
                }

                var debitAccount = accounts.get(tr.getDebitAccount());
                if (debitAccount == null) {
                    debitAccount = new Account(tr.getDebitAccount(), 1, 0, (new BigDecimal(String.valueOf(tr.getAmount()))).negate());
                    accounts.put(tr.getDebitAccount(), debitAccount);
                } else {
                    debitAccount.incDebitCount();
                    debitAccount.setBalance(debitAccount.getBalance().subtract(tr.getAmount()));
                }
            }
        );

        return accounts.values().stream()
                .sorted((e1, e2) -> e1.getAccountNumber().compareTo(e2.getAccountNumber()))
                .toList();
    }

    private int closestPowerOf2(int num) {
        int power = 32;
        while (power <= num/2) {
            power *= 2;
        }
        return power;
    }
}
