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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Projeto</title>

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
           					 <li><a href="${linkTo[AtividadeController].lista}">Atividades</a></li>
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
    <c:if test="${not empty mensagem}">
      <p class="mensagem">${mensagem}</p>
    </c:if>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center text-primary" style="COLOR: #397cbb;">Lista</h1>
            <p></p>
            <p></p>
          </div>
        </div>
      </div>
    </div>
    <c:set var="lista" value="${stringList}"/> 
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <table class="table table-bordered table-condensed table-striped">
              <thead>
                <tr>
                  <th class="active">Titulo</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${stringList}" var="projeto">
                <tr>
                  <td>${projeto}</td>
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

<tr>
    <td>
        <select name="<c:out value="${param.leftId}"/>" multiple="multiple"
            onDblClick="moveSelectedOptions(this,$('<c:out value="${param.rightId}"/>'),true)"
            id="<c:out value="${param.leftId}"/>" size="5">
    <c:if test="${leftList != null}">
        <c:forEach var="list" items="${leftList}" varStatus="status">
            <option value="<c:out value="${list.value}"/>">
                <c:out value="${list.label}" escapeXml="false" />
            </option>
        </c:forEach>
    </c:if>
        </select>
    </td>
    <td class="moveOptions">
        <button name="moveRight" id="moveRight<c:out value="${param.listCount}"/>" type="button" 
            onclick="moveSelectedOptions($('<c:out value="${param.leftId}"/>'),$('<c:out value="${param.rightId}"/>'),true)">
            &gt;&gt;</button><br />
        <button name="moveAllRight" id="moveAllRight<c:out value="${param.listCount}"/>" type="button"
            onclick="moveAllOptions($('<c:out value="${param.leftId}"/>'),$('<c:out value="${param.rightId}"/>'),true)">
            All &gt;&gt;</button><br />
        <button name="moveLeft" id="moveLeft<c:out value="${param.listCount}"/>" type="button"
            onclick="moveSelectedOptions($('<c:out value="${param.rightId}"/>'),$('<c:out value="${param.leftId}"/>'),true)">
            &lt;&lt;</button><br />
        <button name="moveAllLeft" id="moveAllLeft<c:out value="${param.listCount}"/>" type="button"
            onclick="moveAllOptions($('<c:out value="${param.rightId}"/>'),$('<c:out value="${param.leftId}"/>'),true)">
            All &lt;&lt;</button>
    </td>
    <td>
        <select name="<c:out value="${param.rightId}"/>" multiple="multiple"
            id="<c:out value="${param.rightId}"/>" size="5">
    <c:if test="${rightList != null}">
        <c:forEach var="list" items="${rightList}" varStatus="status">
            <option value="<c:out value="${list.value}"/>">
                <c:out value="${list.label}" escapeXml="false"/>
            </option>
        </c:forEach>
    </c:if>
        </select>
    </td>
</tr>
