<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 12/28/14
  Time: 1:01 PM
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
    <%--
        When configuring the Admin Page Please Note That
        Sections only show up when a user has a given role.

        To Add Roles...go to spring-security.xml and add another role for
        <intercept-url pattern="/admin**" access="hasAnyRole('ROLE_ADMIN', ...)" />

        Users cannot reach this page if you don't add their role to the line above

        USE THIS SYTNAX FOR ADDING A SECTION OF BODY:
        <sec:authorize access="hasRole('ROLE_WHATEVER')">

        </sec:authorize>

        --%>
    <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
      <p>ADMIN</p>
    </sec:authorize>

    <sec:authorize access="hasAnyRole('ROLE_HM')">
        <t:HMAdmin>

        </t:HMAdmin>
    </sec:authorize>

    <sec:authorize access="hasAnyRole('root')">
      <p>root</p>
    </sec:authorize>


    <sec:authorize access="hasAnyRole('ROLE_GP', 'ROLE_VGP')">
      <p> GP and VGP</p>
    </sec:authorize>



  </jsp:body>
</t:genericpage>