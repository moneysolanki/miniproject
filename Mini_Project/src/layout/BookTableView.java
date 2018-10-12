package layout;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mini_project.Book;


public class BookTableView extends Application {
    private TableView<Book> table;
    public void start(Stage primaryStage) throws SQLException, Exception {
        //TableView table = new TableView();
        //ObservableList data = getInitialTableData();
        //table.setItems(data);
        Scene scene = new Scene(new Group());
        
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
 
        Label label = new Label("Book");

        table.setEditable(true);
        
        TableColumn bookIdCol = new TableColumn("Book ID:");
        TableColumn bookNameCol = new TableColumn("Book Name");
        TableColumn isbnNameCol = new TableColumn("ISBN No.");
        TableColumn publisherCol = new TableColumn("Publisher");
        TableColumn authorCol = new TableColumn("Author");
        
        table.getColumns().addAll(bookNameCol, isbnNameCol, publisherCol, authorCol);
 
        VBox vbox = new VBox();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        
        /* String uri = "jdbc:mysql://localhost:3306/miniproject";
        Database db = new Database(uri,"root","root");
        Connection c = db.openConnection();
        Book.getBook(c);
        ArrayList<Book> sl = null;
        for (int i = 0; i< sl.size();i++){
            int id = (sl.get(i).getBook_id());
            System.out.println(sl.get(i).getBook_name());
            System.out.println(sl.get(i).getIsbn_no());
            System.out.println(sl.get(i).getPublisher_name());
            System.out.println(sl.get(i).getAuthor_name());
            
        }*/
        
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        primaryStage.setScene(scene);
        primaryStage.show();
        table.getSelectionModel().select(0);
        Book book  = (Book) table.getSelectionModel().getSelectedItem();
    }
    
    public static void main(String[] args) throws Exception {
        /*String uri = "jdbc:mysql://localhost:3306/miniproject";
        Database db = new Database(uri,"root","root");
        Connection c = db.openConnection();
        ArrayList<Book> sl= Book.getBook(c);
        for (int i = 0; i<sl.size();i++){
            System.out.println(sl.get(i).getBook_id());
            System.out.println(sl.get(i).getBook_name());
            System.out.println(sl.get(i).getIsbn_no());
            System.out.println(sl.get(i).getPublisher_name());
            System.out.println(sl.get(i).getAuthor_name());
        }*/
      Application.launch(args);
    }
}