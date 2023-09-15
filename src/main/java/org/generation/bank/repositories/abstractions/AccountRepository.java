package org.generation.bank.repositories.abstractions;

import org.generation.bank.model.Account;

public interface AccountRepository{

    void addAccount(Account account);
    Account findById(long id);
    Iterable<Account> getAccounts();
}
