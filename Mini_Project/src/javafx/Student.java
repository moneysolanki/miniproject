package javafx;


import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import layout.StudentTableView;
import mini_project.Database;

public class Student {
    Label name;
    Label ans;
    Label lStudentName;
    Label lPhoneNo;
    TextField tfStudentName;
    TextField tfPhoneNo ;
    Button button ;
    GridPane gp;
    BorderPane bp;
    StudentTableView stv ;
    TableView t ;

    
    public Student() throws Exception{
        lStudentName = new Label("Student Name:");
        lPhoneNo = new Label("Phone No.:");
        tfStudentName = new TextField();
        tfPhoneNo = new TextField();
        name = new Label("Student");
        ans = new Label();
        button = new Button("Submit");
  
       button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String Name = tfStudentName.getText();                   
                    String PhoneNo = tfPhoneNo.getText();
                    
                    String uri = "jdbc:mysql://localhost:3306/Mini_project";
                    Database db = new Database(uri,"root","root");
                    Connection c = db.openConnection();
                    mini_project.Student.insertStudent(Name,PhoneNo,c);
                    ans.setText("Done");
                } catch (Exception ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
          
        });
        gp = new GridPane();

        gp.add(name,0,0);
        gp.add(lStudentName,0,1);
        gp.add(tfStudentName,2, 1);
        gp.add(lPhoneNo,0,2);
        gp.add(tfPhoneNo,2, 2);
        gp.add(button,2,5);
        gp.add(ans,0,6);
        gp.setHgap(40);
        gp.setVgap(10);
        gp.setPadding(new Insets(50, 50, 50, 50));
        name.setStyle("-fx-font-size: 25px;-fx-font-weight:bold;");
       bp = new BorderPane();
       bp.setLeft(gp);
       stv = new StudentTableView();
       t = stv.getTable();
       bp.setCenter(t);
        
        
    }

    public Label getName() {
        return name;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public Label getAns() {
        return ans;
    }

    public void setAns(Label ans) {
        this.ans = ans;
    }

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

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public GridPane getGp() {
        return gp;
    }

    public void setGp(GridPane gp) {
        this.gp = gp;
    }

    public BorderPane getBp() {
        return bp;
    }

    public void setBp(BorderPane bp) {
        this.bp = bp;
    }

    public StudentTableView getStv() {
        return stv;
    }

    public void setStv(StudentTableView stv) {
        this.stv = stv;
    }

    public TableView getT() {
        return t;
    }

    public void setT(TableView t) {
        this.t = t;
    }

    
    
    
}