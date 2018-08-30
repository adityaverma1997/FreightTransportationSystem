package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataConnection {
private static Connection con = null;

    private DataConnection() {
    }

    public static Connection getConnection() throws Exception {
        if (con == null) {
            Class.forName(Config.DRIVER_NAME);
            con = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASS);
        }
        return con;
    }

    public static void closeConnection() throws Exception {
        if (con != null) {
            con.close();
        }
        con = null;
    }

    public static PreparedStatement getStatement(String query) throws Exception {
        return getConnection().prepareStatement(query);
    }    
}
