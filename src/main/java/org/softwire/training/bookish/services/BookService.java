package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class BookService extends DatabaseService {
        public List<Book> getAllBooks() {
            return jdbi.withHandle(handle ->
                    handle.createQuery("SELECT * FROM Books")
                            .mapToBean(Book.class)
                            .list()
            );
        }

        public void addBook(Book book) {
            jdbi.useHandle(handle ->
                    handle.createUpdate("INSERT INTO Books (ISBN, Title, Author, Descrip, Genre) VALUES (:ISBN, :Title, :Author, :Descrip, :Genre)")
                            .bind("ISBN", book.getISBN())
                            .bind("Title", book.getTitle())
                            .bind("Author", book.getAuthor())
                            .bind("Descrip", book.getDescrip())
                            .bind("Genre", book.getGenre())
                            .execute()
            );
        }

        public void deleteBook(int bookId) {
            jdbi.useHandle(handle ->
                    handle.createUpdate("DELETE FROM Books WHERE BookId = :BookId")
                            .bind("BookId", bookId)
                            .execute()
            );
        }

        public void editBook (Book book) {
            jdbi.useHandle( handle ->
                    handle.createUpdate("UPDATE Books SET ISBN = :ISBN, Title = :Title, Author = :Author, Descrip = :Descrip, Genre = :Genre WHERE bookId = :bookId")
                            .bind("ISBN", book.getISBN())
                            .bind("Title", book.getTitle())
                            .bind("Author", book.getAuthor())
                            .bind("Descript", book.getDescrip())
                            .bind("Genre", book.getGenre())
                            .execute()
            );
        }

        public Book getBookFromID(int bookId) {
                return jdbi.withHandle(handle ->
                        handle.createQuery("SELECT * FROM Books WHERE BookId = :BookId")
                                .mapTo(Book.class)
                                .findOnly()

            );
        }
    }

