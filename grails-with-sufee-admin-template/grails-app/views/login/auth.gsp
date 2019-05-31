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
                <form action="/login/processing" method="post">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control mr-sm-2" name="username" id="username" placeholder="Username"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control mr-sm-2" name="password" id="password" placeholder="Password"/>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
