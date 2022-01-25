
package tools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Singleton {
    private static Singleton instance;
    private EntityManager em;
    
    private Singleton(){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SPTV20ShoesShopArturStassenkoPU");
        em=emf.createEntityManager();
    }
    
    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
}