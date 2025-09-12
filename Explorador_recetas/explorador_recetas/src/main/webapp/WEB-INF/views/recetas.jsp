<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
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
            <%
                String[] listaRecetas = (String[]) request.getAttribute("listaRecetas");
                if (listaRecetas != null) {
                    for (String receta : listaRecetas) {
            %>
                <li>
                    <a href="/recetas/<%= receta %>" class="receta-link"><%= receta %></a>
                </li>
            <%
                    }
                }
            %>
        </ul>
    </div>
</body>
</html