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
        %{--<div class="col-2">--}%
        %{--<g:img dir="images" file="${student.profileImageName}" class="profile-img"/>--}%
        %{--<g:img dir="images" file="${student.profileImageName}" class="profile-img" width="100" height="80"/>--}%
        %{--</div>--}%

        %{--<div class="col-8">--}%
        %{--<p>Student ID: ${student.stdId}</p>--}%

        %{--<p>Name: ${student.name}</p>--}%

        %{--<p>Email : ${student.email}</p>--}%

        %{--<p>Gender: ${student.gender == 1 ? 'Male' : 'Female'}</p>--}%

        %{--<p>Date of birth: <g:formatDate format="dd-MM-yyyy" date="${student.dateOfBirth}"/></p>--}%

        %{--<p>Semester: ${student.semester.name}</p>--}%

        %{--<p>Department: ${student.department.name}</p>--}%
        %{--</div>--}%


        <g:render template="profilePage"/>

    </div>

</div>
</body>
</html>
