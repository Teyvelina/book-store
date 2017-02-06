package com.teyvelina.bookshop.service;

import com.teyvelina.bookshop.domain.Bill;
import com.teyvelina.bookshop.domain.Book;
import com.teyvelina.bookshop.exeception.BookNotFoundException;
import com.teyvelina.bookshop.exeception.NotEnoughMoneyException;
import com.teyvelina.bookshop.reprository.BookRepository;

/**
 * Created by ateper on 2/3/17.
 */
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Bill buy(String name, double cash)
            throws BookNotFoundException, NotEnoughMoneyException {

        if (!bookRepository.exists(name)) {
            throw new BookNotFoundException();
        }

        Book book;
        try {
            book = bookRepository.get(name);
        } catch (Exception e) {
            throw new BookNotFoundException();
        }

        if (book == null) {
            throw new BookNotFoundException();
        }

        if (book.getPrice() > cash) {
            throw new NotEnoughMoneyException();
        }

        Bill bill = new Bill();
        bill.setBook(book);
        bill.setMoney(cash);
        bill.setChange(cash - book.getPrice());

        return bill;
    }
}
