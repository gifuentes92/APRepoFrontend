
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
      document.querySelector('.arriba').classList.add('show')
    } else {
      document.querySelector('.arriba').classList.remove("show");
    }
}, 16); 

 /*
 Mostrar/ocultar elemento anterior
 document.onscroll = function(){
    console.log(document.document.scrolltop);  
    if (document.documentElement.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.querySelector('.arriba').classList.add('show');
      } else {
        document.querySelector('.arriba').classList.remove("show");
      }
    }*/