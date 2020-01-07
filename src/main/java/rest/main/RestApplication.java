package rest.main;

import rest.services.AuthService;

import java.util.*;
import javax.ws.rs.core.Application;

public class RestApplication extends Application {

    @Override // Setting the list of Services to run
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(AuthService.class);
        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }

}
