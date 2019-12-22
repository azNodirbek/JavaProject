package main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import javax.lang.model.type.NullType;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Login {
    @FXML
    public Button headerBorder_register;
    @FXML
    private Label welcomeMessage;
    @FXML
    private TextField login_userIDField;
    @FXML
    private PasswordField login_passwordField;
    @FXML
    private Button login_loginButton;

    public static String username;
    public static String logi="";
    @FXML
    public void login(ActionEvent event) throws IOException {
        //  Checking user inputs process...
        //  ...
        //  by the time authentication finishes & Loads the MainFrame page.
        //  TEMPORARY !!!
        Properties properties = new Properties();
        String log = login_userIDField.getText() , pas = login_passwordField.getText();
        FileInputStream admin = new FileInputStream("Admin.properties");
        properties.load(admin);
        if(properties.containsKey(log) && properties.contains(pas))
        {
            admin.close();
            username = "Admin";
            Main.Switch_S("AdminFrame.fxml");
        }
        else
        {
            admin.close();
            properties.clear();
            FileInputStream librar = new FileInputStream("Librarian.properties");
            properties.load(librar);
            if (properties.containsKey(log) && properties.contains(pas))
            {
                librar.close();
                username = "Librarian";
                Main.Switch_S("LibrarianFrame.fxml");
            }
            else
            {
                librar.close();
                properties.clear();
                FileInputStream stut = new FileInputStream("Students.properties");
                properties.load(stut);
                if (properties.containsKey(log) && properties.contains(pas))
                {
                    stut.close();
                    //logi = log;
                    username = "Student";
                    Main.Switch_S("ReaderFrame.fxml");
                }
                else
                {
                    stut.close();
                    welcomeMessage.setText("Such User is not Existed");
                    welcomeMessage.setTextFill(Paint.valueOf("da0909"));
                    login_userIDField.clear();
                    login_passwordField.clear();
                }
            }

        }

    }

    public void logout(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void register(ActionEvent actionEvent) throws IOException {
        String log = login_userIDField.getText() , pas = login_passwordField.getText();
        Properties properties = new Properties();
        FileInputStream read = new FileInputStream("Students.properties");
        properties.load(read);
        read.close();
        if(properties.containsKey(log) && properties.contains(pas))
        {
            welcomeMessage.setText("Such User is Existed");
            welcomeMessage.setTextFill(Paint.valueOf("da0909"));
            login_userIDField.clear();
            login_passwordField.clear();
        }
        else
        {
            FileOutputStream wr = new FileOutputStream("Students.properties");
            properties.setProperty(log,pas);
            int i = Integer.parseInt(properties.getProperty("i"));
            i++;
            properties.replace("i", String.valueOf(i));
            properties.store(wr, "");
            wr.close();
            welcomeMessage.setText("You have SUCCESSFULLY Registered");
            welcomeMessage.setTextFill(Paint.valueOf("22e611"));
            login_userIDField.clear();
            login_passwordField.clear();
        }
        properties.clear();
    }
}