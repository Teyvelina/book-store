package com.teyvelina.bookshop.domain;

/**
 * Created by ateper on 2/6/17.
 */
public class Bill {

    private Book book;

    private double money;

    private double change;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
}
