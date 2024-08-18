<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="com.aurionpro.dao.*" %>
<%@ page import="com.aurionpro.model.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>View Customers</title>
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
    <h3 class="text-center">Customer List</h3>
    <div class="row mb-3">
        <div class="col-md-4">
            <label for="sortBy">Sort By:</label>
            <select class="form-control" id="sortBy" name="sortBy" onchange="sortCustomers()">
                <option value="nameAsc">Name (Ascending)</option>
                <option value="nameDesc">Name (Descending)</option>
                <option value="balanceAsc">Balance (Ascending)</option>
                <option value="balanceDesc">Balance (Descending)</option>
            </select>
        </div>
    </div>
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
            <tr>
                <th>Customer ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Account Number</th>
                <th>Balance</th>
            </tr>
        </thead>
        <tbody id="customerTableBody">
            <%-- Iterate through the list of customers and display their details --%>
            <% List<Customer> customers = (List<Customer>) request.getAttribute("customers"); %>
            <% AccountDAO accountDAO = new AccountDAO(); %>
            <% for (Customer customer : customers) { %>
                <tr>
                    <td><%= customer.getCustomerId() %></td>
                    <td><%= customer.getFirstName() %></td>
                    <td><%= customer.getLastName() %></td>
                    <td><%= customer.getEmail() %></td>
                    <%
                        List<Account> accounts = accountDAO.getAccountsByCustomerId((customer.getCustomerId()));
                        for (Account account : accounts) {
                    %>
                    <td><%= account.getAccountNumber() %></td>
                    <td><%= account.getBalance() %></td>
                    <% } %>
                </tr>
            <% } %>
        </tbody>
    </table>
</div>

<script>
    function sortCustomers() {
        var sortBy = document.getElementById('sortBy').value;
        // Fetch sorted customer list from backend and refresh the table
        // Implementation of Ajax to fetch sorted customers goes here
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
