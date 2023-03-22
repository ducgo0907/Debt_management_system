
jQuery(".form-valide").validate({
    rules: {
        "val-username": {
            required: !0,
            minlength: 3
        },
        "name": {
            required: !0,
            minlength: 2,
            maxlength: 100
        },

        "val-email": {
            required: !0,
            email: !0
        },
        "email": {
            required: !0,
            email: !0
        },
        "val-password": {
            required: !0,
            minlength: 6
        },
        "oldPassword": {
            required: !0,
            minlength: 6
        },
        "password": {
            required: !0,
            minlength: 6,
            maxlength: 55
        },
        "rePassword": {
            required: !0,
            equalTo: "#password"
        },
        "val-confirm-password": {
            required: !0,
            equalTo: "#val-password"
        },
        "val-select2": {
            required: !0
        },
        "val-select2-multiple": {
            required: !0,
            minlength: 2
        },
        "val-suggestions": {
            required: !0,
            minlength: 5
        },
        "val-skill": {
            required: !0
        },
        "val-currency": {
            required: !0,
            currency: ["$", !0]
        },
        "val-website": {
            required: !0,
            url: !0
        },
        "val-phoneus": {
            required: !0,
            phoneUS: !0
        },
        "val-digits": {
            required: !0,
            digits: !0
        },
        "val-number": {
            required: !0,
            number: !0
        },
        "val-range": {
            required: !0,
            range: [1, 5]
        },
        "val-terms": {
            required: !0
        },
        "val-fullname": {
            required: !0,
            minlength: 3,
            maxlength: 25
        },
        "fullname": {
            required: !0,
            minlength: 2,
            maxlength: 100,
        },
        "birthday": {
            required: !0,
            date: !0,
            today : !Date.parse(new Date()) - 864e5,
        },
        "phonenumber": {
            required: 0,
            number: !0,
            minlength: 10,
            maxlength: 11,
        },
        "address": {
            required: !0,
            minlength: 3,
            maxlength: 255,
        },




    },
    messages: {
        "val-username": {
            required: "Please enter a username",
            minlength: "Your username must consist of at least 3 characters"
        },
        "name": {
            required: "Họ và tên không được để trống",
            minlength: "Họ và tên phải chứa ít nhất 2 kí tự",
            maxlength: "Họ và tên không được vượt quá 100 kí tự"
        },
        "val-email": "Please enter a valid email address",
        "email": "Email không đúng định dạng",
        "val-password": {
            required: "Please provide a password",
            minlength: "Your password must be at least 5 characters long"
        },
        "oldPassword": {
            required: "Mật khẩu cũ không được để trống",
            minlength: "Mật khẩu cần ít nhất 6 kí tự"
        },
        "password": {
            required: "Mật khẩu không được để trống",
            minlength: "Mật khẩu cần ít nhất 6 kí tự",
            maxlength: "Mật khẩu không được quá 55 kí tự"
        },
        "rePassword": {
            required: "Mật khẩu không được để trống",
            minlength: "Mật khẩu cần ít nhất 6 kí tự",
            equalTo: "Mật khẩu nhập lại không trùng khớp"
        },
        "val-confirm-password": {
            required: "Please provide a password",
            minlength: "Your password must be at least 5 characters long",
            equalTo: "Please enter the same password as above"
        },"fullname": {
            required: "Họ và tên không được để trống",
            minlength: "Họ và tên cần ít nhất 3 kí tự",
            maxlength: "Họ và tên không được quá 25 kí tự",
        },
         "val-fullname": {
            required: "Họ và tên không được để trống",
            minlength: "Họ và tên cần ít nhất 3 kí tự",
            maxlength: "Họ và tên không được quá 25 kí tự",
        },
        "birthday": {
            required: "Ngày sinh không được để trống",
            date: "Ngày sinh không đúng định dạng",
            today:"Ngày sinh không thể là ngày hiện tại,"
        },
        "phonenumber": {
            required: "Số điện thoại không được để trống",
            number: "Số điện thoại không đúng định dạng",
            minlength: "Số điện thoại cần ít nhất 10 kí tự",
            maxlength: "Số điện thoại không được quá 11 kí tự",
        },
        "address": {
            required: "Địa chỉ không được để trống",
            minlength: "Địa chỉ cần ít nhất 3 kí tự",
            maxlength: "Địa chỉ không được quá 255 kí tự",
        },
        "val-select2": "Please select a value!",
        "val-select2-multiple": "Please select at least 2 values!",
        "val-suggestions": "What can we do to become better?",
        "val-skill": "Please select a skill!",
        "val-currency": "Please enter a price!",
        "val-website": "Please enter your website!",
        "val-phoneus": "Please enter a US phone!",
        "val-digits": "Please enter only digits!",
        "val-number": "Please enter a number!",
        "val-range": "Please enter a number between 1 and 5!",
        "val-terms": "You must agree to the service terms!"
    },

    ignore: [],
    errorClass: "invalid-feedback animated fadeInUp",
    errorElement: "div",
    errorPlacement: function (e, a) {
        jQuery(a).parents(".form-group > div").append(e)
    },
    highlight: function (e) {
        jQuery(e).closest(".form-group").removeClass("is-invalid").addClass("is-invalid")
    },
    success: function (e) {
        jQuery(e).closest(".form-group").removeClass("is-invalid"), jQuery(e).remove()
    },
});


jQuery(".form-valide-with-icon").validate({
    rules: {
        "val-username": {
            required: !0,
            minlength: 3
        },
        "val-password": {
            required: !0,
            minlength: 6
        },
        "email": {
            required: !0,
            email: !0
        },
        "oldPassword": {
            required: !0,
            minlength: 6
        },
        "password": {
            required: !0,
            minlength: 6,
            maxlength: 55
        },
        "rePassword": {
            required: !0,
            equalTo: "#password"
        },
        "val-fullname": {
            required: !0,
            minlength: 3,
            maxlength: 25
        },
        "fullname": {
            required: !0,
            minlength: 3,
            maxlength: 25
        },
    },
    messages: {
        "val-username": {
            required: "Please enter a username",
            minlength: "Your username must consist of at least 3 characters"
        },
        "val-password": {
            required: "Please provide a password",
            minlength: "Your password must be at least 5 characters long"
        },
        "email": "Email không đúng định dạng",
        "oldPassword": {
            required: "Mật khẩu cũ không được để trống",
            minlength: "Mật khẩu cần ít nhất 6 kí tự"
        },
        "password": {
            required: "Mật khẩu không được để trống",
            minlength: "Mật khẩu cần ít nhất 6 kí tự",
            maxlength: "Mật khẩu không được quá 55 kí tự"
        },
        "rePassword": {
            required: "Mật khẩu không được để trống",
            equalTo: "Mật khẩu nhập lại không trùng khớp"
        },
        "fullname": {
            required: "Họ và tên không được để trống",
            minlength: "Họ và tên cần ít nhất 2 kí tự",
            maxlength: "Họ và tên không được quá 100 kí tự",
        },
         "val-fullname": {
            required: "Họ và tên không được để trống",
            minlength: "Họ và tên cần ít nhất 3 kí tự",
            maxlength: "Họ và tên không được quá 25 kí tự",
        },
    },

    ignore: [],
    errorClass: "invalid-feedback animated fadeInUp",
    errorElement: "div",
    errorPlacement: function (e, a) {
        jQuery(a).parents(".form-group > div").append(e)
    },
    highlight: function (e) {
        jQuery(e).closest(".form-group").removeClass("is-invalid").addClass("is-invalid")
    },
    success: function (e) {
        jQuery(e).closest(".form-group").removeClass("is-invalid").addClass("is-valid")
    }




});