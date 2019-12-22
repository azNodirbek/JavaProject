package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Adding {
    @FXML
    public Label welcomeMessage;
    @FXML
    public TextField Lib_Username;
    @FXML
    public PasswordField Lib_password;
    @FXML
    public Button Librarian_adding;
    @FXML
    public PasswordField Lib_confirm;
    @FXML
    public Button Delete_lib;

    @FXML
    public void lib_register(ActionEvent actionEvent) throws IOException {
        String log = Lib_Username.getText() , pas = Lib_password.getText(), pas1= Lib_confirm.getText();
        if(pas.equals(pas1)) {
            Properties properties = new Properties();
            FileInputStream read = new FileInputStream("Librarian.properties");
            properties.load(read);
            read.close();
            if (properties.containsKey(log) && properties.contains(pas)) {
                welcomeMessage.setText("Such User is Existed");
                welcomeMessage.setTextFill(Paint.valueOf("da0909"));
                Lib_Username.clear();
                Lib_password.clear();
            } else {
                FileOutputStream wr = new FileOutputStream("Librarian.properties");
                properties.setProperty(log, pas);
                properties.store(wr, "");
                wr.close();
                welcomeMessage.setText("You have SUCCESSFULLY Registered");
                welcomeMessage.setTextFill(Paint.valueOf("22e611"));
                Lib_Username.clear();
                Lib_password.clear();
            }
            properties.clear();
        }
        else
        {
            welcomeMessage.setText("Password were different");
            welcomeMessage.setTextFill(Paint.valueOf("da0909"));
            Lib_Username.clear();
            Lib_password.clear();
        }
    }
    @FXML
    public void delete_Librar(ActionEvent actionEvent) throws IOException {
        int i;
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("Librarian.properties");
        properties.load(input);
        String a = Lib_Username.getText();
        if(!properties.containsKey(a))
        {
            welcomeMessage.setText("Such Librarian is not Existed");
            welcomeMessage.setTextFill(Paint.valueOf("e02222"));
        }
        else
        {
            FileOutputStream wr = new FileOutputStream("Librarian.properties");
            properties.remove(a);
            properties.store(wr, "");
            welcomeMessage.setText("Librarian Successfully deleted");
            welcomeMessage.setTextFill(Paint.valueOf("22e611"));
            wr.close();
        }
        properties.clear();
    }
    @FXML
    public static void setBooks() throws IOException {
        String b_name;
        Scanner in = new Scanner(System.in);
        b_name = in.nextLine();
        int i;
        FileInputStream read = new FileInputStream("books.properties");
        Properties pro = new Properties();
        pro.load(read);
        i=Integer.parseInt(pro.getProperty("i"));
        read.close();
        FileOutputStream wr = new FileOutputStream("books.properties");
        pro.setProperty("book["+i+"]", b_name);
        i++;
        pro.replace("i", String.valueOf(i));
        pro.store(wr, "");
    }
}
