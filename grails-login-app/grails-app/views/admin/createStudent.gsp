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

    <div class="row">
        <g:form controller="student" action="create-student">
            <g:hiddenField name="id" value="${System.currentTimeMillis()}"></g:hiddenField>
            <div class="form-group">
                <g:textField name="stdId" placeholder="Student Id" class="form-control" required="true"></g:textField>
            </div>

            <div class="form-group">
                <g:textField name="name" placeholder="Student Name" class="form-control" required="true"></g:textField>
            </div>
            <AppSecurity:emailPasswordFields></AppSecurity:emailPasswordFields>
            <div class="form-group">
                <g:radioGroup name="gender"
                              labels="['Male', 'Female', 'Other']"
                              values="[1, 2, 3]">
                    <span>${it.radio} &nbsp;${it.label}</span>
                </g:radioGroup>
            </div>

            <div class="form-group">
                <g:datePicker name="dateOfBirth" value="${new Date()}"
                              precision="day" years="${1990..2018}"/>
            </div>

            <div class="form-group">
                <g:textField name="batch" class="form-control" placeholder="Batch" required="true"></g:textField>
            </div>

            <div class="form-group">
                <g:select name="currentSemester"
                          from="${semesters}"
                          noSelection="${['null': 'Select One...']}"
                          value="${currentSemester?.name}"
                          optionKey="id"
                          multiple="false"
                          class="form-control"/>
            </div>

            <div class="form-group">
                <g:textField name="department" class="form-control" placeholder="Department" required="true"></g:textField>
            </div>

            <div class="form-group">
                <g:submitButton name="submit" class="btn btn-primary"></g:submitButton>
            </div>
        </g:form>

    </div>
</div>
</body>
</html>
