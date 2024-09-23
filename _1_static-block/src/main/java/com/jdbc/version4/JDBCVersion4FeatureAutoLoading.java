package com.jdbc.version4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCVersion4FeatureAutoLoading {
    // step 1: make sure that ojdbc6/7/8/...jar is added into the classpath
    // NOTE: from oracle11g all the oracle thin drivers that are coming along with oracle installation are based on JDBC4 version supporting AUTO LOADING the JDBC driver class feature

    public static void main(String[] args) throws SQLException {
        // Here we are not loaded the JDBC driver class explicitly because it is already loaded by default because of auto loading feature introduced in JDBC4 version onwards
        // Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");

        if (connection != null) {
            System.out.println("Connection established");
            System.out.println("classname of the connection object : "+connection.getClass().getName()); // oracle.jdbc.driver.T4CConnection
        } else {
            System.out.println("failed to connect with oracle database");
        }

        Statement statement = connection.createStatement();
        if (statement != null) {
            System.out.println("statement object created whose name is : "+statement.getClass().getName()); // oracle.jdbc.driver.OracleStatementWrapper
        } else {
            System.out.println("statement object creation failed");
        }

    }
}
