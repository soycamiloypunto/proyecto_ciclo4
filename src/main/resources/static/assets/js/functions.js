function RegistrarUsuario(){
    console.log("entra a guardar informacion User")
    
    let myData={
        id: $("#id").val(),
        email: $("#email").val(),
        password: $("#pass1").val(),
        name: $("#name").val()
    };

    
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:8080/api/user/new", 
        type:"POST",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#email").val("");
            $("#pass1").val("");
            $("#pass2").val("");
            $("#name").val("");
            alert("Se ha creado un nuevo Usuario");
            window.open("index.html", "_self");        
        }
    });


}

function IniciarSesion(){
    

    var email = $("#email_i").val();
    var pass = $("#pass_i").val();
    
    let myData={
        email: $("#email_i").val(),
        password: $("#pass_i").val()
    };

    
    
    $.ajax({
        url: "http://localhost:8080/api/user/"+email+"/"+pass,
        type: "GET",
        data: myData,
        dataType: "json",
        success : function (data) {
            if (data.id==null){
                alert("El Usuario No existe. Registrese para Iniciar Sesión");
            }else{
                alert("El Usuario con el Email: "+email+" Ha Iniciado Correctamente");
                //window.open("index.html", "_self");  

            }
        }       
        
    });
    

}

function EnviarRegistro(){
    var email=document.getElementById("email").value;
    var pass1=document.getElementById("pass1").value;
    var pass2=document.getElementById("pass2").value;


    console.log("Email: "+email);

    if(validarEmail(email)==true && verificarPasswords(pass1, pass2)==true){
        ValidarEmailExistente();
    }else{
        alert("Verifique que el Email esté bien escrito y que las contraseñas coincidan")
    }
}

function ValidarEmailExistente(){
    
    console.log("Validar Usuario Existente");
    var email = $("#email").val();
    let myData={
        email: $("#email").val()
    };

    
    $.ajax({
        url: "http://localhost:8080/api/user/"+email,
        type: "GET",
        data: myData,
        dataType: "json",
        success : function (data) {
            if (data === true){
                alert("El Email ya se encuentra registrado en el sistema");
            }
            else
            {
                console.log("Usuario no existe se procede a crear");
                RegistrarUsuario();
            }
        }       
        
    });
    

}

// Code Snippet

function validarEmail(email){
        filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (filter.test(email)) {
            // Yay! valid
            console.log("correcto");
            return true;
        }else{
            console.log("Incorrecto");
            alert("Email no válido")
            return false;
        }
    }

  function verificarPasswords(pass1, pass2) {
    console.log("pass1: "+pass1+" pass2: "+pass2);
    if (pass1 != pass2) {
        console.log("Pass No coinciden");
        alert("Las contraseñas no coinciden...")
        return false;
    } else {
        console.log("Pass coinciden");
        return true;
    }
 
}