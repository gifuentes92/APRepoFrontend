
mybutton = document.getElementsByClassName('arriba');


  function topFunction() {
    window.scrollTo({
      top: 0,
      behavior:'smooth'
    });
   
  }

 var scrollToTop = window.setInterval(function() {
    var pos = window.pageYOffset;
    if ( pos > 100 ) {
      document.querySelector(".arriba").style.display ="block";
    } else {
      document.querySelector(".arriba").style.display ="none";
    }
})

 
/* // Mostrar/ocultar elemento anterior
console.log(onscroll);
 document.onscroll = function(){
    console.log(document.document.scrolltop);  
    if (document.documentElement.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.querySelector('.arriba').classList.add('show');
      } else {
        document.querySelector('.arriba').classList.remove("show");
      } 
    }*/