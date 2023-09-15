package org.generation.bank;

import java.util.Calendar;
import java.util.Date;

public class GoldenAccount extends Account{
    public GoldenAccount(double amount) {
        super(amount);
    }

    @Override
    public void deposit(double amount) {
        if (amount >= 0) {
            double bonusPercentage = calculateBonusPercentage();
            double bonus = amount * (bonusPercentage / 100);
            double totalAmount = amount + bonus;
            setBalance(getBalance() + totalAmount);
        }
    }

    private double calculateBonusPercentage() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        switch (dayOfWeek){
            case Calendar.SUNDAY -> {return 1.0;}
            case Calendar.MONDAY -> {return 2.0;}
            case Calendar.TUESDAY -> {return 3.0;}
            case Calendar.WEDNESDAY -> {return 4.0;}
            case Calendar.THURSDAY -> {return 5.0;}
            case Calendar.FRIDAY -> {return 6.0;}
            case Calendar.SATURDAY -> {return 7.0;}
            default -> {return 0.0;}
        }
    }
}
