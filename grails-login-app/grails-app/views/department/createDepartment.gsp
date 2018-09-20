<title>Create department</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Create department
        <span class="float-right">
            <div class="btn-group">
                <g:link action="all" controller="department" class="btn btn-success">All departments</g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <g:form controller="department" action="create">
            <g:hiddenField name="id" value="${System.currentTimeMillis()}"></g:hiddenField>
            <g:render template="form"/>
            <div class="form-group">
                <g:submitButton name="Create" class="btn btn-primary"/>&nbsp;
                <g:link controller="department" action="all" class="btn btn-success">View all</g:link>
            </div>
        </g:form>
    </div>
</div>
