package com.fje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBCExample {
    public static void main(String[] args) {
        // step 1: load the driver (optional for JDBC 4.0+)
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // step 2: establish the connection
            try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "C##ELITEAJ2024", "elite2024");
                 // step 3: create the statement
                 Statement statement = connection.createStatement();
                 // step 4: execute the query
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT")) {

                // step 5: iterate the result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "
                            + resultSet.getInt(3) + " " + resultSet.getString(4) + " " + resultSet.getDouble(5));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
