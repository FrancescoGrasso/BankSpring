package org.generation.bank;

public class Bank {

    private AccountRepository repository;

    // dependecy injection

    //constructor injection
    // (iniettare la dipendenza nel costruttore -
    //  parametro di tipo Interfaccia cosi per polimorfismo posso passare qualsiasi implementazione)
    public Bank(AccountRepository repo) {
        this.repository = repo;
    }// prima: repository = new InMemoryAccountRepository;

    /*
        la banca prima aveva una lista di conti correnti
        -una dipendenza diretta tra due classi di livello differente (logica business - sorgente dati)
        -> dividere dallo strato della logica dei dati
     */

    // setter injection (costruttore vuoto)

    /*public void setRepository(AccountRepository repo) {
        repository = repo;
    }*/

    public void addAccount(Account account) {
        repository.addAccount(account);
    }

    public void handleAccounts(Account firstAccount, Account secondAccount) throws InsufficentBalanceException {
        secondAccount.withdraw(200);
        if (firstAccount.getBalance() > secondAccount.getBalance()) {
            firstAccount.transferTo(secondAccount, 100);
        } else {
            secondAccount.transferTo(firstAccount, 100);
        }
    }

    public void printAccountBalances() {
        System.out.println("Il bilancio degli account nella banca sono: ");

        for (Account account : repository.getAccounts()) {
            System.out.println(account.getBalance());
        }
    }

}
