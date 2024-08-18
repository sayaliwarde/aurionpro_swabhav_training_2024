<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #e0e7ed;
        font-family: 'Poppins', sans-serif;
    }
    .container {
        background-color: #ffffff;
        border-radius: 12px;
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
        padding: 40px;
        margin-top: 50px;
    }
    h2 {
        color: #3e4a61;
        margin-bottom: 30px;
    }
    .list-group-item-action {
        border-radius: 10px;
        transition: background-color 0.3s ease;
        font-weight: 600;
    }
    .list-group-item-action:hover {
        background-color: #17a2b8;
        color: white;
    }
    .btn-danger {
        background-color: #dc3545;
        border-color: #dc3545;
        border-radius: 25px;
        font-weight: 600;
    }
</style>
</head>
<body>
    <div class="container text-center">
        <h2>Welcome Admin</h2>
        <p>Manage the bank system here.</p>
        <div class="list-group">
            <a href="AddBankAccountController" class="list-group-item list-group-item-action">Add Bank Account</a>
            <a href="AddCustomerController" class="list-group-item list-group-item-action">Add Customer</a>
            <a href="ViewCustomersController" class="list-group-item list-group-item-action">View Customers</a>
            <a href="ViewTransactionsController" class="list-group-item list-group-item-action">View Transactions</a>
        </div>
        <div class="mt-4">
            <a href="LogoutController" class="btn btn-danger">Logout</a>
        </div>
    </div>
</body>
</html>
