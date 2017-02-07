package com.teyvelina.bookshop;

import com.teyvelina.bookshop.domain.Bill;
import com.teyvelina.bookshop.exception.BookNotFoundException;
import com.teyvelina.bookshop.exception.NotEnoughMoneyException;
import com.teyvelina.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by ateper on 2/3/17.
 */
@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

}
