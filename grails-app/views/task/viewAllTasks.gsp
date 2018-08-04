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

                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        %{--<img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22508%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20508%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_16502319e25%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A25pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_16502319e25%22%3E%3Crect%20width%3D%22508%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22169.7578125%22%20y%3D%22123.6%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">--}%
                        <div class="card-body">
                            <h5 class="card-title">${task.title}</h5>

                            <p class="card-text">${task.details}</p>

                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" data-toggle="modal" data-target="#viewTaskDetails" data-title="${task.title}" id="${task.id}" onclick="viewMore(this)"
                                            class="btn btn-sm btn-outline-secondary">View</button>
                                    %{--<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>--}%
                                </div>
                                <small class="text-muted"><g:formatDate format="dd-MM-yyyy HH:mm:ss a"
                                                                        date="${task.dateCreated}"/></small>
                            </div>
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


<!-- The Modal -->
<div class="modal" id="viewTaskDetails">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title" id="display-task-title"></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <h5 id="display-task-details"></h5><br>
                <p id="display-creation-date"></p>

            <p id="display-deadline"></p>
            <p id="display-status"></p>
            <p id="display-tags"></p>

        </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<script>

    // For JQuery datatable
    // $(document).ready(function () {
    //     $('#example').DataTable();
    // });
    function viewMore(elem) {
        var title = $(elem).data("title");
        $.ajax({
            url: "/task/viewMore?title="+title,
            success: function (result) {
                // console.log(result)
                $("#display-task-title").text(result.title)
                $("#display-task-details").text(result.details)
                $("#display-creation-date").html(moment(new Date(result.dateCreated)).format("MMMM Do YYYY, h:mm:ss a"))
                $("#display-deadline").text(moment(new Date(result.deadline)).format("MMMM Do YYYY, h:mm:ss a"))
                $("#display-status").text(result.status)
            },
            error: function (e) {
                console.log(e);
            }
        });
    }

</script>

</body>
</html>
