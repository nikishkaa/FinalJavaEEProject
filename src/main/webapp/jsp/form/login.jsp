<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 30.08.2024
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>

<div class="main">
    <h1>HorseNB</h1>
    <h3>Enter your login credentials</h3>
    <form action="login" method="post">

        <label for="email">
            Email:
        </label>
        <input type="text"
               id="email"
               name="email"
               placeholder="Enter your Email" required>

        <label for="psw">
            Password:
        </label>
        <input type="password"
               id="psw"
               name="psw"
               placeholder="Enter your Password" required>

        <div class="wrap">
            <button type="submit">
                Submit
            </button>
        </div>
    </form>

    <p>Not registered?
        <a href="register"
           style="text-decoration: none;">
            Create an account
        </a>
    <p>Forgot a password?
        <a href="recover"
           style="text-decoration: none;">
            Reset password
        </a>
    </p>
</div>


</body>
</html>
