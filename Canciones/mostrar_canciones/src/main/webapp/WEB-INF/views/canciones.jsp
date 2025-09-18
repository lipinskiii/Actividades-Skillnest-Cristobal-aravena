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
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cancion" items="${canciones}">
            <tr>
                <td>${cancion.titulo}</td>
                <td>${cancion.artista}</td>
                <td>
                    <!-- Detalle (GET) -->
                    <a href="/canciones/${cancion.id}">Detalle</a>

                    <!-- Editar (GET que muestra el formulario de edición) -->
                    <a href="/canciones/vistas/actualizacion/${cancion.id}">Editar</a>

                    <!-- Eliminar (DELETE via POST + _method) -->
                    <form action="/canciones/eliminar/${cancion.id}" method="post" style="display:inline">
                        <input type="hidden" name="_method" value="delete"/>
                        <button type="submit">Eliminar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="3">
                <a href="/canciones/formulario/agregar">Agregar canción</a>
            </td>
        </tr>
        </tbody>
    </table>
</c:if>

<c:if test="${empty canciones}">
    <p>No hay canciones disponibles.</p>
</c:if>

</body>
</html>