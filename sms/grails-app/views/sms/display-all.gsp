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

        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="std" in="${students}">
                <tr>
                    <td>${std.name}</td>
                    <td>${std.age}</td>
                </tr>
            </g:each>

            </tbody>
        </table>
    </div>
    <footer class="my-5 pt-5 text-muted text-center text-small">

    </footer>
</div>

</body>
</html>
