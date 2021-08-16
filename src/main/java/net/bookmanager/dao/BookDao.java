package net.bookmanager.dao;

import net.bookmanager.model.Book;

import java.util.List;

public interface BookDao {
     void addBook(Book book);
     void updateBook(Book book);
     void deleteBook(int id);

     public Book getBookId(int id);
     public List<Book> listBooks();
}
