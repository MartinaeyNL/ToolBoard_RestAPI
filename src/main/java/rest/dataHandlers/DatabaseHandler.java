package rest.dataHandlers;

import com.google.gson.JsonObject;
import rest.dataConnections.ConnectionHandler;
import rest.dataConnections.MySqlConHandler;
import rest.dataModels.User;

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
        return this.dataConHandler.executeQuery("SELECT * FROM `Users`");
    }

    public Collection<JsonObject> createNewUser(User user) {
        return this.dataConHandler.executeQuery("INSERT INTO `Users` " +
                "(`userID`, `displayname`, `twitchToken`) " +
                "VALUES (NULL, '" + user.displayname + "', '" + user.twitchToken + "');");
    }
}
