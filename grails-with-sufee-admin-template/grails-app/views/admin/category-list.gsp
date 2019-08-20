<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View All Categories</title>
    <meta name="layout" content="admin"/>
</head>

<body>
<div class="breadcrumbs">
    <div class="col-sm-4">
        <div class="page-header float-left">
            <div class="page-title">
                <h1>View Category panel</h1>
            </div>
        </div>
    </div>

    <div class="col-sm-8">
        <div class="page-header float-right">
            <div class="page-title">
                <ol class="breadcrumb text-right">
                </ol>
            </div>
        </div>
    </div>
</div>

<div class="content mt-3">
    <table id="example2" class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Change Status</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${items}" var="item" status="i">
            <tr>
                <td>${i + 1}</td>
                <td>${item.categoryName}
                </td>
                <td></td>
            </tr>
        </g:each>
        </tbody>
        <tfoot>
        </tfoot>
    </table>
</div> <!-- .content -->
</body>
<script type="text/javascript">
    jQuery(function ($) {
        $('#example2').DataTable({
            'paging'      : true,
            'lengthChange': false,
            'searching'   : false,
            'ordering'    : true,
            'info'        : true,
            'autoWidth'   : false
        })
    })
</script>
</html>
