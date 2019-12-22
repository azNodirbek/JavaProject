package main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

//import static main.Login.logi;

public class MainFrame {
    @FXML
    public BorderPane mainFrame;
    @FXML
    public Button leftBorder_add_librarian_Button;
    @FXML
    public Button leftBorder_add_reader_Button;
    @FXML
    public Button leftBorder_librariansButton;
    @FXML
    public Label welcomeMessage;
    @FXML
    public Button Librarian_adding;
    @FXML
    public Button Delete_reader;
    @FXML
    public Button leftBorder_delete_librarian_Button;
    @FXML
    public Button leftBorder_borrow;
    @FXML
    public Label My_book_view;
    @FXML
    private Label username;
    @FXML
    private Label panelName;
    @FXML
    private Button headerBorder_addButton;
    @FXML
    private Button headerBorder_logoutButton;
    @FXML
    private Button leftBorder_dashboardButton;
    @FXML
    private Button leftBorder_booksButton;
    @FXML
    private Button leftBorder_myBooksButton;
    @FXML
    private Button leftBorder_borrowedBooksButton;
    @FXML
    private Button leftBorder_readersButton;
    @FXML
    private Button leftBorder_blockedReadersButton;
    @FXML
    //  INITIALIZING THE USERNAME & PANEL NAME. TO BE CONTINUED...
    public void initialize() {
        username.setText(Login.username);
        panelName.setText("Empty Panel");
    }

    //  DASHBOARD BUTTON JUST INITIALIZED, TO BE CONTINUED...
    @FXML
    public void setDashboardPane(ActionEvent event) throws IOException {
        panelName.setText("Dashboard");
        GridPane pane = FXMLLoader.load(getClass().getResource("DashboardPane.fxml"));
        mainFrame.setCenter(pane);
    }

    //  BOOKS BUTTON JUST INITIALIZED, TO BE CONTINUED...
    @FXML
    public void setBooksListPane(ActionEvent event) throws IOException {
        panelName.setText("Books");
        GridPane pane = FXMLLoader.load(getClass().getResource("SearchingBooks.fxml"));
        mainFrame.setCenter(pane);
    }

    //  MY BOOKS BUTTON JUST INITIALIZED, TO BE CONTINUED...
    @FXML
    public void setMyBooksListPane(ActionEvent event) throws IOException {
        panelName.setText("My Books");
        GridPane pane = FXMLLoader.load(getClass().getResource("ItemList.fxml"));
        mainFrame.setCenter(pane);
      //  my_bookV();
    }

    /* Following Function related to view all borrowed book by exactly one person. Cause of some error, which i
      couldn't fix in fixed period of time, i left it as default.*/
      /************************************************************************************************************/

        /*public void my_bookV() throws IOException {
            Properties properties = new Properties();
            FileInputStream read = new FileInputStream("Borrowed.properties");
            properties.load(read);
            if(properties.contains("book["+0+"]"+logi))
            {
                My_book_view.setText(properties.getProperty("book["+0+"]"+logi));
            }
            else if (!properties.contains("book["+0+"]"+logi))
            {
                My_book_view.setText("Is not Existed");
            }
            properties.clear();
            read.close();
        }*/

    //  LOG OUT BUTTON JUST INITIALIZED, TO BE CONTINUED...
    @FXML
    public void logout(ActionEvent event) throws IOException {
        //  Saving all the changes to the database...
        //  ...
        //  Loading the Login page.
        Main.Switch_S("Login.fxml");
    }

    //  MY BOOKS BUTTON JUST INITIALIZED, TO BE CONTINUED...
    @FXML
    public void setBorrowedBooksListPane(ActionEvent event) throws IOException {
        panelName.setText("Borrowed Books");
        GridPane pane = FXMLLoader.load(getClass().getResource("Borrowed_book_view.fxml"));
        mainFrame.setCenter(pane);
    }
    @FXML
    public void setBorrowBooksListPane(ActionEvent event) throws IOException {
        panelName.setText("Borrow A book");
        GridPane pane = FXMLLoader.load(getClass().getResource("Borrow_book.fxml"));
        mainFrame.setCenter(pane);
    }
    @FXML
    public void setLibrariansListPane(ActionEvent event) throws IOException {
        panelName.setText("Librarians");
        GridPane pane = FXMLLoader.load(getClass().getResource("Librarian_.fxml"));
        mainFrame.setCenter(pane);
    }
    @FXML
    public void setReadersListPane(ActionEvent event) throws IOException {
        panelName.setText("Readers");
        GridPane pane = FXMLLoader.load(getClass().getResource("reader_serach.fxml"));
        mainFrame.setCenter(pane);
    }
    @FXML
    public void setAddLibrarianListPane(ActionEvent event) throws IOException {
        panelName.setText("Adding Librarian");
        GridPane pane = FXMLLoader.load(getClass().getResource("Adding.fxml"));
        mainFrame.setCenter(pane);
    }
    @FXML
    public void setDeleteReaderListPane(ActionEvent event) throws IOException {
        panelName.setText("Delete Reader");
        GridPane pane = FXMLLoader.load(getClass().getResource("Delete reader.fxml"));
        mainFrame.setCenter(pane);
    }
    @FXML
    public void setDeleteLibrarianListPane(ActionEvent event) throws IOException {
        panelName.setText("Delete Reader");
        GridPane pane = FXMLLoader.load(getClass().getResource("Delete_lib.fxml"));
        mainFrame.setCenter(pane);
    }
}