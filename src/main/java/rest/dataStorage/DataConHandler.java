package rest.dataStorage;

import com.google.gson.JsonObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public abstract class DataConHandler {

    // Variables
    public String urlString = null;
    public String[] credentials = null;

    private Connection connection = null;

    public Collection<JsonObject> executeQuery(String query) {

        // Getting the connection
        try { this.connection = DriverManager.getConnection(this.urlString, this.credentials[0], this.credentials[1]); }
        catch (SQLException ex) { ex.printStackTrace(); }

        // Executing the query
        Collection<JsonObject> toReturn = new ArrayList<>();
        Statement statement = null;
        try {
            // Preparing and executing the query
            ResultSet rSet = null;
            statement = connection.createStatement();
            rSet = statement.executeQuery(query);

            // Splitting the received objects
            if(rSet.isBeforeFirst() == true) {
                while(rSet.next()) {
                    JsonObject obj = new JsonObject();
                    for(int i = 1; i < (rSet.getMetaData().getColumnCount() + 1); i++) {
                        obj.addProperty(rSet.getMetaData().getColumnName(i), rSet.getString(i));
                    }
                    toReturn.add(obj);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try { statement.close(); }
            catch (SQLException e) { e.printStackTrace(); }
        }

        // Return
        if(!toReturn.isEmpty()) { return toReturn; }
        return new ArrayList<>();

    }

}
