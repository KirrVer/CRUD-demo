package net.bookmanager.service;

import net.bookmanager.dao.BookDao;
import net.bookmanager.model.Book;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;


    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);

    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);

    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        this.bookDao.deleteBook(id);
    }

    @Override
    @Transactional
    public Book getBookId(int id) {
        return this.bookDao.getBookId(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {

        return this.bookDao.listBooks();
    }


}
