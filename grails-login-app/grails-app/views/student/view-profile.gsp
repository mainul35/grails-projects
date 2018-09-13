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
            %{--<img src="/student/temp/${student.profileImageName}"/>--}%
            %{--<g:img dir="images" file="${student.profileImageName }", imageName: student.profileImageName/>--}%
            <img src="${createLink(controller: 'file', action: 'getImage', params: "[fileName: '${student.profileImageName}']")}"
                 width="80" height="100"/>
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
