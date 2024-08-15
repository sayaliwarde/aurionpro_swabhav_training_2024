<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5; /* Light nude background */
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #6d4c41; /* Medium brown for header */
            padding: 20px;
            color: white;
            text-align: center;
        }
        .container {
            width: 80%;
            max-width: 1000px;
            margin: 50px auto;
            background-color: #fff; /* White background for content */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #4a3c31; /* Dark brown for headings */
            margin-bottom: 20px;
        }
        a {
            display: block;
            margin: 10px 0;
            padding: 10px 20px;
            background-color: #6d4c41; /* Medium brown for links */
            color: white;
            text-decoration: none;
            border-radius: 6px;
            text-align: center;
        }
        a:hover {
            background-color: #4a3c31; /* Darker brown for hover effect */
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Welcome Admin</h1>
    </div>
    <div class="container">
        <a href="AdminController?action=viewCustomers">View All Customers</a>
        <a href="AdminController?action=viewTransactions">View All Transactions</a>
        <a href="addCustomer.jsp">Add Customer</a>
        <a href="addBankAccount.jsp">Add Bank Account</a>
        <a href="index.jsp">Logout</a>
    </div>
</body>
</html>
