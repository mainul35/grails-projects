<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add role</title>
    <meta name="layout" content="admin"/>
</head>

<body>
<div class="breadcrumbs">
    <div class="col-sm-4">
        <div class="page-header float-left">
            <div class="page-title">
                <h1>Role Management panel</h1>
            </div>
        </div>
    </div>

    <div class="col-sm-8">
        <div class="page-header float-right">
            <div class="page-title">
                <ol class="breadcrumb text-right">
                    <li class="active">Create Role</li>
                </ol>
            </div>
        </div>
    </div>
</div>

<div class="content mt-3">

    <app:alert msg="${msg}" status="${status}"/>

    <form action="/admin/add-role" method="post">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-header"><strong>Add Role&nbsp;</strong><small>Form</small></div>

                <div class="card-body card-block">
                    <div class="form-group"><label for="role" class=" form-control-label">Role Name</label><input
                            type="text" name="authority" id="role" placeholder="Ex: admin" class="form-control"></div>

                    <div class="form-group">
                        <input type="submit" value="Create" class="btn btn-primary"/>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div> <!-- .content -->

</body>
</html>
