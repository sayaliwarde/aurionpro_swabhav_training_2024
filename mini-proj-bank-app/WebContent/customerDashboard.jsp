<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Customer Dashboard</title>
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
    <a class="navbar-brand" href="#">Customer Dashboard</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="CustomerController?action=viewPassbook">View Passbook</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="CustomerController?action=newTransaction">New Transaction</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="CustomerController?action=editProfile">Edit Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container dashboard-container">
    <div class="row">
        <div class="col-md-12 text-center">
            <h3>Welcome, <%= session.getAttribute("customerName") %>!</h3>
            <div class="card-deck">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Passbook</h5>
                        <p class="card-text">Check your transaction history.</p>
                        <a href="CustomerController?action=viewPassbook" class="btn btn-primary">View Passbook</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">New Transaction</h5>
                        <p class="card-text">Make a new transaction.</p>
                        <a href="CustomerController?action=newTransaction" class="btn btn-success">New Transaction</a>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Edit Profile</h5>
                        <p class="card-text">Update your personal information.</p>
                        <a href="CustomerController?action=editProfile" class="btn btn-warning">Edit Profile</a>
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
