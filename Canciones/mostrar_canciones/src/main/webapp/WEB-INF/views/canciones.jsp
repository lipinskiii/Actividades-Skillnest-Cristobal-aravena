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
            
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cancion" items="${canciones}">
            <tr>
                <td>${cancion.titulo}</td>
                
                <td>
                    
                    <a href="/canciones/${cancion.id}">Detalle</a>

                    
                    <a href="/canciones/vistas/actualizacion/${cancion.id}">Editar</a>

                    
                    <form action="/canciones/eliminar/${cancion.id}" method="post" style="display:inline">
                        <input type="hidden" name="_method" value="delete"/>
                        <button type="submit">Eliminar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>

        
        </tbody>
    </table>
    
</c:if>
        <div>
            <tr>
                <td >
                    <a href="/canciones/formulario/agregar">Agregar canción</a>
                </td>
            </tr>
        </div>
        <tr>
            <td >
                <a href="/artistas">Ver lista de artistas</a>
            </td>
        </tr>

<c:if test="${empty canciones}">
    <p>No hay canciones disponibles.</p>
</c:if>

</body>
</html>