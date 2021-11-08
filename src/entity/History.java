
package entity;

import java.io.Serializable;
import java.util.Date;

public class History implements Serializable{
    private Model model;
    private User user;
    private Date purchaseModel;


    public History(){

    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPurchaseModel() {
        return purchaseModel;
    }

    public void setPurchaseModel(Date purchaseModel) {
        this.purchaseModel = purchaseModel;
    }
}