<!doctype html>
<html>
<head>
    <meta name="layout" content="header"/>
    <title>View All Tasks</title>
</head>

<body class="bg-light">

<div class="container-fluid">
    <h1 class="text-center" style="color:#007bff;">${message}</h1>

    <div class="px-3 py-3 pt-md-5  text-center">
        <div class="row">
            <g:each var="task" in="${tasks}">
                <div class="col-sm-3">
                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src=".../100px180/" alt="Card image cap">

                        <div class="card-body">
                            <h5 class="card-title">${task.title}</h5>

                            <p class="card-text">${task.details}</p>
                            <a href="#" class="btn btn-primary">View more</a>
                        </div>
                    </div>
                </div>
            </g:each>
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
