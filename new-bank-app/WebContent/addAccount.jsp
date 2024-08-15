<!DOCTYPE html>
<html lang="en">
<%@ page import="com.aurionpro.model.User" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Bank Account</title>
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
        <h3>Add New Bank Account</h3>

        <form action="AdminServlet?action=addAccount" method="post">
            <% 
                User customer = (User) request.getAttribute("customer");
                if (customer != null) {
            %>
            <div class="mb-3">
                <label for="customerId" class="form-label">Customer ID</label>
                <input type="text" class="form-control" id="customerId" name="customerId" value="<%= customer.getId() %>" readonly>
            </div>
            <div class="mb-3">
                <label for="customerName" class="form-label">Customer Name</label>
                <input type="text" class="form-control" id="customerName" name="customerName" value="<%= customer.getFirstName() %> <%= customer.getLastName() %>" readonly>
            </div>
            <div class="mb-3">
                <label for="accountNumber" class="form-label">Account Number</label>
<input type="text" class="form-control" id="accountNumber" name="accountNumber" value="<%= String.format("%010d", Math.abs(new java.util.Random().nextLong() % 10000000000L)) %>" readonly>

            </div>
            <div class="mb-3">
                <label for="initialDeposit" class="form-label">Initial Deposit</label>
                <input type="number" class="form-control" id="initialDeposit" name="initialDeposit" min="5000" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Account</button>
            <% } else { %>
                <div class="alert alert-danger">Customer information is not available. Please go back and try again.</div>
            <% } %>
            <% if (request.getAttribute("message") != null) { %>
                <div class="alert alert-info mt-3">
                    <%= request.getAttribute("message") %>
                </div>
            <% } %>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
