<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>Person List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Age</th><th>Email</th><th>Gender</th></tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.fullname}</td>
            <td>${emp.age}</td>
            <td>${emp.email}</td>
            <td>${emp.gender}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/">Add New Person</a>
</html>
