package com.teyvelina.bookshop.service;

import com.teyvelina.bookshop.domain.Bill;
import com.teyvelina.bookshop.domain.Book;
import com.teyvelina.bookshop.exception.BookNotFoundException;
import com.teyvelina.bookshop.exception.NotEnoughMoneyException;
import com.teyvelina.bookshop.reprository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ateper on 2/3/17.
 */
@Service
public class BookService {

    @Autowired
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
