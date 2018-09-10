<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
</head>

<body class="align-content-center">
<div class="container">

    <h1>Update semester</h1>
    <App:msg msg="${msg}" status="${status}"/>
    <div class="row">
        <g:form controller="semester" action="update">
            <g:hiddenField name="id" value="${semester.id}"></g:hiddenField>
            <g:render template="form"/>
            <div class="form-group">
                <label>Current courses</label>
                <p>
                <g:each var="course" in="${semester.offeredCourses}">
                    &nbsp;${course.name},
                </g:each>
                </p>
            </div>
            <div class="form-group">
                <g:submitButton name="submit" class="btn btn-primary">Update</g:submitButton>
                <g:link controller="semester" action="view-all-semesters" class="btn btn-success">View all</g:link>
            </div>
        </g:form>

    </div>
</div>
</body>
</html>
