<!DOCTYPE html>
<html>
<head>
    <title>View Passbook</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-5">Passbook</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Transaction Type</th>
                    <th>Amount</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaction" items="${transactions}">
                    <tr>
                        <td>${transaction.transactionType}</td>
                        <td>${transaction.amount}</td>
                        <td>${transaction.transactionDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
