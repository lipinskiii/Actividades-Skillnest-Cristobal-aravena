
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


function megusta(titulo) {
    
    alert(`Te gustó "${titulo}"`);
    
    const boton = event.currentTarget;
    
    let texto = boton.textContent;
    
    let numeroLikes = parseInt(texto.match(/\d+/)[0]);
    
    numeroLikes++;
    
    boton.textContent = `${numeroLikes} me gusta`;
}