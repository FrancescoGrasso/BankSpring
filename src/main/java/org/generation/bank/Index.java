package org.generation.exercises.bank_account_prof;

public class Index {
    public static void main(String[] args) {
        // Creazione di due account
        Account account1 = new SavingsAccount(1000); // Esempio di un account di risparmio
        Account account2 = new CheckingAccount(500); // Esempio di un account corrente
        Account account3 = new GoldenAccount(3000); // Esempio di account Gold
        Account account4 = new CaymanAccount(5000, "segreto123");

        AccountRepository ac = new InMemoryAccountRepository();
        Bank bank = new Bank(ac);

        bank.addAccount(account1);
        bank.addAccount(account2);

        // Stampa dei saldi iniziali
        System.out.println("Saldo dell'Account 1: " + account1.getBalance());
        System.out.println("Saldo dell'Account 2: " + account2.getBalance());
        System.out.println("Saldo dell'Account 3: " + account3.getBalance());

        // Esecuzione del trasferimento
        double amountToTransfer = 200;
        double depositAmmount = 300;
        try {
            account1.transfer(account2, amountToTransfer);
        } catch (InsufficentBalanceException e) {
            System.out.println(e.getMessage());
            System.out.printf("L'operazione avrebbe portato uno sforamento di %f \n", (e.getAmount() - e.getBalance()));
        }
        account3.deposit(depositAmmount);
        account4.deposit(6000);


        // Stampa dei saldi dopo il trasferimento
        System.out.println("\nDopo il trasferimento di " + amountToTransfer + " da Account 1 a Account 2:");
        System.out.println("Saldo dell'Account 1: " + account1.getBalance());
        System.out.println("Saldo dell'Account 2: " + account2.getBalance());
        System.out.println("Il saldo dell'account 3 (GOLD): " + account3.getBalance());
        System.out.println("Il saldo del conto Cayman: " + account4.getBalance());

        bank.printAccountBalances();
    }
}

