package com.tekgs.nextgen.tekmart.data.value;

import java.text.NumberFormat;
import java.util.Locale;

public class Cents {
    private final Double amount;

    public Cents(Integer amount) {
        this.amount = Double.valueOf(amount);
    }

    public static Cents getInstance(Integer amount) {
        return new Cents(amount);
    }

    public String inDollarAmount() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return numberFormat.format(amount / 100);
    }
}
