package org.generation.bank.model;

public class CheckingAccount extends Account{
    public CheckingAccount(double amount) {
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
