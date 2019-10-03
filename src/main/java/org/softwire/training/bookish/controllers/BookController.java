package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.BookPageModel;
import org.softwire.training.bookish.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class BookController {
    @Controller
    @RequestMapping("/books")
    public class BookController{

        private final BookService bookService;

        @Autowired
        public BookController(BookService bookService){
            this.bookService = bookService;
        }
        @RequestMapping("")
        ModelAndView books() {

            List<Book> allBooks = bookService.getAllBooks();
            BookPageModel bookPageModel = new BookPageModel();
            bookPageModel.setBooks(allBooks);
            return new ModelAndView("book", "model")
        }

    }
}
