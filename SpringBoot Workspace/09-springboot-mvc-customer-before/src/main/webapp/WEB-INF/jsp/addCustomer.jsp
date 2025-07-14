<html>

<head>
    <title>Add Customer</title>
</head>

<body>
    <h2>Add Customer</h2>
    <form method="post" modelAttribute="customer" action="saveCustomer.do">
        <table>
            <tr>
                <td>First Name:</td>
                <td>
                    <input type="text" name="firstName" />
                </td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>
                    <input type="text" name="lastName" />
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="text" name="email" />
                </td>
            </tr>
            <tr>
                <td>Account ID:</td>
                <td>
                    <input type="text" name="account.accountId" />
                </td>
            </tr>
            <tr>
                <td>Balance:</td>
                <td>
                    <input type="text" name="account.balance" />
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add Customer" /></td>
            </tr>
        </table>
        </form:form>
</body>

</html>