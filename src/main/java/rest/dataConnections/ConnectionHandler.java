package rest.dataConnections;

import com.google.gson.JsonObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public abstract class ConnectionHandler {

    // Variables
    public String urlString;
    public String[] credentials;

    private Connection connection = null;

    public Collection<JsonObject> executeQuery(String query) throws SQLException {

        // Getting the connection
        try { this.connection = DriverManager.getConnection(this.urlString, this.credentials[0], this.credentials[1]); }
        catch (SQLException ex) { ex.printStackTrace(); }

        // Executing the query
        Collection<JsonObject> toReturn = new ArrayList<>();
        Statement statement = null;
        try {
            // Preparing and executing the query
            statement = connection.createStatement();
            if(query.contains("INSERT") || query.contains("UPDATE") || query.contains("DELETE")) {
                int result = statement.executeUpdate(query);
                JsonObject obj = new JsonObject();
                obj.addProperty("result", result);
                toReturn.add(obj);
            }
            else {
                ResultSet rSet = null;
                rSet = statement.executeQuery(query);

                // Splitting the received objects
                if(rSet.isBeforeFirst()) {
                    while(rSet.next()) {
                        JsonObject obj = new JsonObject();
                        for(int i = 1; i < (rSet.getMetaData().getColumnCount() + 1); i++) {
                            obj.addProperty(rSet.getMetaData().getColumnName(i), rSet.getString(i));
                        }
                        toReturn.add(obj);
                    }
                }
            }
        } finally {
            try { if(statement != null) { statement.close(); } }
            catch (SQLException | NullPointerException e) { e.printStackTrace(); }
        }

        // Return
        if(!toReturn.isEmpty()) { return toReturn; }
        return new ArrayList<>();

    }

}
