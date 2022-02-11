package sptv20shoesshoparturstassenkofx;

import entity.History;
import entity.Model;
import entity.User;
import facade.HistoryFacade;
import facade.ModelFacade;
import facade.UserFacade;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

public class PurchaseShoeController {
    private HistoryFacade historyFacade;
    private ModelFacade modelFacade;
    private UserFacade userFacade;
    private Singleton singleton;
    @FXML
    private Button backButton;

    @FXML
    private ListView<Model> listModel;

    @FXML
    private ListView<User> listUser;

    @FXML
    private Button purchaseButton;

    @FXML
        public void backButton(ActionEvent event)throws IOException{
        Parent tableViewParent=FXMLLoader.load(getClass().getResource("/sptv20shoesshoparturstassenkofx/Shop.fxml"));
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }

    @FXML
    void purchase(ActionEvent event)throws SQLException {
        userFacade= new UserFacade(User.class);
        modelFacade= new ModelFacade(Model.class);
        historyFacade=new HistoryFacade(History.class);
        singleton=Singleton.getInstance();
        Long indexModel=listModel.getSelectionModel().getSelectedItem().getId();
        Model model=modelFacade.find((long) indexModel);
        Long indexUser=listUser.getSelectionModel().getSelectedItem().getId();
        User user=userFacade.find((long) indexUser);
        if (user.getAmountMoney()>=model.getPrice()
                &&model.getQuantity()>0) {
            History history=new History();
            history.setModel(model);
            history.setUser(user);
            Calendar c=new GregorianCalendar();
            history.setPurchaseModel(c.getTime());
            historyFacade.create(history);
            model.setQuantity(model.getQuantity()-1);
            modelFacade.edit(model);
            user.setAmountMoney(user.getAmountMoney()-model.getPrice());
            userFacade.edit(user);
        }
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
        modelFacade= new ModelFacade(Model.class);
        listModel.getItems().clear();
        List<Model> models=modelFacade.findAll();
        for (int i = 0;i < models.size(); i++) {
            listModel.getItems().addAll(models.get(i));
        }   
    }

}
