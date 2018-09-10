<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
</head>

<body class="align-content-center">
<div class="container">
    <AppSecurity:msg status="${status}" msg="${msg}"/>
    <table class="table table-dark table-hover">
        <thead>
        <tr>
            <th>Course name</th>
            <th>Course code</th>
            <th>Credits</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <g:each var="course" in="${courses}">
            <tr>
                <td>${course.name}</td>
                <td>${course.code}</td>
                <td>${course.courseCredits}</td>
                <td>
                    <div class="btn-group">
                        <g:link type="button" class="btn btn-primary" controller="course"
                                action="edit" params="[id: course.id]">Edit</g:link>
                        <g:link type="button" class="btn btn-danger" controller="course"
                                action="delete" params="[id: course.id]">Delete</g:link>
                    </div>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>
