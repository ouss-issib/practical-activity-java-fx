module ma.enset.javafxactivitypratique {
    requires javafx.controls;
    requires javafx.fxml;


    opens ma.enset.javafxactivitypratique to javafx.fxml;
    exports ma.enset.javafxactivitypratique;
}