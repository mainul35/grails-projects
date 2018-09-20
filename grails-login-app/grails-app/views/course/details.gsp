<title>Semester details</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        Create semester
    </div>

    <div class="card-body">

        <table class="table">
            <tbody>
            <tr>
                <th class="text-right">Course name</th><td class="text-left">${course.name}</td>
            </tr>
            <tr>
                <th class="text-right">Course code</th><td class="text-left">${course.code}</td>
            </tr>
            <tr>
                <th class="text-right">Course credit</th><td class="text-left">${course.courseCredits}</td>
            </tr>
            </tbody>
        </table>
        <App:authorized role="ROLE_ADMIN">
            <div class="form-action-panel">
                <a href="/course/all" class="btn btn-primary">Cancel</a>
            </div>
        </App:authorized>
    </div>
</div>