<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>
</head>
<body>
	<p>Usuario: <sec:authentication property="name" /></p>
	<form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="Cerrar sesión" />
	</form>

	<h1>Lista de Productos</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Acciones</th>
		</tr>
		<c:forEach var="producto" items="${productos}">
			<tr>
				<td>${producto.id}</td>
				<td>${producto.nombre}</td>
				<td>${producto.precio}</td>
				<td>
					<sec:authorize access="hasAnyAuthority('ADMIN', 'EDITOR')">
						<a href="productos/editar/${producto.id}">Editar</a>
					</sec:authorize>
					<sec:authorize access="hasAuthority('ADMIN')">
						<a href="productos/eliminar/${producto.id}">Eliminar</a>
					</sec:authorize>
				</td>
			</tr>
		</c:forEach>
	</table>

	<sec:authorize access="hasAnyAuthority('ADMIN', 'CREATOR')">
		<a href="productos/nuevo">Agregar un nuevo producto</a>
	</sec:authorize>
</body>
</html>
