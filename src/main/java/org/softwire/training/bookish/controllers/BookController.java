package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.page.BookPageModel;
import org.softwire.training.bookish.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

    @Controller
    @RequestMapping("/books")
    public class BookController {

        private final BookService bookService;

        @Autowired
        public BookController(BookService bookService) {
            this.bookService = bookService;
        }

        @RequestMapping("")
        ModelAndView books() {

            List<Book> allBooks = bookService.getAllBooks();
            BookPageModel bookPageModel = new BookPageModel();
            bookPageModel.setBooks(allBooks);
            return new ModelAndView("book", "model", bookPageModel);

    }
        @RequestMapping("/add-book")
        RedirectView addBook(@ModelAttribute Book book) {

            bookService.addBook(book);

            return new RedirectView("/books");
        }

        @RequestMapping("/delete-book")
        RedirectView deleteBook(@RequestParam int bookId){

            bookService.deleteBook(bookId);

            return new RedirectView("/books");
        }

        @RequestMapping("/edit-book")
        ModelAndView editBook(@RequestParam int bookId){

            bookService.getBookFromID(bookId);

            return new ModelAndView("bookedit", "model", bookId);
        }
        @RequestMapping("/confirm-edit-book")
        RedirectView confirmEditBook(@ModelAttribute Book book){

            bookService.editBook(book);
            return new RedirectView("/books");
        }
}
