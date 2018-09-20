<div class="form-group">
    <label>Student Name</label>
    <g:textField name="name"  value="${user?.name}" placeholder="Name" class="form-control" required="true"></g:textField>
    <App:renderErrorMessage fieldName="name" model="${user}" errorMessage="please.enter.first.name"/>
</div>
<div class="form-group">
    <label>Sex</label><br/>
    <g:radioGroup name="gender"
                  labels="['Male', 'Female', 'Other']"
                  value="${user?.gender}"
                  values="[1, 2, 3]">
        <span>${it.radio} &nbsp;${it.label}</span>
    </g:radioGroup>
</div>

<div class="form-group">
    <label>Date of Birth</label>
    <g:datePicker name="dateOfBirth" value="${user?.dateOfBirth?:new Date()}"
                  precision="day" years="${1990..2018}"/>
</div>
