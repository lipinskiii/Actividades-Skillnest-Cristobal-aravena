<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detalle del Artista</title>
</head>
<body>
    <h1>Detalle del Artista</h1>
    
    <c:if test="${not empty artista}">
        <div>
            <h2>Información del Artista</h2>
            <p><strong>ID:</strong> ${artista.id}</p>
            <p><strong>Nombre:</strong> ${artista.nombre}</p>
            <p><strong>Apellido:</strong> ${artista.apellido}</p>
            <p><strong>Biografía:</strong> ${artista.biografia}</p>
            <p><strong>Fecha de Creación:</strong> ${artista.fechaCreacion}</p>
            <p><strong>Fecha de Actualización:</strong> ${artista.fechaActualizacion}</p>
        </div>
        
        <h3>Canciones de este artista:</h3>
        <c:if test="${not empty artista.canciones}">
            <ul>
                <c:forEach items="${artista.canciones}" var="cancion">
                    <li>
                        <strong>${cancion.titulo}</strong> - 
                        Álbum: ${cancion.album} - 
                        Género: ${cancion.genero}
                    </li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty artista.canciones}">
            <p>Este artista no tiene canciones registradas.</p>
        </c:if>
    </c:if>
    
    <c:if test="${empty artista}">
        <p>Artista no encontrado.</p>
    </c:if>
    
    <br>
    <a href="/artistas">Volver a la lista de artistas</a>
    <br>
    <a href="/canciones">Ir a la lista de canciones</a>
</body>
</html>