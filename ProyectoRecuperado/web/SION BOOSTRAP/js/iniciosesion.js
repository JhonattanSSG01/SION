function validar() {
    var correo,contraseña,expresion;
    correo = document.getElementById('correo').value;
    contraseña = document.getElementById('contraseña').value;
    expresion = /\w+@\w+\.+[a-z]/;

   if(correo==='migu009@gmail.com' && contraseña==='cero#223'){
    alert("Tus datos son correctos, Bienvenido Miguel Castañeda");
    location.href="/SION BOOPSTRAP/dashboardadmin.html";
       }
    if (correo==='guill2345@yahoo.com' && contraseña==='1013676062$$'){
     alert("Tus datos son correctos, Bienvenido Guillermo Robledo");
    location.href="/SION BOOPSTRAP/gerenteadministrativo.html"; 
       }
    if (correo==='vicky78@hotmail.com' && contraseña==='@0987651234'){
     alert("Tus datos son correctos, Bienvenida Victoria Altahona");
    location.href="/SION BOOPSTRAP/Secretaria.html"; 
    }
    if (correo==='abbdel@yahoo.com' && contraseña==='80214918'){
     alert("Tus datos son correctos, Bienvenida Abby Celeste Delgado");
    location.href="/SION BOOPSTRAP/vistacliente.html"; 
    }
     
   if (correo ==="" || contraseña ===""){
    alert("Todos los campos son obligatorios");
    return false;
   
   }
   else if (correo.length>35){
    alert("El nombre es muy largo");
    return false;
   }
   else if (!expresion.test(correo)) {
    alert("El correo no tiene formato válido");
    return false;

   }
   else if (contraseña.length<10){
    alert("La contraseña no es correcta");
    return false;
   }
}
