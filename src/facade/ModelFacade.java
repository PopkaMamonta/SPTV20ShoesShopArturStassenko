
package facade;

import entity.Model;
import javax.persistence.EntityManager;
import tools.Singleton;

public class ModelFacade extends AbstractFacade<Model> {
    
    @Override
    protected EntityManager getEntityManager() {
        Singleton singleton=Singleton.getInstance();
        return singleton.getEntityManager();
    }
    
    public ModelFacade(Class<Model> entityClass) {
        super(entityClass);
    }
}
