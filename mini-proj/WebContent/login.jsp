<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #e6f2ff;
        font-family: 'Roboto', sans-serif;
    }
    .login-container {
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        padding: 30px;
        max-width: 500px;
        margin: 50px auto;
    }
    .card-header {
        background-color: #0069d9;
        color: white;
    }
    .btn-primary, .btn-secondary {
        border-radius: 30px;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card login-container">
                    <div class="card-header text-center">
                        <h3>Login</h3>
                    </div>
                    <div class="card-body">
                        <form action="LoginController" method="post">
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" id="username" name="username" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <div class="form-group">
                                <label for="role">Login As</label>
                                <select class="form-control" id="role" name="role" required>
                                    <option value="" disabled selected>Select role</option>
                                    <option value="admin">Admin</option>
                                    <option value="customer">Customer</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Submit</button>
                            <button type="reset" class="btn btn-secondary btn-block">Reset</button>
                        </form>
                        <% 
                            String error = request.getParameter("error");
                            if (error != null) { 
                        %>
                            <div class="alert alert-danger mt-3" role="alert">
                                <%= error %>
                            </div>
                        <% 
                            } 
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
