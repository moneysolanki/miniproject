package layout;

import javafx.Book;
import javafx.Borrow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.Return;
import javafx.Student;

public class Main extends Application {

    Tab tab1;
    Tab tab2;
    Tab tab3;
    Tab tab4;

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Library");
        TabPane tabPane = new TabPane();
        tab1 = new Tab("Student");
        tab2 = new Tab("Book");
        tab3 = new Tab("Borrow Book");
        tab4 = new Tab("Return Book");

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
        BorderPane studentbp = s.getBp();
        tab1.setContent(studentbp);

        Book b = new Book();
        BorderPane bookbp = b.getBp();
        tab2.setContent(bookbp);

        Borrow borrow = new Borrow();
        BorderPane borrowbp = borrow.getBp();
        tab3.setContent(borrowbp);

        Return r = new Return();
        BorderPane returnbp = r.getBp();
        tab4.setContent(returnbp);

        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);

    }

    public Tab getTab1() {
        return tab1;
    }

    public void setTab1(Tab tab1) {
        this.tab1 = tab1;
    }

    public Tab getTab2() {
        return tab2;
    }

    public void setTab2(Tab tab2) {
        this.tab2 = tab2;
    }

    public Tab getTab3() {
        return tab3;
    }

    public void setTab3(Tab tab3) {
        this.tab3 = tab3;
    }

    public Tab getTab4() {
        return tab4;
    }

    public void setTab4(Tab tab4) {
        this.tab4 = tab4;
    }

}
