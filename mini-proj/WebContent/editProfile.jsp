<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
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
        max-width: 600px;
        margin: 50px auto;
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
    }
    .btn-primary {
        background-color: #0069d9;
        border-color: #0062cc;
        border-radius: 30px;
    }
</style>
<script>
    function validatePassword() {
        var password = document.getElementById('password').value;
        var errorMsg = '';

        var minLength = /.{8,}/;
        var uppercase = /[A-Z]/;
        var lowercase = /[a-z]/;
        var specialChar = /[!@#$%^&*(),.?":{}|<>]/;

        if (!minLength.test(password)) {
            errorMsg += 'Password must be at least 8 characters long.\n';
        }
        if (!uppercase.test(password)) {
            errorMsg += 'Password must contain at least one uppercase letter.\n';
        }
        if (!lowercase.test(password)) {
            errorMsg += 'Password must contain at least one lowercase letter.\n';
        }
        if (!specialChar.test(password)) {
            errorMsg += 'Password must contain at least one special character.\n';
        }

        if (errorMsg) {
            alert(errorMsg);
            return false; // Prevent form submission
        }
        return true; // Allow form submission
    }
</script>
</head>
<body>
    <div class="container">
        <h2>Edit Profile</h2>
        
        <!-- Form to search for a customer by ID -->
        <form action="EditProfileController" method="get">
            <div class="form-group">
                <label for="customerId">Customer ID</label>
                <input type="number" class="form-control" id="customerId" name="customerId" required>
            </div>
            <button type="submit" class="btn btn-primary">Load Customer</button>
        </form>
        <hr>
        
        <!-- Form to update customer details -->
        <form action="EditProfileController" method="post" onsubmit="return validatePassword()">
            <!-- Field for customer ID -->
            <div class="form-group">
                <label for="customerId">Customer ID</label>
                <input type="number" class="form-control" id="customerId" name="customerId" value="${customer.customerId}" readonly required>
            </div>
            
            <!-- Field for first name -->
            <div class="form-group">
                <label for="firstName">Customer First Name</label>
                <input type="text" class="form-control" id="firstName" name="customerFirstName" value="${customer.customerFirstName}" required>
            </div>
            
            <!-- Field for last name -->
            <div class="form-group">
                <label for="lastName">Customer Last Name</label>
                <input type="text" class="form-control" id="lastName" name="customerLastName" value="${customer.customerLastName}" required>
            </div>
            
            <!-- Field for password -->
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" value="${customer.password}" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Profile</button>
        </form>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-info">${successMessage}</div>
        </c:if>
    </div>
</body>
</html>
