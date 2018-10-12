package javafx;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import mini_project.student;
import mini_project.Database;

public class Student{
    Label lStudentName;
    Label lPhoneNo;
    TextField tfStudentName;
    TextField tfPhoneNo;
    GridPane gp;

    public Label getlStudentName() {
        return lStudentName;
    }

    public void setlStudentName(Label lStudentName) {
        this.lStudentName = lStudentName;
    }

    public Label getlPhoneNo() {
        return lPhoneNo;
    }

    public void setlPhoneNo(Label lPhoneNo) {
        this.lPhoneNo = lPhoneNo;
    }

    public TextField getTfStudentName() {
        return tfStudentName;
    }

    public void setTfStudentName(TextField tfStudentName) {
        this.tfStudentName = tfStudentName;
    }

    public TextField getTfPhoneNo() {
        return tfPhoneNo;
    }

    public void setTfPhoneNo(TextField tfPhoneNo) {
        this.tfPhoneNo = tfPhoneNo;
    }

    public GridPane getGp() {
        return gp;
    }

    public void setGp(GridPane gp) {
        this.gp = gp;
    }
        
    public Student(){
        lStudentName = new Label("Student Name:");
        lPhoneNo = new Label("Phone No.:");
        tfStudentName = new TextField();
        tfPhoneNo = new TextField();
    
        Button button = new Button("Submit");
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String Name = tfStudentName.getText();                   
                    String PhoneNo = tfPhoneNo.getText();
                    
                    String uri = "jdbc:mysql://localhost:3306/Mini_project";
                    Database db = new Database(uri,"root","root");
                    Connection c = db.openConnection();
                    student.insertStudent(Name,PhoneNo,c);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
          
        });
        gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(8);
        gp.add(lStudentName,0,0);
        gp.add(tfStudentName,1, 0);
        gp.add(lPhoneNo,0,1);
        gp.add(tfPhoneNo,1, 1);
        gp.add(button,1,4);
    }   
}