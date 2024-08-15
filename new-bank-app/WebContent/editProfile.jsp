<!DOCTYPE html>
<html lang="en">
<%@ page import="com.aurionpro.model.User" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
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
        <h3>Edit Profile</h3>
        <form action="CustomerServlet?action=editProfile" method="post">
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="<%= ((User) session.getAttribute("user")).getFirstName() %>" required>
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="<%= ((User) session.getAttribute("user")).getLastName() %>" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= ((User) session.getAttribute("user")).getEmail() %>" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Update Profile</button>
            <% if (request.getAttribute("message") != null) { %>
                <div class="alert alert-info mt-3">
                    <%= request.getAttribute("message") %>
                </div>
            <% } %>
        </form>
        <button onclick="window.history.back();" class="btn btn-secondary mt-3">Back</button>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
