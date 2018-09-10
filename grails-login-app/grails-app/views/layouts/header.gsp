<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="header"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    %{--<asset:link rel="icon" href="favicon.ico" type="image/x-ico" />--}%

    <asset:stylesheet src="bootstrap.css"/>
    %{--<asset:stylesheet src="libs/jquery_ui/jquery-ui.css"/>--}%

    <g:layoutHead/>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <AppSecurity:adminMenues></AppSecurity:adminMenues>
            <AppSecurity:studentMenues></AppSecurity:studentMenues>
        </ul>
        <ul class="navbar-nav ml-auto">
            <AppSecurity:menuOnAuthenticationState></AppSecurity:menuOnAuthenticationState>
        </ul>
    </div>
</nav>
<g:layoutBody/>



<asset:javascript src="jquery-3.2.1.min.js"/>
<asset:javascript src="popper.min.js"/>
%{--<asset:javascript src="libs/jquery.dataTables.min.js"></asset:javascript>--}%
<asset:javascript src="bootstrap.js"/>
%{--<asset:javascript src="libs/moment-with-locales.js"/>--}%
%{--<asset:javascript src="libs/jquery_ui/jquery-ui.js"/>--}%

</body>
</html>