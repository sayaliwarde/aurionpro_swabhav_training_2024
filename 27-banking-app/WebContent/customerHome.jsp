<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.bank.model.Customer" %>
<%
    HttpSession session = request.getSession(false);
    Customer customer = (Customer) session.getAttribute("customer");
    if (customer == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <nav>
        <ul>
            <li><a href="customerDashboard.jsp">Home</a></li>
            <li><a href="viewPassbook.jsp">View Passbook</a></li>
            <li><a href="makeTransaction.jsp">Make a Transaction</a></li>
            <li><a href="editProfile.jsp">Edit Profile</a></li>
            <li><a href="customerLogoutServlet">Logout</a></li>
        </ul>
    </nav>
    <div class="dashboard-content">
        <h1>Welcome, <%= customer.getFirstName() %></h1>
    </div>
</body>
</html>
