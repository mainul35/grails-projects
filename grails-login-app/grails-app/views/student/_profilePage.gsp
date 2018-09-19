<div class="container emp-profile">
    <div class="row">
        <div class="col-md-4">
            <div class="profile-img">
                <g:img dir="images" file="${student?.profileImageName ?: 'download.png'}" class="profile-img" width="80"
                       height="100"/>
            </div>
        </div>

        <div class="col-md-8">
            <div class="profile-head">
                <div class="row">
                    <div class="col-7">
                        <h5>
                            Name:&nbsp;${student.name}
                        </h5>
                    </div>

                    <div class="col-5">
                        <a href="/student/edit/${student.id}">&nbsp;<span class="fa fa-pencil "></span></a>
                    </div>
                </div>
                <h6>
                    Student of ${student.department.name} department
                </h6>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label>Student ID</label>
                </div>

                <div class="col-md-6">
                    <p>${student.stdId}</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label>Email</label>
                </div>

                <div class="col-md-6">
                    <p>${student.email}</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label>Gender</label>
                </div>

                <div class="col-md-6">
                    <p>${student.gender == 1 ? 'Male' : student.gender == 2 ? 'Female' : 'Other'}</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label>Date of Birth</label>
                </div>

                <div class="col-md-6">
                    <p><g:formatDate format="dd-MM-yyyy" date="${student.dateOfBirth}"/></p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label>Semester</label>
                </div>

                <div class="col-md-6">
                <p><g:link controller="semester"
                           action="details" params="[id: student.semester.id]">${student.semester.name}</p></g:link>
                </div>
            </div>
        </div>
    </div>
</div>
