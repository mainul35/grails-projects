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
        <div class="col-2">
            %{--<g:img uri="${grails.login.app.UploadService.FILE_PATH}${student.profileImageName}"/>--}%
            <img src="${createLink(controller: 'image', action: 'getImage', imageName: student.profileImageName)}" />
        </div>
        <div class="col-8">
            <p>Student ID: ${student.stdId}</p>
            <p>Name: ${student.name}</p>
            <p>Email : ${student.email}</p>
            <p>Gender: ${student.gender}</p>
            <p>Date of birth: ${student.dateOfBirth}</p>
            <p>Semester: ${student.semester.name}</p>
            <p>Department: ${student.department.name}</p>
        </div>
    </div>
</div>
</body>
</html>
