<div class="form-group">
    <label>Semester</label>
    <g:select name="semester"
              from="${semesters}"
              noSelection="${['null': 'Select Semester...']}"
              optionValue="name"
              value="${user?.semester?.id}"
              optionKey="id"
              class="form-control"/>
</div>

<div class="form-group">
    <label>Department</label>
    <g:select name="department" placeholder="Department"
              required="true"
              from="${departments}"
              noSelection="${['null': 'Select Department...']}"
              optionValue="name"
              value="${user?.department?.id}"
              optionKey="id"
              class="form-control"/>
</div>