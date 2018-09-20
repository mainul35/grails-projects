<title>All semesters</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        All semesters
        <span class="float-right">
            <div class="btn-group">
                <g:form controller="semester" action="find" method="GET">
                    <div class="input-group" id="search-area">
                        <g:select name="colName" class="form-control" from="[name: 'Semester name']"
                                  value="${params?.colName}" optionKey="key" optionValue="value"/>
                        <g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit">Search</button>
                        </span>
                    </div>
                </g:form>
            </div>

            <div class="btn-group">
                <g:link action="create" controller="semester" class="btn btn-success">Create semester</g:link>
                <g:link action="statistics" controller="semester" class="btn btn-primary">View statistics</g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <th>Semester name</th>
                <th>Semester durations</th>
                <th class="action-row">Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="semester" in="${semesters}">
                <tr>
                    <td>${semester.name}</td>
                    <td>${semester.duration}</td>
                    <td>
                        <div class="btn-group">
                            <g:link type="button" class="btn btn-success" controller="semester"
                                    action="details" params="[id: semester.id]"><span
                                    class="fa fa-eye fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-primary" controller="semester"
                                    action="edit" params="[id: semester.id]"><span
                                    class="fa fa-pencil fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-danger delete-confirmation" controller="semester"
                                    action="delete" params="[id: semester.id]"><span
                                    class="fa fa-remove fa-lg"></span></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
