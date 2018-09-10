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
    <h1>Register</h1>
    <div class="row">
        <g:form name="registration-form" controller="user" action="register" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <g:textField name="stdId"  class="form-control" placeholder="Name" required="required" value="${user?.stdId}"></g:textField>
            </div>

            <div class="form-group">
                <label for="name">Name</label>
                <g:textField name="name"  class="form-control" placeholder="Name" required="required" value="${user?.name}"></g:textField>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <g:textField name="email" class="form-control" type="email" placeholder="Email" required="required" value="${user?.email}"></g:textField>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <g:textField name="batch" class="form-control" type="email" placeholder="Email" required="required" value="${user?.email}"></g:textField>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <g:passwordField name="password" class="form-control" type="password" placeholder="Password"
                                 required="required" value="${user?.password}"></g:passwordField>
            </div>
            <div class="form-group">
                <g:submitButton name="submit" type="submit" value="Register" class="btn btn-primary"></g:submitButton>
                <g:link class="btn btn-primary" controller="auth" action="login">Log in</g:link>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>
