<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <meta name="layout" content="header"/>
</head>

<body class="align-content-center">
<div class="container">
    <App:msg status="${status}" msg="${msg}"/>
    <table class="table table-dark table-hover">
        <thead>
        <tr>
            <th>Department name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <g:each var="department" in="${departments}">
            <tr>
                <td>${department.name}</td>
                <td>
                    <div class="btn-group">
                        <g:link type="button" class="btn btn-primary" controller="department"
                                action="edit" params="[id: department.id]">Edit</g:link>
                        <g:link type="button" class="btn btn-danger" controller="department"
                                action="delete" params="[id: department.id]">Delete</g:link>
                    </div>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>
