/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mini_project.borrow;
import mini_project.database;


public class Borrow extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label lroll_no = new Label("Student Roll No.:");
        Label lBook_id = new Label("Book ID:");
        
        TextField tfroll_no = new TextField();
        TextField tfBook_id = new TextField();
        
        
        Button button = new Button("Submit");
        GridPane gp = new GridPane();
        
        gp.setHgap(5);
        gp.setVgap(8);
        
       button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    int RollNo = Integer.parseInt(tfroll_no.getText());                   
                    int BookID = Integer.parseInt(tfBook_id.getText());
                    
                    String uri = "jdbc:mysql://localhost:3306/miniproject";
                    database db = new database(uri,"root","root");
                    Connection c = db.openConnection();
                    
                    borrow.insertBorrow(RollNo,BookID,c);
                    System.out.println("Done");
                    
                } catch (Exception ex) {
                    Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
        });
        gp.add(lroll_no,0,0);
        gp.add(tfroll_no,1, 0);
        gp.add(lBook_id,0,1);
        gp.add(tfBook_id,1, 1);
        
        gp.add(button,1,4);
        
        Scene scene = new Scene(gp);
        primaryStage.setTitle("Borrow");
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
