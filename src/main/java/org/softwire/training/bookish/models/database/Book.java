package org.softwire.training.bookish.models.database;

public class Book {

    int bookId;
    int ISBN;
    String Title;
    String Author;
    String Descrip;
    String Genre;


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String descrip) {
        Descrip = descrip;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getBookId() {
        return bookId;
    }

}
