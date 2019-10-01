package org.softwire.training.bookish;

import org.apache.tomcat.jni.Library;
import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;

import javax.swing.*;
import java.sql.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String database = "Library";
        String user = "root";
        String password = "Weasel211170";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

        //jdbcMethod(connectionString);
        jdbiMethod(connectionString);
    }

//    private static void jdbcMethod(String connectionString) throws SQLException {
//        Connection connection = DriverManager.getConnection(connectionString);
//        System.out.println("JDBC method...");
//
//        // TODO: print out the details of all the books (using JDBC)
//        Statement stmnt = null;
//        String query = "select * from Books";
//        try {
//            stmnt = connection.createStatement();
//            ResultSet rs = stmnt.executeQuery(query);
//            while(rs.next()){
//                int bookId = rs.getInt("BookId");
//                int isbn = rs.getInt("ISBN");
//                String title = rs.getString("Title");
//                String author = rs.getString("Author");
//                String description = rs.getString("Descrip");
//                String genre = rs.getString("Genre");
//                System.out.println(bookId + "\t" + isbn + "\t" + title + "\t" + author + "\t" + description + "\t" + genre);
//            }
//    }catch (SQLException e){
//
//        }finally {
//            if(stmnt != null){
//                stmnt.close();
//            }
//        }
//        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
//
//
//
//    }


    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);

        List<Book> books = jdbi.withHandle(handle ->{
//            handle.createUpdate("INSERT INTO Books(bookId, ISBN, Title, Author, Descrip, Genre) VALUES (:bookId, :ISBN, :Title, :Author, :Descrip, :Genre)")
//                    .bind("bookId", )

            return handle.createQuery("SELECT * FROM Books")
                    .mapToBean(Book.class)
                    .list();
                });
        for(int x =0; x <books.size(); x++) {
            System.out.println(books.get(x).getBookId()+ " "+books.get(x).getISBN()+ " "+books.get(x).getTitle()+" "+books.get(x).getAuthor()+" "+books.get(x).getDescrip()+" "+books.get(x).getGenre());

           // System.out.println();

        }

    }
}
