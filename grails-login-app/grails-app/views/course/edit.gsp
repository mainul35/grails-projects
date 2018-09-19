<title>Edit course</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Edit course
    </div>

    <div class="card-body">
        <g:form controller="course" action="update">
            <g:hiddenField name="id" value="${course.id}"/>
            <g:render template="form"/>
            <div class="form-group">
                <g:submitButton name="Update" class="btn btn-primary"/>&nbsp;
                <g:link controller="course" action="all" class="btn btn-success">View all</g:link>
            </div>
        </g:form>

    </div>
</div>