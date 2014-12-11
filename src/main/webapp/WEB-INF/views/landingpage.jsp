<%--
  Landing page for the Vantage website
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:genericpage>
    <jsp:attribute name="headscripts">
        <script src="/WEB-INF/scripts/LandingPage.js"></script>
    </jsp:attribute>

    <jsp:body>
      <h1>Landing Page for Vantage</h1>
      <p>Test message from controller: ${testMessage}</p>
    </jsp:body>
</t:genericpage>