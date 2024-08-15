<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Transactions</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 20px;
        }
        .debit {
            background-color: #f8d7da;
        }
        .credit {
            background-color: #d4edda;
        }
    </style>
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="adminHome.jsp">Admin Dashboard</a>
        </nav>
        <h2 class="text-center mt-4">View Transactions</h2>
        <form action="viewTransactions" method="get">
            <div class="form-group">
                <label for="startDate">Start Date</label>
                <input type="date" class="form-control" id="startDate" name="startDate" required>
            </div>
            <div class="form-group">
                <label for="endDate">End Date</label>
                <input type="date" class="form-control" id="endDate" name="endDate" required>
            </div>
            <div class="form-group">
                <label for="transactionType">Transaction Type</label>
                <select class="form-control" id="transactionType" name="transactionType">
                    <option value="">All</option>
                    <option value="debit">Debit</option>
                    <option value="credit">Credit</option>
                    <option value="transfer">Transfer</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Filter Transactions</button>
        </form>
        <table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>Sender Account</th>
                    <th>Receiver Account</th>
                    <th>Type</th>
                    <th>Amount</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaction" items="${transactions}">
                    <tr class="${transaction.type == 'debit' ? 'debit' : (transaction.type == 'credit' ? 'credit' : '')}">
                        <td>${transaction.senderAccount}</td>
                        <td>${transaction.receiverAccount}</td>
                        <td>${transaction.type}</td>
                        <td>${transaction.amount}</td>
                        <td>${transaction.date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
