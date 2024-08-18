<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="com.aurionpro.dao.*" %>
<%@ page import="com.aurionpro.model.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>View Transactions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .table-container {
            margin-top: 50px;
        }
        .table-container .table {
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }
        .table-container h3 {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="adminDashboard.jsp">Admin Dashboard</a>
     <button class="btn btn-outline-secondary ml-auto" onclick="window.history.back();">Back</button>
</nav>

<div class="container table-container">
    <h3 class="text-center">Transaction List</h3>
    <div class="row mb-3">
        <div class="col-md-4">
            <label for="startDate">Start Date:</label>
            <input type="date" class="form-control" id="startDate" name="startDate">
        </div>
        <div class="col-md-4">
            <label for="endDate">End Date:</label>
            <input type="date" class="form-control" id="endDate" name="endDate">
        </div>
        <div class="col-md-4">
            <label for="transactionType">Transaction Type:</label>
            <select class="form-control" id="transactionType" name="transactionType">
                <option value="all">All</option>
                <option value="credit">Credit</option>
                <option value="debit">Debit</option>
                <option value="transfer">Bank Transfer</option>
            </select>
        </div>
    </div>
    <button class="btn btn-primary mb-3" onclick="filterTransactions()">Filter</button>
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
            <tr>
                <th>Transaction ID</th>
                <th>Sender Account Number</th>
                <th>Receiver Account Number</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody id="transactionTableBody">
            <%-- Iterate through the list of transactions and display their details --%>
            <% List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions"); %>
            <% for (Transaction transaction : transactions) { %>
                <tr>
                    <td><%= transaction.getTransactionId() %></td>
                    <td><%= transaction.getSenderAccountNumber() %></td>
                    <td><%= transaction.getReceiverAccountNumber() %></td>
                    <td><%= transaction.getType() %></td>
                    <td><%= transaction.getAmount() %></td>
                    <td><%= transaction.getTransactionDate() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</div>

<script>
    function filterTransactions() {
        var startDate = document.getElementById('startDate').value;
        var endDate = document.getElementById('endDate').value;
        var transactionType = document.getElementById('transactionType').value;
        // Fetch filtered transaction list from backend and refresh the table
        // Implementation of Ajax to fetch filtered transactions goes here
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
