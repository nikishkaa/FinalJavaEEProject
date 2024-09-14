<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 14.09.2024
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Role</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>
<div class="main">
    <h1>HorseNB</h1>
    <h3>Add new Role</h3>
    <form action="add-role" method="post">

        <label for="role-name">
            Role name:
        </label>
        <input type="text"
               id="role-name"
               name="role-name"
               placeholder="Enter new Role name" required>

        <label for="description">
            Role description:
        </label>
        <input type="text"
               id="description"
               name="description"
               placeholder="Enter Role description">

        <div class="wrap">
            <button type="submit">
                Submit
            </button>
        </div>
    </form>

</body>
</html>
