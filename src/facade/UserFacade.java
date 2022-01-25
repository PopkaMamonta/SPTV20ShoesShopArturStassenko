
package facade;

import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import tools.Singleton;

public class UserFacade extends AbstractFacade<User>{
    


    @Override
    protected EntityManager getEntityManager() {
        Singleton singleton=Singleton.getInstance();
        return singleton.getEntityManager();
    }
   
    public UserFacade(Class<User> entityClass) {
        super(entityClass);
    }
}
