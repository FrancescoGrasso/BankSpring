package org.generation.bank.repositories.implementations;

import org.generation.bank.model.Account;
import org.generation.bank.model.services.abstractions.AccountService;
import org.generation.bank.repositories.abstractions.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("accountService")
//@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class AccountServiceImp implements AccountService {

    private AccountRepository repo;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepo){

        this.repo = accountRepo;

        System.out.println("AccountServiceImp");
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
