package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDbAndRetrieveMetaData {
    private Connection connection = null;

    public void connectTo() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");    
            System.out.println("Driver Registered!");
            
           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root"); 
            System.out.println("Connected to db!");
            
            DatabaseMetaData dbMetaData = connection.getMetaData();
            
            
            ResultSet tables = dbMetaData.getTables(null, null, "%", new String[] {"TABLE"});
            
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Table: " + tableName);

                // Get columns
                ResultSet columns = dbMetaData.getColumns(null, null, tableName, "%");
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    int columnSize = columns.getInt("COLUMN_SIZE");
                    System.out.println("Column: " + columnName + ", Type: " + columnType + ", Size: " + columnSize);
                }
                columns.close();

                // Get number of rows
                Statement statement = connection.createStatement();
                ResultSet rowCountResultSet = statement.executeQuery("SELECT COUNT(*) FROM " + tableName);
                if (rowCountResultSet.next()) {
                    int rowCount = rowCountResultSet.getInt(1);
                    System.out.println("Number of rows in " + tableName + ": " + rowCount);
                }
                rowCountResultSet.close();
                statement.close();
            }
            tables.close();
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
