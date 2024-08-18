<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Bank Account</title>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #f0f4f8;
        font-family: 'Poppins', sans-serif;
    }
    .container {
        background-color: #ffffff;
        border-radius: 12px;
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
        padding: 40px;
        max-width: 700px;
        margin: 50px auto;
    }
    h2 {
        color: #3e4a61;
        margin-bottom: 30px;
    }
    .btn-primary, .btn-success {
        background-color: #28a745;
        border-color: #28a745;
        border-radius: 25px;
        font-weight: 600;
    }
    .btn-secondary {
        background-color: #6c757d;
        border-color: #6c757d;
        border-radius: 25px;
        font-weight: 600;
    }
</style>
<script>
    function validateDeposit() {
        var balance = parseFloat(document.getElementById('balance').value);
        if (isNaN(balance) || balance < 5000) {
            alert('Initial deposit must be a number and cannot be less than 5000.');
            return false;
        }
        return true;
    }
</script>
</head>
<body>
    <div class="container">
        <h2>Add Bank Account</h2>
        <form action="AddBankAccountController" method="get">
            <div class="form-group">
                <label for="customerId">Customer ID:</label>
                <input type="text" class="form-control" id="customerId" name="customerId" required>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
            <a href="adminHome.jsp" class="btn btn-secondary">Cancel</a>
        </form>

        <c:if test="${not empty customer}">
            <div class="mt-5">
                <h3>Customer Details</h3>
                <p><strong>First Name:</strong> ${customer.customerFirstName}</p>
                <p><strong>Last Name:</strong> ${customer.customerLastName}</p>
                <p><strong>Email:</strong> ${customer.emailId}</p>

                <form action="AddBankAccountController" method="post" onsubmit="return validateDeposit();">
                    <input type="hidden" name="customerId" value="${customer.customerId}">
                    <div class="form-group">
                        <label for="accountType">Account Type:</label>
                        <input type="text" class="form-control" id="accountType" name="accountType" required>
                    </div>
                    <div class="form-group">
                        <label for="balance">Initial Deposit:</label>
                        <input type="number" class="form-control" id="balance" name="balance" step="0.01" min="5000" required>
                    </div>
                    <button type="submit" class="btn btn-success">Generate Account Number</button>
                </form>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <p class="text-danger">${error}</p>
        </c:if>
    </div>
</body>
</html>
