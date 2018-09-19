<title>Edit semester</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Edit semester
    </div>

    <div class="card-body">
        <g:form controller="semester" action="update">
            <g:hiddenField name="id" value="${semester.id}"></g:hiddenField>
            <g:render template="form"/>
            <div class="form-group">
                <label>Current courses</label>

                <p>
                    <g:each var="course" in="${semester.offeredCourses}">
                        &nbsp;${course.name},
                    </g:each>
                </p>
            </div>

            <div class="form-group">
                <g:submitButton name="submit" class="btn btn-primary">Update</g:submitButton>
                <g:link controller="semester" action="all" class="btn btn-success">View all</g:link>
            </div>
        </g:form>

    </div>
</div>
