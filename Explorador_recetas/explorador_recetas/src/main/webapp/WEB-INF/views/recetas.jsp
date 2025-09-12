<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Explorador de Recetas</title>
    <link rel="stylesheet" href="/css/estilo.css">
</head>
<body>
    <div class="container">
        <h1>Nuestras Recetas</h1>
        <ul class="lista-recetas">
            
            <c:forEach var="receta" items="${listaRecetas}">
                <li>
                    <a href="/recetas/${receta}" class="receta-link">${receta}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>