<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="headscripts" fragment="true" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">   <%-- Makes it so it inititally looks good on mobile--%>

    <script src="<c:url value="/js/external/jquery-2.1.1.min.js" />"></script>
    <link href="<c:url value="/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/bootstrap/dist/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />
    <script src="<c:url value="/bootstrap/dist/js/bootstrap.min.js" />"></script>
    <link href="/css/theme.css" rel="stylesheet" type="text/css" />
    <jsp:invoke fragment="headscripts"/>
    <title>Vantage</title>

</head>

<body>
    <div id="banner">
        <div id="background">
            <img id="logo" alt="Logo" src="http://www.phikappapsi.com/connect/media/images/upload/Main%20logo%20for%20web.gif">
            <span id="title">Washington Alpha</span>
        </div>
    </div>
    <!-- Static navbar -->
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="true" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Project name</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Announcements</a></li>
                    <li class=dropdown">
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
                    <li class=""><a href="">Log Out</a></li>
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