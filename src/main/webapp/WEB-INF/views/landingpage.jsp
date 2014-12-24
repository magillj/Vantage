<%--
  Landing page for the Vantage website
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:genericpage>
    <jsp:attribute name="headscripts">
        
    </jsp:attribute>

    <jsp:body>
        <p>Test message from controller: ${testMessage}</p>
    </jsp:body>
</t:genericpage>