package com.teyvelina.bookshop.exeception;

/**
 * Created by ateper on 2/6/17.
 */
public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException() {
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }

}
