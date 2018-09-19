<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails student management app"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>

    <script type="text/javascript">
        GT.baseURL = "${session.getServletContext().getContextPath()}/";
        <g:if test="${flash?.message && flash?.message?.info}">
        jQuery(document).ready(function () {
            GT.messageBox.showMessage(Boolean(${flash.message?.success}), "${flash.message?.info}");
        });
        </g:if>
    </script>
    <g:layoutHead/>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark rounded">
        <a class="navbar-brand" href="/">Grails student management app</a>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <ul class="navbar-nav mr-5">
            <App:adminMenues/>
        </ul>
        <ul class="navbar-nav ml-auto">
            <App:menuOnAuthenticationState/>
        </ul>

    </nav>
</header>




<App:isAuthenticated authFlag="true">
    <div class="container-fluid">
        <div class="row">
            <App:adminSideNav>
                <main role="main" class="col-sm-9 ml-sm-auto col-md-10 pt-3">
                    <g:layoutBody/>
                </main>
            </App:adminSideNav>
            <App:studentSideNav>
                <main role="main" class="col-sm-9 ml-sm-auto col-md-10 pt-3">
                    <g:layoutBody/>
                </main>
            </App:studentSideNav>
        </div>
    </div>
</App:isAuthenticated>
<App:isAuthenticated authFlag="false">
    <g:layoutBody/>
</App:isAuthenticated>

</body>
</html>
