package org.generation.bank.model.services.abstractions;

import org.generation.bank.model.Account;

public interface AccountService {
    Iterable<Account> getAllAccounts();
    void save(Account a);
    Account findAccountById(long id);
}
