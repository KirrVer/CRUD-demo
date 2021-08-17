package net.bookmanager.service;

import net.bookmanager.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
    Book getBookId(int id);
    List<Book> listBooks();

}
