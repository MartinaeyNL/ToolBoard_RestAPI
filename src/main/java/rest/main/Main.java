package rest.main;

import com.google.gson.Gson;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Main {

    // Variables
    static final URI BASE_URI = getBaseURI();

    // Starting class
    public static void main(String[] args) throws IOException {
        System.out.println("Starting grizzly...");
        HttpServer httpServer = startServer();
        System.in.read();
        httpServer.shutdownNow();
    }

    // Methods
    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new RestApplication());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(8088).build();
    }
}
