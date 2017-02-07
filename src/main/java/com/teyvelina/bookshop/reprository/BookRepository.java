package com.teyvelina.bookshop.reprository;

import com.teyvelina.bookshop.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ateper on 2/6/17.
 */
@Repository
public class BookRepository {

    private List<Book> books;

    public BookRepository(List<Book> books) {
        this.books = books;
    }

    public Book get(String name) throws Exception {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        throw new Exception("No such book found");
    }

    public boolean exists(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
