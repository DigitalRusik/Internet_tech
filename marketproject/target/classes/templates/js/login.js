$(document).ready(function(){
    $('#lbtn_submit').click(function(){
        let lemail   = $('#lemail').val();
        let lpass = $('#lpass').val();
        $.ajax({
            url: "api/greeting1",
            type: "post",
            data: {
                "lemail":   lemail,
                "lpass":   lpass
            },
            error:function(){$("#lrconts").html("Ошибка авторизации!");},
            beforeSend: function() {
                $("#lrconts").html("Авторизация...");
            },
            success: function(result){
                if (result === "Вход выполнен!") {
                    location.reload();
                }
                $('#lrconts').html(result);
            }
        });
    });
});