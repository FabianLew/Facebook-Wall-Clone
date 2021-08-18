$(document).ready(function (){
    $("#submitBtn").click(submitOnClick);
});

function submitOnClick(){
    var user = {};
    user["username"] = $("#username").val();
    user["password"] = $("#password").val();
    user["email"] = $("#email").val();
    user["name"] = $("#name").val();
    user["lastName"] = $("#lastName").val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "http://localhost:8080/registration",
        data : JSON.stringify(user),
        dataType : 'json',
        success : function (data, textStatus, xhr){
            if(xhr.status === 200) {
                window.location = ('http://localhost:8080/login');
            }
        },
        error: function(xhr,textStatus){
            if(xhr.status === 409) {
                $("#errorMsg").text("This username is already used");
            }
        }
    });
}
