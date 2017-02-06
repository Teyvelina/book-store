package com.teyvelina.bookshop.exeception;

/**
 * Created by ateper on 2/6/17.
 */
@SuppressWarnings("WeakerAccess")
public class BookNotFoundException extends Exception {

    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }

}
