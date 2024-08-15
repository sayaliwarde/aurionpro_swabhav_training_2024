<%@ page import="java.util.List" %>
<%@ page import="com.bank.model.Customer" %>
<%@ page import="com.bank.dao.CustomerDAO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.bank.model.Admin" %>
<%
    HttpSession session = request.getSession(false);
    Admin admin = (Admin) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    List<Customer> customers = CustomerDAO.getAllCustomers();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer List</title>
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
    <div class="list-container">
        <h2>Customer List</h2>
        <table>
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Account Number</th>
                </tr>
            </thead>
            <tbody>
                <% for (Customer customer : customers) { %>
                    <tr>
                        <td><%= customer.getCustomerId() %></td>
                        <td><%= customer.getFirstName() %></td>
                        <td><%= customer.getLastName() %></td>
                        <td><%= customer.getEmail() %></td>
                        <td><%= customer.getAccountNumber() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
