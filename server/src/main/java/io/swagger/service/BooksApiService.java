package io.swagger.service;

import io.swagger.api.BooksApiDelegate;
import io.swagger.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksApiService implements BooksApiDelegate {

    @Override
    public ResponseEntity<List<Book>> filterAllBooks() {
        Book book = new Book();
        book.setId(100L);
        book.setName("Test Book");
        List<Book> books = new ArrayList<>();
        books.add(book);
        ResponseEntity<List<Book>> result = new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        return result;
    }
}
