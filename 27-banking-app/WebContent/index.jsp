<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Login</title>
    <link rel="stylesheet" href="styles.css"> <!-- Assuming you have a separate CSS file -->
</head>
<body>
    <div class="login-container">
        <h2>Bank Login</h2>
        <div class="login-forms">
            <!-- Admin Login -->
            <div class="login-form">
                <h3>Admin Login</h3>
                <form action="adminLoginServlet" method="post">
                    <label for="adminEmail">Email:</label>
                    <input type="email" id="adminEmail" name="email" required>
                    <label for="adminPassword">Password:</label>
                    <input type="password" id="adminPassword" name="password" required>
                    <button type="submit">Login</button>
                </form>
            </div>
            <!-- Customer Login -->
            <div class="login-form">
                <h3>Customer Login</h3>
                <form action="customerLoginServlet" method="post">
                    <label for="customerEmail">Email:</label>
                    <input type="email" id="customerEmail" name="email" required>
                    <label for="customerPassword">Password:</label>
                    <input type="password" id="customerPassword" name="password" required>
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
