<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dao" class="daos.LivroDAO"/>
	<h1>Lista de livros</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Título</th>
				<th>Autor</th>
				<th>Editora</th>
				<th>Ano de publicação</th>
				<th>Edição</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${dao.lista}">
				<tr>
					<td>${livro.titulo}</td>
					<td>${livro.autor}</td>
					<td>${livro.editora}</td>
					<td>${livro.anoPublicacao}</td>
					<td>${livro.edicao}</td>
				</tr>
			</c:forEach>
		</tbody>
</body>
</html>