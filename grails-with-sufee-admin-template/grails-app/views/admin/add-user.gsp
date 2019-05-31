<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add User</title>
    <meta name="layout" content="admin"/>

</head>

<body>
<div class="breadcrumbs">
    <div class="col-sm-4">
        <div class="page-header float-left">
            <div class="page-title">
                <h1>User Management panel</h1>
            </div>
        </div>
    </div>

    <div class="col-sm-8">
        <div class="page-header float-right">
            <div class="page-title">
                <ol class="breadcrumb text-right">
                    <li class="active">Add User</li>
                </ol>
            </div>
        </div>
    </div>
</div>

<div class="content mt-3">

    <app:alert msg="${msg}" status="${status}"/>

    <g:uploadForm controller="admin" action="add-user" method="post" enctype='multipart/form-data'>
        <div class="col-lg-12">
            <div class="card">
                <div class="card-header"><strong>Add User&nbsp;</strong><small>Form</small></div>

                <div class="card-body card-block">
                    <appUser:nameField firstName="${user?.firstName}" lastName="${user?.lastName}"/>
                    <appUser:emailPasswordField email="${user?.email}" password="${user?.password}"/>
                    <appUser:contactField contact="${user?.contact}" />
                    <appUser:addressField address="${user?.address}"/>
                    <appUser:positionField position="${user?.position}"/>
                    <appUser:roleAssigningField roles="${user?.roles}"/>

                    <div class="form-group">
                        <label for="joiningDate">Joining Date</label>
                        <g:datePicker type="date" class="form-control mr-sm-2" placeholder="Joining Date" name="joiningDate"
                                      id="joiningDate" value="${user?.joiningDate}"
                                      precision="day" years="${2000..2050}"/>
                    </div>

                    <app:fileField/>

                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" value="Create User"/>
                    </div>
                </div>
            </div>
        </div>
    </g:uploadForm>
</div> <!-- .content -->
<script src="/assets/js/lib/chosen/chosen.jquery.min.js"></script>
<script>
    jQuery(document).ready(function () {
        jQuery(".standardSelect").chosen({
            disable_search_threshold: 10,
            no_results_text: "Oops, nothing found!",
            width: "100%"
        });
    });
</script>
</body>

</html>
