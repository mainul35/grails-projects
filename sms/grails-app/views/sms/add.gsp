<!doctype html>
<html>
<head>
    <meta name="layout" content="header"/>
    <title>Add new student</title>
</head>

<body class="bg-light">

<div class="container-fluid">
    <g:hasErrors>
        <g:eachError><p><g:message error="${it}"/></p></g:eachError>
    </g:hasErrors>
    <form id="stdAddForm" action="/sms/add" onsubmit="return validateForm()" method="post">
        <div class="row">
            <div class="form-group col-md-12">
                <label for="name">Name</label>
                <input type="text" class="form-control" placeholder="Student Name" onkeyup="isNameEmpty(this); isAlreadyExists(this);" id="name" name="name"/>
                <span id="nameErr"></span>
            </div>

            <div class="form-group col-md-12">
                <label for="name">Age</label>
                <input type="number" class="form-control" placeholder="Age" id="age" onkeyup="isAgeEmpty(this)" name="age"
                       onkeypress="return isNumber(event)"/>
                <span id="ageErr"></span>
            </div>

            <div class="form-group col-md-12">
                <input type="submit" value="Save" class="btn btn-primary"/>
            </div>
        </div>
    </form>
</div>

<asset:javascript src="validator.js"/>
</body>
</html>
