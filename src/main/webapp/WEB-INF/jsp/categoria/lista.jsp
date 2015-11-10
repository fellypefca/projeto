<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/jquery/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/bootstrap/jquery/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <link href="/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/font.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">

<title>Projeto</title>
  </head>
  
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/jquery/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
   
    <script type="text/javascript" src="/bootstrap/jquery/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
    <link href="/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <title>Home</title>
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
            <li>
              <a href="${linkTo[ProjetoController].formulario}"> Cadastrar Projeto</a>
            </li>
            <li>
              <a href="${linkTo[PesquisadorController].formulario}"> Cadastrar Pesquisador</a>
            </li>
            <li>
              <a href="${linkTo[ProjetoController].formulario}"> Atividades</a>
            </li>
            <li>
              <a href="${linkTo[DepartamentoController].formulario}"> Cadastrar Departamento</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <c:if test="${not empty mensagem}">
      <p class="mensagem">${mensagem}</p>
    </c:if>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center text-primary" style="COLOR: #397cbb;">Categorias Cadastradas</h1>
            <p></p>
            <p></p>
          </div>
        </div>
      </div>
    </div>
    
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <table class="table table-bordered table-condensed table-striped">
              <thead>
                <tr>
                  <th class="active">Tipo de Categorias</th>
 
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${categoriaList}" var="categoria">
                <tr>
                  <td>${categoria.tipo}</td>
                  <td class="hidden-xs">
                    <a href="${linkTo[CategoriaController].edita}?tipo=${categoria.tipo}"> <i class="fa fa-2x fa-fw text-primary fa-edit"></i></a>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>