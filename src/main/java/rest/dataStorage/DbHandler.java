package rest.dataStorage;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collection;

public class DbHandler {

    // Variables
    DataConHandler dataConHandler;

    // Constructor
    public DbHandler() {
        this.dataConHandler = new MySqlConHandler();
    }

    /*--------------------------------------------------*/

    // Methods
    public Collection<JsonObject> getAllUsers() {
        Collection<JsonObject> toReturn = this.dataConHandler.executeQuery("SELECT * FROM `Users`");
        if(toReturn != null) { return toReturn; }
        return new ArrayList<>();
    }
}
