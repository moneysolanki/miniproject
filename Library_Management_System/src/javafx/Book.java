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
import library_management_system.database;

public class Book {
    Label lBookName;
    Label lIsbnNo;
    Label lPublisherName;
    Label lAuthorName;
    TextField tfBookName;
    TextField tfIsbnNo;
    TextField tfPublisherName;
    TextField tfAuthorName;
    GridPane gp;
    
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
    
    public Book(){
        lBookName = new Label("Book Name:");
        lIsbnNo = new Label("ISBN No.:");
        lPublisherName = new Label("Publisher Name:");
        lAuthorName = new Label("Author Name:");
        tfBookName= new TextField();
        tfIsbnNo = new TextField();
        tfPublisherName = new TextField();
        tfAuthorName = new TextField();
        Button button = new Button("Submit");
               
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String Name = tfBookName.getText();                   
                    String isbn = tfIsbnNo.getText();
                    String publisherName = tfPublisherName.getText();
                    String authorName = tfAuthorName.getText();
                    
                    String uri = "jdbc:mysql://localhost:3306/miniproject";
                    database db = new database(uri,"root","root");
                    Connection c = db.openConnection();
                    library_management_system.book.insertBook(Name,isbn,publisherName,authorName,c);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
          
        });
        gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(8);
        gp.add(lBookName,0,0);
        gp.add(tfBookName,1, 0);
        gp.add(lIsbnNo,0,1);
        gp.add(tfIsbnNo,1, 1);
        gp.add(lPublisherName,0,2);
        gp.add(tfPublisherName,1, 2);
        gp.add(lAuthorName,0,3);
        gp.add(tfAuthorName,1, 3);
        gp.add(button,1,4);
        
        /*
        ToolBar toolbar = new ToolBar();
        HBox statusbar = new HBox();
        final Label label = new Label("Address Book");

        table.setEditable(true);
 
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        borderPane.setLeft(gp);
        borderPane.setRight(table);
        */
    }
}