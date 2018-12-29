<!--
Trabalho Prático de Desenvolvimento Web 2 (IFSP - ADS, 2015/2)

Desenvolvido por:

    Lucas Masalskas RA: 1101579
    Tiago Oliveira  RA: 1101986
-->

<%//atribuição isErrorPage permite que tenhamos acesso ao objeto do exception%>
<%@ page isErrorPage="true" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->         
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>           
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="js/jquery.maskMoney.js" type="text/javascript"></script>
        <title>Error</title>
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
        <div class="text-center">
            <h1>Ops, você fez alguma merda!</h1>
            
                <img src="imagens/404.jpg" class="img-rounded">  <br>                  
            
            <br>   <p><a class="btn btn-info btn-lg" href="index.html" role="button" >Voltar Index</a></p>
        </div>                                
        
    </body>
</html>