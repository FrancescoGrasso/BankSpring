package org.generation.bank.model;

import org.generation.bank.model.Account;

public class SavingsAccount extends Account {
    public SavingsAccount(double amount) {
        super(amount);
    }

    @Override
    public void deposit(double amount) {
        if (amount >= 0) {
            setBalance(getBalance() + amount);
        } else {
            throw new IllegalArgumentException("L'importo del deposito non può essere negativo");
        }
    }
}
