package com.saje;

import java.sql.*;
import java.util.Scanner;

public class EmployeeJDBCExample {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static final String USERNAME = "C##ELITEAJ2024";
    public static final String PASSWORD = "elite2024";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Scanner scn = new Scanner(System.in);

        try {

            System.out.print("Enter employee salary range (lower limit) :  ");
            double lowerLimit = Double.parseDouble(scn.nextLine()); // 50000
            System.out.print("Enter employee salary range (upper limit) :  ");
            double upperLimit = Double.parseDouble(scn.nextLine()); // 70000

            // 1. Load the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Establish the connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 3. Create the statement for table creation
            statement = connection.createStatement();

            // 4. Execute the table creation query (if not already created)

//            resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_SALARY BETWEEN " + lowerLimit + " AND " + upperLimit);
            resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_SALARY BETWEEN " + lowerLimit + " AND " + upperLimit);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2)+" : "+resultSet.getDouble(4));
            }


        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            scn.close(); // Close scanner resource
        }
    }
}
