<!--
Trabalho Prático de Desenvolvimento Web 2 (IFSP - ADS, 2015/2)

Desenvolvido por:

    Lucas Masalskas RA: 1101579
    Tiago Oliveira  RA: 1101986
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->         
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>           
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="js/jquery.maskMoney.js" type="text/javascript"></script>
        <title>Editar</title>
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
        
        
        <!-- Page Content -->
    <div class="container">

        <!-- Formulario de Edicao de Produto -->
        <form class="form-horizontal" method='post' action='EditarServlet'>
            <fieldset>

            <!-- Form Name -->
            <legend>Editar Produto</legend>

            <!-- Nome input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="nome">Nome do Produto</label>  
              <div class="col-md-8">
                  <input id="nome" name="nome" placeholder="Nome do Produto" class="form-control input-md" required="" type="text" value="${sessionScope.listaProdutos[sessionScope.indexProduto].nome}">
              
              </div>
            </div>

            <!-- Descricao -->
            <div class="form-group">
              <label class="col-md-3 control-label" for="descricao">Descrição</label>
              <div class="col-md-8">                     
                <input id="descricao" name="descricao" placeholder="Descricao do Produto" class="form-control input-md" required="" type="text" value="${sessionScope.listaProdutos[sessionScope.indexProduto].descricao}">                
              </div>
            </div>

            <!-- URL imagem input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="imagem">Link da Imagem</label>  
              <div class="col-md-8">
              <input id="imagem" name="imagem" placeholder="Entre a URL da imagem do produto" class="form-control input-md" required="" type="text" value="${sessionScope.listaProdutos[sessionScope.indexProduto].imagem}">

              </div>
            </div>

            <!-- Preco input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="preco">Preço</label>
              <div class="col-md-3">
                <div class="input-group">
                  <span class="input-group-addon">R$</span>
                  <input id="preco" name="preco" class="form-control" placeholder="Preço do produto" required="" type="text" value="${sessionScope.listaProdutos[sessionScope.indexProduto].preco}" min="0">
                </div>

              </div>
            </div>

            <!-- Estoque input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="estoque">Quantidade em Estoque</label>  
              <div class="col-md-3">

              <input id="estoque" name="estoque" placeholder="Quantidade do produto" class="form-control input-md" required="" type="number" min="0" value="${sessionScope.listaProdutos[sessionScope.indexProduto].estoque}">
              </div>
            </div>
            
            <form class="form-vertical">              
                <button id="bteditar" name="bteditar" class="btn btn-success">Salvar
                <input type='hidden' name='acao' value="editar"/>
                </button>
            </form>
            
            <form class="form-vertical">              
            <button id="btdeletar" name="btdeletar" class="btn btn-success">Deletar
            <input type='hidden' name='acao' value="deletar"/>                          
            </button>
            </form>
                
            <!--        
                    <a href="EditarServlet?acao=editar">Salvar</a>
                    <br>
                    <a href="EditarServlet?acao=deletar">Apagar</a>                   
                
            -->
            
            </fieldset>
        </form>

        
    </div>        
    </body>
    <script>
        $(function() {
            $('#preco').maskMoney();
        })
    </script>
</html>
