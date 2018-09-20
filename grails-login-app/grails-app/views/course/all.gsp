<title>All cources</title>
<meta name="layout" content="header"/>


<div class="card">
    <div class="card-header">
        <span class="float-left">
        Showing all cources
        </span>

        <span class="float-right">
            <div class="btn-group">
                <g:form controller="course" action="find" method="GET">
                    <div class="input-group" id="search-area">
                        <g:select name="colName" class="form-control" from="[name:'Course name', code:'Course code']" value="${params?.colName}" optionKey="key" optionValue="value"/>
                        <g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit">Search</button>
                        </span>
                    </div>
                </g:form>
            </div>
            <div class="btn-group">
                <g:link action="create" controller="course" class="btn btn-success">New course</g:link>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <th class="sortable">Course name</th>
                <th>Course code</th>
                <th>Credits</th>
                <th class="action-row">Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="course" in="${courses}">
                <tr>
                    <td>${course.name}</td>
                    <td>${course.code}</td>
                    <td>${course.courseCredits}</td>
                    <td>
                        <div class="btn-group">
                            <g:link type="button" class="btn btn-success" controller="course"
                                    action="details" params="[id: course.id]"><span class="fa fa-eye fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-primary" controller="course"
                                    action="edit" params="[id: course.id]"><span class="fa fa-pencil fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-danger" controller="course"
                                    action="delete" params="[id: course.id]"><span class="fa fa-remove fa-lg delete-confirmation"></span></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
