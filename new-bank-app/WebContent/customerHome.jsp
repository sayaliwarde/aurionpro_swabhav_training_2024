<!DOCTYPE html>
<html lang="en">
<%@ page import="com.aurionpro.model.User" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Bank Customer</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerServlet?action=viewPassbook">View Passbook</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerServlet?action=newTransaction">New Transaction</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerServlet?action=editProfile">Edit Profile</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Welcome, <%= ((User) session.getAttribute("user")).getFirstName() %>!</h5>
                <p class="card-text">Please choose an action from the navigation menu.</p>
                <% if (request.getAttribute("message") != null) { %>
                    <div class="alert alert-info mt-3">
                        <%= request.getAttribute("message") %>
                    </div>
                <% } %>
            </div>
        </div>
        <button onclick="window.history.back();" class="btn btn-secondary mt-3">Back</button>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
