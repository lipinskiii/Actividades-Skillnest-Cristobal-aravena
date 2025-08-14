
document.getElementById('btnSesion').addEventListener('click', function() {
    if (this.textContent === 'Iniciar sesión') {
        this.textContent = 'Cerrar sesión';
    } else {
        this.textContent = 'Iniciar sesión';
    }
});


document.querySelector('.Agregardefinicion').addEventListener('click', function() {
    this.style.display = 'none'; 
});

document.addEventListener("DOMContentLoaded", function() {
    let likesButtons = document.querySelectorAll(".boton-megusta");

    for(let i = 0; i < likesButtons.length; i++)  {
        likesButtons[i].addEventListener("click", function() {
            let numeroSpan = this.querySelector(".numero");
            
            let numero = parseInt(numeroSpan.textContent);
            numero++;
            numeroSpan.textContent = numero;
            
            let articulo = this.closest(".Primer-Articulo");
            let nombreAnimal = articulo.querySelector("h2").textContent;

            alert("¡Le diste like a: " + nombreAnimal + "!");
        });
    }
});



        

