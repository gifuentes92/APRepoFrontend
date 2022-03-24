"use strict";

mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
//window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0; // Safari
  document.documentElement.scrollTop = 0; //  Chrome, Firefox, IE and Opera
}


function cambiarInfoAEditar()
{
  let cambiarInfoAEditarInput=prompt("Ingrese el nuevo valor a editar");
  document.getElementById("parrafo").innerHTML=cambiarInfoAEditarInput;
}


function cambiarNombre()
{
  let cambiarNombreInput=prompt("Ingrese el nombre");
  document.getElementById("titulo").innerHTML=cambiarNombreInput;
}



