$('#attachment').bind('change', function () {
    if (this.files[0].size > Math.ceil(5000000)) {
        $('#attachment-msg').css('color', 'red');
        $('#update-btn').prop('disabled', true);
    }
    else if (this.files[0].size < Math.ceil(5000000)) {
        $('#attachment-msg').css('color', 'white');
        $('#update-btn').prop('disabled', false);
    }
    $('#attachment-msg').text('This file size is: ' + Math.ceil(this.files[0].size / 1024) + " KB");
});