package library_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Return {
    public int return_id;
    public int borrow_id;

    public Return(int return_id,int borrow_id) {
        this.return_id = return_id;
        this.borrow_id = borrow_id;
    }

    public static void insertReturn(int borrow_id,Connection con) throws SQLException{
        String sql = "insert into return values(null,?,null);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,borrow_id);
        ps.executeUpdate();
        ps.close();
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