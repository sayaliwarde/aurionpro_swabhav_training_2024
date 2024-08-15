<!DOCTYPE html>
<html>
<head>
    <title>Customer Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-5">Welcome ${customer.firstName}</h2>
        <ul class="list-group">
            <li class="list-group-item"><a href="new_transaction.jsp">New Transaction</a></li>
            <li class="list-group-item"><a href="view_passbook.jsp">View Passbook</a></li>
            <li class="list-group-item"><a href="edit_profile.jsp">Edit Profile</a></li>
        </ul>
    </div>
</body>
</html>
