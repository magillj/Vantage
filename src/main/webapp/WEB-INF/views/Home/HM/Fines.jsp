<%--
  Created by IntelliJ IDEA.
  User: btaylor5
  Date: 12/30/14
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<t:genericpage>
    <jsp:attribute name="headscripts">

    </jsp:attribute>

  <jsp:body>
    <sec:authorize access="hasAnyRole('HM')">
      <div>
        <p>Check Duty Button Will Go Here</p>
        <p> Alert Box Will Pop Up asking to confirm start of checking Duties ... Click yes, and it will start a huge javascript interactive step by step walk-through of duties</p>
      </div>
    </sec:authorize>
  </jsp:body>
</t:genericpage>