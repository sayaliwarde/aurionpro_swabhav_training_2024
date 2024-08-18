<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passbook</title>
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
</style>
</head>
<body>
    <div class="container">
        <h2>Passbook</h2>
        <form action="PassbookController" method="get" class="mb-4">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="receiverAccountNumber">Receiver Account:</label>
                    <input type="text" class="form-control" id="receiverAccountNumber" name="receiverAccountNumber">
                </div>
                <div class="form-group col-md-4">
                    <label for="startDate">Start Date:</label>
                    <input type="date" class="form-control" id="startDate" name="startDate">
                </div>
                <div class="form-group col-md-4">
                    <label for="endDate">End Date:</label>
                    <input type="date" class="form-control" id="endDate" name="endDate">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
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
                <c:forEach var="entry" items="${passbookEntries}">
                    <tr>
                        <td>${entry.id}</td>
                        <td>${entry.senderAccno}</td>
                        <td>${entry.receiverAccno}</td>
                        <td>${entry.transactionType}</td>
                        <td>${entry.amount}</td>
                        <td>${entry.transactionDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
