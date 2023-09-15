package org.generation.bank;

public interface AccountRepository{

    void addAccount(Account account);
    Account findById(long id);
    Iterable<Account> getAccounts();
}
