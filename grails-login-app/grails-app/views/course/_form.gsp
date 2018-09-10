<div class="form-group">
    <label>Course Name</label>
    <g:textField name="name" placeholder="Course Name" value="${course?.name}" class="form-control" required="true"/>
</div>

<div class="form-group">
    <label>Course Code</label>
    <g:textField name="code" placeholder="Course Code" class="form-control" value="${course?.code}" required="true"/>
</div>

<div class="form-group">
    <label>Course Credit</label>
    <g:field type="text" name="courseCredits" placeholder="Credit Hours" class="form-control" value="${course?.courseCredits}" required="true"/>
</div>