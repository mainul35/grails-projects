function isNameEmpty(elem){
    if(elem.value.trim()==''){
        $('#nameErr').text("Name must not be empty")
        $('#nameErr').css('color', '#ff2233')
    }
    else{
        $('#nameErr').text("")
    }
}

function isAgeEmpty(elem){
    if(elem.value.trim()==''){
        $('#ageErr').text("Age must not be empty")
        $('#ageErr').css('color', '#ff2233')
    }else{
        $('#ageErr').text("")
    }
}

function isAlreadyExists(elem) {
    var name = elem.value.trim()
    jQuery.ajax({
        type: "GET",
        url: "/sms/find-by-name?name="+name,
        success: function (result) {
            if(!(result=='{}')){
                $('#nameErr').text("Student with same name already exists!")
                $('#nameErr').css('color', '#ff2233')
            }
            // else if((result=='{}')){
            //     $('#nameErr').text("")
            //     $('#nameErr').css('color', '#ffffff')
            // }
        }
    });
}

$("#stdAddForm").bind('submit', function (e) {
    e.preventDefault();
    var isValid = validateForm();
    if (!isValid) {
        e.preventDefault();
        return false;
    }
});



function validateForm() {
    var name = document.forms["stdAddForm"]["name"].value;
    var age = document.forms["stdAddForm"]["age"].value;
    if (name == "") {
        $('#nameErr').text("Name must not be empty")
        $('#nameErr').css('color', '#ff2233')
        return false
    }
    if (age == "") {
        $('#ageErr').text("Age must not be empty")
        $('#ageErr').css('color', '#ff2233')
        return false
    }
}


function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        $('#ageErr').text("Only numbers are allowed!")
        $('#ageErr').css('color', '#ff2233')
        return false;
    } else {
        $('#ageErr').text("")
        $('#ageErr').css('color', '#ff2233')
        return true;
    }
}