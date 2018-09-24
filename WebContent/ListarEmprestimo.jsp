<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dao" class="daos.EmprestimoDAO"/>
	<h1>Lista de Emprestimo</h1>
	<table border="1px">
		
		<tr>
			<th>Matrícula aluno</th>
			<th>Id livro</th>
			<th>Data empréstimo</th>
			<th>Data devolução</th>
		</tr>
	
		<c:forEach var="emprestimo" items="${dao.lista}">
			<tr>
				<td>${emprestimo.matriculaAluno}</td>
				<td>${emprestimo.dataNascimento}</td>
				<td>${emprestimo.dataDevolucao}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>