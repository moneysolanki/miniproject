
package mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

    private Connection con;
    private String uri;
    private String username;
    private String password;

    public database(String uri, String username, String password) {
        this.uri = uri;
        this.username = username;
        this.password = password;
    }
    public Connection openConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.con = DriverManager.getConnection(uri, "root", "root");
        return con;
    }
    public void closeConnection() throws SQLException{
        con.close();
    }
    

}
