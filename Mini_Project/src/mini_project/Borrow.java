
package mini_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Borrow {

    public int borrow_id;
    public int roll_no;
    public int book_id;


    public Borrow(int borrow_id, int roll_no, int book_id) {
        this.borrow_id = borrow_id;
        this.roll_no = roll_no;
        this.book_id = book_id;

    }
    
    
    public static void insertBorrow(int roll_no, int book_id,Connection con) throws SQLException{
        String sql = "insert into borrow_book values(null,?,?,null);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, roll_no);
        ps.setInt(2,book_id);
        ps.executeUpdate();
        ps.close();
    }
    
    public static ObservableList<Borrow> getBorrow(Connection con) throws SQLException {
        ObservableList<Borrow> borrowArray = FXCollections.observableArrayList();
        String sql = "select * from borrow_book;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int borrowId = rs.getInt(1);
            int rollNo = rs.getInt(2);;
            int bookId = rs.getInt(3);
            Borrow b = new Borrow(borrowId , rollNo,bookId);
            borrowArray.add(b);
        } 
        rs.close();
        ps.close();
        return borrowArray;
    
    } /*
    public static void main(String[] args) throws Exception {
        String uri = "jdbc:mysql://localhost:3306/miniproject";
        Database b = new Database(uri,"root","root");
        Connection c = b.openConnection();
        Borrow.insertBorrow(1,10, c);
    }*/
    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

   
    
 
           
}