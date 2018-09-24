<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Empréstimo de livros</h1>
	<form action="ServletGeral" method="post">
		<input type="hidden" name="comando" value="BuscarLivro">
		<div>
      		<label>Titulo do livro:</label>
       		<input type="text" name="titulo">
       		<input type="submit" value="buscar">
     	</div>
     </form>
     
     <form action="ServletGeral" method="post">
     	<input type="hidden" name="comando" value="ComandoEmprestimo">
     	<select name="tituloBusca">
     		<c:forEach var="livro" items="${livros}">
     			<option value="${livro.titulo}">${livro.titulo}</option>
     		</c:forEach>
     	</select>
     	<div>
      		<label>Emprestar:</label>
       		<input type="text" name="matricula">
       		<input type="submit" value="emprestar">
     	</div>
     </form>
</body>
</html>