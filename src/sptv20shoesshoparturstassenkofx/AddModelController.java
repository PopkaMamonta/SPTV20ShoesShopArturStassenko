package sptv20shoesshoparturstassenkofx;

import entity.Model;
import facade.ModelFacade;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import tools.Singleton;

public class AddModelController {
        private ModelFacade modelFacade;
        private Singleton singleton;
    

    @FXML
    private Button addModelButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField brandShoe;

    @FXML
    private TextField nameShoe;

    @FXML
    private TextField price;

    @FXML
    private TextField quantity;

    @FXML
    private TextField sizeShoe;

    @FXML
    public void backButton(ActionEvent event)throws IOException{
        Parent tableViewParent=FXMLLoader.load(getClass().getResource("/sptv20shoesshoparturstassenkofx/Shop.fxml"));
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }
    @FXML
    void addModel(ActionEvent event)throws SQLException {
        modelFacade= new ModelFacade(Model.class);
        singleton=Singleton.getInstance();

        Window owner = addModelButton.getScene().getWindow();

        System.out.println(brandShoe.getText());
        System.out.println(nameShoe.getText());
        System.out.println(price.getText());
        System.out.println(quantity.getText());
        System.out.println(sizeShoe.getText());
        if (brandShoe.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Введите, пожалуйста, брэнд!");
            return;
        }

        if (nameShoe.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Введите, пожалуйста, название!");
            return;
        }
        if (price.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Введите, пожалуйста, цену!");
            return;
        }
        if (quantity.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Введите, пожалуйста, количество!");
            return;
        }
        if (sizeShoe.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Введите, пожалуйста, размер!");
            return;
        }
        Model model=new Model();
        model.setBrand(brandShoe.getText());
        model.setName(nameShoe.getText());
        model.setSize(Integer.parseInt(sizeShoe.getText()));
        model.setPrice(Integer.parseInt(price.getText()));
        model.setQuantity(Integer.parseInt(quantity.getText()));
        modelFacade.create(model);
        
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Обувь добавлена!");
    }


    private static void showAlert(Alert.AlertType alertType, Window owner, String message) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    }


