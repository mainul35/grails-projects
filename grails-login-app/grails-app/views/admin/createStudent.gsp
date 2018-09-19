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
    $('#attachment').bind('change', function () {
        if(this.files[0].size > Math.ceil(5000000)){
            $('#attachment-msg').css( 'color', 'red' );
            $('#update-btn').prop( 'disabled', true );
        }
        else if(this.files[0].size < Math.ceil(5000000)){
            $('#attachment-msg').css( 'color', 'white' );
            $('#update-btn').prop( 'disabled', false );
        }
        $('#attachment-msg').text('This file size is: ' + Math.ceil(this.files[0].size / 1024) + " KB");
    });
</script>