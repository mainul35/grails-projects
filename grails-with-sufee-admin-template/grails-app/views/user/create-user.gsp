<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create User</title>
    <meta name="layout" content="header"/>
</head>

<body>
<div class="container">

    <form>
        <div class="form-group">
            <label for="firstName">First name</label>
            <input type="text" class="form-control mr-sm-2" name="firstName" id="firstName"
                   placeholder="First Name"/>
        </div>

        <div class="form-group">
            <label for="lastName">Last name</label>
            <input type="text" class="form-control mr-sm-2" name="lastName" id="lastName"
                   placeholder="Last Name"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control mr-sm-2" name="email" id="email"
                   placeholder="Email"/>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control mr-sm-2" name="password"
                   id="password" placeholder="Password"/>
        </div>
        <div class="form-group">
            <label for="contact">Contact</label>
            <input type="password" class="form-control mr-sm-2" name="contact"
                   id="contact" placeholder="Contact"/>
        </div>
        %{--<input type="text" name="fName" id="fName"/>--}%
        <input type="submit" class="btn btn-primary"/>
    </form>

</div>
</body>
</html>
