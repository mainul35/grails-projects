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
            <h1>403 FORBIDDEN</h1>
            The server understood the request but refuses to authorize it.
            <hr>
            If authentication credentials were provided in the request, the server considers them insufficient to grant access. The client SHOULD NOT automatically repeat the request with the same credentials. The client MAY repeat the request with new or different credentials. However, a request might be forbidden for reasons unrelated to the credentials.
        </div>
    </div>

</div>
</body>
</html>
