<title>Create student</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Create student
        <App:authorized role="ROLE_ADMIN">
            <span class="float-right">
                <div class="btn-group">
                    <g:link action="all" controller="student"
                            class="btn btn-success">All students</g:link>
                </div>
            </span>
        </App:authorized>
    </div>

    <div class="card-body">
        <g:uploadForm controller="admin" action="register-student" enctype='multipart/form-data'>
            <g:hiddenField name="id" value="${user?.id}"></g:hiddenField>
            <div class="form-group">
                <label>Student ID</label>
                <g:textField name="stdId" placeholder="Student Id" value="${user?.stdId}" class="form-control"
                             required="true"></g:textField>
            </div>
            <g:render template="name_sex_dob"/>

            <App:emailField email="${user?.email}" id="email" spanId="email-error"/>
            <App:passwordField password="${user?.password}"/>
            <g:render template="semester_department"/>
            <div class="form-group">
                <input id="attachment" type="file" name="image" accept="image/*"/>
                <span id="attachment-msg">Max file size is 5MB</span>
            </div>

            <div class="form-group">
                <g:submitButton id="update-btn" name="submit" class="btn btn-primary"></g:submitButton>
            </div>
        </g:uploadForm>
    </div>
</div>
<script type="text/javascript">

    validateImage('#attachment', '#attachment-msg', '#update-btn')
        validateEmail('#email', '#email-error', '#update-btn')
        validateSemester('#semester-opt', '#semester-span', '#update-btn')
        validateDepartment('#dept-opt', '#dept-span', '#update-btn')

    //     $('#update-btn').prop('disabled', false);
    // } else {
    //     $('#update-btn').prop('disabled', true);

    // }
</script>