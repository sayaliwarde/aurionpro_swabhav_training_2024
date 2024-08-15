<%@ page import="java.util.List" %>
<%@ page import="com.bank.model.Transaction" %>
<%@ page import="com.bank.dao.TransactionDAO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.bank.model.Admin" %>
<%
    HttpSession session = request.getSession(false);
    Admin admin = (Admin) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    String startDate = request.getParameter("startDate");
    String endDate = request.getParameter("endDate");
    String transactionType = request.getParameter("transactionType");

    List<Transaction> transactions = TransactionDAO.getFilteredTransactions(startDate, endDate, transactionType);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction List</title>
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
    <div class="filter-container">
        <form action="transactionList.jsp" method="get">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate">
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate">
            <label for="transactionType">Transaction Type:</label>
            <select id="transactionType" name="transactionType">
                <option value="">All</option>
                <option value="Credit">Credit</option>
                <option value="Debit">Debit</option>
                <option value="Transfer">Transfer</option>
            </select>
            <button type="submit">Filter</button>
        </form>
    </div>
    <div class="list-container">
        <h2>Transaction List</h2>
        <table>
            <thead>
                <tr>
                    <th>Transaction ID</th>
                    <th>Sender Account</th>
                    <th>Receiver Account</th>
                    <th>Amount</th>
                    <th>Date</th>
                    <th>Type</th>
                </tr>
            </thead>
            <tbody>
                <% for (Transaction transaction : transactions) { %>
                    <tr>
                        <td><%= transaction.getTransactionId() %></td>
                        <td><%= transaction.getSenderAccount() %></td>
                        <td><%= transaction.getReceiverAccount() %></td>
                        <td><%= transaction.getAmount() %></td>
                        <td><%= transaction.getDate() %></td>
                        <td><%= transaction.getType() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
