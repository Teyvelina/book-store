package com.teyvelina.bookshop.config;

import com.teyvelina.bookshop.domain.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ateper on 07.02.17.
 */
@Configuration
public class BooksConfiguration {

    @Bean
    public List<Book> books() {
        return Arrays.asList(
                new Book("Pushkin", 10.50),
                new Book("Gogol", 5.30)
        );
    }

}
