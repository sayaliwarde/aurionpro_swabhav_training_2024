<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "java.util.List" %>
<%@ page import="com.aurionpro.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add New Account</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container h3 {
            margin-bottom: 20px;
        }
        .form-container .btn {
            border-radius: 25px;
        }
        .form-container .alert {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="adminDashboard.jsp">Admin Dashboard</a>
    <button class="btn btn-outline-secondary ml-auto" onclick="window.history.back();">Back</button>
</nav>

<div class="container form-container">
    <h3 class="text-center">Add New Account</h3>
    <form action="admin" method="post">
        <input type="hidden" name="action" value="addAccount">
        <div class="form-group">
            <label for="customerId">Customer ID:</label>
            <select class="form-control" id="customerId" name="customerId" required>
                <%
                    @SuppressWarnings("unchecked")
                    List<Customer> newCustomers = (List<Customer>) request.getAttribute("newCustomers");
                %>
                <% if (newCustomers != null && !newCustomers.isEmpty()) { %>
                    <% for (Customer customer : newCustomers) { %>
                        <option value="<%= customer.getCustomerId() %>"><%= customer.getFirstName() %> <%= customer.getLastName() %> (ID: <%= customer.getCustomerId() %>)</option>
                    <% } %>
                <% } else { %>
                    <option value="">No new customers available</option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="balance">Initial Balance:</label>
            <input type="number" class="form-control" id="balance" name="balance" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Add Account</button>
        <% if (request.getAttribute("message") != null) { %>
            <div class="alert alert-info text-center mt-3">
                <%= request.getAttribute("message") %>
            </div>
        <% } %>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
