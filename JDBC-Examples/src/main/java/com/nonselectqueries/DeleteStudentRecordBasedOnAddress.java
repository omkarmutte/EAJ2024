package com.nonselectqueries;

import java.sql.*;
import java.util.Scanner;

// IF WE ARE EXECUTING NON-SELECT SQL QUERY WITH THE HELP OF JDBC THEN AUTO-COMMIT BY DEFAULT IS ENABLED(TRUE)

public class DeleteStudentRecordBasedOnAddress {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static final String USERNAME = "C##ELITEAJ2024";
    public static final String PASSWORD = "elite2024";

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String name = null;
        String query = null;

        // 1. load the JDBC driver classname to the DriverManager service
//        Class.forName("oracle.jdbc.driver.OracleDriver");  : No need because autoload of JDBC driver is done in JDBC 4.0+
        System.out.print("Enter student name : ");

        if (scn != null) {
            name = scn.nextLine();
        }
        name = "'" + name + "'";
        query = "DELETE FROM STUDENT WHERE student_nm=" + name;

        // 2. Establish the connection
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            if (connection != null) {
                // 3. create a statement
                try (Statement statement = connection.createStatement()) {
                    if (statement != null) {
                        int affectedRows = 0;
                        // 4. execute the query and get the result set
                        affectedRows = statement.executeUpdate(query);
                        if (affectedRows == 0) {
                            System.out.println("Record not found");
                        } else {
                            System.out.println(affectedRows + " record(s) deleted");
                        }
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
