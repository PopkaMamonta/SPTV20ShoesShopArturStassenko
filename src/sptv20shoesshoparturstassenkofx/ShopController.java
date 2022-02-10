package sptv20shoesshoparturstassenkofx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ShopController {

    @FXML
    private Button add_model;

    @FXML
    private Button add_moneyuser;

    @FXML
    private Button add_user;

    @FXML
    private Button backButton;

    @FXML
    private Button change_inf;

    @FXML
    private Button income_permonth;

    @FXML
    private Button income_shop;

    @FXML
    private Button list_model;

    @FXML
    private Button purchase_shoe;

    @FXML
    private Button reg_listuser;

    @FXML
        public void addModel(ActionEvent event)throws IOException{
        Parent tableViewParent=FXMLLoader.load(getClass().getResource("/sptv20shoesshoparturstassenkofx/AddModel.fxml"));
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }
        
    @FXML
        public void backButton(ActionEvent event)throws IOException{
        Parent tableViewParent=FXMLLoader.load(getClass().getResource("/sptv20shoesshoparturstassenkofx/FXML.fxml"));
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }
    @FXML
        public void listModel(ActionEvent event)throws IOException{
        Parent tableViewParent=FXMLLoader.load(getClass().getResource("/sptv20shoesshoparturstassenkofx/ListModel.fxml"));
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }
    }

