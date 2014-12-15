<%--
  Landing page for the Vantage website
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:genericpage>
    <jsp:attribute name="headscripts">
        <script src="<c:url value="/js/LandingPage.js" />"></script>
    </jsp:attribute>

    <jsp:body>
        <div style="background-color:#355e3b; height: 200px; width: 100%; border: 7px solid #BD2031;">
          <img style="height:200px; width: 280px;" alt="Logo" src="http://www.phikappapsi.com/connect/media/images/upload/Main%20logo%20for%20web.gif">
          <span id="title">Washington Alpha</span>
      </div>
      <div id="top-nav">
          <ul id="main-menu">
              <li> About </li>
              <li> Duties </li>
              <li> Recruitment</li>
              <li> Scholarship </li>
          </ul>
      </div>
        <p>Test message from controller: ${testMessage}</p>
    </jsp:body>
</t:genericpage>