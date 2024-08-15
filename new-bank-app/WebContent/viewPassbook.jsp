<!DOCTYPE html>
<html lang="en">
<%@ page import="java.util.List" %>
<%@ page import="com.aurionpro.model.Transaction" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Passbook</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .debit {
            background-color: #f8d7da;
        }
        .credit {
            background-color: #d4edda;
        }
    </style>
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
        <h3>Your Transactions</h3>
        <table class="table table-bordered table-hover mt-3">
            <thead class="table-dark">
                <tr>
                    <th>Sender Account</th>
                    <th>Receiver Account</th>
                    <th>Type</th>
                    <th>Amount</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <% List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions"); %>
                <% for (Transaction transaction : transactions) { %>
                <tr class="<%= transaction.getType().equals("debit") ? "debit" : "credit" %>">
                    <td><%= transaction.getSenderAccount() %></td>
                    <td><%= transaction.getReceiverAccount() %></td>
                    <td><%= transaction.getType() %></td>
                    <td><%= transaction.getAmount() %></td>
                    <td><%= transaction.getTransactionDate() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <button onclick="window.history.back();" class="btn btn-secondary mt-3">Back</button>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
