package ma.enset.javafxactivitypratique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


//Créer une application JavaFX qui permet de gérer les produits. L'application se compose des éléments suivants:
//1- Une classe Product avec deux attributs name et price, des constructeurs, des getters, des setters et la méthode toString.
//2- Créer la vue product-view qui affiche un formulaire et une listeview pour afficher les produits.
//3- Créer le controlleur ProuctController qui réponds aux actions de l'utilisateur.
//4- Créer une feuille de style css à appliquer sur l'interface graphique.
//5- Créer une classe application avec la méthode start pour démarer l'application.


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
