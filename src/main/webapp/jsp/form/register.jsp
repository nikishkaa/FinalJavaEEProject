<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 30.08.2024
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>

<div class="main">
    <h1>HorseNB</h1>
    <h3>Create new account</h3>

    <%--Error massage block--%>
    <h2 style="color: #ff385c">${msg}</h2>
    <c:if test="${cause != null}">
        <details>
            <summary>Error Details</summary>
            <c:out value="${cause}"/>
            <details>
                <summary>Stack Trace</summary>
                <c:out value="${stack-trace}"/>
            </details>
        </details>
    </c:if>

    <form action="register" method="post">

        <label for="user_name">
            Name*:
        </label>
        <input type="text"
               id="user_name"
               name="user_name"
               placeholder="Enter your Name*" required>


        <label for="email">
            Email*:
        </label>
        <input type="text"
               id="email"
               name="email"
               placeholder="Enter your Email*" required>

        <label for="phone_number">
            Phone Number:
        </label>
        <input type="text"
               id="phone_number"
               name="phone_number"
               placeholder="Enter your Phone Number">

        <label for="psw">
            Password*:
        </label>
        <input type="password"
               id="psw"
               name="psw"
               placeholder="Enter your Password*" required>


        <label for="psw_replay">
            Replay your Password*:
        </label>
        <input type="password"
               id="psw_replay"
               name="psw_replay"
               placeholder="Replay your Password*" required>

        <div class="wrap">
            <button type="submit">
                Submit
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
