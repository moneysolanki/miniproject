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
import layout.ReturnTableView;
import mini_project.Database;



public class Return {
    Label name;
    Label ans;
    Label lborrow_id;
    TextField tfborrow_id;
    Button button;
    GridPane gp;
    BorderPane bp;
    ReturnTableView rtv ;
    TableView t ;

    public Return() throws Exception{
        lborrow_id = new Label("Borrow ID:");
        tfborrow_id = new TextField();
        button = new Button("Submit");
        name = new Label("Return");
        ans = new Label();
        
        
       button.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                try {
                    int BorrowID = Integer.parseInt(tfborrow_id.getText());                   
                    
                    String uri = "jdbc:mysql://localhost:3306/Mini_project";
                    Database db = new Database(uri,"root","root");
                    Connection c = db.openConnection();
                    mini_project.Return.insertReturn(BorrowID, c);
                    ans.setText("Done");
                    
                } catch (Exception ex) {
                    Logger.getLogger(Return.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
          
        });
       gp = new GridPane();
        
        gp.add(name,0,0);
        gp.add(lborrow_id,0,1);
        gp.add(tfborrow_id,2, 1);
        gp.add(button,2,2);
        gp.add(ans,0,4);
        gp.setHgap(40);
        gp.setVgap(10);
        gp.setPadding(new Insets(50, 50, 50, 50));
        
        name.setStyle("-fx-font-size: 25px;-fx-font-weight:bold;");
        bp = new BorderPane();
        bp.setLeft(gp);
        rtv = new ReturnTableView() ;
        t = rtv.getTable();
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

    public BorderPane getBp() {
        return bp;
    }

    public void setBp(BorderPane bp) {
        this.bp = bp;
    }

    public ReturnTableView getRtv() {
        return rtv;
    }

    public void setRtv(ReturnTableView rtv) {
        this.rtv = rtv;
    }

    public TableView getT() {
        return t;
    }

    public void setT(TableView t) {
        this.t = t;
    }
  
}