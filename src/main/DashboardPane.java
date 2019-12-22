package main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class DashboardPane {
    //  INITIALIZATION OF ALL LABELS...
    @FXML
    private Label totalBooks;
    @FXML
    private Label borrowedBooks;
    @FXML
    private Label subjects;
    @FXML
    private Label types;
    @FXML
    private Label readers;
    @FXML
    private Label booksName_1;
    @FXML
    private Label authorName_1;
    @FXML
    private Label booksName_2;
    @FXML
    private Label authorName_2;
    @FXML
    private Label booksName_3;
    @FXML
    private Label authorName_3;
    @FXML
    private JScrollPane scrollPane;
    //  INITIALIZATION OF ALL THE LABELS...
    //  WILL BE LOADED FROM THE DATABASE LATER...
    public void initialize() throws IOException {
        totalBooks.setText(booknum());
        borrowedBooks.setText("0");
        subjects.setText(booknum());
        types.setText(booknum());
        readers.setText(read_n());
        booksName_1.setText("HTML5 - Up and Running");
        booksName_2.setText("CSS - in Depth");
        booksName_3.setText("Java - How to program");
    }
    public static String booknum() throws IOException {
        String i;
        FileInputStream read = new FileInputStream("books.properties");
        Properties properties = new Properties();
        properties.load(read);
        i=properties.getProperty("i");
        read.close();
        properties.clear();
        return i;
    }
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
    public static void main(String[] args) throws IOException {
        setBooks();
    }
    public static String read_n() throws IOException {
        String i;
        FileInputStream read = new FileInputStream("Students.properties");
        Properties properties = new Properties();
        properties.load(read);
        i=properties.getProperty("i");
        read.close();
        properties.clear();
        return i;
    }
    public static void set_reader() throws IOException {
    }
}