package rest.main;

import rest.services.AuthService;
import rest.services.Service;
import rest.services.UserService;

import java.util.*;
import javax.ws.rs.core.Application;

public class RestApplication extends Application {

    @Override // Setting the list of which Services to run
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(AuthService.class);
        //set.add(UserService.class);
        return set;
    }

}
