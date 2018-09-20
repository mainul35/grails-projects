<div class="form-group">
    <label>Semester</label>
    <g:select name="semester"
              from="${semesters}"
              noSelection="${['null': 'Select Semester...']}"
              optionValue="name"
              value="${user?.semester}"
              optionKey="id"
              class="form-control"
              id="semester-opt"
    />
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
              class="form-control"
              id="dept-opt"
    />
    <span id='dept-span'></span>
</div>