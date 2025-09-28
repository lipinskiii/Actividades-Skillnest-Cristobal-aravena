<%@ taglib prefix="c" uri="http://jakarta.ee/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html><html lang="es"><head>
<meta charset="UTF-8"/><title>Login/Registro</title>
<style>
 body{font-family:system-ui,sans-serif;margin:0 auto;max-width:920px;padding:28px}
 .tabs{display:flex;gap:8px;margin-bottom:12px}
 .tab{padding:10px 16px;border:1px solid #ddd;border-bottom:none;border-radius:12px 12px 0 0;text-decoration:none;color:#111}
 .tab.active{background:#f5f5f5;font-weight:600}
 .panel{border:1px solid #ddd;border-radius:0 12px 12px 12px;padding:22px;box-shadow:0 6px 16px rgba(0,0,0,.06)}
 .grid{display:grid;grid-template-columns:1fr 1fr;gap:16px}
 .field{display:grid;align-items:center;grid-template-columns:1fr 1fr;gap:8px}
 .err{color:#b00020;font-size:12px;text-align:right}
 button{margin-top:12px;padding:10px 14px;border:none;border-radius:10px;background:#111;color:#fff;cursor:pointer}
</style></head><body>

<div class="tabs">
  <a class="tab ${activeTab eq 'login' ? 'active' : ''}" href="?tab=login">Iniciar sesión</a>
  <a class="tab ${activeTab eq 'register' ? 'active' : ''}" href="?tab=register">Crear cuenta</a>
</div>

<div class="panel">
<c:choose>
  <c:when test="${activeTab eq 'register'}">
    <form:form method="post" action="${pageContext.request.contextPath}/procesa/registro" modelAttribute="usuario">
      <div class="grid">
        <div class="field"><label>Usuario</label><div>
          <form:input path="nombreUsuario"/><form:errors path="nombreUsuario" cssClass="err"/></div></div>
        <div class="field"><label>Correo</label><div>
          <form:input path="correo"/><form:errors path="correo" cssClass="err"/></div></div>
        <div class="field"><label>Contraseña</label><div>
          <form:password path="contrasenia"/><form:errors path="contrasenia" cssClass="err"/></div></div>
        <div class="field"><label>Confirmación</label><div>
          <form:password path="confirmacionContrasenia"/><form:errors path="confirmacionContrasenia" cssClass="err"/></div></div>
        <div class="field"><label>Nombre</label><div>
          <form:input path="nombre"/><form:errors path="nombre" cssClass="err"/></div></div>
        <div class="field"><label>Apellido</label><div>
          <form:input path="apellido"/><form:errors path="apellido" cssClass="err"/></div></div>
        <div class="field"><label>Fecha nacimiento</label><div>
          <form:input type="date" path="fechaDeNacimiento"/><form:errors path="fechaDeNacimiento" cssClass="err"/></div></div>
      </div>
      <button type="submit">Registrarme</button>
    </form:form>
  </c:when>
  <c:otherwise>
    <form:form method="post" action="${pageContext.request.contextPath}/procesa/login" modelAttribute="loginUsuario">
      <div class="field"><label>Usuario o Correo</label><div>
        <form:input path="usernameOrEmail"/><form:errors path="usernameOrEmail" cssClass="err"/></div></div>
      <div class="field"><label>Contraseña</label><div>
        <form:password path="contrasenia"/><form:errors path="contrasenia" cssClass="err"/></div></div>
      <button type="submit">Entrar</button>
    </form:form>
  </c:otherwise>
</c:choose>
</div>

</body></html>