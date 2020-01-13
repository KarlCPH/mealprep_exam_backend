package facades;

import dtos.RecipeDTO;
import entities.RecipeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class RecipeFacade {

    private static RecipeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private RecipeFacade() {
    }


    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static RecipeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RecipeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //@Override
    public List<RecipeDTO> getAllRecipes() {
        EntityManager em = emf.createEntityManager();
        try {
            List<RecipeDTO> recipeDTOS = new ArrayList<>();
            List<RecipeEntity> recipeEntities = em.createNamedQuery("RecipeEntity.getAllRows", RecipeEntity.class).getResultList();
            recipeEntities.forEach(recipeEntity -> recipeDTOS.add(new RecipeDTO(recipeEntity)));
            return recipeDTOS;
        } finally {
            em.close();
        }
    }


}
