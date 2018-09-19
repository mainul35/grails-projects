<title>Edit department</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Edit department
    </div>

    <div class="card-body">
        <g:form controller="department" action="update">
            <g:hiddenField name="id" value="${department.id}"></g:hiddenField>
            <g:render template="form"/>
            <div class="form-group">
                <g:submitButton name="Update" class="btn btn-primary"/>&nbsp;
                <g:link controller="department" action="all" class="btn btn-success">View all</g:link>
            </div>
        </g:form>
    </div>
</div>
