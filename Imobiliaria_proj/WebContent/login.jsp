<html>
<head>
<title>Login Segurado</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						${mensagem}
						
						<h5 class="card-title text-center">Login</h5>
						<form action="${pageContext.request.contextPath}/loginControllerServlet" method="post">
							<div class="form-group">
								<label>Usuario:</label> <input id="usuario" name="usuario"
									type="text" class="form-control"
									placeholder="Digite seu usuario:" required>
							</div>
							<div class="form-group">
								<labe>Senha:</label> <input id="senha" name="senha"
									type="password" class="form-control"
									placeholder="Digite sua senha:" required>
							</div>

							<div class="g-recaptcha"
								data-sitekey="6LeUkbkUAAAAAL9iLLiRi7AYfmXj7IPaV82jK8jA"></div><br>
							<button type="submit" class="btn btn-primary">Entrar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--js-->
	<script src="https://www.google.com/recaptcha/api.js" adiamento
		assíncrono>
		
	</script>
</body>
</html>