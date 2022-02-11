package sptv20shoesshoparturstassenkofx;

import entity.User;
import facade.UserFacade;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import tools.Singleton;

public class ListUserController {
    private UserFacade userFacade;
    private Singleton singleton;
    
    @FXML
    private Button backButton;

    @FXML
    private ListView<User> listUser;

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
        userFacade= new UserFacade(User.class);
        singleton=Singleton.getInstance();
        listUser.getItems().clear();
        List<User> users=userFacade.findAll();
        for (int i = 0;i < users.size(); i++) {
            listUser.getItems().addAll(users.get(i));
        }    
    }

}
