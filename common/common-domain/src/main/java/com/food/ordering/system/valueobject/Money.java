package com.food.ordering.system.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    public final BigDecimal amount;

    public static final Money ZERO = new Money(BigDecimal.ZERO);

    public Money(BigDecimal amount){
        this.amount = amount;
    }

    public BigDecimal getAmount(){
        return amount;
    }


    public boolean isGreaerThanZeo(){
        return  (this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0);
    }

    public boolean isGreaerThan(Money money){
        return (amount != null && this.amount.compareTo(money.getAmount()) > 0);
    }

    public Money add(Money money){
        return new Money(setScale(this.amount.add(money.getAmount())));
    }

    public Money subtract(Money money){
        return new Money(setScale(this.amount.subtract(money.getAmount())));
    }

    public Money multiply(Money money){
        return new Money(setScale(this.amount.multiply(money.getAmount())));
    }

    private BigDecimal setScale(BigDecimal value){
        return value.setScale(2 , RoundingMode.HALF_DOWN);
    }
}
