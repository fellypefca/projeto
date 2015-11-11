<html><head>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
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
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center text-primary">Universidade Federal de Campina Grande</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="text-left text-muted">SCP - Sistema de Cadastro de Projetos</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <ul class="lead text-muted">
              <li>
                <a href="${linkTo[ProjetoController].lista}"> Lista de Projetos</a>
              </li>
              <li>
                <a href="${linkTo[ProjetoController].lista}"> Lista de Pesquisadores</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center">Team</h1>
            <p class="text-center">We are a group of skilled individuals.</p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-2">
            <img src="http://pingendo.github.io/pingendo-bootstrap/assets/user_placeholder.png"
            class="img-circle img-responsive">
          </div>
          <div class="col-md-4">
            <h3 class="text-left">Fellype Cavalcante</h3>
            <p class="text-left">Lorem ipsum dolor sit amet, adipiscing elit Aenean commodo ligula eget.</p>
          </div>
          <div class="col-md-2">
            <img src="http://pingendo.github.io/pingendo-bootstrap/assets/user_placeholder.png"
            class="img-circle img-responsive">
          </div>
          <div class="col-md-4">
            <h3 class="text-left">Luiza Carvalho</h3>
            <p class="text-left">Lorem ipsum dolor sit amet, adipiscing elit Aenean commodo ligula eget.</p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-2">
            <img src="http://pingendo.github.io/pingendo-bootstrap/assets/user_placeholder.png"
            class="img-circle img-responsive">
          </div>
          <div class="col-md-4">
            <h3 class="text-left">Gustavo Nóbrega</h3>
            <p class="text-left">Lorem ipsum dolor sit amet, adipiscing elit Aenean commodo ligula eget.</p>
          </div>
          <div class="col-md-2">
            <img src="http://pingendo.github.io/pingendo-bootstrap/assets/user_placeholder.png"
            class="img-circle img-responsive">
          </div>
          <div class="col-md-4 text-center">
            <h3 class="text-left">Reinaldo Gomes</h3>
            <p class="text-left">Lorem ipsum dolor sit amet, adipiscing elit Aenean commodo ligula eget.</p>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>