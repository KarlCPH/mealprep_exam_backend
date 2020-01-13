package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dtos.RecipeDTO;
import facades.RecipeFacade;
import facades.ScraperFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

//Todo Remove or change relevant parts before ACTUAL use
@Path("recipes")
public class RecipesResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/startcode",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final RecipeFacade RECIPE_FACADE = RecipeFacade.getFacadeExample(EMF);
    private static final ScraperFacade SCRAPER_FACADE = ScraperFacade.getScraperFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    @RolesAllowed("user")
    public String getAllRecipes() {
        List<RecipeDTO> recipes = RECIPE_FACADE.getAllRecipes();
        return GSON.toJson(recipes);
    }

    @Path("global")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getGlobalRecipes() throws ExecutionException, InterruptedException {
        StringBuilder jsonStr = new StringBuilder();
        for (String json : SCRAPER_FACADE.getAllApiData()) {
            jsonStr.append(json);
        }
        JsonParser jsonParser = new JsonParser();
        JsonElement data = jsonParser.parse(jsonStr.toString());
        return GSON.toJson(data);
    }


}
