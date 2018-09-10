<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
</head>

<body class="align-content-center">
<div class="container">
    <h1>Edit Student</h1>
    <App:msg status="${status}" msg="${msg}"/>
    <div class="row">
        <g:uploadForm controller="student" action="update" enctype='multipart/form-data'>
            <g:hiddenField name="id" value="${student?.id}"></g:hiddenField>
            <div class="form-group">
                <label>Student ID</label>
                <g:textField name="stdId" placeholder="Student Id" value="${student.stdId}" class="form-control" required="true" disabled="true"></g:textField>
            </div>
            <App:editStudent email="${student.email}" password="${student.email}"/>
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
