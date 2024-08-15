<!DOCTYPE html>
<html lang="en">
<head>
<%@ page import="java.util.List" %>
<%@ page import="com.aurionpro.model.User" %>
<%@ page import="com.aurionpro.model.Account" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Customers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Bank Admin</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="AdminServlet?action=viewCustomers">View Customers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="adminHome.jsp">Add Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminServlet?action=addAccount">Add Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminServlet?action=viewTransactions">View Transactions</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <h3>Customer List</h3>
        <table class="table table-bordered table-hover mt-3">
            <thead class="table-dark">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Account Number</th>
                    <th>Balance</th>
                </tr>
            </thead>
            <tbody>

    <% 
        List<User> customers = (List<User>) request.getAttribute("customers");
        for (User customer : customers) {
            Account account = (Account) request.getAttribute("account" + customer.getId());
    %>
    <tr>
        <td><%= customer.getFirstName() %></td>
        <td><%= customer.getLastName() %></td>
        <td><%= account != null ? account.getAccountNumber() : "N/A" %></td>
        <td><%= account != null ? account.getBalance() : "N/A" %></td>
    </tr>
    <% } %>
</tbody>
            
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
