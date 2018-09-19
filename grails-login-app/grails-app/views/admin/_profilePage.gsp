<div class="container emp-profile">
    <div class="row">
        <div class="col-md-4">
            <div class="profile-img">
                <g:img dir="images" file="${admin.profileImageName?:'download.png'}" class="profile-img" width="80" height="100"/>
            </div>
        </div>

        <div class="col-md-8">
            <div class="profile-head">
                <div class="row">
                    <div class="col-7">
                        <h5>
                            Name:&nbsp;${admin?.name}
                        </h5>
                    </div>

                    <div class="col-5">
                        <a href="/admin/edit/${admin?.id}">&nbsp;<span class="fa fa-pencil "></span></a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label>Email</label>
                </div>

                <div class="col-md-6">
                    <p>${admin?.email}</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label>Gender</label>
                </div>

                <div class="col-md-6">
                    <p>${admin?.gender == 1 ? 'Male' : admin?.gender == 2 ? 'Female' : 'Other'}</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label>Date of Birth</label>
                </div>

                <div class="col-md-6">
                    <p><g:formatDate format="dd-MM-yyyy" date="${admin?.dateOfBirth}"/></p>
                </div>
            </div>
        </div>
    </div>
</div>
