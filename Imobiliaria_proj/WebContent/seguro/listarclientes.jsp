<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/style.css">
<title>Listar Segurado</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-7  mx-auto" >
				<div class="card card-signin my-5  shadow-lg">
					<div class="card-body">
								<span><a href="${pageContext.request.contextPath}/seguro/menu.jsp">Voltar</a></span>
						<h5 class="card-title text-center">Listar Segurado</h5>

						<table class="table table-bordered">
								<tr  class="table-info">
									<td></td>
									<td>Nome</td>
									<td>CPF</td>
									<td>RG</td>
									<td>Ações</td>
									
								</tr>

							<c:forEach var="segurado" items="${segurados}">
								<tr>
									<td>${segurado.id}</td>
									<td>${segurado.nome}</td>
									<td>${segurado.cpf}</td>
									<td>${segurado.rg}</td>
   									<td><a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/seguro/seguradoControllerServlet?acao=alterarsegurado&id=${segurado.id}">Editar</a>
  								 	<a class="btn btn-danger btn-sm"  href="${pageContext.request.contextPath}/seguro/seguradoControllerServlet?acao=excluirsegurado&id=${segurado.id}">Excluir</a></td>
								</tr>
							</c:forEach>																				
							
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

