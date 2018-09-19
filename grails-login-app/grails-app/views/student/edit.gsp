<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Edit Profile of ${user?.name}
    </div>

    <div class="card-body">
        <g:uploadForm controller="student" action="update" enctype='multipart/form-data'>
            <g:hiddenField name="id" value="${user?.id}"></g:hiddenField>
            <div class="form-group">
                <label>Student ID</label>
                <g:textField name="stdId" placeholder="Student Id" value="${user?.stdId}"
                             class="form-control" required="true" disabled="true"></g:textField>
            </div>
            <App:editProfile email="${user?.email}" password="" id="${user.id}" user="${user}"/>

            <App:authorized role="ROLE_ADMIN">
                <g:render template="/student/semester_department"/>
            </App:authorized>
            <div class="form-group">
                <input id="attachment" type="file" name="image"/>
                <span id="attachment-msg">Max file size is 5MB</span>
            </div>

            <div class="form-group">
                <g:submitButton name="Update" id="update-btn" class="btn btn-primary btn-lg"></g:submitButton>
            </div>
        </g:uploadForm>
    </div>
</div>

<script type="text/javascript">
    $('#attachment').bind('change', function () {
        $('#attachment-msg').text('This file size is: ' + this.files[0].size / 1024 + "KB");

        if(this.files[0].size>(5*1024*1024)){
            $('#attachment-msg').css( 'color', 'red' );
            $('#update-btn').prop( 'disabled', true );
        }else{
            $('#attachment-msg').css( 'color', 'white' );
            $('#update-btn').prop( 'disabled', false );
        }
    });
</script>
