<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Detalle libro</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty nombreLibro}">
            <p><strong>Título:</strong> ${nombreLibro}</p>
            <p><strong>Autor:</strong> ${nombreAutor}</p>
        </c:when>
        <c:otherwise>
            <p>${mensaje}</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
</html>