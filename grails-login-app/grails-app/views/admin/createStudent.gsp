<title>Create student</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Create student
    </div>

    <div class="card-body">
        <g:uploadForm controller="admin" action="register-student" enctype='multipart/form-data'>
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
