package mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database1 {
    private Connection con;
    private String username;
    private String password;
    private String uri;
    
    public Database1(String uri, String username, String password) {
        this.uri = uri;
        this.username = username;
        this.password = password;
    }
    
    public Connection openConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(uri, "root", "root");
        return con;
    }
    
    public void closeConnection() throws Exception{
        con.close();
    }

}