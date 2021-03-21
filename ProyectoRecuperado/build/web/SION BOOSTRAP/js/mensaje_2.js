/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* global swal */

function Mensajee(titulo, texto, icono){
    swal({
  title: titulo,
  text: texto,
  icon: icono,
  buttons: true,
  dangerMode: true
})
.then((willDelete) => {
  if (willDelete) {
    swal("Poof  T\372 registro ha sido eliminado por completo", {
      icon: "success"
    });
  } else {
    swal('T\372 registro ha sido salvado');
  }
});
}