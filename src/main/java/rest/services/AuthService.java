package rest.services;

import com.google.gson.Gson;
import rest.dataModels.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
public class AuthService implements Service {

    // Variables
    private final Gson gson = new Gson();

    @POST
    @Path("/createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        return Response.ok(gson.toJson(user), MediaType.APPLICATION_JSON).build();
    }
    // WORKED:
    //public Response createUser() {
    //    return Response.ok().build();
    //}
}
