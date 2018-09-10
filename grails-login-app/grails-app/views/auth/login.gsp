<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
</head>
<body class="align-content-center">
<div class="container">
    <AppSecurity:msg msg="${msg}" status="${status}"></AppSecurity:msg>
    <h1>Log in</h1>
    <div class="row">
        <g:form controller="auth" action="login" method="post">
            <AppSecurity:emailPasswordFields></AppSecurity:emailPasswordFields>
            <div class="form-group">
                <g:submitButton type="submit" class="btn btn-primary" value="Login" name="submit"/>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>