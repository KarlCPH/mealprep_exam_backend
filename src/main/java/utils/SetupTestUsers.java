package utils;


import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class SetupTestUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        persistRecipeEntities(emf);
        persistUserEntities(emf);

    }
    private static void persistRecipeEntities(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        DayplanEntity dayplanEntity0 = new DayplanEntity();
        DayplanEntity dayplanEntity1 = new DayplanEntity();
        DayplanEntity dayplanEntity2 = new DayplanEntity();

        IngredientEntity ingredientEntity0 = new IngredientEntity();
        IngredientEntity ingredientEntity1 = new IngredientEntity();
        IngredientEntity ingredientEntity2 = new IngredientEntity();

        ItemEntity itemEntity0 = new ItemEntity();
        ItemEntity itemEntity1 = new ItemEntity();
        ItemEntity itemEntity2 = new ItemEntity();

        MenuplanEntity menuplanEntity0 = new MenuplanEntity();
        MenuplanEntity menuplanEntity1 = new MenuplanEntity();
        MenuplanEntity menuplanEntity2 = new MenuplanEntity();

        RecipeEntity recipeEntity0 = new RecipeEntity();
        RecipeEntity recipeEntity1 = new RecipeEntity();
        RecipeEntity recipeEntity2 = new RecipeEntity();

        recipeEntity0.setDescription("FREDAGSMYS");
        recipeEntity0.setIngredients("Meat 500g, 2 onions, etc");
        recipeEntity0.setPrep("");
        recipeEntity0.setPrep_time("20min");
        recipeEntity0.setPreparation_steps("make the meat etc");

    }

    private static void persistUserEntities(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
        // CHANGE the three passwords below, before you uncomment and execute the code below
        // Also, either delete this file, when users are created or rename and add to .gitignore
        // Whatever you do DO NOT COMMIT and PUSH with the real passwords

        User user = new User("user", "test");
        User admin = new User("admin", "test");
        User both = new User("user_admin", "test");

        if (admin.getUserPass().equals("test") || user.getUserPass().equals("test") || both.getUserPass().equals("test"))
            throw new UnsupportedOperationException("You have not changed the passwords");

        em.getTransaction().begin();
        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        em.persist(userRole);
        em.persist(adminRole);
        em.persist(user);
        em.persist(admin);
        em.persist(both);
        em.getTransaction().commit();
        System.out.println("PW: " + user.getUserPass());
        System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
        System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
        System.out.println("Created TEST Users");
    }
}
