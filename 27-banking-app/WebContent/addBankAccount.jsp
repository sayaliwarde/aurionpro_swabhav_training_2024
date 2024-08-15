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

    List<Customer> pendingCustomers = CustomerDAO.getPendingCustomers();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Account</title>
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
    <div class="form-container">
        <h2>Add Bank Account</h2>
        <form action="addAccountServlet" method="post">
            <label for="customerId">Customer ID:</label>
            <select id="customerId" name="customerId" required>
                <option value="">Select Customer</option>
                <% for (Customer customer : pendingCustomers) { %>
                    <option value="<%= customer.getCustomerId() %>"><%= customer.getCustomerId() %> - <%= customer.getFirstName() %> <%= customer.getLastName() %></option>
                <% } %>
            </select>
            <label for="accountNumber">Account Number:</label>
            <input type="text" id="accountNumber" name="accountNumber" readonly>
            <button type="button" onclick="generateAccountNumber()">Generate Account Number</button>
            <label for="balance">Initial Balance:</label>
            <input type="number" id="balance" name="balance" min="5000" required>
            <button type="submit">Add Account</button>
        </form>
    </div>
    <script>
        function generateAccountNumber() {
            const accountNumber = Math.floor(1000000000 + Math.random() * 9000000000);
            document.getElementById('accountNumber').value = accountNumber;
        }
    </script>
</body>
</html>
