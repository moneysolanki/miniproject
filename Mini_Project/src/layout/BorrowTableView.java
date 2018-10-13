/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import mini_project.Borrow;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import mini_project.Database;


public class BorrowTableView{
    TableView table;
    Label lBorrow ;
    VBox vbox ;
    TableColumn <Integer, Borrow> borrowId;
    TableColumn <Integer, Borrow> rollNo;
    TableColumn <Integer, Borrow> bookId;
   
    
    public BorrowTableView() throws Exception{
               
        String uri = "jdbc:mysql://localhost:3306/Mini_project";
        Database db = new Database(uri,"root","root");
        ObservableList<Borrow> borrowArray = Borrow.getBorrow(db.openConnection());
        table = new TableView();
        lBorrow = new Label("Borrow");
  
        borrowId = new TableColumn("Borrow ID:");
        borrowId.setCellValueFactory(new PropertyValueFactory("borrow_id"));
        
        rollNo = new TableColumn("Student Roll No.");
        rollNo.setCellValueFactory(new PropertyValueFactory("roll_no"));
        
        bookId = new TableColumn("Book ID:");
        bookId.setCellValueFactory(new PropertyValueFactory("book_id"));
        
        table.getColumns().addAll(borrowId, rollNo, bookId);
        table.setItems(borrowArray);
        
        vbox = new VBox();
        vbox.setPadding(new Insets(50, 50, 50, 50));
        table.setMaxHeight(600);
        table.setMaxWidth(700);
        vbox.setSpacing(50);
        vbox.getChildren().addAll(lBorrow, table);

    }

    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }

    public Label getlBorrow() {
        return lBorrow;
    }

    public void setlBorrow(Label lBorrow) {
        this.lBorrow = lBorrow;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public TableColumn<Integer, Borrow> getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(TableColumn<Integer, Borrow> borrowId) {
        this.borrowId = borrowId;
    }

    public TableColumn<Integer, Borrow> getRollNo() {
        return rollNo;
    }

    public void setRollNo(TableColumn<Integer, Borrow> rollNo) {
        this.rollNo = rollNo;
    }

    public TableColumn<Integer, Borrow> getBookId() {
        return bookId;
    }

    public void setBookId(TableColumn<Integer, Borrow> bookId) {
        this.bookId = bookId;
    }
    
    
    
    
}