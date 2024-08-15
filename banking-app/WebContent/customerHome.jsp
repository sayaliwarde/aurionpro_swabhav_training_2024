<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5; /* Light nude background */
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff; /* White background for content */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #4a3c31; /* Dark brown for headings */
            margin-bottom: 1.5rem;
        }
        a {
            display: block;
            padding: 15px;
            margin: 10px 0;
            background-color: #d4bfb6; /* Light nude background for links */
            color: #4a3c31; /* Dark brown text */
            text-decoration: none;
            border-radius: 6px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            font-size: 1rem;
        }
        a:hover {
            background-color: #b37a70; /* Slightly darker nude for hover effect */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome Customer</h1>
        <a href="CustomerController?action=viewPassbook&customerId=${customer.customerId}">View Passbook</a>
        <a href="newTransaction.jsp">Make Transaction</a>
        <a href="editProfile.jsp">Edit Profile</a>
        <a href="index.jsp">Logout</a>
    </div>
</body>
</html>
