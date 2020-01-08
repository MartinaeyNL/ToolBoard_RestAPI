package rest.dataStorage;

public class MySqlConHandler extends DataConHandler {

    // Constructor
    public MySqlConHandler() {

        // Finding driver
        try { Class.forName("com.mysql.cj.jdbc.Driver"); }
        catch (ClassNotFoundException e) { e.printStackTrace(); }

        // Setting parameters
        this.urlString = "jdbc:mysql://185.5.52.135:3306/toolboardV1";
        this.credentials = new String[] { "root", "test23" };
    }
}
