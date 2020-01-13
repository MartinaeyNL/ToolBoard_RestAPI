package rest.dataHandlers;

import com.google.gson.JsonObject;
import rest.dataConnections.ConnectionHandler;
import rest.dataConnections.MySqlConHandler;
import rest.dataModels.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class DatabaseHandler {

    // Variables
    private ConnectionHandler dataConHandler;

    // Constructor
    public DatabaseHandler() {
        this.dataConHandler = new MySqlConHandler();
    }

    /*--------------------------------------------------*/

    // Methods
    public Collection<JsonObject> getAllUsers() {
        Collection<JsonObject> result = new ArrayList<>();
        try { result = this.dataConHandler.executeQuery("SELECT * FROM `Users`"); }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public Collection<JsonObject> connectUser(User user) {
        Collection<JsonObject> result = new ArrayList<>();
        try {
            // Try to add user to database, will return components if it exists (aka logs in).
            result = this.dataConHandler.executeQuery("INSERT INTO `Users` " +
                "(`displayname`, `twitchUserId`) " +
                "VALUES ('" + user.displayname + "', '" + user.twitchUserId + "');");
        }
        catch(SQLException ex) {
            switch (ex.getErrorCode()) {
                // If duplicate entry, return a "login" result.
                case 1062: {
                    JsonObject obj = new JsonObject();
                    obj.addProperty("result", 1);
                    result.add(obj);
                }
            }
        }
        return result;
    }
}
