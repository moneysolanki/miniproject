package layout;

import javafx.Book;
import javafx.Borrow;
import javafx.RETURN;
import javafx.Student;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) {
       primaryStage.setTitle("Library");
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Student");        
        Tab tab2 = new Tab("Book");            
        Tab tab3 = new Tab("Borrow Book");
        Tab tab4 = new Tab("Return Book");
 
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        tabPane.getTabs().add(tab4);
        
        tabPane.setMinHeight(500);
        tabPane.setMinWidth(500);
        tabPane.setTabMinHeight(40);
        tabPane.setTabMinWidth(80);

        tabPane.setStyle("-fx-font-size: 15px;-fx-font-weight:bold;");   
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
       
        Student s = new Student();
        GridPane studentgp = s.getGp();
        tab1.setContent(studentgp);
       
        Book b  = new Book();
        GridPane bookgp = b.getGp();
        tab2.setContent(bookgp);
       
        Borrow borrow = new Borrow();
        GridPane borrowgp = borrow.getGp();
        tab3.setContent(borrowgp);
       
        RETURN r = new RETURN();
        GridPane returngp = r.getGp();
        tab4.setContent(returngp);

        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);
        primaryStage.show();  
    }

    public static void main(String[] args) {
        Application.launch(args);  
    }
}