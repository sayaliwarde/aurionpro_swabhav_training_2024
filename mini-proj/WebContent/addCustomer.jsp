<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
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
        margin-top: 50px;
        max-width: 600px;
        padding: 40px;
        background-color: white;
        border-radius: 12px;
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
    }
    h2 {
        color: #3e4a61;
        margin-bottom: 30px;
    }
    .btn-primary {
        background-color: #28a745;
        border-color: #28a745;
        border-radius: 25px;
        font-weight: 600;
    }
</style>
<script>
    function validateForm() {
        var firstName = document.getElementById('firstName').value;
        var lastName = document.getElementById('lastName').value;
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;
        var balance = parseFloat(document.getElementById('balance').value);

        // Validate first name and last name
        var nameRegex = /^[A-Za-z]+$/;
        if (!nameRegex.test(firstName) || !nameRegex.test(lastName)) {
            alert('First name and last name must contain only letters.');
            return false;
        }

        // Validate email
        var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailRegex.test(email)) {
            alert('Email must be in a valid format.');
            return false;
        }

        // Validate password
        var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        if (!passwordRegex.test(password)) {
            alert('Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.');
            return false;
        }

        // Validate balance
        if (isNaN(balance) || balance < 5000) {
            alert('Balance must be a number and cannot be less than 5000.');
            return false;
        }

        return true;
    }
</script>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Add New Customer</h2>
        <form action="AddCustomerController" method="post" onsubmit="return validateForm();">
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" class="form-control" name="firstName" id="firstName" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" class="form-control" name="lastName" id="lastName" required>
            </div>
            <div class="form-group">
                <label for="email">Email ID:</label>
                <input type="email" class="form-control" name="email" id="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" name="password" id="password" required>
            </div>
            <div class="form-group">
                <label for="balance">Balance:</label>
                <input type="number" class="form-control" name="balance" id="balance" step="0.01" min="5000" value="5000" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Add Customer</button>
        </form>
    </div>
</body>
</html>
