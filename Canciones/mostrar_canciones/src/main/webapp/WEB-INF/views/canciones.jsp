<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Lista de Canciones</title>
</head>
<body>
    <h1>Lista de Canciones</h1>
    
    <c:if test="${not empty canciones}">
        <table>
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Artista</th>
                    <th>Detalle</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cancion" items="${canciones}">
                    <tr>
                        <td>${cancion.titulo}</td>
                        <td>${cancion.artista}</td>
                        <td>
                            <a href="/canciones/detalle/${cancion.id}">
                                Detalle
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
    <c:if test="${empty canciones}">
        <p>No hay canciones disponibles.</p>
    </c:if>
</body>
</html>