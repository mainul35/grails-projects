<div class="form-group">
    <label>Semester</label>
    <g:select name="semester"
              from="${semesters}"
              noSelection="${['null': 'Select Semester...']}"
              optionValue="name"
              value="${user?.semester}"
              optionKey="id"
                id="semester-opt"
              class="form-control"/>
    <span id='semester-span'></span>
</div>

<div class="form-group">
    <label>Department</label>
    <g:select name="department" placeholder="Department"
              required="true"
              from="${departments}"
              noSelection="${['null': 'Select Department...']}"
              optionValue="name"
              value="${user?.department}"
              optionKey="id"
        id="dept-opt"
              class="form-control"/>
    <span id='dept-span'></span>
</div>