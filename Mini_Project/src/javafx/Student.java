package javafx;

import mini_project.student;
import mini_project.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import layout.TabGUI;
import mini_project.student;
import mini_project.Database;

public class Student extends Application {


    public Node gp;
     @Override
    public void start(Stage primaryStage) {
        Label lStudentName = new Label("Student Name:");
        Label lPhoneNo = new Label("Phone No.:");
        TextField tfStudentName = new TextField();
        TextField tfPhoneNo = new TextField();
        
        Button button = new Button("Submit");
        GridPane gp = new GridPane();
        
        gp.setHgap(5);
        gp.setVgap(8);
        
       button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String Name = tfStudentName.getText();                   
                    String PhoneNo = tfPhoneNo.getText();
                    
                    String uri = "jdbc:mysql://localhost:3306/miniproject";
                    Database db = new Database(uri,"root","root");
                    Connection c = db.openConnection();
                    student.insertStudent(Name,PhoneNo,c);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
          
        });
        gp.add(lStudentName,0,0);
        gp.add(tfStudentName,1, 0);
        gp.add(lPhoneNo,0,1);
        gp.add(tfPhoneNo,1, 1);
        gp.add(button,1,4);
        
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Student");
        tabPane.getTabs().add(tab1);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(tabPane);
        borderPane.setLeft(gp);
        
        Scene scene = new Scene(borderPane);
        
        primaryStage.setTitle("Student");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }   
}