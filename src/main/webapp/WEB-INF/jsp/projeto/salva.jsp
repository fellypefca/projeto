<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<title>Projetos</title>
</head>
<body>
<div class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><span>Brand</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active">
              <a href="${linkTo[IndexController].index}">Home</a>
            </li>
            <li>
              <a href="${linkTo[ProjetoController].formulario}"> Cadastrar Projetos</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
	<h2>Projeto cadastrado com sucesso!</h2>
	<p>
		Veja aqui a <a href="${linkTo[ProjetoController].lista}"> lista de
			todos os projetos </a>
	</p>
</body>
</html>