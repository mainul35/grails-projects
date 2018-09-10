<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
</head>

<body class="align-content-center">
<div class="container">
    <h1>Create Course</h1>
    <AppSecurity:msg msg="${msg}" status="${status}"/>

    <div class="row">
        <g:form controller="course" action="create-course">
            <g:render template="form"/>
            <div class="form-group">
                <g:submitButton name="Create" class="btn btn-primary"/>&nbsp;
                <g:link controller="course" action="view-all-courses" class="btn btn-success">View all</g:link>
            </div>
        </g:form>
    </div>
</div>
</body>
</html>