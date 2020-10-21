var main = {
    init : function () {
        var _this = this;
        $('#btn-signup').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            id: $('#InputId').val(),
            pw: $('#InputPw').val(),
            name: $('#InputName').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/signup_ok',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입 되었습니다.');
            location.href("/users/login")
        }).fail(function (error) {
            alert(error);
        });
    }

};

main.init();