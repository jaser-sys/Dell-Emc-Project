function wait(ms) {
    var start = new Date().getTime();
    var end = start;
    while (end < start + ms) {
        end = new Date().getTime();
    }
}

function redirectTo() {
    setTimeout(function () {
    }, 10000);

    window.location.href = "search.html";

}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}
function CheckPassword(inputtxt) {
    var passw = /^[A-Za-z]\w{7,14}$/;
    if (inputtxt.value.match(passw)) {
        //alert('Correct, try another...')
        return true;
    }
    else {
        //alert('Wrong...!')
        return false;
    }
}

function ValidateIPaddress(ipaddress) {
    var ipformat = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    if (ipaddress.value.match(ipformat)) {
      
        return true;
    }
    else {
        return false;
    }
}

function ValidatePath(path)
{
    var isValid = /("(([a-zA-Z]:)|(\\\\[^/\\:\*\?""<>\|]+(\\[a-zA-Z]\$)?))\\([^/\\:\*\?""<>\|]+\\)*[^/\\:\*\?""<>\|]+(\.[^/\\:\*\?""<>\|]+[^/\\:\*\?""<>\|\s])?")|((([a-zA-Z]:)|(\\\\[^/\\:\*\?""<>\|\s]+(\\[a-zA-Z]\$)?))\\([^/\\:\*\?""<>\|\s]+\\)*[^/\\:\*\?""<>\|\s]+(\.[a-zA-Z0-9]+)?)/.test(path);
    if (path.value.match(isValid))
    {
        return true;
    }
    else
    {
        return false;
    }
}

function validate(input1,input2,input3)
{

    if (CheckPassword(input1) && ValidateIPaddress(input2) && ValidatePath(input3))
        
    {
        Swal.fire(
            'Good job!',
            'You register !',
            'success'           
        )

    }

    else if (!CheckPassword(input1))
    {
    
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Password Is Invilid',
            footer: '<a </a>'
        });
    }
        else if (!ValidateIPaddress(input2))
    {

        Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'IP Is Invilid',
        footer: '<a </a>'
        });
    }
        else if (!ValidatePath(input3))
    {

        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Path Is Invilid',
            footer: '<a </a>'
        });
    }
}
    





//(function ($) {
//    "use strict";


//    /*==================================================================
//    [ Validate ]*/
//    var input = $('.validate-input .input100');

//    $('.validate-form').on('submit', function () {
//        var check = true;

//        for (var i = 0; i < input.length; i++) {
//            if (validate(input[i]) == false) {
//                showValidate(input[i]);
//                check = false;
//            }
//        }

//        return check;
//    });


//    $('.validate-form .input100').each(function () {
//        $(this).focus(function () {
//            hideValidate(this);
//        });
//    });

//    function validate(input) {
//        if ($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
//            if ($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
//                return false;
//            }
//        }
//        else {
//            if ($(input).val().trim() == '') {
//                return false;
//            }
//        }
//    }
//    if ($(input).attr('type') == 'text' || $(input).attr('name') == 'pass') {
//        if ($(input).val().match(/^[A-Za-z]\w{7,14}$/) == false) {
//            return false;
//        }
//    }
//    else {
//        if ($(input).val().trim() == '') {
//            return false;
//        }
//    }
//    if ($(input).attr('type') == 'text' || $(input).attr('name') == 'ip') {
//        if ($(input).val().match(/^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/) == false) {
//            return false;
//        }
//    }
//    else {
//        if ($(input).val().trim() == '') {
//            return false;
//        }
//    }
//}
//    function showValidate(input) {
//        var thisAlert = $(input).parent();

//        $(thisAlert).addClass('alert-validate');
//    }

//    function hideValidate(input) {
//        var thisAlert = $(input).parent();

//        $(thisAlert).removeClass('alert-validate');
//    }



//})(jQuery);