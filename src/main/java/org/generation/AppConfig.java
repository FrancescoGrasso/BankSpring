package org.generation;

import org.generation.bank.model.Bank;
import org.generation.bank.model.services.abstractions.AccountService;
import org.generation.bank.repositories.abstractions.AccountRepository;
import org.generation.bank.repositories.implementations.AccountServiceImp;
import org.generation.bank.repositories.implementations.InMemoryAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.generation"})
public class AppConfig {
//    @Bean(name = "accountService")
//    public AccountService getAccountService(){
//        AccountService a = new AccountServiceImp(getAccountRepository());
//        return a;
//    }
//    @Bean(name = "accountRepository")
//    public AccountRepository getAccountRepository(){
//        return new InMemoryAccountRepository();
//    }
//    @Bean(name = "bank")
//    public Bank getBank(){
//        return new Bank(getAccountService());
//    }
}
