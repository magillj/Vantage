<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 12/28/14
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="/images/pkp_favicon.ico">

  <title>Sign Up</title>

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
  <form:form class="form-horizontal" action='/submit' method="POST" commandName="account">
    <fieldset>
      <div id="legend">
        <legend class="">Register</legend>
      </div>
      <div class="control-group">
        <%--FirstName--%>
        <label class="control-label"  for="FirstName">First Name</label>
        <div class="controls">
          <form:input path="FirstName" type="text" id="FirstName" name="FirstName" placeholder="First Name" class="input-xlarge" />
          <p class="help-block">Please provide your First Name</p>
        </div>
      </div>

      <div class="control-group">
        <%--Middle Name--%>
        <label class="control-label"  for="MiddleName">Middle Name</label>
        <div class="controls">
          <form:input path="MiddleName" type="text" id="MiddleName" name="MiddleName" placeholder="Middle Name" class="input-xlarge" />
          <p class="help-block">Please provide your Middle Name if you have one, it will be used to report to nationals</p>
        </div>
      </div>


      <div class="control-group">
        <%--Last Name--%>
        <label class="control-label"  for="LastName">Last Name</label>
        <div class="controls">
          <form:input path="LastName" type="text" id="LastName" name="LastName" placeholder="Last Name" class="input-xlarge" />
          <p class="help-block">Please provide your Last Name</p>
        </div>
      </div>

      <div class="control-group">
        <%--Email--%>
        <label class="control-label" for="email">E-mail</label>
        <div class="controls">
          <form:input path="Email" type="text" id="email" name="email" placeholder="" />
          <p class="help-block">Please provide your E-mail (preferably UW)</p>
        </div>
      </div>
      <%--PC --%>
      <div class="control-group">
        <label class="control-label" for="PC">Pledge Class:</label>
        <form:select path="PC" class="form-control" id="PC" name="PC">
          <option>11</option>
          <option>12</option>
          <option>13</option>
          <option>14</option>
          <%--TODO MAKE THIS AUTOGENERATE for current years--%>
        </form:select>
      </div>

      <div class="control-group">
        <%--Initiation Number--%>
        <label class="control-label" for="InitiationNumber">Initiation Number</label>
        <div class="controls">
          <form:input path="InitiationNumber" type="text" id="InitiationNumber" name="InitiationNumber" placeholder="####..." />
          <p class="help-block">If you forget your dots I'll Kill You</p>
        </div>
      </div>

      <div class="control-group">
        <%--Cell Number--%>
        <label class="control-label" for="CellNumber">Cellphone Number</label>
        <div class="controls">
          <form:input path="CellNumber" type="text" id="CellNumber" name="CellNumber" placeholder="" />
          <p class="help-block"></p>
        </div>
      </div>

      <div class="control-group">
        <%--High School--%>
        <label class="control-label" for="HighSchool"> High School</label>
        <div class="controls">
          <form:input path="HighSchool" type="text" id="HighSchool" name="HighSchool" placeholder="" />
          <p class="help-block"></p>
        </div>
      </div>

      <div class="control-group">
        <%--Home Address--%>
        <label class="control-label" for="HomeAddress">Home Address</label>
        <div class="controls">
          <form:textarea path="HomeAddress" id="HomeAddress" name="HomeAddress" placeholder="" />
          <p class="help-block"> Please include city, state, zip</p>
        </div>
      </div>

      <div class="control-group">
        <%--Major--%>
        <label class="control-label" for="Major"> Major </label>
        <div class="controls">
          <form:input path="Major" type="text" id="Major" name="Major" placeholder="" />
          <p class="help-block">Please provide your Major. </p>
        </div>
      </div>

      <div class="control-group">
        <!-- Password-->
        <label class="control-label" for="password">Password</label>
        <div class="controls">
          <form:input path="password" type="password" id="password" name="password" placeholder="" class="input-xlarge" />
          <p class="help-block">Password should be at least 4 characters</p>
        </div>
      </div>

      <div class="control-group">
        <!-- Password -->
        <label class="control-label"  for="password_confirm">Password (Confirm)</label>
        <div class="controls">
          <form:input path="password_confirm" type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge" />
          <p class="help-block">Please confirm password</p>
        </div>
      </div>


      <div class="control-group">
        <%--Parent Title--%>
        <label class="control-label" for="Title"> Parent's Title</label>
        <div class="controls">
          <form:input path="Title" type="text" id="Title" name="Title" placeholder="" />
          <p class="help-block">Mr., Mrs., Ms., Dr.</p>
        </div>
      </div>

      <div class="control-group">
        <%--Parent Fname--%>
        <label class="control-label" for="ParentFname"> Parent's First Name</label>
        <div class="controls">
          <form:input path="ParentFname" type="text" id="ParentFname" name="ParentFname" placeholder="" />
          <p class="help-block">Mr., Mrs., Ms., Dr.</p>
        </div>
      </div>

      <div class="control-group">
        <%--Parent Fname--%>
        <label class="control-label" for="ParentLname"> Parent's Last Name</label>
        <div class="controls">
          <form:input path="ParentLname" type="text" id="ParentLname" name="ParentLname" placeholder="" />
          <p class="help-block">Mr., Mrs., Ms., Dr.</p>
        </div>
      </div>


      <div class="control-group">
        <%--Parent Email--%>
        <label class="control-label" for="ParentEmail">Parent's E-mail</label>
        <div class="controls">
          <form:input path="ParentEmail" type="text" id="ParentEmail" name="ParentEmail" placeholder="" />
          <p class="help-block">Please provide your parents E-mail. This will be used to send newsletters and invitations. </p>
        </div>
      </div>

      <div class="control-group">
        <%--Magic Phrase--%>
        <label class="control-label" for="MagicPhrase">Magic Phrase</label>
        <div class="controls">
          <form:input path="MagicPhrase" type="text" id="MagicPhrase" name="MagicPhrase" placeholder="" />
          <p class="help-block"></p>
        </div>
      </div>

      <div class="control-group">
        <!-- Button -->
        <div class="controls">
          <input type="submit" value="Submit" class="btn btn-success" />
        </div>
      </div>

    </fieldset>
  </form:form>
</div>
</body>
</html>
