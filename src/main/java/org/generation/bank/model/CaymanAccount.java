package org.generation.bank;

public class CaymanAccount extends Account{
    private String secretCode;

    public CaymanAccount(double amount, String secretCode) {
        super(amount);
        this.secretCode = secretCode;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            double totalBalance = getBalance() + amount;

            if (totalBalance > 10000) {
                double bonus = amount * 0.10;
                amount += bonus;
            }
            setBalance(getBalance() + amount);
        }else {
            throw new IllegalArgumentException("L'importo del deposito deve essere positivo");
        }
    }
}
