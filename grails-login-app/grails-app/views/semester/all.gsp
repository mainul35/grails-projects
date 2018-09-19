<title>All semesters</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        All semesters
    </div>

    <div class="card-body">
        <table class="table table-dark table-hover">
            <thead>
            <tr>
                <th>Semester name</th>
                <th>Semester durations</th>
                %{--<th>Details</th>--}%
                <th class="action-row">Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="semester" in="${semesters}">
                <tr>
                    <td>${semester.name}</td>
                    <td>${semester.duration}</td>
                    %{--<td><g:link type="button" class="btn btn-primary" controller="semester"--}%
                    %{--action="details" params="[id: semester.id]">Edit</g:link>--}%
                    %{--</td>--}%
                    <td>
                        <div class="btn-group">
                            <g:link type="button" class="btn btn-primary" controller="semester"
                                    action="edit" params="[id: semester.id]">Edit</g:link>
                            <g:link type="button" class="btn btn-danger" controller="semester"
                                    action="delete" params="[id: semester.id]">Delete</g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
