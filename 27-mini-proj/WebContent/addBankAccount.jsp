<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Bank Account</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 20px;
        }
    </style>
    <script>
        function generateAccountNumber() {
            var accountNumber = Math.floor(1000000000 + Math.random() * 9000000000);
            document.getElementById('accountNumber').value = accountNumber;
        }
    </script>
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="adminHome.jsp">Admin Dashboard</a>
            <button class="btn btn-outline-secondary ml-auto" onclick="window.history.back();">Back</button>
        </nav>
        <h2 class="text-center mt-4">Add Bank Account</h2>
        <form action="addBankAccount" method="post">
            <div class="form-group">
                <label for="customerId">Customer ID</label>
                <select class="form-control" id="customerId" name="customerId" required>
                    <c:forEach var="customer" items="${customers}">
                        <option value="${customer.customerId}">${customer.firstName} ${customer.lastName} (${customer.customerId})</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="accountNumber">Account Number</label>
                <input type="text" class="form-control" id="accountNumber" name="accountNumber" readonly>
                <button type="button" class="btn btn-secondary mt-2" onclick="generateAccountNumber()">Generate Account Number</button>
            </div>
            <div class="form-group">
                <label for="balance">Initial Balance</label>
                <input type="number" class="form-control" id="balance" name="balance" min="5000" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Add Account</button>
        </form>
        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3">${error}</div>
        </c:if>
        <c:if test="${not empty message}">
            <div class="alert alert-success mt-3">${message}</div>
        </c:if>
    </div>
</body>
</html>
