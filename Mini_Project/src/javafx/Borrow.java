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
import layout.BorrowTableView;
import mini_project.Database;

public class Borrow {

    Label lroll_no;
    Label lBook_id;
    Label name;
    Label ans;
    TextField tfroll_no;
    TextField tfBook_id;
    Button button;
    GridPane gp;
    BorderPane bp;
    BorrowTableView btv ;
    TableView t ;   
    

    public Borrow() throws Exception {
        
        lroll_no = new Label("Student Roll No.:");
        lBook_id = new Label("Book ID:");
        tfroll_no = new TextField();
        tfBook_id = new TextField();
        button = new Button("Submit");
        name = new Label("Borrow");
        ans = new Label();
        
       button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    int RollNo = Integer.parseInt(tfroll_no.getText());   
                    int BookID = Integer.parseInt(tfBook_id.getText());
                    
                    String uri = "jdbc:mysql://localhost:3306/Mini_project";
                    Database db = new Database(uri,"root","root");
                    Connection c = db.openConnection();
                    mini_project.Borrow.insertBorrow(RollNo,BookID,c);
                    ans.setText("Done");
                    
                } catch (Exception ex) {
                    Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
        });
        gp = new GridPane();
        
        gp.add(name,0,0);
        gp.add(lroll_no,0,1);
        gp.add(tfroll_no,2, 1);
        gp.add(lBook_id,0,2);
        gp.add(tfBook_id,2, 2); 
        gp.add(button,2,3);
        gp.add(ans,0,6);
        gp.setHgap(40);
        gp.setVgap(10);
        gp.setPadding(new Insets(50, 50, 50, 50));
        
        name.setStyle("-fx-font-size: 25px;-fx-font-weight:bold;");
        bp = new BorderPane();
        bp.setLeft(gp);
        btv = new BorrowTableView() ;
        t = btv.getTable();
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

    public BorderPane getBp() {
        return bp;
    }

    public void setBp(BorderPane bp) {
        this.bp = bp;
    }

    public BorrowTableView getBtv() {
        return btv;
    }

    public void setBtv(BorrowTableView btv) {
        this.btv = btv;
    }

    public TableView getT() {
        return t;
    }

    public void setT(TableView t) {
        this.t = t;
    }
  
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
    
    
    
}
