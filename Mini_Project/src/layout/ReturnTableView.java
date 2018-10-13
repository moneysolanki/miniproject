/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

/**
 *
 * @author manisha
 */
import mini_project.Return;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import mini_project.Database;


public class ReturnTableView{
    TableView table;
    Label lReturn ;
    VBox vbox ;
    TableColumn <Integer, Return> returnId;
    TableColumn <Integer, Return> borrowId;
    
    public ReturnTableView() throws Exception{
               
        String uri = "jdbc:mysql://localhost:3306/Mini_project";
        Database db = new Database(uri,"root","root");
        ObservableList<Return> returnArray = Return.getReturn(db.openConnection());
        table = new TableView();
        lReturn = new Label("Return");
  
        returnId = new TableColumn("Return ID:");
        returnId.setCellValueFactory(new PropertyValueFactory("return_id"));
        
        borrowId = new TableColumn("Borrow ID:");
        borrowId.setCellValueFactory(new PropertyValueFactory("borrow_id"));
        
        table.getColumns().addAll(returnId, borrowId);
        table.setItems(returnArray);
        
        vbox = new VBox();
        vbox.setPadding(new Insets(50, 50, 50, 50));
        table.setMaxHeight(600);
        table.setMaxWidth(700);
        vbox.setSpacing(50);
        vbox.getChildren().addAll(lReturn, table);

    }

    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }

    public Label getlReturn() {
        return lReturn;
    }

    public void setlReturn(Label lReturn) {
        this.lReturn = lReturn;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public TableColumn<Integer, Return> getReturnId() {
        return returnId;
    }

    public void setReturnId(TableColumn<Integer, Return> returnId) {
        this.returnId = returnId;
    }

    public TableColumn<Integer, Return> getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(TableColumn<Integer, Return> borrowId) {
        this.borrowId = borrowId;
    }
    
}