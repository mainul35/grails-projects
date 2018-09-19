<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
    <link rel="stylesheet" href="${resource(file: 'login.css')}" type="text/css">
</head>

<body class="align-content-center">
<div class="container">
    %{--<App:msg msg="${msg}" status="${status}"></App:msg>--}%

    <div class="flex">
        <div>
            <h1>404 NOT FOUND</h1>
            The server could not find the page you have requested for.
            <hr>
            Technically, an Error 404 is a client-side error, implying that the error is your mistake, either because you typed the URL incorrectly or the page has been moved or removed from the website and you should have known.

            Another possibility is if a website has moved a page or resource but did so without redirecting the old URL to the new one. When that happens, you'll receive a 404 error instead of being automatically routed to the new page.
        </div>
    </div>

</div>
</body>
</html>
