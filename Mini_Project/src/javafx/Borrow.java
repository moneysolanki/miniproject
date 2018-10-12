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
import mini_project.Database;


public class Borrow {
    Label lroll_no;
    Label lBook_id;
    TextField tfroll_no;
    TextField tfBook_id;
    Button button;

    GridPane gp;

    public Label getLroll_no() {
        return lroll_no;
    }

    public void setLroll_no(Label lroll_no) {
        this.lroll_no = lroll_no;
    }

    public Label getlBook_id() {
        return lBook_id;
    }

    public void setlBook_id(Label lBook_id) {
        this.lBook_id = lBook_id;
    }

    public GridPane getGp() {
        return gp;
    }

    public void setGp(GridPane gp) {
        this.gp = gp;
    }

    public TextField getTfroll_no() {
        return tfroll_no;
    }

    public void setTfroll_no(TextField tfroll_no) {
        this.tfroll_no = tfroll_no;
    }

    public TextField getTfBook_id() {
        return tfBook_id;
    }

    public void setTfBook_id(TextField tfBook_id) {
        this.tfBook_id = tfBook_id;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Borrow() {
        
        lroll_no = new Label("Student Roll No.:");
        lBook_id = new Label("Book ID:");
        tfroll_no = new TextField();
        tfBook_id = new TextField();
 
        button = new Button("Submit");
        gp = new GridPane();
        
        gp.setHgap(5);
        gp.setVgap(8);
        
       button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    int RollNo = Integer.parseInt(tfroll_no.getText());   
                    int BookID = Integer.parseInt(tfBook_id.getText());
                    
                    String uri = "jdbc:mysql://localhost:3306/miniproject";
                    Database db = new Database(uri,"root","root");
                    Connection c = db.openConnection();
                    
                    mini_project.Borrow.insertBorrow(RollNo,BookID,c);
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
    
    }
  
    
    
    
}
