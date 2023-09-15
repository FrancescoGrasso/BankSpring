package org.generation.bank;

public abstract class Account {
    private double balance;
    private long id;

    public Account(double amount) {
        if (amount >= 0) {
            this.balance = amount;
        } else {
            throw new IllegalArgumentException("L'importo iniziale non può essere negativo");
        }
    }

    public double getBalance() {
        return balance;
    }

    public long getId(){
        return id;
    }

    public void withdraw(double amount) throws InsufficentBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("L'importo da prelevare non è valido");
        }
        if (amount > balance) {
            throw new InsufficentBalanceException("Non può prelevare più di quanto v'è nel conto", amount, balance);
        }
    }

    public abstract void deposit(double amount);

    public void transfer(Account destinationAccount, double amount) throws InsufficentBalanceException {
        if (amount >= 0 && amount <= balance) {
            withdraw(amount);
            destinationAccount.deposit(amount);
        } else {
            throw new IllegalArgumentException("L'importo da trasferire non è valido");
        }
    }

    public void transferTo(Account destinationAccount, int amount) throws InsufficentBalanceException {
        if (balance >= amount) {
            withdraw(amount);
            destinationAccount.deposit(amount);
        } else {
            throw new IllegalArgumentException("L'importo da trasferire non è valido");
        }
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void setId(long id) {
        this.id = id;
    }
}