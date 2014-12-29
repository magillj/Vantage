<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 12/28/14
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="/images/pkp_favicon.ico">

  <title>Sign In</title>

  <script src="<c:url value="/js/external/jquery-2.1.1.min.js" />"></script>
  <script src="<c:url value="/bootstrap/dist/js/bootstrap.min.js" />"></script>
  <link href="<c:url value="/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/bootstrap/dist/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/css/signin.css" />" rel="stylesheet" type="text/css" />


  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>

<div class="container">

  <form class="form-signin" name='loginForm'
        action="<c:url value='/j_spring_security_check' />" method='POST'>

    <img id="logo" alt="Logo" class="center-block" src="<c:url value="/images/pkp_logo.png"/>">

    <c:if test="${not empty error}">
      <div class="alert alert-danger">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Error:</span>
        ${error}
      </div>
    </c:if>
    <c:if test="${not empty msg}">
      <div class="msg">${msg}</div>
    </c:if>

    <h2 class="form-signin-heading">Please sign in</h2>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <%-- TODO: Remember Me Functionality--%>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <div class="checkbox">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>
    <button class="btn-danger btn-lg btn-primary btn-block" type="submit">Sign in</button>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />

  </form>



</div> <!-- /container -->
</body>
</html>