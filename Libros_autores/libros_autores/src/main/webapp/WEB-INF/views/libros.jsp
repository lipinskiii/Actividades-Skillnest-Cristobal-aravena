<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Libros</title>
</head>
<body>
    <h1>Lista de Libros</h1>
    <ul>
        <c:forEach items="${libros}" var="libro">
            <li><a href="/libros/${libro.key}">${libro.key}</a></li>
        </c:forEach>
    </ul>
    <a href="/libros/formulario">Agregar nuevo libro</a>
    
</body>
</html>