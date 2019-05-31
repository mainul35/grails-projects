<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
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

        <div class="content mt-3 text-center">
            <div class="animated fadeIn">

                <div class="card">
                    <div class="card-header">
                        <strong class="card-title">Users</strong>
                    </div>

                    <div class="card-body">
                        <div id="bootstrap-data-table_wrapper"
                        class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
                        <div class="row">
                            <div class="col-sm-12 col-md-6">
                                %{--<div class="dataTables_length" id="bootstrap-data-table_length">--}%
                                    %{--<label>Show <select name="bootstrap-data-table_length"--}%
                                                        %{--aria-controls="bootstrap-data-table"--}%
                                                        %{--class="form-control form-control-sm">--}%
                                        %{--<option value="10">10</option>--}%
                                        %{--<option value="20">20</option>--}%
                                        %{--<option value="50">50</option>--}%
                                        %{--<option value="-1">All</option>--}%
                                    %{--</select> entries</label>--}%
                                %{--</div>--}%
                            </div>

                            <div class="col-sm-12 col-md-6">
                                <div id="bootstrap-data-table_filter" class="dataTables_filter">
                                    <label>Search:<input type="search" id="search" class="form-control form-control-sm"
                                        placeholder="Search" onkeyup="return searchUser(this.id)"
                                        aria-controls="bootstrap-data-table"/>
                                    </label>
                                </div>
                            </div>
                        </div>

                %{--        Card view       --}%
                        <div id="cards" class="row">
                            <g:each var="user" in="${users}">
                                <div class="card col-4" style="width:20rem;margin:20px 0 24px 0">

                                    <img class="card-img-top" src="${resource(dir: 'images', file: user?.profileImage?:'/default.png')}"
                                         alt="image" style="margin:1%"/>

                                         <div class="card-body">
                                        <a style="color: #007bff;" href="/admin/view-profile?username=${user.username}">
                                            <h4 class="card-title">${user.firstName.concat(' ').concat(user.lastName)}</h4>
                                        </a>

                                        <p class="card-text">Email:&nbsp;${user.email}<br/>
                                            Contact:&nbsp;${user.contact}<br/>
                                        </p>
                                        <g:if test="${!user.accountLocked}">
                                            <a href="/admin/change-lock-status?id=${user.id}" class="btn btn-danger">
                                                <span class="fa fa-lock"></span>&nbsp;Lock
                                            </a>
                                        </g:if>
                                        <g:if test="${user.accountLocked}">
                                            <a href="/admin/change-lock-status?id=${user.id}" class="btn btn-success">
                                                <span class="fa fa-unlock"></span>&nbsp;Unlock
                                            </a>
                                        </g:if>
                                        <g:if test="${!user.accountExpired}">
                                            <a href="/admin/change-expire-status?id=${user.id}" class="btn btn-danger">
                                                <span class="fa fa-lock"></span>&nbsp;Expire Account
                                            </a>
                                        </g:if>
                                        <g:if test="${user.accountExpired}">
                                            <p style="color: #9f191f;">Account Expired</p>
                                        </g:if>
                                    </div>
                                </div>
                            </g:each>
                        </div>


                    %{--<div class="row">--}%
                        %{--<div class="col-sm-12 col-md-5">--}%
                            %{--<div class="dataTables_info"--}%
                                 %{--id="bootstrap-data-table_info" role="status"--}%
                                 %{--aria-live="polite">Showing 1 to 1 of 1 entries</div>--}%
                        %{--</div>--}%

                        %{--<div class="col-sm-12 col-md-7">--}%
                            %{--<div class="dataTables_paginate paging_simple_numbers"--}%
                                 %{--id="bootstrap-data-table_paginate">--}%
                                %{--<ul--}%
                                        %{--class="pagination">--}%
                                    %{--<li class="paginate_button page-item previous disabled"--}%
                                        %{--id="bootstrap-data-table_previous">--}%
                                        %{--<a href="#"--}%
                                           %{--aria-controls="bootstrap-data-table"--}%
                                           %{--data-dt-idx="0"--}%
                                           %{--tabindex="0"--}%
                                           %{--class="page-link">Previous</a>--}%
                                    %{--</li>--}%
                                    %{--<li class="paginate_button page-item active">--}%
                                        %{--<a href="#"--}%
                                           %{--aria-controls="bootstrap-data-table"--}%
                                           %{--data-dt-idx="1" tabindex="0"--}%
                                           %{--class="page-link">1</a>--}%
                                    %{--</li>--}%
                                    %{--<li--}%
                                            %{--class="paginate_button page-item next disabled"--}%
                                            %{--id="bootstrap-data-table_next">--}%
                                        %{--<a href="#" aria-controls="bootstrap-data-table"--}%
                                           %{--data-dt-idx="2" tabindex="0"--}%
                                           %{--class="page-link">Next</a>--}%
                                    %{--</li>--}%
                                %{--</ul>--}%
                            %{--</div>--}%
                        %{--</div>--}%
                    %{--</div>--}%
                    </div>
                </div>
            </div>
        </div><!-- .animated -->
    </div><!-- .content -->

<asset:javascript src="js/script.js"></asset:javascript>
</body>
</html>
