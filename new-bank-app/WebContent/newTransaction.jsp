<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Transaction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Bank Customer</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerServlet?action=viewPassbook">View Passbook</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerServlet?action=newTransaction">New Transaction</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CustomerServlet?action=editProfile">Edit Profile</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <h3>Create New Transaction</h3>
        <form action="CustomerServlet?action=newTransaction" method="post">
            <div class="mb-3">
                <label for="transactionType" class="form-label">Transaction Type</label>
                <select class="form-select" id="transactionType" name="transactionType" required onchange="toggleReceiverAccount()">
                    <option value="credit">Credit</option>
                    <option value="debit">Debit</option>
                    <option value="transfer">Bank Transfer</option>
                </select>
            </div>
            <div class="mb-3" id="receiverAccountDiv" style="display:none;">
                <label for="receiverAccount" class="form-label">Receiver Account Number</label>
                <input type="text" class="form-control" id="receiverAccount" name="receiverAccount">
            </div>
            <div class="mb-3">
                <label for="amount" class="form-label">Amount</label>
                <input type="number" class="form-control" id="amount" name="amount" min="1" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit Transaction</button>
            <% if (request.getAttribute("message") != null) { %>
                <div class="alert alert-info mt-3">
                    <%= request.getAttribute("message") %>
                </div>
            <% } %>
        </form>
        <button onclick="window.history.back();" class="btn btn-secondary mt-3">Back</button>
    </div>

    <script>
        function toggleReceiverAccount() {
            var transactionType = document.getElementById('transactionType').value;
            var receiverAccountDiv = document.getElementById('receiverAccountDiv');
            receiverAccountDiv.style.display = (transactionType === 'transfer') ? 'block' : 'none';
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
