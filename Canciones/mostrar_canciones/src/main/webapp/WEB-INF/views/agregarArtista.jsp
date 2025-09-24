<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Agregar Artista</title>
</head>
<body>
    <h1>Agregar Nuevo Artista</h1>

    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>

    <form:form action="/artistas/procesa/agregar" method="post" modelAttribute="artista">
        
        <div>
            <form:label path="nombre">Nombre:</form:label>
            <form:input path="nombre" />
            <form:errors path="nombre" />
        </div>

        <div>
            <form:label path="apellido">Apellido:</form:label>
            <form:input path="apellido" />
            <form:errors path="apellido" />
        </div>

        <div>
            <form:label path="biografia">Biografía:</form:label>
            <form:textarea path="biografia" rows="4" cols="50" />
            <form:errors path="biografia" />
        </div>

        <div>
            <button type="submit">Crear Artista</button>
            <a href="/artistas">Cancelar</a>
        </div>
    </form:form>
</body>
</html>