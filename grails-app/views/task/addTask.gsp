<!doctype html>
<html>
<head>
    <meta name="layout" content="header"/>
    <title>Add Task</title>
</head>

<body class="bg-light">

<div class="container-fluid">
    <h1 class="text-center" style="color:#007bff;">${message}</h1>

    <div class="px-3 py-3 pt-md-5  text-center">
        <g:if test="${ task != null  && task.errors }"><p style="color: #ac2925">${task.errors}</p></g:if>
        <div class="row">
            <form action="/task/addTask_POST" method="post">
                <div class="row">
                    <div class="form-group col-md-12">
                        <input type="text" class="form-control" placeholder="Title" id="title" name="title"/>
                    </div>
                    <div class="form-group col-md-12">
                        <input type="text" class="form-control" placeholder="Description" name="details" id="details"/>
                    </div>
                    <div class="form-group col-md-12">
                        <input type="date" class="form-control" placeholder="Deadline" name="deadline" id="deadline"/>
                    </div>
                    <div class="form-group col-md-12">
                        <input type="submit" value="Save" class="btn btn-primary"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">© 2017-2018 Company Name</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>

<script>

    // For JQuery datatable
    // $(document).ready(function () {
    //     $('#example').DataTable();
    // });
</script>

</body>
</html>
