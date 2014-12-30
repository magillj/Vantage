<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="headscripts" fragment="true" %>
<%@taglib prefix="sec"
uri="http://www.springframework.org/security/tags"%><html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">   <%-- Makes it so it inititally looks good on mobile--%>

    <script src="<c:url value="/js/external/jquery-2.1.1.min.js" />"></script>
    <link href="<c:url value="/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/bootstrap/dist/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />
    <script src="<c:url value="/bootstrap/dist/js/bootstrap.min.js" />"></script>
    <link href="/css/theme.css" rel="stylesheet" type="text/css" />
    <link rel="icon" href="<c:url value="/images/pkp_favicon.ico" />" />
    <jsp:invoke fragment="headscripts"/>
    <title>Vantage</title>

</head>

<body>
    <!-- Static navbar -->
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="true" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img id="logo" alt="Logo" src="<c:url value="/images/pkp_logo.png" />" /></a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Announcements</a></li>
                    <li class=dropdown-inverse">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">HM<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Duties</a></li>
                            <li><a href="#">Fines</a></li>
                            <li><a href="#">$150 Request</a></li>
                        </ul>
                    </li>
                    <li class=dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Scholarship<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Study Tables</a></li>
                            <li><a href="#">Submit Grades</a></li>
                            <li><a href="#">Resources</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Utilities <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Menu</a></li>
                            <li><a href="#">Lost and Found</a></li>
                            <li><a href="#">Laundry Room</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class=""><a href="<c:url value="/login?logout" />">Log Out</a></li>
                    <li class=""><a href="">Officer Portal</a></li> <%-- Only Show this if they have a portal --%>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>

    <div id="content">
        <jsp:doBody/>
    </div>

    <div id="footer">
        <!--TODO: Insert footer code-->
    </div>
</body>
</html>