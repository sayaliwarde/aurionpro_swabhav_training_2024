<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.aurionpro.entity.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home</title>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #f8f9fa;
        font-family: 'Roboto', sans-serif;
    }
    .container {
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        padding: 30px;
        margin-top: 50px;
    }
    .navbar-brand {
        font-weight: bold;
        color: #007bff;
    }
    .list-group-item-action {
        border-radius: 10px;
        transition: background-color 0.3s ease;
    }
    .list-group-item-action:hover {
        background-color: #007bff;
        color: white;
    }
    .btn-danger {
        background-color: #dc3545;
        border-color: #dc3545;
        border-radius: 30px;
    }
</style>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="customerHome.jsp">Banking System</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="customerHome.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="ViewTransactionsController">Passbook</a></li>
                <li class="nav-item"><a class="nav-link" href="NewTransactionController">New Transaction</a></li>
                <li class="nav-item"><a class="nav-link" href="EditProfileController">Edit Profile</a></li>
                <li class="nav-item"><a class="nav-link text-danger" href="LogoutController">Logout</a></li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link disabled">Welcome, <%= ((Customer) session.getAttribute("customer")).getCustomerFirstName() %></a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-5">
        <h2 class="text-center">Customer Home</h2>
        <div class="list-group">
            <a href="PassbookController" class="list-group-item list-group-item-action">Passbook</a>
            <a href="NewTransactionController" class="list-group-item list-group-item-action">New Transaction</a>
            <a href="EditProfileController" class="list-group-item list-group-item-action">Edit Profile</a>
        </div>
        <div class="mt-4 text-center">
            <a href="LogoutController" class="btn btn-danger">Logout</a>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
