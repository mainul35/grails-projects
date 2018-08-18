<!doctype html>
<html>
<head>
    <meta name="layout" content="header"/>
    <title>Add new student</title>
</head>

<body class="bg-light">

<div class="container-fluid">
    <form name="stdAddForm" onsubmit="return show()">
        <div class="row">
            <div class="form-group col-md-12">
                <label for="name">Name</label>
                <input type="text" class="form-control" placeholder="Student Name" id="name" name="name"/>
                <span id="nameErr"></span>
            </div>

            <div class="form-group col-md-12">
                <input type="submit" value="Search" class="btn btn-primary"/>
            </div>
            <h4 id="result"></h4>
        </div>
    </form>
</div>

<script>
    function show() {
        var name = document.forms["stdAddForm"]["name"].value;

        $.ajax({
            url: "/sms/find-by-name?name="+name,
            method: 'GET',
            success: function(data){
                if(data=='{}'){
                    $('#result').text('There is no student named '+name)
                }else{
                    console.log(data)
                    $('#result').text(data.name+"'s age is "+ data.age)
                }
            }
        });

        return false;
    }
</script>

</body>
</html>
