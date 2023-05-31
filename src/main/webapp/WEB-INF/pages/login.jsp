<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
<h2>Login</h2>
<form method="post" action="login">
    <label for="username">Login : </label>
    <input type="text" id="username" name="username" value="${username}">
    <label for="password">Password : </label>
    <input type="password" id="password" name="password">
    <span style="color: red">${errorMessage}</span>
    <button type="submit">Connect</button>
</form>

</body>
</html>