<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>New Transaction</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container h3 {
            margin-bottom: 20px;
        }
        .form-container .btn {
            border-radius: 25px;
        }
        .form-container .alert {
            margin-top: 20px;
        }
    </style>
    <script>
        function toggleReceiverAccountField() {
            const transactionType = document.getElementById('type').value;
            const receiverAccountField = document.getElementById('receiverAccountField');

            if (transactionType === 'transfer') {
                receiverAccountField.style.display = 'block';
            } else {
                receiverAccountField.style.display = 'none';
                document.getElementById('receiverAccountNumber').value = ''; // Clear the input field when hidden
            }
        }
    </script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="customerDashboard.jsp">Customer Dashboard</a>
    <button class="btn btn-outline-secondary ml-auto" onclick="window.history.back();">Back</button>
</nav>

<div class="container form-container">
    <h3 class="text-center">New Transaction</h3>
    <form action="customer" method="post">
        <input type="hidden" name="action" value="newTransaction">
        <div class="form-group">
            <label for="type">Transaction Type:</label>
            <select class="form-control" id="type" name="type" required onchange="toggleReceiverAccountField()">
                <option value="credit">Credit</option>
                <option value="debit">Debit</option>
                <option value="transfer">Bank Transfer</option>
            </select>
        </div>
        <div class="form-group">
            <label for="amount">Amount:</label>
            <input type="number" class="form-control" id="amount" name="amount" required>
        </div>
        <div class="form-group" id="receiverAccountField" style="display: none;">
            <label for="receiverAccountNumber">Receiver Account Number (for Transfer):</label>
            <input type="text" class="form-control" id="receiverAccountNumber" name="receiverAccountNumber">
        </div>
        <button type="submit" class="btn btn-primary btn-block">Submit</button>
        <% if (request.getAttribute("message") != null) { %>
            <div class="alert alert-info text-center mt-3">
                <%= request.getAttribute("message") %>
            </div>
        <% } %>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
