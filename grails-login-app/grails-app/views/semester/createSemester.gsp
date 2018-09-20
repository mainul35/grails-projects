<title>Create semester</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Create semester
        <span class="float-right">
            <div class="btn-group">
                <g:link action="all" controller="semester" class="btn btn-success">All semesters</g:link>
                <g:link action="statistics" controller="semester" class="btn btn-primary">View statistics</g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <g:form controller="semester" action="create">
            <g:hiddenField name="id" value="${System.currentTimeMillis()}"></g:hiddenField>
            <g:render template="form"/>
            <div class="form-group">
                <g:submitButton name="submit" class="btn btn-primary">Save</g:submitButton>
                <g:link controller="semester" action="all" class="btn btn-success">View all</g:link>
            </div>
        </g:form>

    </div>
</div>

