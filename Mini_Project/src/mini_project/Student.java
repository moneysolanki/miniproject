package mini_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Student {
    public int roll_no;
    public String student_name;
    public String phone_no;

    public Student(int roll_no, String student_name, String phone_no) {
        this.roll_no = roll_no;
        this.student_name = student_name;
        this.phone_no = phone_no;
    }
    
    public static void insertStudent(String student_name,String phone_no,Connection con) throws SQLException{
        String sql = "insert into student values(null,?,?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, student_name);
        ps.setString(2,phone_no);
        ps.executeUpdate();
        ps.close();
    }
   

    public static ObservableList<Student> getStudent(Connection con) throws SQLException {
        ObservableList<Student> studentArray = FXCollections.observableArrayList();
        String sql = "select * from student;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int rollNo = rs.getInt(1);
            String studentName = rs.getString(2);
            String phoneNo = rs.getString(3);
            Student s = new Student(rollNo,studentName, phoneNo);
            studentArray.add(s);
        } 
        rs.close();
        ps.close();
        return studentArray;
    
    } 

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
}