<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard</title>
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
                    <li class="active">View Roles</li>
                </ol>
            </div>
        </div>
    </div>
</div>

<div class="content mt-3">

    <div class="col-lg-12">
        <div class="card">
            <div class="card-header">
                <strong class="card-title">Displaying all roles</strong>
            </div>

            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Role</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each var="role" in="${roles}">
                        <tr>
                            <th scope="row">${role.id}</th>
                            <td>${role.authority}</td>
                        </tr>
                    </g:each>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div><!-- .content -->

</body>
</html>
