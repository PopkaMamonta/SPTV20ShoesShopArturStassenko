package sptv20shoesshoparturstassenkofx;

import entity.Model;
import facade.ModelFacade;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import static javafx.scene.input.KeyCode.T;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import tools.Singleton;

public class ListModelController {
    private ModelFacade modelFacade;
    private Singleton singleton;
        
    @FXML
    private Button backButton;

    @FXML
    private ListView<Model> listModel;
    

    @FXML
    public void backButton(ActionEvent event)throws IOException{
        Parent tableViewParent=FXMLLoader.load(getClass().getResource("/sptv20shoesshoparturstassenkofx/Shop.fxml"));
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }

    @FXML
    public void initialize() {
        modelFacade= new ModelFacade(Model.class);
        singleton=Singleton.getInstance();
        listModel.getItems().clear();
        List<Model> models=modelFacade.findAll();
        for (int i = 0;i < models.size(); i++) {
            listModel.getItems().addAll(models.get(i));
        }    
    }
}


