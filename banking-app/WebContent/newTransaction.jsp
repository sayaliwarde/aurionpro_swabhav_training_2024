<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Transaction</title>
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
            margin-bottom: 1.5rem;
        }
        label {
            display: block;
            margin-bottom: 0.5rem;
            color: #6d4c41; /* Medium brown for labels */
        }
        input[type="text"],
        select {
            width: 100%;
            padding: 0.75rem;
            margin-bottom: 1rem;
            border: 1px solid #d4bfb6; /* Light nude border */
            border-radius: 6px;
            background-color: #faf9f6; /* Very light nude background */
            color: #4a3c31; /* Dark brown text */
        }
        input[type="submit"] {
            background-color: #6d4c41; /* Medium brown for submit button */
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
        <h1>Create New Transaction</h1>
        <form action="CustomerController?action=createTransaction" method="post">
            <label for="senderAccount">Sender Account:</label>
            <input type="text" id="senderAccount" name="senderAccount" required>
            
            <label for="receiverAccount">Receiver Account:</label>
            <input type="text" id="receiverAccount" name="receiverAccount" required>
            
            <label for="amount">Amount:</label>
            <input type="text" id="amount" name="amount" required>
            
            <label for="type">Type:</label>
            <select id="type" name="type">
                <option value="debit">Debit</option>
                <option value="credit">Credit</option>
            </select>
            
            <input type="submit" value="Make Transaction">
        </form>
    </div>
</body>
</html>
