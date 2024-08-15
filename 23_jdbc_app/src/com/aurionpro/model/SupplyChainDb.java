package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SupplyChainDb {

    private Connection connection = null;
    private Statement statement = null;

    public void connectToDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supplychain", "root", "root");
            System.out.println("Connection Successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void getProductsWithSuppliers() {
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT p.Name AS ProductName, s.Name AS SupplierName FROM products AS p JOIN suppliers AS s ON p.SupplierID = s.SupplierID");

            System.out.println("Products along with supplier name");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findSuppliersForProduct() {
        String query = "SELECT s.name, s.supplierid, p.name FROM products AS p JOIN suppliers AS s ON s.supplierid = p.supplierid";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findProductsSuppliedByMoreThanOneSupplier() {
        String query = "SELECT p.ProductID, p.Name AS ProductName, " +
                       "COUNT(DISTINCT p.SupplierID) AS SupplierCount " +
                       "FROM products AS p GROUP BY p.ProductID, p.Name " +
                       "HAVING SupplierCount > 1";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Products Supplied by More Than One Supplier");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listSuppliersWithoutProducts() {
        String query = "SELECT s.SupplierID, s.Name AS SupplierName " +
                       "FROM suppliers AS s LEFT JOIN products AS p ON s.SupplierID = p.SupplierID " +
                       "WHERE p.SupplierID IS NULL";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Suppliers Without Products");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findAllOrdersLastMonth() {
        String query = "SELECT OrderID, OrderDate " +
                       "FROM orders WHERE OrderDate >= CURDATE() - INTERVAL 1 MONTH";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Orders Placed Within the Last Month");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTotalQuantityOrderedForEachProduct() {
        String query = "SELECT p.name AS ProductName, SUM(od.Quantity) AS TotalQuantityOrdered " +
                       "FROM orderdetails AS od JOIN products AS p ON od.ProductID = p.ProductID " +
                       "GROUP BY p.name";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Total Quantity Ordered for Each Product");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveAllOrdersWithTotalAmount() {
        String query = "SELECT o.OrderID, SUM(od.Quantity * od.Price) AS TotalAmount " +
                       "FROM orders AS o JOIN orderdetails AS od ON o.OrderID = od.OrderID " +
                       "GROUP BY o.OrderID";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Orders Along with the Total Amount Spent for Each Order");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllOrdersWithDetails() {
        String query = "SELECT od.quantity, p.name, o.orderid, o.orderdate, od.price " +
                       "FROM orderdetails AS od JOIN orders AS o ON od.orderid = o.orderid " +
                       "JOIN products AS p ON od.productid = p.productid";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Orders with Details Including Product Names and Quantities");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listAllProductsAndInventory() {
        String query = "SELECT p.Name AS ProductName, i.QuantityOnHand " +
                       "FROM products AS p JOIN inventory AS i ON p.productid = i.fk_productid";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Products and Their Current Inventory Levels");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAverageInventoryForEachProduct() {
        String query = "SELECT p.Name AS ProductName, AVG(i.QuantityOnHand) AS AverageInventory " +
                       "FROM products AS p JOIN inventory AS i ON p.ProductID = i.fk_productID " +
                       "GROUP BY p.Name";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Average Inventory Level for Each Product");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
