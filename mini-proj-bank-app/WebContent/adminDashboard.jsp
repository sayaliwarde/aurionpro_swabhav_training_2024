<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .dashboard-container {
            margin-top: 50px;
        }
        .dashboard-container .card {
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }
        .dashboard-container h3 {
            margin-bottom: 30px;
        }
        .dashboard-container .btn {
            border-radius: 25px;
        }
        .navbar-nav .nav-item .nav-link {
            color: white;
        }
        .navbar-nav .nav-item .nav-link:hover {
            color: #ddd;
        }
        .btn-back {
            background-color: #007bff;
            color: white;
            border-radius: 25px;
        }
        .btn-back:hover {
            background-color: #0056b3;
            color: white;
        }
        .btn-logout {
            background-color: #dc3545;
            color: white;
            border-radius: 25px;
        }
        .btn-logout:hover {
            background-color: #c82333;
            color: white;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="adminDashboard.jsp">Admin Dashboard</a>
    <button class="btn btn-back ml-auto" onclick="window.history.back();">Back</button>
    <a href="logout" class="btn btn-logout ml-2">Logout</a>
</nav>

<div class="container dashboard-container">
    <div class="row">
        <div class="col-md-12 text-center">
            <h3>Welcome, Admin!</h3>
            <div class="card-deck">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Customers</h5>
                        <p class="card-text">View customer details.</p>
                        <a href="admin?action=viewCustomers" class="btn btn-primary">View Customers</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Add New Customer</h5>
                        <p class="card-text">Add new customers to the bank.</p>
                        <a href="addCustomer.jsp" class="btn btn-success">Add Customer</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Add New Account</h5>
                        <p class="card-text">Open new accounts for customers.</p>
                        <a href="admin?action=prepareAddAccount" class="btn btn-warning">Add Account</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Transactions</h5>
                        <p class="card-text">View transactions.</p>
                        <a href="admin?action=viewTransactions" class="btn btn-danger">View Transactions</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
