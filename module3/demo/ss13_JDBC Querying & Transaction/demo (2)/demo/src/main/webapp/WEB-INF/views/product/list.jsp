<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 9/14/2022
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>
    <h1>Product list</h1>

    <a href="/product?action=create">Add new product</a>
    <table border="1">
        <tr>
            <th>No</th>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Date release</th>
            <th>Quantity</th>
            <th>Product type</th>
        </tr>
        <c:forEach items="${products}" varStatus="item">
            <tr>
                <td>${item.count }</td>
                <td>${item.current.id}</td>
                <td>${item.current.name}</td>
                <td>${item.current.price}</td>
                <td><fmt:formatDate value="${item.current.dateRelease}" pattern="dd/MM/yyyy" /> </td>
                <td>${item.current.quantity}</td>
                <td>${item.current.type.name}</td>

            </tr>
        </c:forEach>
    </table>
    <c:if test="${isPrevious == true}">
        <a href="/product?action=list&page=${currentPage - 1}&size=${size}">Previous</a>
    </c:if>
    <a href="/product?action=list&page=${currentPage}&size=${size}">${currentPage}</a>
    <c:if test="${isNext == true}">
        <a href="/product?action=list&page=${currentPage + 1}&size=${size}">Next</a>
    </c:if>
</body>
</html>
