<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Artistas</title>
</head>
<body>
    <h1>Lista de Artistas</h1>
    
    <c:if test="${not empty artistas}">
        <div>
            <c:forEach items="${artistas}" var="artista">
                <div>
                    <a href="artistas/Detalle/${artista.id}">
                        ${artista.nombre} ${artista.apellido}
                    </a>
                    <a> (haga click en el artista para ver detalle)</a>
                </div>
            </c:forEach>
        </div>
    </c:if>
    
    <c:if test="${empty artistas}">
        <p>No hay artistas registrados.</p>
    </c:if>
    
    <br>
    <a href="/canciones">Ir a canciones</a>
    </br>
    <a href="/artistas/formulario/agregar">Agregar Nuevo Artista</a>
</body>
</html>