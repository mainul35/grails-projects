<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Edit Profile of ${user.name}
    </div>

    <div class="card-body">
        <g:uploadForm controller="admin" action="update" enctype='multipart/form-data'>
            <g:hiddenField name="id" value="${user?.id}"></g:hiddenField>
            <App:editProfile user="${user}"/>
            <App:emailField email="${user?.email}" id="email" spanId="email-error"/>
            <App:renderErrorMessage fieldName="email" model="${user}" errorMessage="please.enter.first.name"/>
            <div class="form-group">
                <input id="attachment" type="file" name="image" accept="image/*"/>
                <span id="attachment-msg">Max file size is 5MB</span>
            </div>

            <div class="form-group">
                <g:submitButton id="update-btn" name="Update" class="btn btn-primary btn-lg"></g:submitButton>
            </div>
        </g:uploadForm>
    </div>
</div>
<script type="text/javascript">
    validateImage('#attachment', '#attachment-msg', '#update-btn')
    validateEmail('#email', '#email-error', '#update-btn')

</script>