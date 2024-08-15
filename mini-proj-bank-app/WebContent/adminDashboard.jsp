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
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Banking Admin</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="admin?action=viewCustomers">View Customers</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="admin?action=addCustomer">Add New Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="admin?action=addAccount">Add New Account</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="admin?action=viewTransactions">View Transactions</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container dashboard-container">
    <div class="row">
        <div class="col-md-12 text-center">
            <h3>Welcome, Admin!</h3>
            <div class="card-deck">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Customers</h5>
                        <p class="card-text">Manage and view customer details.</p>
                        <a href="AdminController?action=viewCustomers" class="btn btn-primary">View Customers</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Add New Customer</h5>
                        <p class="card-text">Add new customers to the bank.</p>
                        <a href="AdminController?action=addCustomer" class="btn btn-success">Add Customer</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Add New Account</h5>
                        <p class="card-text">Open new accounts for customers.</p>
                        <a href="AdminController?action=addAccount" class="btn btn-warning">Add Account</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Transactions</h5>
                        <p class="card-text">View and manage transactions.</p>
                        <a href="AdminController?action=viewTransactions" class="btn btn-danger">View Transactions</a>
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
