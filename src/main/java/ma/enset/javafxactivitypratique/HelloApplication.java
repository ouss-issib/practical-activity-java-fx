package ma.enset.javafxactivitypratique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


//Créer une application JavaFX qui permet de gérer les produits. L'application se compose des éléments suivants:
//2- Créer la vue product-view qui affiche un formulaire et une listeview pour afficher les produits.
//3- Créer le controlleur ProuctController qui réponds aux actions de l'utilisateur.
//4- Créer une feuille de style css à appliquer sur l'interface graphique.
//5- Créer une classe application avec la méthode start pour démarer l'application.


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 500);
        stage.setTitle("Product Management Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
