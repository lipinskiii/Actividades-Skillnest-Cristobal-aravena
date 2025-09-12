<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle de Receta</title>
    <link rel="stylesheet" href="/css/estilo.css">
</head>
<body>
    <div class="container">
        <a href="/recetas" class="back-link">← Volver a recetas</a>
        
        <%
            String nombreReceta = (String) request.getAttribute("nombreReceta");
            String[] ingredientes = (String[]) request.getAttribute("ingredientes");
            String mensajeError = (String) request.getAttribute("mensajeError");
            
            if (nombreReceta != null && ingredientes != null) {
        %>
                <h1><%= nombreReceta %></h1>
                <h2>Ingredientes:</h2>
                <ul class="lista-ingredientes">
                    <%
                        for (String ingrediente : ingredientes) {
                    %>
                        <li><%= ingrediente %></li>
                    <%
                        }
                    %>
                </ul>
        <%
            } else {
        %>
                <div class="error-message">
                    <h1>Receta no encontrada</h1>
                    <p><%= mensajeError != null ? mensajeError : "Error desconocido" %></p>
                </div>
        <%
            }
        %>
    </div>
</body>
</html>