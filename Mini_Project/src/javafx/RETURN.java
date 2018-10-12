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
import mini_project.Return;
import mini_project.Database;

public class RETURN{
    Label lborrow_id;
    TextField tfborrow_id; 
    Button button;
    GridPane gp;

    public Label getLborrow_id() {
        return lborrow_id;
    }

    public void setLborrow_id(Label lborrow_id) {
        this.lborrow_id = lborrow_id;
    }

    public TextField getTfborrow_id() {
        return tfborrow_id;
    }

    public void setTfborrow_id(TextField tfborrow_id) {
        this.tfborrow_id = tfborrow_id;
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
    
    public RETURN(){
        lborrow_id = new Label("Borrow ID:");
        tfborrow_id = new TextField();
        button = new Button("Submit");
        gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(8);
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int BorrowID = Integer.parseInt(tfborrow_id.getText());                   
                    
                    String uri = "jdbc:mysql://localhost:3306/Mini_project";
                    Database db = new Database(uri,"root","root");
                    Connection c = db.openConnection();
                    Return.insertReturn(BorrowID,c);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
          
        });
        gp.add(lborrow_id,0,0);
        gp.add(tfborrow_id,1,0);
        gp.add(button,1,4);
    }  
}