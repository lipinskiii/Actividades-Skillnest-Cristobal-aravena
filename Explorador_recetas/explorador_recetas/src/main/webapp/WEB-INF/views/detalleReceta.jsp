<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle de Receta</title>
    <link rel="stylesheet" href="/css/estilo.css">
</head>
<body>
    <div class="container">
        <a href="/recetas" class="back-link">← Volver a recetas</a>
        
        <c:choose>
            <c:when test="${not empty nombreReceta}">
                <h1>${nombreReceta}</h1>
                <h2>Ingredientes:</h2>
                <ul class="lista-ingredientes">
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <li>${ingrediente}</li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <div class="error-message">
                    <h1>Receta no encontrada</h1>
                    <p>${mensajeError}</p>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>