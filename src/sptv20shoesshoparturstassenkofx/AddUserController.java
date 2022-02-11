package sptv20shoesshoparturstassenkofx;

import entity.User;
import facade.ModelFacade;
import facade.UserFacade;
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

public class AddUserController {
    private UserFacade userFacade;
    private Singleton singleton;
    @FXML
    private Button addUserButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField fulnameUser;

    @FXML
    private TextField moneyUser;

    @FXML
    private TextField nameUser;

    @FXML
    private TextField telUser;

    @FXML
    void addUser(ActionEvent event) throws SQLException{
        userFacade= new UserFacade(User.class);
        singleton=Singleton.getInstance();

        Window owner = addUserButton.getScene().getWindow();

        System.out.println(nameUser.getText());
        System.out.println(fulnameUser.getText());
        System.out.println(telUser.getText());
        System.out.println(moneyUser.getText());
        if (nameUser.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Введите, пожалуйста, имя!");
            return;
        }

        if (fulnameUser.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Введите, пожалуйста, фамилию!");
            return;
        }
        if (telUser.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Введите, пожалуйста, номер телефона!");
            return;
        }
        if (moneyUser.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner,"Введите, пожалуйста, количество денег!");
            return;
        }
        User user=new User();
        user.setName(nameUser.getText());
        user.setSurname(fulnameUser.getText());
        user.setTel(telUser.getText());
        user.setAmountMoney(Integer.parseInt(moneyUser.getText()));
        userFacade.create(user);
        
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Пользователь добавлен!");
    }


    private static void showAlert(Alert.AlertType alertType, Window owner, String message) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    

    @FXML
    public void backButton(ActionEvent event)throws IOException{
        Parent tableViewParent=FXMLLoader.load(getClass().getResource("/sptv20shoesshoparturstassenkofx/Shop.fxml"));
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }
    

}
