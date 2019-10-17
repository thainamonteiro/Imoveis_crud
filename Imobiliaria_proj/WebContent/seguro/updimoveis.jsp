<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/style.css">
<title>Alterar Seguro</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<a href="menu.jsp">Voltar</a>
						<h5 class="card-title text-center">Alterar Seguro</h5>
						<form
							action="${pageContext.request.contextPath}/seguro/seguroControllerServlet?acao=listarseguro"
							method="post">
							<div class="form-group">
								<label>Id:</label> <input type="text" id="id" name="id"
									class="form-control" readonly value="${seguros.id}">
							</div>

							<div class="form-group">
								<label>Seguro:</label> <input type="text" id="identificacao"
									name="identificacao" value="${seguros.identificacao}"
									class="form-control" required />
							</div>

							<div class="form-group">
								<label>Valor:</label> <input type="number" step="any" id="valor"
									name="valor" class="form-control" required
									value="${seguros.valor}" />
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