<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Passbook</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5; /* Light nude background */
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            max-width: 900px;
            margin: 50px auto;
            background-color: #fff; /* White background for content */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #4a3c31; /* Dark brown for headings */
            text-align: center;
            margin-bottom: 1.5rem;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #d4bfb6; /* Light nude border */
        }
        th {
            background-color: #6d4c41; /* Medium brown for headers */
            color: white;
        }
        tr:nth-child(even) {
            background-color: #faf9f6; /* Very light nude for alternating rows */
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #6d4c41; /* Medium brown */
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
    <div class="container">
        <h1>Your Transactions</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Sender</th>
                <th>Receiver</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Type</th>
            </tr>
            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td>${transaction.transactionId}</td>
                    <td>${transaction.senderAccount}</td>
                    <td>${transaction.receiverAccount}</td>
                    <td>${transaction.amount}</td>
                    <td>${transaction.date}</td>
                    <td>${transaction.type}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="customerHome.jsp">Back</a>
    </div>
</body>
</html>
