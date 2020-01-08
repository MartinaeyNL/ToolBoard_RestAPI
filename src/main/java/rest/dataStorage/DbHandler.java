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
        //Collection<JsonObject> toReturn = new ArrayList<>();
        //try {
        //    Statement statement = this.dataConHandler.executeQuery("SELECT * FROM `Users`");
        //    if(set.next() == true) {
        //        JsonObject obj = new JsonObject();
        //        obj.addProperty("displayname", set.getString(1));
        //        obj.addProperty("twitchToken", set.getString(2));
        //        toReturn.add(obj);
        //    }
        //    if(toReturn.size() > 0) { return toReturn; }
        //    return null;
        //}
        //catch (SQLException ex) { ex.printStackTrace(); }
        //return toReturn;
}
