let botonEliminar = document.querySelectorAll(".boton2");

for(let i = 0; i < botonEliminar.length; i ++){
    botonEliminar[i].addEventListener("click", function(event){
        // Remover el elemento contenedor
        event.target.closest(".Solicitudesconecc").remove();
        // this.closest(".card-list-item").remove();

        // Actualizar el número de conexiones en la página
        let connectionRequestNumber = document.querySelector("#connectionRequestNumber");
        let valorActual = connectionRequestNumber.textContent;
        valorActual --;
        connectionRequestNumber.textContent = valorActual;
        let TotalConnections = document.querySelector("#totalConnections")
        let Total = TotalConnections.textContent;
        Total ++;
        TotalConnections.textContent = Total;
        
    });
}
document.querySelector(".boton-editar").addEventListener("click", function (event) {
    event.preventDefault(); // Evita que el enlace recargue la página
    
    // Selecciona el h1
    let nombreUsuario = document.querySelector(".nombre-usuario");

    // Cambia el texto directamente
    nombreUsuario.textContent = "Gerardo Lopez";
});