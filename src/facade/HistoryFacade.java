
package facade;

import entity.History;
import entity.Model;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import tools.Singleton;

public class HistoryFacade extends AbstractFacade<History>{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTV20ShoesShopArturStassenkoPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    @Override
    protected EntityManager getEntityManager() {
        Singleton singleton=Singleton.getInstance();
        return singleton.getEntityManager();
    }
    public HistoryFacade(Class<History> entityClass) {
        super(entityClass);
    }
    
    public History findHistoryByModel(Model model) {
        try {
            return (History) getEntityManager().createQuery("SELECT h FROM History h WHERE h.model = :model")
                    .setParameter("model", model)
                    .getSingleResult(); 
        } catch (Exception e) {
            return null;
        }
    }
    

    
}
