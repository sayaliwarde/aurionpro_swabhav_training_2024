<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Bank Admin</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="AdminServlet?action=viewCustomers">View Customers</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="adminHome.jsp">Add Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminServlet?action=addAccount">Add Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AdminServlet?action=viewTransactions">View Transactions</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

      <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Welcome, Admin</h5>
                <p class="card-text">Please choose an action from the navigation menu.</p>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

