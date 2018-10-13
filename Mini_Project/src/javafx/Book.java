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
import layout.BookTableView;
import mini_project.Database;

public class Book {
    Label name;
    Label ans;
    Label lBookName;
    Label lIsbnNo;
    Label lPublisherName;
    Label lAuthorName;
    TextField tfBookName;
    TextField tfIsbnNo;
    TextField tfPublisherName;
    TextField tfAuthorName;
    GridPane gp;
    BorderPane bp;
    BookTableView btv ;
    TableView t ;

    
    public Book() throws Exception{
        
        lBookName = new Label("Book Name:");
        lIsbnNo = new Label("ISBN No.:");
        lPublisherName = new Label("Publisher Name:");
        lAuthorName = new Label("Author Name:");
        tfBookName= new TextField();
        tfIsbnNo = new TextField();
        tfPublisherName = new TextField();
        tfAuthorName = new TextField();
        name = new Label("Book");
        ans = new Label();
        Button button = new Button("Submit");
               
       button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String Name = tfBookName.getText();                   
                    String isbn = tfIsbnNo.getText();
                    String publisherName = tfPublisherName.getText();
                    String authorName = tfAuthorName.getText();
                    
                    String uri = "jdbc:mysql://localhost:3306/Mini_project";
                    Database db = new Database(uri,"root","root");
                    Connection c = db.openConnection();
                    mini_project.Book.insertBook(Name,isbn,publisherName,authorName,c);
                    ans.setText("Done");
                    
                } catch (Exception ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
          
        });
        gp = new GridPane();
        
        gp.add(name,0,0);
        gp.add(lBookName,0,1);
        gp.add(tfBookName,2, 1);
        gp.add(lIsbnNo,0,2);
        gp.add(tfIsbnNo,2, 2);
        gp.add(lPublisherName,0,3);
        gp.add(tfPublisherName,2, 3);
        gp.add(lAuthorName,0,4);
        gp.add(tfAuthorName,2, 4);
        gp.add(button,2,5);
        gp.add(ans,0,6);
        gp.setHgap(40);
        gp.setVgap(10);
        gp.setPadding(new Insets(50, 50, 50, 50));
        name.setStyle("-fx-font-size: 25px;-fx-font-weight:bold;");
       bp = new BorderPane();
       bp.setLeft(gp);
       btv = new BookTableView();
       t = btv.getTable();
       bp.setCenter(t);
        
    }

    public BookTableView getBtv() {
        return btv;
    }

    public void setBtv(BookTableView btv) {
        this.btv = btv;
    }

    public TableView getT() {
        return t;
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

    public void setT(TableView t) {
        this.t = t;
    }
  public TextField getTfBookName() {
        return tfBookName;
    }

    public void setTfBookName(TextField tfBookName) {
        this.tfBookName = tfBookName;
    }

    public TextField getTfIsbnNo() {
        return tfIsbnNo;
    }

    public void setTfIsbnNo(TextField tfIsbnNo) {
        this.tfIsbnNo = tfIsbnNo;
    }

    public TextField getTfPublisherName() {
        return tfPublisherName;
    }

    public void setTfPublisherName(TextField tfPublisherName) {
        this.tfPublisherName = tfPublisherName;
    }

    public TextField getTfAuthorName() {
        return tfAuthorName;
    }

    public void setTfAuthorName(TextField tfAuthorName) {
        this.tfAuthorName = tfAuthorName;
    }

    public BorderPane getBp() {
        return bp;
    }

    public void setBp(BorderPane bp) {
        this.bp = bp;
    }
    
    public GridPane getGp() {
        return gp;
    }

    public void setGp(GridPane gp) {
        this.gp = gp;
    }

    public Label getlBookName() {
        return lBookName;
    }

    public void setlBookName(Label lBookName) {
        this.lBookName = lBookName;
    }

    public Label getlIsbnNo() {
        return lIsbnNo;
    }

    public void setlIsbnNo(Label lIsbnNo) {
        this.lIsbnNo = lIsbnNo;
    }

    public Label getlPublisherName() {
        return lPublisherName;
    }

    public void setlPublisherName(Label lPublisherName) {
        this.lPublisherName = lPublisherName;
    }

    public Label getlAuthorName() {
        return lAuthorName;
    }

    public void setlAuthorName(Label lAuthorName) {
        this.lAuthorName = lAuthorName;
    }
    
        
    }

