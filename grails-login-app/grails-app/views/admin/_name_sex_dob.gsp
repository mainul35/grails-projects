<div class="form-group">
    <label>Student Name</label>
    <g:textField name="name"  value="${student?.name}" placeholder="Student Name" class="form-control" required="true"></g:textField>
</div>
<div class="form-group">
    <label>Sex</label><br/>
    <g:radioGroup name="gender"
                  labels="['Male', 'Female', 'Other']"
                  value="${student?.gender}"
                  values="[1, 2, 3]">
        <span>${it.radio} &nbsp;${it.label}</span>
    </g:radioGroup>
</div>

<div class="form-group">
    <label>Date of Birth</label>
    <g:datePicker name="dateOfBirth" value="${student?.dateOfBirth?:new Date()}"
                  precision="day" years="${1990..2018}"/>
</div>
