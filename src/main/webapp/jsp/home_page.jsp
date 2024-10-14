<%@ page import="org.example.finaljavaeeproject.entity.user.User" %><%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 30.08.2024
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HorseNB</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>


<h1 style="color: #ff385c">HorseNB</h1>
<a style="color: #ff385c" href="login">Login</a>
<br>
<a style="color: #ff385c" href="register">Register</a>
<br>
<a style="color: #ff385c" href="recover">Forgot Password</a>
<br>

<a style="color: #ff385c" href="logout">Logout</a>
<br>
<a style="color: #ff385c" href="jsp/admin-panel.jsp">Admin Panel</a>
<br>


<%--TODO переделать под JSPX--%>
<%
    Object object = session.getAttribute("user");
    if (object == null) {
%>
<a class="nav-link" href="login">Login</a>
</li>
<%
} else {

    User user = (User) object;

%>
<h4>Hello, <%=user.getName()%>
</h4>

<a class="nav-link" href="logout">Logout</a>
<%}%>


</body>
</html>
