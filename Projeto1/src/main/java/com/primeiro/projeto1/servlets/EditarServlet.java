/*
Trabalho Prático de Desenvolvimento Web 2 (IFSP - ADS, 2015/2)

Desenvolvido por:

    Lucas Masalskas RA: 1101579
    Tiago Oliveira  RA: 1101986
*/
package com.primeiro.projeto1.servlets;

import com.primeiro.projeto1.classes.Produto;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

@WebServlet(name = "EditarServlet", urlPatterns = {"/EditarServlet"})
public class EditarServlet extends HttpServlet implements Serializable{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(session != null){

            List<Produto> lista = (ArrayList<Produto>) request.getSession().getAttribute("listaProdutos");        
            //Edita ou deleta um campo
            Map<String, String[]> parametros = request.getParameterMap();

            if(!request.getParameter("acao").equals("editando"))
            {      
                if(request.getParameter("acao")==null) {
                    response.sendRedirect("index.html");   
                    return;
                }
                else if (request.getParameter("acao").equals("deletar")){
                    //DELETAR
                    try {

                        Integer a = Integer.parseInt(request.getSession().getAttribute("id").toString());  

                        for (int index = 0; index < lista.size(); index++){

                            if (lista.get(index).getId().equals(a)){
                                lista.remove(index);
                                request.getSession().setAttribute("id", null);
                                request.getSession().setAttribute("listaProdutos", lista);
                                break;
                            }
                        }

                        //lista.remove(request.getSession().getAttribute("id"));

                        response.sendRedirect("index.html");
                        return;
                    } catch (NumberFormatException e) {
                        System.out.println("Botao errado inválida!");
                    }
                }

            }

            // Redireciona para pagina Editar
            // Checa se ID existe
            Integer a = Integer.parseInt(request.getParameter("id"));


            boolean flag = false;
            for (int index = 0; index < lista.size(); index++){
                if (lista.get(index).getId().equals(a)){
                    request.getSession().setAttribute("indexProduto", index);
                    flag = true;
                    break;
                }

            }

            if (flag){
                request.getSession().setAttribute("id", request.getParameter("id"));
                request.getRequestDispatcher("/WEB-INF/editar.jsp").forward(request, response);
                return;
            }
            else {
                response.sendRedirect("index.html");
                return;
            }
        }
        else{
            response.sendRedirect("index.html");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session != null){
            

            List<Produto> lista = (ArrayList<Produto>) request.getSession().getAttribute("listaProdutos");        
            //Edita ou deleta um campo
            Map<String, String[]> parametros = request.getParameterMap();


            try{
                if(request.getParameter("acao")==null ){
                    response.sendRedirect("index.html");
                    return;
                }
                else if (request.getParameter("acao").equals("editar")){
                    //EDITAR
                    try {
                        // Checa se todos parâmetros foram passados
                        if (parametros.containsKey("nome") &&
                            parametros.containsKey("descricao") &&
                            parametros.containsKey("imagem") &&
                            parametros.containsKey("estoque") &&
                            parametros.containsKey("preco")){
                            // Checa se ID existe
                            Integer a = Integer.parseInt(request.getSession().getAttribute("id").toString());
                            //Produto produtoASerEditado;

                            //for (Produto produto : lista){
                            // O for de antes não funcionava nesse caso
                            boolean flag = true;
                            for (int index = 0; index < lista.size(); index++){
                                if (lista.get(index).getId().equals(a)){

                                    // Atualiza o item da lista sem mudar o ID
                                    lista.get(index).setNome(parametros.get("nome")[0].toString());
                                    lista.get(index).setDescricao(parametros.get("descricao")[0].toString());
                                    lista.get(index).setImagem(parametros.get("imagem")[0].toString());
                                    lista.get(index).setEstoque(parametros.get("estoque")[0].toString().replaceAll("-", ""));                                    
                                    lista.get(index).setPreco(parametros.get("preco")[0].toString().replaceAll("-", ""));

                                    // Atualiza lista
                                    request.getSession().setAttribute("listaProdutos", lista);
                                    flag = false;
                                    response.sendRedirect("index.html");

                                    return;
                                }                            
                            }
                            if(flag){
                                response.sendRedirect("index.html");
                                return;
                            }


                        } else {
                            response.sendRedirect("index.html");
                            return;
                        }    
                    } catch (NumberFormatException e) {
                        System.out.println("Botao errado inválida!");
                    }
                }


                else           
                    response.sendRedirect("index.html");
            }
            catch(ExceptionInInitializerError e) {                 
                response.sendRedirect("index.html");
            }

        }
        else{
            response.sendRedirect("index.html");
        }
        
        
    }
}
