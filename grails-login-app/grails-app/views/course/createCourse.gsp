<title>Create course</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Create course
    </div>

    <div class="card-body">
        <g:form controller="course" action="create">
            <g:hiddenField name="id" value="${System.currentTimeMillis()}"></g:hiddenField>
            <g:render template="form"/>
            <div class="form-group">
                <g:submitButton name="Create" class="btn btn-primary"/>&nbsp;
                <g:link controller="course" action="all" class="btn btn-success">View all</g:link>
            </div>
        </g:form>
    </div>
</div>