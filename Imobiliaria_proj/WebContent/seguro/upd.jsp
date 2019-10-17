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
<title>Editar Segurado</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						 ${mensagem}
						<h5 class="card-title text-center">Alterar Segurado</h5>
						<form
							action="${pageContext.request.contextPath}/seguro/seguradoControllerServlet?acao=listarsegurado"
							method="post">
							<div class="form-group">
								<label>Id:</label> <input type="text" id="id" name="id"
									class="form-control" readonly value="${segurado.id}">
							</div>
							<div class="form-group">
								<label>Nome:</label> <input type="text" id="nome" name="nome"
									class="form-control" placeholder="Digite seu nome:"  required value="${segurado.nome}">
							</div>
							
							<div class="form-group">
								<labe>Cpf:</label> <input type="text" id="cpf" name="cpf"
									class="form-control" placeholder="Digite seu cpf:" required value="${segurado.cpf}">
							</div>
							<div class="form-group">
								<label>Rg:</label> <input type="text" id="rg" name="rg"
									class="form-control" placeholder="Digite seu rg:" required value="${segurado.rg}">
							</div>

							<div class="form-group">
								<label>Sexo:</label>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" id="sexo"
										name="sexo" value="feminino" value="${segurado.sexo}"> <label
										class="form-check-label">Feminino</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" id="sexo"
										name="sexo" value="masculino" value="${segurado.sexo}"> <label
										class="form-check-label">Masculino</label>
								</div>
							</div>

							<div class="form-group">
								<label>Correntista:</label> <select name="correntista"
									id="correntista" class="form-control">
									<option value="segunda" value="${segurado.correntista}">Sim</option>
									<option value="terca" value="${segurado.correntista}">Não</option>
								</select>
							</div>

							<div class="form-group">
								<label>Dias de visita:</label> <select multiple
									name="diasVisita" id="diasVisita" class="form-control"
									id="exampleFormControlSelect1"  value="${segurado.diasVisita}">
									<option value="segunda">Segunda</option>
									<option value="terca">Terça</option>
									<option value="quarta">Quarta</option>
									<option value="quinta">Quinta</option>
									<option value="sexta">Sexta</option>
								</select>
							</div>

							<div class="form-group">
								<label>Data de Nascimento:</label> <input type='date'
									id="data_nasc" name="data_nasc" class="form-control" />
							</div>

							<div class="form-group">
								<label>Seguro:</label>
								<div class="form-check">
									<c:forEach var="seguro" items="${seguros}">
										<input class="form-check-input" type="checkbox"
											value="${seguro.id}" name="seguro" >
										<label class="form-check-label">
											${seguro.identificacao} </label>
										<br>
									</c:forEach>
								</div>
							</div>

							<button type="submit" class="btn btn-primary">Editar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>