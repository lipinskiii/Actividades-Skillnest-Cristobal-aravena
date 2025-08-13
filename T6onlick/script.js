
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


function megusta(titulo,event) {

    alert(`Te gustó "${titulo}"`);

    const boton = event.currentTarget;

    let numeroLikes = parseInt(boton.textContent) || 0;

    numeroLikes++;

    boton.textContent = `${numeroLikes} Me gusta`;
}