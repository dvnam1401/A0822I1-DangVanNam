<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vanna
  Date: 26/03/2023
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User management</h1>
    <h2>
        <a href="users?action=users">List All User</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <div>
            <caption>
                <h2>Search user</h2>
            </caption>
        </div>
        <div>
            <b>Country: </b> <input type="text" name="country" id="country" size="45">
            <input type="submit" value="Search">
        </div>
    </form>
    <c:if test="${user != null}">
        <div align="center">
            <table border="1" , cellpadding="5">
                <caption><h2>List of Users</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Country</th>
                    <th>Actions</th>
                </tr>
                <tr>
                    <c:forEach var="user" items="${user}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a href="/users?action=edit&id=${user.id}">Edit</a>
                        <a href="/users?action=delete&id=${user.id}">Delete</a>
                    </td>
                </tr>
                </c:forEach>
                </tr>
            </table>
        </div>
    </c:if>

</div>
</body>
</html>
