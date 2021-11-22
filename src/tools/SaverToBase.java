
package tools;

import entity.History;
import entity.Model;
import entity.User;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaverToBase implements Keeping {
    private EntityManagerFactory emf=Persistence.createEntityManagerFactory("SPTV20ShoesShopArturStassenkoPU");
    private EntityManager em=emf.createEntityManager();
    private EntityTransaction tx=em.getTransaction();
    

    @Override
    public void saveModels(List<Model> models) {
        tx.begin();
        for (int i = 0;i< models.size(); i++) {
            if (models.get(i).getId()==null) {
                em.persist(models.get(i));
            }
        }
        tx.commit();
    }

    @Override
    public List<Model> loadModels() {
        List<Model> models=null;
        try{
            return em.createQuery("SELECT m FROM Model m").getResultList();
        }catch(Exception e){
            models=new ArrayList<>();
        }
        return models;
    }

    @Override
    public void saveUsers(List<User> users) {
        tx.begin();
        for (int i = 0;i< users.size(); i++) {
            if (users.get(i).getId()==null) {
                em.persist(users.get(i));
            }
        }
        tx.commit();
    }

    @Override
    public List<User> loadUsers() {
        List<User> users=null;
        try{
            return em.createQuery("SELECT u FROM User u").getResultList();
        }catch(Exception e){
            users=new ArrayList<>();
        }
        return users;
    }

    @Override
    public void saveHistories(List<History> histories) {
        tx.begin();
        for (int i = 0;i< histories.size(); i++) {
            if (histories.get(i).getId()==null) {
                em.persist(histories.get(i));
            }
        }
        tx.commit();
    }

    @Override
    public List<History> loadHistories() {
        List<History> histories=null;
        try{
            return em.createQuery("SELECT h FROM History h").getResultList();
        }catch(Exception e){
            histories=new ArrayList<>();
        }
        return histories;
    }
}
