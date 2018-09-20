<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Edit Profile of ${user?.name}
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
        <g:uploadForm controller="student" action="update" enctype='multipart/form-data' onsubmit="validate()">
            <g:hiddenField name="id" value="${user?.id}"></g:hiddenField>
            <div class="form-group">
                <label>Student ID</label>
                <g:textField name="stdId" placeholder="Student Id" value="${user?.stdId}"
                             class="form-control" required="true" disabled="true"></g:textField>
            </div>
            <App:editProfile user="${user}"/>
            <App:emailField email="${user?.email}" id="email" spanId="email-error"/>
            <App:authorized role="ROLE_ADMIN">
                <g:render template="/student/semester_department"/>
            </App:authorized>
            <div class="form-group">
                <input id="attachment" type="file" name="image" accept="image/*"/>
                <span id="attachment-msg">Max file size is 5 MB</span>
            </div>

            <div class="form-group">
                <g:submitButton name="Update" id="update-btn" class="btn btn-primary btn-lg"
                                onclick="validate()"></g:submitButton>
            </div>
        </g:uploadForm>
    </div>
</div>

<script type="text/javascript">
    // function validate() {
    validateImage('#attachment', '#attachment-msg', '#update-btn')
    validateEmail('#email', '#email-error', '#update-btn')
    validateSemester('#semester-opt', '#semester-span', '#update-btn')
    validateDepartment('#dept-opt', '#dept-span', '#update-btn')
    // ) {
    //     $('#update-btn').prop('disabled', false);
    //     // return true
    // } else {
    //     $('#update-btn').prop('disabled', true);
    //     // return false
    // }
    // }



</script>
