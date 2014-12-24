<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="headscripts" fragment="true" %>
<html>
<head>
    <script src="<c:url value="/js/external/jquery-2.1.1.min.js" />"></script>
    <link href="<c:url value="/bootstrap/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/bootstrap/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />
    <script src="<c:url value="/js/external/bootstrap.min.js" />"></script>
    <link href="/css/theme.css" rel="stylesheet" type="text/css" />
    <jsp:invoke fragment="headscripts"/>
    <title>Vantage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> <%-- Makes it so it inititally looks good on mobile--%>

</head>

<body>
    <div id="banner">
        <div id="background">
            <img id="logo" alt="Logo" src="http://www.phikappapsi.com/connect/media/images/upload/Main%20logo%20for%20web.gif">
            <span id="title">Washington Alpha</span>
        </div>
    </div>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                    <li><a href="#">Link</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Link</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <div id="content">
        <jsp:doBody/>
    </div>

    <div id="footer">
        <!--TODO: Insert footer code-->
    </div>
</body>
</html>