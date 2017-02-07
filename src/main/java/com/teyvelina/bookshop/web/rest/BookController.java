package com.teyvelina.bookshop.web.rest;

import com.teyvelina.bookshop.domain.Bill;
import com.teyvelina.bookshop.domain.Book;
import com.teyvelina.bookshop.domain.Purchase;
import com.teyvelina.bookshop.exception.BookNotFoundException;
import com.teyvelina.bookshop.exception.NotEnoughMoneyException;
import com.teyvelina.bookshop.reprository.BookRepository;
import com.teyvelina.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ateper on 07.02.17.
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public Bill buy(@RequestBody Purchase purchase) throws BookNotFoundException, NotEnoughMoneyException {
        Bill bill = null;
        try {
            bill = bookService.buy(purchase.getName(), purchase.getCash());
        } catch (BookNotFoundException e) {
            System.out.println("There is no such book in the store");
            ;
        } catch (NotEnoughMoneyException e) {
            System.out.println("You have no enough money");
        }

        if (bill == null) {
            return null;
        }

        return bill;
    }


    /*public Bill buy(String name, double cash)
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
   `         throw new NotEnoughMoneyException();
        }

        Bill bill = new Bill();
        bill.setBook(book);
        bill.setMoney(cash);
        bill.setChange(cash - book.getPrice());

        return bill;
    }*/
}
