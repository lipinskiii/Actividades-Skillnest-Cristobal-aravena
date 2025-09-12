<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Formulario de Libros</title>
</head>
<body>
    <h1>Agregar Nuevo Libro</h1>
    
    <form method="POST" action="procesa/libro">
        <div>
            <label for="nombreLibro">Nombre del Libro:</label>
            <input type="text" id="nombreLibro" name="nombreLibro" required>
        </div>
        <div>
            <label for="nombreAutor">Nombre del Autor:</label>
            <input type="text" id="nombreAutor" name="nombreAutor" required>
        </div>
        <button type="submit">Agregar Libro</button>
    </form>
    
    <br>
    <a href="<c:url value='/libros'/>">Volver a la lista de libros</a>
</body>
</html>