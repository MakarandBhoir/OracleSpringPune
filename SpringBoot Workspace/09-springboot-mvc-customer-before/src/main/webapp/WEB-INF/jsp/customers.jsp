<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>View Customers</title>
    </head>

    <body>
        <h2>Customer List</h2>
        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Account ID</th>
                <th>Balance</th>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.account.accountId}</td>
                    <td>${customer.account.balance}</td>
                </tr>
            </c:forEach>
        </table>
        <br />
        <a href="addCustomer.view">Add New Customer</a>
    </body>

    </html>