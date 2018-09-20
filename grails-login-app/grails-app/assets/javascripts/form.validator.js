function validateImage(input, span, button) {
    $(input).bind('change', function () {
        if (this.files[0].size > Math.ceil(5000000)) {
            $(span).css('color', 'red');
        }
        else if (this.files[0].size < Math.ceil(5000000)) {
            $(span).css('color', 'white');
        }
        $(span).text('This file size is: ' + Math.ceil(this.files[0].size / 1024) + ' KB');

        var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png"];

        var sFileName = this.files[0].name;

        var blnValid = false;
        for (var j = 0; j < _validFileExtensions.length; j++) {
            var sCurExtension = _validFileExtensions[j];
            if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                blnValid = true;
                break;
            }
        }

        if (!blnValid) {
            $(span).text("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "))
            $(span).css('color', 'red');
            return false
        }else{
            $(span).text("")
            $(span).css('color', 'white');
            return true
        }

    });


}

function validateCredit(input, span, button) {
    $(input).bind('change', function () {
        if (this.value == '0' || this.value > '5') {
            $(span).text('Credit must not be 0')
            $(span).css('color', 'red')
            return false
        } else {
            $(span).text('')
            $(span).css('color', 'white')
            return true
        }
    });
}

function validateEmail(input, span, button) {
    $(input).bind('change', function () {
        var matcher = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (matcher.test(String(this.value).toLowerCase())) {
            $(span).text("")
            $(span).css('color', 'white');
            var email = this.value
            $.ajax({
                url: '/user/checkEmailInDb?email='+email,
                method: 'GET',
                success: function (data) {
                    if(data=='200'){
                        $(span).text('email address already registered!')
                        $(span).css('color', 'red');
                        return false
                    }else if(data=='404'){
                        $(span).text('')
                        $(span).css('color', 'white');
                        return true
                    }
                }
            });
        }else{
            $(span).text('Invaid email address')
            $(span).css('color', 'red');
            return false
        }
    });
}

function validateSemester(input, span, button){
    $(input).bind('change', function () {
        if(this.value=='null'){
            $(span).text('No semester selected')
            $(span).css('color', 'red');
            return false
        }else{
            $(span).text('')
            $(span).css('color', 'white');
            return true
        }
    })
    if(this.value=='null'){
        $(span).text('No semester selected')
        $(span).css('color', 'red');
        return false
    }else{
        $(span).text('')
        $(span).css('color', 'white');
        return true
    }
}

function validateDepartment(input, span, button){
    $(input).bind('change', function () {
        if(this.value=='null'){
            $(span).text('No department selected')
            $(span).css('color', 'red');
            return false
        }else{
            $(span).text('')
            $(span).css('color', 'white');
            return true
        }
    })

    if(this.value=='null'){
        $(span).text('No department selected')
        $(span).css('color', 'red');

        return false
    }else{
        $(span).text('')
        $(span).css('color', 'white');
        return true
    }
}