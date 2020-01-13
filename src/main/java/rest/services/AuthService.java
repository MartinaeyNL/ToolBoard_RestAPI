package rest.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import rest.dataModels.User;
import rest.dataHandlers.DatabaseHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("auth")
public class AuthService implements Service {

    // Variables
    private final Gson gson = new Gson();
    private DatabaseHandler dbHandler;

    // Constructor
    public AuthService() {
        this.dbHandler = new DatabaseHandler();
    }

    /*---------------------------------------------------*/

    // Methods
    @POST
    @Path("/connectUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response connectUser(User user) {
        Collection<JsonObject> received = dbHandler.connectUser(user);
        String toReturn = gson.toJson(received);
        System.out.println(toReturn);
        return Response.ok(toReturn, MediaType.APPLICATION_JSON).build();
    }


    @GET
    @Path("/getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        Collection<JsonObject> received = dbHandler.getAllUsers();
        return Response.ok(gson.toJson(received), MediaType.APPLICATION_JSON).build();
    }

    // Works too ;)
    @POST
    @Path("/testRest")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response testRest(@QueryParam("test")String test) {
        System.out.println("Test is [" + test + "]");
        return Response.ok("Hey welcome to the rest server [" + test + "]", MediaType.TEXT_PLAIN).build();
    }
}
