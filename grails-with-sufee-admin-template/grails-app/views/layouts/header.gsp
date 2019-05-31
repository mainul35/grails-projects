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
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/task/view-all-tasks">View All</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/task/addTask">Add Task</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/tag/saveTagPage">Add Tag</a>
            </li>
        </ul>
        <sec:ifNotLoggedIn>
            <a href="/login/auth" class="btn btn-primary">Login</a>
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
            <a href="/logout" class="btn btn-primary">Logout</a>
        </sec:ifLoggedIn>
        %{--<form class="form-inline my-2 my-lg-0">--}%
            %{--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--}%
            %{--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--}%
        %{--</form>--}%
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
