<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Transactions</title>
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
        max-width: 800px;
        margin: 50px auto;
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
    }
    .table {
        margin-top: 20px;
    }
    .btn-primary {
        margin-top: 20px;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>View Transactions</h2>
        <form action="ViewTransactionsController" method="get" class="mb-4">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="transactionType">Transaction Type:</label>
                    <input type="text" class="form-control" id="transactionType" name="transactionType">
                </div>
                <div class="form-group col-md-4">
                    <label for="startDate">Start Date:</label>
                    <input type="date" class="form-control" id="startDate" name="startDate">
                </div>
                <div class="form-group col-md-4">
                    <label for="endDate">End Date:</label>
                    <input type="date" class="form-control" id="endDate" name="endDate">
                </div>
                <div class="form-group col-md-4">
                    <label for="sortOrder">Sort By:</label>
                    <select class="form-control" id="sortOrder" name="sortOrder">
                        <option value="">None</option>
                        <option value="sender_accno ASC">Sender Account (Asc)</option>
                        <option value="sender_accno DESC">Sender Account (Desc)</option>
                        <option value="receiver_accno ASC">Receiver Account (Asc)</option>
                        <option value="receiver_accno DESC">Receiver Account (Desc)</option>
                        <option value="transaction_date ASC">Date (Asc)</option>
                        <option value="transaction_date DESC">Date (Desc)</option>
                    </select>
                </div>
                <div class="form-group col-md-12 text-right">
                    <button type="submit" class="btn btn-primary mt-4">Search</button>
                </div>
            </div>
        </form>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Sender Account</th>
                    <th>Receiver Account</th>
                    <th>Transaction Type</th>
                    <th>Amount</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaction" items="${transactions}">
                    <tr>
                        <td>${transaction.id}</td>
                        <td>${transaction.senderAccno}</td>
                        <td>${transaction.receiverAccno}</td>
                        <td>${transaction.transactionType}</td>
                        <td>${transaction.amount}</td>
                        <td>${transaction.transactionDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="adminHome.jsp" class="btn btn-primary">Back to Admin Home</a>
    </div>
</body>
</html>
