package ma.enset.javafxactivitypratique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProductApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,450,500);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        stage.setTitle("Product Management Application ");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
