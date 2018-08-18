<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="header"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    %{--<asset:link rel="icon" href="favicon.ico" type="image/x-ico" />--}%

    <asset:stylesheet src="libs/bootstrap/css/bootstrap.min.css"/>
    <asset:stylesheet src="libs/jquery_ui/jquery-ui.css"/>

    <g:layoutHead/>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Add Student <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/sms/display-all">Show all</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/sms/search">Search</a>
            </li>
        </ul>
    </div>
</nav>
<g:layoutBody/>



<asset:javascript src="libs/jquery.min.js"/>
<asset:javascript src="libs/bootstrap/js/popper.min.js"/>
<asset:javascript src="libs/jquery.dataTables.min.js"></asset:javascript>
<asset:javascript src="libs/bootstrap/js/bootstrap.min.js"/>
<asset:javascript src="libs/moment-with-locales.js"/>
<asset:javascript src="libs/jquery_ui/jquery-ui.js"/>

</body>
</html>
