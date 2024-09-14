<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 30.08.2024
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recover Password</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>

<div class="main">
    <h1>HorseNB</h1>
    <h3>Password Recovery</h3>


    <form action="recover" method="post">

        <label for="email">
            Email:
        </label>
        <input type="text"
               id="email"
               name="email"
               placeholder="Enter your Email" required>

        <div class="wrap">
            <button type="submit">
                Send Email
            </button>
        </div>
    </form>

    <p>Registered?
        <a href="login"
           style="text-decoration: none;">
            login in account
        </a>
    </p>
</div>


</body>
</html>
