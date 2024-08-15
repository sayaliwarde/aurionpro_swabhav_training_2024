<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Bank Account</title>
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
            background-color: #fff; /* White background for the form */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #4a3c31; /* Dark brown for headings */
            text-align: center;
            margin-bottom: 1rem;
        }
        label {
            display: block;
            margin-bottom: 0.5rem;
            color: #6d4c41; /* Medium brown */
        }
        input[type="text"] {
            width: 100%;
            padding: 0.75rem;
            margin-bottom: 1rem;
            border: 1px solid #d4bfb6; /* Light nude border */
            border-radius: 6px;
            background-color: #faf9f6; /* Very light nude background */
            color: #4a3c31; /* Dark brown text */
        }
        input[type="submit"] {
            background-color: #6d4c41; /* Medium brown */
            color: white;
            border: none;
            padding: 0.75rem;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            font-size: 1rem;
        }
        input[type="submit"]:hover {
            background-color: #4a3c31; /* Darker brown for hover effect */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add Bank Account</h1>
        <form action="AdminController?action=addBankAccount" method="post">
            <label for="customerId">Customer ID:</label>
            <input type="text" id="customerId" name="customerId" required>
            
            <label for="accountNumber">Account Number:</label>
            <input type="text" id="accountNumber" name="accountNumber" required>
            
            <label for="balance">Balance:</label>
            <input type="text" id="balance" name="balance" required>
            
            <input type="submit" value="Add Bank Account">
        </form>
    </div>
</body>
</html>
