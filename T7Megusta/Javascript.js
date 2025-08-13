
document.querySelectorAll('.Boton-Like').forEach(boton => {
    
    boton.addEventListener('click', () => {
        let contador = boton.previousElementSibling;
        let likes = parseInt(contador.textContent) + 1;
        contador.textContent = `${likes} like${likes !== 1 ? 's' : ''}`;
    });
});
