<title>All departments</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        All departments
    </div>

    <div class="card-body">
        <table class="table table-dark table-hover">
            <thead>
            <tr>
                <th class="sortable">Department name</th>
                <th class="action-row">Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="department" in="${departments}">
                <tr>
                    <td>${department.name}</td>
                    <td>
                        <div class="btn-group">
                            <g:link type="button" class="btn btn-primary" controller="department"
                                    action="edit" params="[id: department.id]">Edit</g:link>
                            <g:link type="button" class="btn btn-danger" controller="department"
                                    action="delete" params="[id: department.id]">Delete</g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>