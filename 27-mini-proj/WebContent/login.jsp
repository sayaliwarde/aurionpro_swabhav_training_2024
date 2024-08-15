<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .login-container {
            max-width: 400px;
            margin: 100px auto;
            padding: 20px;
            border-radius: 8px;
            background: #ffffff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2 class="text-center">Login</h2>
        <form action="adminLogin" method="post">
            <div class="form-group">
                <label for="Username">Username</label>
                <input type="text" class="form-control" id="Username" name="username" required>
            </div>
            <div class="form-group">
                <label for="Password">Password</label>
                <input type="password" class="form-control" id="Password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Login as Admin</button>
        </form>
        <hr>
        <form action="customerLogin" method="post">
            <div class="form-group">
                <label for="customerEmail">Email</label>
                <input type="email" class="form-control" id="customerEmail" name="email" required>
            </div>
            <div class="form-group">
                <label for="customerPassword">Password</label>
                <input type="password" class="form-control" id="customerPassword" name="password" required>
            </div>
            <button type="submit" class="btn btn-success btn-block">Login as Customer</button>
        </form>
        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-3">${error}</div>
        </c:if>
    </div>
</body>
</html>
