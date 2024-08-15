<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>New Transaction</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-5">New Transaction</h2>
        <form action="CustomerServlet" method="post">
            <input type="hidden" name="action" value="newTransaction">
            <div class="form-group">
                <label for="transactionType">Transaction Type:</label>
                <select class="form-control" id="transactionType" name="transactionType">
                    <option value="credit">Credit</option>
                    <option value="debit">Debit</option>
                    <option value="transfer">Transfer</option>
                </select>
            </div>
            <div class="form-group">
                <label for="amount">Amount:</label>
                <input type="number" class="form-control" id="amount" name="amount" required>
            </div>
            <div class="form-group">
                <label for="receiverAccountNumber">Receiver Account Number:</label>
                <input type="text" class="form-control" id="receiverAccountNumber" name="receiverAccountNumber">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <c:if test="${not empty message}">
            <div class="alert alert-info mt-3">${message}</div>
        </c:if>
    </div>
</body>
</html>
