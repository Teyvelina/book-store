package com.teyvelina.bookshop;

import com.teyvelina.bookshop.domain.Bill;
import com.teyvelina.bookshop.exeception.BookNotFoundException;
import com.teyvelina.bookshop.exeception.NotEnoughMoneyException;
import com.teyvelina.bookshop.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ateper on 2/3/17.
 */
public class BookStoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
                "application-context.xml"
        });

        BookService bookService = context.getBean(BookService.class);

        Bill bill = null;
        try {
            bill = bookService.buy("Pushkin 123", 1.50);
        } catch (BookNotFoundException e) {
            System.out.println("There is no such book in the store");;
        } catch (NotEnoughMoneyException e) {
            System.out.println("You have no enough money");
        }

        if (bill == null) {
            return;
        }

        System.out.println("You've successfully bought the book");
        System.out.println("Book: " + bill.getBook().getName());
        System.out.println("Change: " + bill.getChange());

    }

}
