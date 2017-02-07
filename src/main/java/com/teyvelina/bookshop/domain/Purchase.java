package com.teyvelina.bookshop.domain;

/**
 * Created by ateper on 07.02.17.
 */
public class Purchase {

    private String name;

    private double cash;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
