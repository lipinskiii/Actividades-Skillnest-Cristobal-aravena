<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Canción</title>
</head>
<body>
    <h1>Editar Canción</h1>

    <c:if test="${not empty error}">
        <div>
            <p>${error}</p>
        </div>
    </c:if>

    <form:form action="/canciones/actualizacion/${cancion.id}" method="post" modelAttribute="cancion">
        


        <div>
            <label for="titulo">Título (5-100 caracteres):</label>
            <form:input path="titulo" id="titulo" />
            <form:errors path="titulo" />
        </div>

        <div>
            <label for="artistaId">Artista:</label>
            <select name="artistaId" id="artistaId" required>
                <option value="">-- Seleccione un artista --</option>
                <c:forEach items="${artistas}" var="artista">
                    <option value="${artista.id}">
                        ${artista.nombre} ${artista.apellido}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="album">Álbum (3-50 caracteres):</label>
            <form:input path="album" id="album" />
            <form:errors path="album" />
        </div>

        <div>
            <label for="genero">Género (3-30 caracteres):</label>
            <form:input path="genero" id="genero" />
            <form:errors path="genero" />
        </div>

        <div>
            <label for="idioma">Idioma (3-30 caracteres):</label>
            <form:input path="idioma" id="idioma" />
            <form:errors path="idioma" />
        </div>

        <div>
        <input type="hidden" name="_method" value="put"/>
            <button type="submit">Editar Canción</button>
        </div>

    </form:form>

    <br>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>