package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import javax.print.DocFlavor;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import static main.Login.logi;

public class Search_reader {

    @FXML
    public Label welcomeMessage;
    @FXML
    public TextField Reader_name;
    @FXML
    public Button Search_reader_but;
    @FXML
    public Label Reader_name_dis;
    @FXML
    public Label Reader_password;
    Properties properties = new Properties();
    @FXML
    public void search_reader(ActionEvent actionEvent) throws IOException {
        FileInputStream inputStream = new FileInputStream("Students.properties");
        properties.load(inputStream);
        String a = Reader_name.getText();
        if(!properties.containsKey(a))
        {
            welcomeMessage.setText("Such Reader is not Existed");
            welcomeMessage.setTextFill(Paint.valueOf("e02222"));
        }
        else
        {
            Reader_password.setText("Login: " + a + "     |    " + "Password: " + properties.getProperty(a));
            welcomeMessage.setText("Such Reader Existed");
            welcomeMessage.setTextFill(Paint.valueOf("22e611"));
        }
        properties.clear();
        inputStream.close();
    }
    public void delete_reader(ActionEvent actionEvent) throws IOException {
        int i;
        FileInputStream input = new FileInputStream("Students.properties");
        properties.load(input);
        String a = Reader_name.getText();
        if(!properties.containsKey(a))
        {
            welcomeMessage.setText("Such Reader is not Existed");
            welcomeMessage.setTextFill(Paint.valueOf("e02222"));
        }
        else
        {
            FileOutputStream wr = new FileOutputStream("Students.properties");
            properties.remove(a);
            i=Integer.parseInt(properties.getProperty("i"));
            i--;
            properties.replace("i",String.valueOf(i));
            properties.store(wr, "");
            welcomeMessage.setText("Reader Successfully deleted");
            welcomeMessage.setTextFill(Paint.valueOf("22e611"));
            wr.close();
        }
        properties.clear();
    }

    public void search_librarian(ActionEvent actionEvent) throws IOException {
        FileInputStream inputStream = new FileInputStream("Librarian.properties");
        properties.load(inputStream);
        String a = Reader_name.getText();
        if(!properties.containsKey(a))
        {
            welcomeMessage.setText("Such Librarian is not Existed");
            welcomeMessage.setTextFill(Paint.valueOf("e02222"));
        }
        else
        {
            Reader_password.setText("Login: " + a + "     |    " + "Password: " + properties.getProperty(a));
            welcomeMessage.setText("Such Librarian Existed");
            welcomeMessage.setTextFill(Paint.valueOf("22e611"));
        }
        properties.clear();
        inputStream.close();
    }

    public void Borrow_b(ActionEvent actionEvent) throws IOException {

        String a = Reader_name.getText();
        FileInputStream read = new FileInputStream("books.properties");
        properties.load(read);
        if(!properties.contains(a))
        {
            welcomeMessage.setText("Such Book is not Existed");
            welcomeMessage.setTextFill(Paint.valueOf("e02222"));
        }
        else
        {
            if(properties.contains(a))
            {
                welcomeMessage.setText("Such Book has been Borrowed Already");
                welcomeMessage.setTextFill(Paint.valueOf("e02222"));
            }
            else {
                int i;
                FileOutputStream wr = new FileOutputStream("Borrowed.properties");
                for(i=0; properties.containsKey("borrowed[" + i +  "]"+ logi); i++);
                i++;
                properties.setProperty("borrowed[" + i +  "]"+ logi, a);
                properties.store(wr, "");
                welcomeMessage.setText("Such Book Existed, You have borrowed!");
                welcomeMessage.setTextFill(Paint.valueOf("25e022"));
                wr.close();
            }
        }
        properties.clear();
        read.close();
    }
    public void Borrow_b_v(ActionEvent actionEvent) throws IOException {
        String a = Reader_name.getText();
        FileInputStream read = new FileInputStream("Borrowed.properties");
        properties.load(read);
        if(!properties.contains(a))
        {
            welcomeMessage.setText("Such Book has not been Borrowed");
            welcomeMessage.setTextFill(Paint.valueOf("e02222"));
        }
        else
        {
            Reader_password.setText("Name of the book:\t" + a);
            welcomeMessage.setText("Such Book was Borrowed");
            welcomeMessage.setTextFill(Paint.valueOf("25e022"));
        }
        properties.clear();
        read.close();
    }
}
