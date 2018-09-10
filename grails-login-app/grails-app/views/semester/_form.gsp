<div class="form-group">
    <label>Semester name</label>
    <g:textField name="name" placeholder="Semester Name" value="${semester?.name}" class="form-control" required="true"></g:textField>
</div>
<div class="form-group">
    <label>Semester Duration</label>
    <g:textField name="duration" type="number" placeholder="Duration"  value="${semester?.duration}" class="form-control" required="true"></g:textField>
</div>
<div class="form-group">
    <label>Select courses</label>
    <g:select name="offeredCourses"
              from="${courses}"
              noSelection="${['null': 'Select One...']}"
              optionValue="name"
              optionKey="id"
              multiple="true"
              class="form-control"/>
</div>

<div class="form-group">
    <label>Academic year</label>
    <g:datePicker name="academicYear" class="form-control" placeholder="Academic Year" required="true"
                  value="${new Date()}"
                  precision="year" years="${1990..2018}"/>
</div>
