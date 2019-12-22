package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class Searching {

    @FXML
    public TextField Book_name;
    @FXML
    public Label welcomeMessage;
    @FXML
    public Label booksName;
    @FXML
    public Button Search_book_b;
    @FXML
    public TextField Reader_name;
    Properties properties = new Properties();
    @FXML
    public void search_book(ActionEvent actionEvent) throws IOException {
        String a = Book_name.getText();
        FileInputStream read = new FileInputStream("books.properties");
        properties.load(read);
        if(!properties.contains(a))
        {
            welcomeMessage.setText("Such Book is not Existed");
            welcomeMessage.setTextFill(Paint.valueOf("e02222"));
            Book_name.clear();
        }
        else
        {
            welcomeMessage.setText("Such Book Existed");
            welcomeMessage.setTextFill(Paint.valueOf("22e611"));
            Book_name.clear();
            booksName.setText(a);
        }
        properties.clear();
        read.close();
    }
}
