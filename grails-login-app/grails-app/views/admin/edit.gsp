<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Edit Profile of ${user.name}
    </div>

    <div class="card-body">
        <g:uploadForm controller="admin" action="update" enctype='multipart/form-data'>
            <g:hiddenField name="id" value="${user?.id}"></g:hiddenField>

            <App:editProfile email="${user.email}" password="" user="${user}"/>
            <div class="form-group">
                <input type="file" name="image"/>
            </div>

            <div class="form-group">
                <g:submitButton name="Update" class="btn btn-primary btn-lg"></g:submitButton>
            </div>
        </g:uploadForm>
    </div>
</div>