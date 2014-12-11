<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="headscripts" fragment="true" %>
<html>
<head>
    <script src="<c:url value="/scripts/external/jquery-2.1.1.min.js" />"></script>
    <jsp:invoke fragment="headscripts"/>

    <title>Vantage</title>
</head>

<body>
    <div id="banner">
        <!--TODO: Insert banner code-->
    </div>

    <div id="content">
        <jsp:doBody/>
    </div>

    <div id="footer">
        <!--TODO: Insert footer code-->
    </div>
</body>
</html>