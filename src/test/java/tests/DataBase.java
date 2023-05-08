package tests;

import org.junit.Assert;
import utils.ConfigFileParser;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class DataBase {

    private static Connection con = null;
    private static Statement stmt;
    private static String DB_URL = ConfigFileParser.parser("DB_URL");
    private static String DB_USER = ConfigFileParser.parser("DB_USER");
    private static String DB_PASSWORD = ConfigFileParser.parser("DB_PASSWORD");


    private static void SeleniumDatabaseConfiguration() {
        try {
            String dbClass = "org.postgresql.Driver";
            Class.forName(dbClass).newInstance();
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String runQuery(String query) throws SQLException {
        String queryResult = null;
        try {
            SeleniumDatabaseConfiguration();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                queryResult = res.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tearDown();
        }

        return queryResult;
    }

    public void validateNameSurnameLength(String DbQueryOutPut) {
        String delims = "[ ]+";
        String[] tokens = DbQueryOutPut.split(delims);
        Assert.assertTrue("Invalid surname format: " + tokens[0] + " lenght is to short", (tokens[0].length() >= 5));
        System.out.println("last name length: " + tokens[0].length());
        Assert.assertTrue("Invalid name format, " + tokens[1] + " lenght is to short", (tokens[1].length() >= 3));
        System.out.println("first name length: " + tokens[1].length());
    }

    public Map<String, String> mapPopulation (String inputQuery) throws SQLException {
        Map<String, String> queryResult = new HashMap();
        try {
            SeleniumDatabaseConfiguration();
            ResultSet res = stmt.executeQuery(inputQuery);
            while (res.next()) {
                queryResult.put(res.getString(1),res.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tearDown();
        }
        return queryResult;
    }

    private void tearDown() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}

