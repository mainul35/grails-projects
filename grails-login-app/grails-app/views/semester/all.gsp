<title>All semesters</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        All semesters
    </div>

    <div class="card-body">
        <table class="table">
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
                                    action="details" params="[id: semester.id]"><span class="fa fa-eye fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-primary" controller="semester"
                                    action="edit" params="[id: semester.id]"><span class="fa fa-pencil fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-danger" controller="semester"
                                    action="delete" params="[id: semester.id]"><span class="fa fa-remove fa-lg"></span></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
