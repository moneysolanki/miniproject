package mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection con;
    private String username;
    private String password;
    private String uri;
    
    public Database(String username,String password,String uri){
        this.username=username;
        this.password=password;
        this.uri=uri;
    }
    
    public Connection openConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(username,password,uri);
        return con;
    }
    
    public void closeConnection() throws Exception{
        con.close();
    }
    
    public static void main(String[] args) {
        String uri="jdbc:mysql://localhost:3306/Student";
        Database d=new Database("root","test123",uri);
        System.out.println("user"+d.username);
        System.out.println("pass"+d.password);
        System.out.println("uri"+d.uri);
    }
}