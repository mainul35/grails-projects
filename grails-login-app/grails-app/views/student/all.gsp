<title>All students</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Displaying all students
    </div>

    <div class="card-body">
        <table class="table">
            <thead class="table-dark">
            <tr>
                <th>Student name</th>
                <th>Student email</th>
                <th>Sex</th>
                <th>Department</th>
                <th>Semester</th>
                <th class="action-row">Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="student" in="${students}">
                <tr>
                    <td><g:link controller="student"
                                action="profile" params="[id: student.id]">${student.name}</g:link></td>
                    <td>${student.email}</td>
                    <g:if test="${student.gender == 1}">
                        <td>Male</td>
                    </g:if>
                    <g:elseif test="${student.gender == 2}">
                        <td>Female</td>
                    </g:elseif>
                    <g:else>
                        <td>Other</td>
                    </g:else>
                    <td>${student.department.name}</td>
                    <td><g:link controller="semester"
                                action="details" params="[id: student.semester.id]">${student.semester.name}</g:link></td>
                    <td>
                        <div class="btn-group">
                            <g:link type="button" class="btn btn-primary" controller="student"
                                    action="edit" params="[id: student.id]"><span class="fa fa-pencil fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-danger" controller="student"
                                    action="delete" params="[id: student.id]"><span class="fa fa-remove fa-lg"></span></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>