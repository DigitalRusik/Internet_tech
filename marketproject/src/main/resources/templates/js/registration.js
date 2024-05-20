$(document).ready(function(){
    $('#btn_submit').click(function(){
        let username = $('#username').val();
        let email   = $('#email').val();
        let pass = $('#pass').val();
        $.ajax({
            url: "api/greeting",
            type: "post",
            data: {
                "username": username,
                "email":   email,
                "pass":   pass
            },
            error:function(){$("#erconts").html("Ошибка регистрации!");},
            beforeSend: function() {
                $("#erconts").html("Регистрация...");
            },
            success: function(result){
                if (result === "Ваш аккаунт зарегистрирован!") {
                    location.reload();
                }
                $('#erconts').html(result);
            }
        });
    });
});
