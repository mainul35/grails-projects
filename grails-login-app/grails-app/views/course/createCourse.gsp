<title>Create course</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        <span class="float-left">
            Create course
        </span>
        <span class="float-right">
            <div class="btn-group">
                <g:link action="all" controller="course" class="btn btn-success">All courses</g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <g:form controller="course" action="create">
            <g:hiddenField name="id" value="${System.currentTimeMillis()}"></g:hiddenField>
            <g:render template="form"/>
            <div class="form-group">
                <g:submitButton name="Create" class="btn btn-primary"/>&nbsp;
                %{--<g:link controller="course" action="all" class="btn btn-success">View all</g:link>--}%
            </div>
        </g:form>
    </div>
</div>