package javafx;

import mini_project.Database;
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
import mini_project.Return;
import mini_project.Database;

public class RETURN extends Application {
     @Override
    public void start(Stage primaryStage) {
        Label lborrow_id = new Label("Borrow ID:");
        TextField tfborrow_id = new TextField();
        
        Button button = new Button("Submit");
        GridPane gp = new GridPane();
        
        gp.setHgap(5);
        gp.setVgap(8);
        
       button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    int BorrowID = Integer.parseInt(tfborrow_id.getText());                   
                    
                    String uri = "jdbc:mysql://localhost:3306/miniproject";
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
        
        Scene scene = new Scene(gp);
        primaryStage.setTitle("Books_Returned");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }   
}