<%--
  Landing page for the Vantage website
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<t:genericpage>
    <jsp:attribute name="headscripts">
        
    </jsp:attribute>


    <jsp:body>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <p>Test message from controller: ${testMessage}</p>
        </sec:authorize>
    </jsp:body>
</t:genericpage>