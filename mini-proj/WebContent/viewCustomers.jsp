<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customers</title>
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
        <h2>View Customers</h2>
        <form action="ViewCustomersController" method="get" class="mb-4">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="customerId">Customer ID:</label>
                    <input type="text" class="form-control" id="customerId" name="customerId">
                </div>
                <div class="form-group col-md-4">
                    <label for="firstName">First Name:</label>
                    <input type="text" class="form-control" id="firstName" name="firstName">
                </div>
                <div class="form-group col-md-4">
                    <button type="submit" class="btn btn-primary mt-4">Search</button>
                </div>
            </div>
        </form>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email ID</th>
                    <th>Balance</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.customerId}</td>
                        <td>${customer.customerFirstName}</td>
                        <td>${customer.customerLastName}</td>
                        <td>${customer.emailId}</td>
                        <td>${customer.balance}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="adminHome.jsp" class="btn btn-primary">Back to Admin Home</a>
    </div>
</body>
</html>
