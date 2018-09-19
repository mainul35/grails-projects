<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
</head>

<body class="align-content-center">
<div class="container">
    <h1>Create Student</h1>
    <App:msg msg="${msg}" status="${status}"/>
    <div class="row">
        <g:uploadForm controller="admin" action="register" enctype='multipart/form-data'>
            <g:hiddenField name="id" value="${System.currentTimeMillis()}"></g:hiddenField>
            <div class="form-group">
                <label>Student ID</label>
                <g:textField name="stdId" placeholder="Student Id" value="${student?.id}" class="form-control"
                             required="true"></g:textField>
            </div>
            <g:render template="name_sex_dob"/>
            <App:emailPasswordFields email="${student?.email}" password="${student?.password}"/>
            <g:render template="semester_department"/>
            <div class="form-group">
                <input type="file" name="image"/>
            </div>

            <div class="form-group">
                <g:submitButton name="submit" class="btn btn-primary"></g:submitButton>
            </div>
        </g:uploadForm>

    </div>
</div>
</body>
</html>
