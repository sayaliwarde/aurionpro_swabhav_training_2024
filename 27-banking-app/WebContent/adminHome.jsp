<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.bank.model.Admin" %>
<%
    HttpSession session = request.getSession(false);
    Admin admin = (Admin) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <nav>
        <ul>
            <li><a href="adminDashboard.jsp">Home</a></li>
            <li><a href="customerList.jsp">Customers</a></li>
            <li><a href="transactionList.jsp">Transactions</a></li>
            <li><a href="adminLogoutServlet">Logout</a></li>
        </ul>
    </nav>
    <div class="dashboard-content">
        <h1>Welcome, Admin</h1>
    </div>
</body>
</html>
