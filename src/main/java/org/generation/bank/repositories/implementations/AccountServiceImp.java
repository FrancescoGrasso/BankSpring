package org.generation.bank.repositories.implementations;

import org.generation.bank.model.Account;
import org.generation.bank.model.services.abstractions.AccountService;
import org.generation.bank.repositories.abstractions.AccountRepository;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImp implements AccountService {

    private AccountRepository repo;

    public AccountServiceImp(AccountRepository accountRepo){
        this.repo = accountRepo;
    }
    @Override
    public Iterable<Account> getAllAccounts() {
        return repo.getAccounts();
    }

    @Override
    public void save(Account a) {
        repo.addAccount(a);
    }

    @Override
    public Account findAccountById(long id) {
        return repo.findById(id);
    }
}
