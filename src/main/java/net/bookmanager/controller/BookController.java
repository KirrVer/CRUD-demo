package net.bookmanager.controller;

import net.bookmanager.model.Book;
import net.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";

    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        if (book.getId() == 0){
            this.bookService.addBook(book);
        }
        else this.bookService.updateBook(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        this.bookService.deleteBook(id);

        return "redirect:/books";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
    model.addAttribute("book", this.bookService.getBookId(id));
    model.addAttribute("listBooks",this.bookService.listBooks());

    return "books";
    }

    @RequestMapping(value = "/bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookId(id));
        return "bookdata";
    }


}
