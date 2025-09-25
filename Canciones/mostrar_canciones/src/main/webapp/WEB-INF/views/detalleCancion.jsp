<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Detalle de Canción</title>
</head>
<body>
    <h1>Detalle de Canción</h1>
    
    <c:choose>
        <c:when test="${not empty cancion}">
            
            <p><strong>Título:</strong> ${cancion.titulo}</p>
            <p value="${artista.id}"><strong >Artista:</strong> ${cancion.artista}</p>
            <p><strong>Álbum:</strong> ${cancion.album}</p>
            <p><strong>Género:</strong> ${cancion.genero}</p>
            <p><strong>Idioma:</strong> ${cancion.idioma}</p>
            <p><strong>Fecha Creación:</strong> ${cancion.fechaCreacion}</p>
            <p><strong>Fecha Actualización:</strong> ${cancion.fechaActualizacion}</p>
        </c:when>
        <c:otherwise>
            <p>La canción no fue encontrada.</p>
        </c:otherwise>
    </c:choose>
    
    <br>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>