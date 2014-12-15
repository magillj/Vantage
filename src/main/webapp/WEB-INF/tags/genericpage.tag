<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="headscripts" fragment="true" %>
<html>
<head>
    <script src="<c:url value="/js/external/jquery-2.1.1.min.js" />"></script>
    <jsp:invoke fragment="headscripts"/>

    <title>Vantage</title>
</head>

<body>
    <div id="banner">
        <div style="background-color:#355e3b; height: 200px; width: 100%; border: 7px solid #BD2031;">
            <img style="height:200px; width: 280px;" alt="Logo" src="http://www.phikappapsi.com/connect/media/images/upload/Main%20logo%20for%20web.gif">
            <span id="title">Washington Alpha</span>
        </div>
    </div>

    <div id="content">
        <jsp:doBody/>
    </div>

    <div id="footer">
        <!--TODO: Insert footer code-->
    </div>
</body>
</html>