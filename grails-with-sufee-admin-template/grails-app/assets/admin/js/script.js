function searchUser(id) {
    var searchTerm = document.getElementById(id).value;
    var $ = jQuery
    $.ajax({
        url: "/admin/search-user?searchTerm="+searchTerm,
        method: 'GET',
        success: function(data){
            if(data.length==0){
                $('#cards').html('')
                $('#cards').html('<div class="sufee-alert alert with-close alert-danger alert-dismissible fade show">\n' +
                    '                                            <span class="badge badge-pill badge-danger">Sorry</span>\n' +
                    '                                                We failed to find any user with this name.\n' +
                    '                                              <button type="button" class="close" data-dismiss="alert" aria-label="Close">\n' +
                    '                                                <span aria-hidden="true">×</span>\n' +
                    '                                            </button>\n' +
                    '                                        </div>')
            }else{
                $('#cards').html('')
                for(var i = 0; i<data.length; i++){
                    console.log(data)
                    $('#cards').append(
                        '<div class="card col-4" style="width:20rem;margin:20px 0 24px 0">\n' +
                        '\n' +
                        '                            <img class="card-img-top" src="/assets/default.png" alt="image" style="width:100%">\n' +
                        '\n' +
                        '                            <div class="card-body">\n' +
                        '                                <a style="color: #007bff;" href="/admin/view-profile?username=mainul35">\n' +
                        '                                    <h4 class="card-title">'+data[i].firstName+' '+data[i].lastName+'</h4>\n' +
                        '                                </a>\n' +
                        '\n' +
                        '                                <p class="card-text">Email:&nbsp;'+data[i].email+'<br>\n' +
                        '                                    Contact:&nbsp;'+data[i].contact+'<br>\n' +
                        '                                </p>\n' +
                        '                                \n' +
                        '                                \n' +
                        '                                    <span id="accountLocked{{data[i].id}}"></span>\n' +
                        '                                \n' +
                        '                                \n' +
                        '                                \n' +
                        '                                    <span id="accountExpired{{data[i].id}}"></span>\n' +
                        '                                \n' +
                        '                            </div>\n' +
                        '                        </div>'
                    )

                    if(data[i].accountLocked){
                        $('#accountLocked{{data[i].id}}').append('<a href="/admin/change-lock-status?id='+data[i].id+'" class="btn btn-success">\n' +
                            '                     <span class="fa fa-unlock"></span>&nbsp;Unlock\n' +
                            '                     </a>'
                        )
                    }
                    if(!data[i].accountLocked){
                        $('#accountLocked{{data[i].id}}').append('<a href="/admin/change-lock-status?id='+data[i].id+'" class="btn btn-danger">\n' +
                            '                     <span class="fa fa-lock"></span>&nbsp;Lock\n' +
                            '                     </a>'
                        )
                    }
                    if(!data[i].accountExpired){
                        $('#accountExpired{{data[i].id}}').append('<a href="/admin/change-expire-status?id='+data[i].id+'" class="btn btn-danger">\n' +
                            '                     <span class="fa fa-lock"></span>&nbsp;Expire Account\n' +
                            '                     </a>'
                        )
                    }
                    if(data[i].accountExpired){
                        $('#accountExpired{{data[i].id}}').append('<p style="color: #9f191f;">Account Expired</p>')
                    }
                }
            }
        }
    });
    return false;
}
