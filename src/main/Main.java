package main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = primaryStage;
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("img/icon.jpg")));
        stage.setTitle("Library Management System");
        scene = new Scene(root, 650, 378);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    //  SWITCHES THE SCENES OF THE STAGE (WINDOW)
    public static void Switch_S(String fileName) throws IOException {
        root = FXMLLoader.load(Main.class.getResource(fileName));
        scene = new Scene(root, 750, 500);
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}