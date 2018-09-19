<title>Semester details</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Create semester
    </div>

    <div class="card-body">

        <table class="table">
            <tbody><tr>
                <th class="text-right">Course Name</th><td class="text-left">${semester.name}</td>
            </tr>

            <tr>
                <th class="text-right">Semester duration</th>
                <td class="text-left">
                        ${semester.duration}
                </td>
            </tr>

            <tr>
                <th class="text-right">Offered courses</th>
                <td class="text-left">
                    <ul>
                        <g:each var="course" in="${semester.offeredCourses}">
                            <li>&nbsp;${course.name}</li>
                        </g:each>
                    </ul>
                </td>
            </tr>
            <tr>
                <th class="text-right">Registered students</th>
                <td class="text-left">
                    <ul>
                        <g:each var="student" in="${semester.students}">
                            <li><g:link controller="student"
                                        action="profile" params="[id: student.id]">${student.name}</g:link></li>
                        </g:each>
                        <g:if test="${semester.students.isEmpty()}">
                            <p>None</p>
                        </g:if>
                    </ul>
                </td>
            </tr>
            </tbody></table>
        <App:authorized role="ROLE_ADMIN">
            <div class="form-action-panel">
                <a href="/semester/all" class="btn btn-primary">Cancel</a>
            </div>
        </App:authorized>
    </div>
</div>