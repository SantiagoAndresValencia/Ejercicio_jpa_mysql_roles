<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Iniciar sesión</h1>

	<c:if test="${param.error != null}">
		<p>Usuario o contraseña incorrectos</p>
	</c:if>
	<c:if test="${param.logout != null}">
		<p>Sesión cerrada</p>
	</c:if>

	<form action="${pageContext.request.contextPath}/login" method="post">
		Usuario: <input type="text" name="username" /><br />
		Contraseña: <input type="password" name="password" /><br />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="Entrar" />
	</form>
</body>
</html>
