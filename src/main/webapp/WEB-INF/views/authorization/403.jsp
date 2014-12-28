<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 12/27/14
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>HTTP Status 403 - Access is denied</title>
</head>
<body>
<h1>HTTP Status 403 - Access is denied</h1>

<c:choose>
  <c:when test="${empty username}">
    <h2>You do not have permission to access this page!</h2>
  </c:when>
  <c:otherwise>
    <h2>Username : ${username} <br/>
      You do not have permission to access this page!</h2>
  </c:otherwise>
</c:choose>
</body>
</html>
