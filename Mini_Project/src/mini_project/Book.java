package mini_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;

public class Book {
    public int book_id;
    public String book_name;
    public String isbn_no;
    public String publisher_name;
    public String author_name;

    public Book(int book_id, String book_name, String isbn_no, String publisher_name, String author_name) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.isbn_no = isbn_no;
        this.publisher_name = publisher_name;
        this.author_name = author_name;
    }
    
    public static void insertBook(String book_name,String isbn_no,String publisher_name,String author_name,Connection con) throws SQLException{
        String sql = "insert into book values(null,?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, book_name);
        ps.setString(2,isbn_no);
        ps.setString(3,publisher_name);
        ps.setString(4,author_name);
        ps.executeUpdate();
        ps.close();
    }
 
    public static ObservableList<Book> getBook(Connection con) throws SQLException {
        ObservableList<Book> bookArray = FXCollections.observableArrayList();
        String sql = "select * from book;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String ISBN = rs.getString(3);
            String publisher = rs.getString(4);
            String author =  rs.getString(5);
            Book b = new Book(id ,name, ISBN,  publisher, author);
            bookArray.add(b);
        } 
        rs.close();
        ps.close();
        return bookArray;
    
    } 
    
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getIsbn_no() {
        return isbn_no;
    }

    public void setIsbn_no(String isbn_no) {
        this.isbn_no = isbn_no;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}