<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Application - Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5; /* Light nude background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: #fff; /* White background for the form */
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 350px;
        }
        h1 {
            margin-bottom: 1.5rem;
            font-size: 1.8rem;
            color: #4a3c31; /* Dark brown */
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 0.5rem;
            color: #6d4c41; /* Medium brown */
        }
        input[type="email"],
        input[type="password"],
        select {
            width: 100%;
            padding: 0.75rem;
            margin-bottom: 1rem;
            border: 1px solid #d4bfb6; /* Light nude border */
            border-radius: 6px;
            background-color: #faf9f6; /* Very light nude background */
            color: #4a3c31; /* Dark brown text */
        }
        input[type="email"]::placeholder,
        input[type="password"]::placeholder {
            color: #8c735b; /* Medium nude for placeholders */
        }
        input[type="submit"] {
            background-color: #6d4c41; /* Medium brown */
            color: white;
            border: none;
            padding: 0.75rem;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            font-size: 1rem;
        }
        input[type="submit"]:hover {
            background-color: #4a3c31; /* Darker brown for hover effect */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bank Application</h1>
        <form action="LoginController" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required placeholder="Enter your email">
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required placeholder="Enter your password">
            
            <label for="role">Role:</label>
            <select id="role" name="role">
                <option value="admin">Admin</option>
                <option value="customer">Customer</option>
            </select>
            
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>
