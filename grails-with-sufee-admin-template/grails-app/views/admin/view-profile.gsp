<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User profile</title>
    <meta name="layout" content="admin"/>
</head>

<body>
<div class="container-fluid">

    <g:if test="${user != null}">

        <div class="row">
            <div class="col-3">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="v-pills-basic-info-tab" data-toggle="pill" href="#v-pills-home" role="tab"
                       aria-controls="v-pills-home" aria-selected="true">Basic info</a>
                    <a class="nav-link" id="v-pills-address-tab" data-toggle="pill" href="#v-pills-profile" role="tab"
                       aria-controls="v-pills-profile" aria-selected="true">Address</a>
                    <a class="nav-link" id="v-pills-contact-tab" data-toggle="pill" href="#v-pills-messages" role="tab"
                       aria-controls="v-pills-messages" aria-selected="false">Contact</a>
                </div>
            </div>

            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel"
                         aria-labelledby="v-pills-home-tab">
                        <div class="row" style="margin-top: 1%;">
                            <div class="col-2">
                                <img src="${resource(dir: 'images', file: 'default.png')}" alt="Profile picture"/>
                            </div>

                            <div class="col-10">
                                <g:if test="${user instanceof sm.trading.erp.User}">
                                    <h5>${user.firstName + ' ' + user.lastName}</h5>
                                    <br/>
                                    <p>
                                        Position: ${user.position}<br/>
                                        Joining date: ${user.position.equalsIgnoreCase('admin') ? formatDate(format: 'dd-MM-yyyy', date: user.joiningDate) : 'N/A'}<br/>
                                        <g:if test="${user.leavingDate != null}">
                                            Leaving date: ${user.position.equalsIgnoreCase('admin') ? formatDate(format: 'dd-MM-yyyy', date: user.leavingDate) : 'N/A'}<br/>
                                        </g:if>
                                        Status:&nbsp;
                                        <g:if test="${user.accountLocked == true}">
                                            <span style="color: #f55443">Locked</span>
                                        </g:if>
                                        <g:if test="${user.accountLocked == false}">
                                            <span style="color: #00bf8f">Active</span>
                                        </g:if>
                                        <g:if test="${user.accountExpired == true}">
                                            <span style="color: #f55443">Retired</span>
                                        </g:if>

                                    </p>
                                </g:if>
                                <g:if test="${user instanceof sm.trading.erp.ExternalUser}">
                                    Internal User
                                </g:if>
                            </div>
                        </div>
                    </div>

                    <div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
                         aria-labelledby="v-pills-profile-tab">
                        <div class="row" style="margin-top: 1%;">
                            <div class="col-2">
                                <img src="${resource(dir: 'images', file: 'default.png')}" alt="Profile picture"/>
                            </div>

                            <div class="col-10">
                                <g:if test="${user instanceof sm.trading.erp.User}">
                                    <h5>${user.firstName + ' ' + user.lastName}</h5>
                                    <br/>
                                    <p>
                                        Address: ${user.address}
                                    </p>
                                </g:if>
                                <g:if test="${user instanceof sm.trading.erp.ExternalUser}">
                                    Internal User
                                </g:if>
                            </div>
                        </div>
                    </div>

                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
                         aria-labelledby="v-pills-messages-tab">
                        <div class="row" style="margin-top: 1%;">
                            <div class="col-2">
                                <img src="${resource(dir: 'images', file: 'default.png')}" alt="Profile picture"/>
                            </div>

                            <div class="col-10">
                                <g:if test="${user instanceof sm.trading.erp.User}">
                                    <h5>${user.firstName + ' ' + user.lastName}</h5>
                                    <br/>

                                    <p>
                                        Mail: ${user.email}<br/>
                                        Mobile: ${user.contact}
                                    </p>
                                </g:if>
                                <g:if test="${user instanceof sm.trading.erp.ExternalUser}">
                                    Internal User
                                </g:if>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </g:if>
    <g:if test="${user == null}">
        <div class="sufee-alert alert with-close alert-danger" role="alert">
            <span class="badge badge-pill badge-danger">Oops!</span>
            <h5>Sorry, We could not find the profile you are looking for.</h5>
        </div>
    </g:if>
</div>
<script>

</script>
</body>
</html>
