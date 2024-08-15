<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>Add Account</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-5">Add New Account</h2>
        <form action="AdminServlet" method="get">
            <input type="hidden" name="action" value="addAccount">
            <div class="form-group">
                <label for="customerId">Customer ID:</label>
                <input type="number" class="form-control" id="customerId" name="customerId" required>
            </div>
            <div class="form-group">
                <label for="initialBalance">Initial Balance:</label>
                <input type="number" class="form-control" id="initialBalance" name="initialBalance" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Account</button>
        </form>
        <c:if test="${not empty message}">
            <div class="alert alert-info mt-3">${message}</div>
        </c:if>
    </div>
</body>
</html>
