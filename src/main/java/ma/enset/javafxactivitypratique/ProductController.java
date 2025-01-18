package ma.enset.javafxactivitypratique;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class ProductController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(list);
    }

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldPrice;

    @FXML
    private ListView<Product> listView;

    private ObservableList<Product> list = FXCollections.observableArrayList();

    @FXML
    protected void onSearchProduct() {
        boolean isFound = false;
        if(textFieldName.getText().trim().isEmpty()){
            showAlert("Error", "Please enter a product name", Alert.AlertType.ERROR);
        }
        else {
            for(Product p : list){
                if(p.getName().equalsIgnoreCase(textFieldName.getText())){
                    textFieldPrice.setText(Double.toString(p.getPrice()));
                    isFound = true;
                }
            }
            if(!isFound){
                showAlert("Error", "Product not found", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    protected void onAddProduct() {
        if(textFieldName.getText().trim().isEmpty() || textFieldPrice.getText().trim().isEmpty()) {
            showAlert("Error", "Please enter a product name and price", Alert.AlertType.ERROR);
        }
        else{
            if(!isValidPrice(textFieldPrice.getText())){
                showAlert("Error", "Please enter a valid price", Alert.AlertType.ERROR);
            }
            else
            {
                Product product = new Product(textFieldName.getText(), Double.parseDouble(textFieldPrice.getText()));
                list.add(product);
                textFieldName.clear();
                textFieldPrice.clear();
            }
        }
    }

    @FXML
    protected void onDeleteProduct() {
        if(listView.getSelectionModel().getSelectedItem() == null){
            showAlert("Error", "Please select a product to delete",Alert.AlertType.WARNING);
        }
        else{
            list.remove(listView.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    protected void onUpdateProduct() {
        boolean isUpdated = false;
       if(textFieldPrice.getText().trim().isEmpty()) {
           showAlert("Error", "Please enter a product price", Alert.AlertType.ERROR);
       }
       else{
           for(Product p : list){
               if(p.getName().equalsIgnoreCase(textFieldName.getText())){
                    p.setPrice(Double.parseDouble(textFieldPrice.getText()));
                    isUpdated = true;
                    break;
               }
           }
       }
       if(!isUpdated){
           showAlert("Error", "Product not updated", Alert.AlertType.ERROR);
       }
       else
       {
           showAlert("Information","Product Updated Successfully ", Alert.AlertType.INFORMATION);
           listView.refresh();
           textFieldName.clear();
           textFieldPrice.clear();
       }
    }

    private void showAlert(String title, String message,Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private boolean isValidPrice(String price) {
        try{
            Double.parseDouble(price);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
