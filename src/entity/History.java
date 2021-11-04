
package entity;

import java.util.Date;

public class History {
    private Model model;
    private User user;
    private Date purchaseBook;


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

    public Date getPurchaseBook() {
        return purchaseBook;
    }

    public void setPurchaseBook(Date purchaseBook) {
        this.purchaseBook = purchaseBook;
    }
}