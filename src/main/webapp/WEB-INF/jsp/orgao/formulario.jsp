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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="/bootstrap/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<link href="/bootstrap/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css">



<title>Cadastro de Orgaos</title>
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
          <a class="navbar-brand" href="${linkTo[IndexController].index}">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
        				<a href="#" data-toggle="dropdown" class="dropdown-toggle">Projeto <b class="caret"></b></a>
        				<ul class="dropdown-menu">
           					 <li><a href="#">Atividades</a></li>
           					 <li><a href="${linkTo[ProjetoController].formulario}">Cadastrar</a></li>
           					 <li><a href="${linkTo[ProjetoController].lista}">Lista</a></li>
       					 </ul>
            </li>
            <li class="dropdown">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Pesquisador <b class="caret"></b></a>
        				<ul class="dropdown-menu">
           					 <li><a href="${linkTo[PesquisadorController].formulario}">Cadastrar</a></li>
           					 <li><a href="${linkTo[PesquisadorController].lista}">Lista</a></li>
 						 </ul>
            </li>
             <li class="dropdown">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Categoria <b class="caret"></b></a>
        				<ul class="dropdown-menu">
           					 <li><a href="${linkTo[CategoriaController].formulario}">Cadastrar</a></li>
           					 <li><a href="${linkTo[CategoriaController].lista}">Lista</a></li>
 						 </ul>
            </li>
           <li class="dropdown">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Departamento <b class="caret"></b></a>
        				<ul class="dropdown-menu">
           					 <li><a href="${linkTo[DepartamentoController].formulario}">Cadastrar</a></li>
           					 <li><a href="${linkTo[DepartamentoController].lista}">Lista</a></li>
 						 </ul>
            </li>
              <li class="dropdown">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Orgão Financiador <b class="caret"></b></a>
        				<ul class="dropdown-menu">
           					 <li><a href="${linkTo[OrgaoController].formulario}">Cadastrar</a></li>
           					 <li><a href="${linkTo[OrgaoController].lista}">Lista</a></li>
 						 </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
	<h2 class="text-center" style="COLOR: #397cbb;">Formulário de
		cadastro de Orgaos</h2>
	<div class="div-ident section text-left">
		<div class="container div-ident">
			<div class="col-md-9 div-ident">
				<p></p>
				<p></p>
				<form role="form" id="form" class=""
					action="${linkTo[OrgaoController].salva }" method="post">
					<div class="form-group">
						<input type="hidden" name="orgao.id" value="${orgao.id}">
						
						<label class="control-label">Nome</label> <input
							class="form-control" type="text" name="orgao.nome"
							value="${orgao.nome}" />
					</div>
					<div class="form-group">
						<label class="control-label">CNPJ</label> <input
							class="form-control" type="text" name="orgao.cnpj"
							value="${orgao.cnpj}" />
					</div>
					
					<ul class="errors">
						<c:forEach items="${errors}" var="error">
							<li>
								<!-- o campo em que ocorreu o erro, ou o tipo do erro -->
								${error.category}: <!-- a mensagem de erro de validação -->
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