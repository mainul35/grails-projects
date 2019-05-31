<g:if test="${!msg.empty}">
    <div class="col-sm-12">
        <div class="alert  alert-${status} alert-dismissible fade show" role="alert">
            <span class="badge badge-pill badge-${status}">${status.charAt(0).toUpperCase()}${status.substring(1)}</span> ${msg}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
        </div>
    </div>
</g:if>