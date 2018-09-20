<title>All departments</title>
<meta name="layout" content="header"/>

<div class="card">
    <div class="card-header">
        <span class="float-left">
            All departments
        </span>
        <span class="float-right">
            <div class="btn-group">
                <g:form controller="department" action="find" method="GET">
                    <div class="input-group" id="search-area">
                        <g:select name="colName" class="form-control" from="[name:'Department name']" value="${params?.colName}" optionKey="key" optionValue="value"/>
                        <g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit">Search</button>
                        </span>
                    </div>
                </g:form>
            </div>
            <div class="btn-group">
                <g:link action="create" controller="department" class="btn btn-success">Create department</g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <table class="table table-bordered">
            <thead class="table-dark">
            <tr>
                <th class="sortable">Department name</th>
                <th class="action-row">Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="department" in="${departments}">
                <tr>
                    <td>${department.name}</td>
                    <td>
                        <div class="btn-group">
                            <g:link type="button" class="btn btn-success" controller="department"
                                    action="details" params="[id: department.id]"><span class="fa fa-eye fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-primary" controller="department"
                                    action="edit" params="[id: department.id]"><span
                                    class="fa fa-pencil fa-lg"></span></g:link>
                            <g:link type="button" class="btn btn-danger delete-confirmation" controller="department"
                                    action="delete" params="[id: department.id]"><span
                                    class="fa fa-remove fa-lg"></span></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>