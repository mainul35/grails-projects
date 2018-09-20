<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
    <link rel="stylesheet" href="${resource(file: 'login.css')}" type="text/css">
</head>

<body class="align-content-center">
%{--<meta name="layout" content="public">--}%
<div id="global-wrapper">
    <div id="content-wrapper">
        <div class="container">
            %{--<App:msg msg="${msg}" status="${status}"></App:msg>--}%


            <div class="col-sm-6 col-md-4 mx-auto">
                <div class="account-wall">
                    <g:img dir="images" file="download.png" class="profile-img"/>

                    <g:form controller="auth" action="login" method="post" class="form-signin">
                        <App:emailField email="${flash?.user?.email}"/>
                        <App:passwordField password="${flash?.user?.password}"/>
                        <div class="form-group">
                            <g:submitButton type="submit" class="btn btn-lg btn-primary btn-block" value="Login"
                                            name="submit"/>
                        </div>
                    </g:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
