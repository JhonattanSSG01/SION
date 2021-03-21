function validar() {
    var nombre,correo,telefono,expresion;
    nombre = document.getElementById('nombre').value;
    correo = document.getElementById('correo').value;
    telefono = document.getElementById('telefono').value;
    expresion = /\w+@\w+\.+[a-z]/;
   if (nombre ==="" || correo ==="" || telefono ===""){
    alert("Todos los campos son obligatorios");
    return false;
   
   }
   else if (nombre.length>35){
    alert("El nombre es muy largo");
    return false;
   }
    else if (nombre.length<5){
    alert("El nombre es muy corto");
    return false;
   }
   else if (correo.length>45){
    alert("El correo es muy largo");
    return false;
   }
   else if (!expresion.test(correo)) {
    alert("El correo no tiene formato válido");
    return false;

   }
   else if (telefono.length<6){
    alert("El telefono no existe");
    return false;
   }
};