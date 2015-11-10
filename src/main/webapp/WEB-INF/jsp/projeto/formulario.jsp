<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/jquery-ui.js"></script>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/jquery-ui.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="/bootstrap/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<link href="/bootstrap/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css">


<script type="text/javascript"
	src="/bootstrap/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<link href="/bootstrap/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css">

<script>
		$(function() {
			$("#datepicker").datepicker();
		});
</script>

<script>
		$(function() {
			$("#datepicker2").datepicker();
		});
</script>

<title>Cadastro de Projetos</title>
</head>

<body>
	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-ex-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${linkTo[IndexController].index}">Home</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${linkTo[ProjetoController].formulario}">
							Cadastrar Projeto</a></li>
					<li><a href="${linkTo[PesquisadorController].formulario}">
							Cadastrar Pesquisador</a></li>
					<li><a href="${linkTo[ProjetoController].formulario}">
							Atividades</a></li>
					<li><a href="${linkTo[DepartamentoController].formulario}">
							Cadastrar Departamento</a></li>
				</ul>
			</div>
		</div>
	</div>
	<h2 class="text-center" style="COLOR: #397cbb;">Formul�rio de
		cadastro de projetos</h2>
	<div class="div-ident section text-left">
		<div class="container div-ident">
			<div class="col-md-9 div-ident">
				<p></p>
				<p></p>
				<form role="form" id="form" class=""
					action="${linkTo[ProjetoController].salva }" method="post">
					<div class="form-group">

						<label class="control-label">T�tulo</label> <input
							class="form-control" type="text" name="projeto.titulo"
							value="${projeto.titulo}" />
					</div>
					<input type="hidden" name="projeto.id" value="${projeto.id}">
					<div class="form-group" id="descricao">
						<label class="control-label">Descri��o</label>
						<textarea class="form-control" name="projeto.descricao">${projeto.descricao}</textarea>
					</div>
					<div class="form-group" id="pchave">
						<label class="control-label" id="pchave">Palavras-chave</label> <input
							class="form-control" type="text" name="projeto.palavrasChave"
							value="${projeto.palavrasChave}" />
						<p class="help-block">Separe as palavras-chave com o uso de
							v�rgulas</p>
					</div>
					<div class="form-group">
						<label class="control-label" id="cordnome">Nome do
							Coordenador</label> <input class="form-control" type="text"
							name="projeto.nomeDoCoordenador"
							value="${projeto.nomeDoCoordenador}" />
					</div>
					<div class="form-group" id="initdata">
						<label class="control-label">Data de Inicio</label> <input
							class="form-control" id="datepicker" type="text"
							name="projeto.dataPublicacao" value="${projeto.dataInicio}" />
					</div>

					<div class="form-group">
						<label class="control-label" id="finaldata">Data do
							T�rmino</label> <input class="form-control" id="datepicker2" type="text"
							name="projeto.dataFim" value="${projeto.dataFim}" />
					</div>
					<ul class="errors">
						<c:forEach items="${errors}" var="error">
							<li>
								<!-- o campo em que ocorreu o erro, ou o tipo do erro -->
								${error.category}: <!-- a mensagem de erro de valida��o -->
								${error.message}
							</li>
						</c:forEach>
					</ul>
					<input type="submit" class="btn btn-primary" value="Salvar" />
				</form>
			</div>
		</div>
	</div>
</body>

</html>