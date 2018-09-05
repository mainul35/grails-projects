<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
</head>
<body class="align-content-center">
<div class="container">
    <div class="row">
        <g:form controller="auth" action="login" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <g:textField type="text" class="form-control mr-sm-2" name="email" id="email" placeholder="Email" required="required"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <g:passwordField type="password" class="form-control mr-sm-2" name="password" id="password" placeholder="Password" required="required"/>
            </div>
            <div class="form-group">
                <g:submitButton type="submit" class="btn btn-primary" value="Login" name="submit"/>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>
