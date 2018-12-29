<!--
Trabalho Prático de Desenvolvimento Web 2 (IFSP - ADS, 2015/2)

Desenvolvido por:

    Lucas Masalskas RA: 1101579
    Tiago Oliveira  RA: 1101986
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->         
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>           
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="js/jquery.maskMoney.js" type="text/javascript"></script>
        <title>Index</title>
    </head>
    <body>
        <br>
        <br>
        <h1>Primeiro Projeto!</h1>
        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">                    
                    <a class="navbar-brand" href="index.html">Site de Produtos</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            
                            <form class="navbar-form navbar-left" role="search" action='index.html' method='get'>
                                <div class="form-group">                                    
                                    <input type="text" class="form-control" placeholder="Buscar por..." name="filtro">
                                </div>
                                <button type="submit" class="btn btn-default">Buscar</button>
                            </form>
                            
                        </li>
                                               
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Produto <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                
                                <li>                                    
                                    <a href="VerificaServlet?acao=cadastrar">Cadastrar</a>
                                </li>
                                <li>
                                    <a href="VerificaServlet?acao=invalidate">Deletar Todos</a>
                                </li>

                            </ul>

                        </li>
                        <li>
                            <a href="VerificaServlet?acao=invalidate">Sair</a>
                        </li>
                        
                    </ul>

                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
        
        
        <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Produtos á venda
                </h1>
            </div>
        </div>
            <br>
            
            
<%//Percorrendo a lista de produtos, com seu número e escrevo seus atributos%>         
        <c:forEach var="produto" items="${listaProdutos}" varStatus="aux" >
            
            <c:if test="${fn:containsIgnoreCase(produto.descricao, param.filtro) ||
                          fn:containsIgnoreCase(produto.nome, param.filtro)||
                          fn:containsIgnoreCase(produto.preco, param.filtro)||
                          fn:containsIgnoreCase(produto.estoque, param.filtro)}">                           

                <a href="EditarServlet?id=${produto.id}&acao=editando">
                    <div class="col-md-4">

                        <div class="panel panel-default">
                            <div class="panel-heading">                        
                           <!--     <a href="EditarServlet?id=${produto.id}&acao=editando"><h4><i class="fa fa-fw fa-check" name="editar" ></i>${produto.nome}</h4></a> -->
                                <h4><i class="fa fa-fw fa-check" name="editar" ></i>${produto.nome}</h4>
                            </div>            
                            <div class="panel-body">
                                <p>Descrição: ${produto.descricao}</p>
                                <img src="${produto.imagem}" class="img-rounded" width="304" height="236">
                                <p>R$ ${produto.preco}</p>
                                <p>Quantidade disponível: ${produto.estoque}</p>
                            </div>
                        </div>
                    </div>
                </a>
            </c:if>
        </c:forEach>                                    
        </div>
    </div>        
    </body>
</html>
