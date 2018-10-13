
package layout;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import mini_project.Book;
import mini_project.Database;


public class BookTableView{
    TableView table;
    Label lBook ;
    VBox vbox ;
    TableColumn <Integer, Book> bookid;
    TableColumn <String, Book> bookName;
    TableColumn <String, Book> isbn;
    TableColumn <String, Book> publisherCol;
    TableColumn <String, Book>authorCol;

    
    
    public BookTableView() throws Exception{
               
        String uri = "jdbc:mysql://localhost:3306/Mini_project";
        Database db = new Database(uri,"root","root");
        ObservableList<Book> bookArray = Book.getBook(db.openConnection());
        table = new TableView();
        lBook = new Label("Book");
        
        bookid = new TableColumn("Book ID:");
        bookid.setCellValueFactory(new PropertyValueFactory("book_id"));
        
        bookName = new TableColumn("Book Name");
        bookName.setCellValueFactory(new PropertyValueFactory("book_name"));
        
        isbn = new TableColumn("ISBN No.");
        isbn.setCellValueFactory(new PropertyValueFactory("isbn_no"));
        
        publisherCol = new TableColumn("Publisher Name");
        publisherCol.setCellValueFactory(new PropertyValueFactory("publisher_name"));
        
        authorCol = new TableColumn("Author Name");
        authorCol.setCellValueFactory(new PropertyValueFactory("author_name"));
        
        table.getColumns().addAll(bookid, bookName, isbn, publisherCol, authorCol);
        table.setItems(bookArray);

        vbox = new VBox();
        vbox.setPadding(new Insets(50, 50, 50, 50));
        table.setMaxHeight(600);
        table.setMaxWidth(700);
        vbox.setSpacing(50);
        vbox.getChildren().addAll(lBook, table);

    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }
    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }

    public Label getlBook() {
        return lBook;
    }

    public void setlBook(Label lBook) {
        this.lBook = lBook;
    }

    public TableColumn<Integer, Book> getBookid() {
        return bookid;
    }

    public void setBookid(TableColumn<Integer, Book> bookid) {
        this.bookid = bookid;
    }

    public TableColumn<String, Book> getBookName() {
        return bookName;
    }

    public void setBookName(TableColumn<String, Book> bookName) {
        this.bookName = bookName;
    }

    public TableColumn<String, Book> getIsbn() {
        return isbn;
    }

    public void setIsbn(TableColumn<String, Book> isbn) {
        this.isbn = isbn;
    }

    public TableColumn<String, Book> getPublisherCol() {
        return publisherCol;
    }

    public void setPublisherCol(TableColumn<String, Book> publisherCol) {
        this.publisherCol = publisherCol;
    }

    public TableColumn<String, Book> getAuthorCol() {
        return authorCol;
    }

    public void setAuthorCol(TableColumn<String, Book> authorCol) {
        this.authorCol = authorCol;
    }
}