<g:if test="${status==true}">
    <div class="alert alert-success">
        <strong>${msg}</strong>
    </div>
</g:if>
<g:if test="${status==false}">
    <div class="alert alert-danger">
        <strong>${msg}</strong>
    </div>
</g:if>