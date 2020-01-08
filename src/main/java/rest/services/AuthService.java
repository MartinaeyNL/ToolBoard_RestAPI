package rest.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import rest.dataModels.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
public class AuthService implements Service {

    // Variables
    private final Gson gson = new Gson();

    /*---------------------------------------------------*/

    // Methods
    @POST
    @Path("/createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        System.out.println("User is [" + user + "]");
        return Response.ok(gson.toJson(user), MediaType.APPLICATION_JSON).build();
    }

    // WORKS:
    @POST
    @Path("/testRest")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response testRest(@QueryParam("test")String test) {
        System.out.println("Test is [" + test + "]");
        return Response.ok("Hey welcome to the rest server [" + test + "]", MediaType.TEXT_PLAIN).build();
    }
}
