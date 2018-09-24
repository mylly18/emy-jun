<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dao" class="daos.AlunoDAO"/>
	<h1>Lista de alunos</h1>
	<table border="1px">
		
			<tr>
				<th>Matrícula</th>
				<th>Nome</th>
				<th>Endereço</th>
				<th>Data de nascimento</th>
				<th>CPF</th>
			</tr>
		
	
			<c:forEach var="aluno" items="${dao.lista}">
				<tr>
					<td>${aluno.matricula}</td>
					<td>${aluno.nome}</td>
					<td>${aluno.endereco}</td>
					<td>${aluno.dataNascimento}</td>
					<td>${aluno.cpf}</td>
				</tr>
			</c:forEach>
		
	</table>
</body>
</html>