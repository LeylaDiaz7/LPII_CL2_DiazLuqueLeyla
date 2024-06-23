<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="java.util.List"%>
<%@page import="model.TblProductocl2"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body bgcolor="#ce5dec9">

<h1 align="center">Listado de productos</h1>

<h2 align="center"> <a href="registrarProducto.jsp" style="text-decoration:none; color:blue;">Registrar Producto</a></h2>

<table border="2" align="center">

		<tr>
			<td>ID</td>
			<td>NOMBRE</td>
			<td>PRECIO VENTA</td>
			<td>PRECIO COMPRA</td>
			<td>ESTADO</td>
			<td>DESCRIPCIÓN</td>
		</tr>

		<%
		List<TblProductocl2> listadocliente=(List<TblProductocl2>)request.getAttribute("listadoProductos");
		//aplicamos una condicion..

		if (listadocliente != null) {

			//aplicamos un bucle for..

			for (TblProductocl2 lis : listadocliente) {
			%>
			<tr>
				<td><%=lis.getIdproductocl2()%></td>
				<td><%=lis.getNombrecl2()%></td>
				<td><%=lis.getPrecioventacl2()%></td>
				<td><%=lis.getPreciocompcl2()%></td>
				<td><%=lis.getEstadocl2()%></td>
				<td><%=lis.getDescripcl2()%></td>
			</tr>
			<%
			} //fin del bucle for...
			%>
			<%
		} //fin de la condicion ...
		%>
	</table>
	
</body>
</html>
