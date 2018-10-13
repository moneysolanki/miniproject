package mini_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Return {
    public int return_id;
    public int borrow_id;

    public Return(int return_id,int borrow_id) {
        this.return_id = return_id;
        this.borrow_id = borrow_id;
    }
    
    public static void insertReturn(int borrow_id,Connection con) throws SQLException{
        String sql = "insert into return_book values(null,?,null);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,borrow_id);
        ps.executeUpdate();
        ps.close();
    }
    public static ObservableList<Return> getReturn(Connection con) throws SQLException {
        ObservableList<Return> returnArray = FXCollections.observableArrayList();
        String sql = "select * from return_book;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int returnId = rs.getInt(1);
            int borrowId = rs.getInt(2);
            Return r = new Return(returnId ,borrowId);
            returnArray.add(r);
        } 
        rs.close();
        ps.close();
        return returnArray;
    
    }
    public int getReturn_id() {
        return return_id;
    }

    public void setReturn_id(int return_id) {
        this.return_id = return_id;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }
}