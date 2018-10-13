
package layout;

import mini_project.Student;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import mini_project.Database;

public class StudentTableView{
    TableView table;
    Label lStudent ;
    VBox vbox ;
    TableColumn <Integer, Student> rollno;
    TableColumn <String, Student> studentName;
    TableColumn <String, Student> phoneNo;
      
    
    public StudentTableView() throws Exception{
               
        String uri = "jdbc:mysql://localhost:3306/Mini_project";
       Database db = new Database(uri,"root","root");
         ObservableList<Student> studentArray = Student.getStudent(db.openConnection());
        table = new TableView();
        lStudent = new Label("Student");
  
        rollno = new TableColumn("Roll No:");
        rollno.setCellValueFactory(new PropertyValueFactory("roll_no"));
        
        studentName = new TableColumn("Student Name");
        studentName.setCellValueFactory(new PropertyValueFactory("student_name"));
        
        phoneNo = new TableColumn("Phone No.");
        phoneNo.setCellValueFactory(new PropertyValueFactory("phone_no"));
       
        table.getColumns().addAll(rollno, studentName, phoneNo);
        table.setItems(studentArray);
        
        vbox = new VBox();
        vbox.setPadding(new Insets(50, 50, 50, 50));
        table.setMaxHeight(600);
        table.setMaxWidth(700);
        vbox.setSpacing(50);
        vbox.getChildren().addAll(lStudent,table);

    }

    public Label getlStudent() {
        return lStudent;
    }

    public void setlStudent(Label lStudent) {
        this.lStudent = lStudent;
    }


    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }

    
    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public TableColumn<Integer, Student> getRollno() {
        return rollno;
    }

    public void setRollno(TableColumn<Integer, Student> rollno) {
        this.rollno = rollno;
    }

    public TableColumn<String, Student> getStudentName() {
        return studentName;
    }

    public void setStudentName(TableColumn<String, Student> studentName) {
        this.studentName = studentName;
    }

    public TableColumn<String, Student> getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(TableColumn<String, Student> phoneNo) {
        this.phoneNo = phoneNo;
    }

    
    
}
