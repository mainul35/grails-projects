<title>All cources</title>
<meta name="layout" content="header"/>


<div class="card">
    <div class="card-header">
        Showing all cources
    </div>

    <div class="card-body">

        %{--<App:msg status="${status}" msg="${msg}"/>--}%
        <table class="table">
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
                            <g:link type="button" class="btn btn-primary" controller="course"
                                    action="edit" params="[id: course.id]"><span class="fa fa-pencil fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-danger" controller="course"
                                    action="delete" params="[id: course.id]"><span class="fa fa-remove fa-lg"></span></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
