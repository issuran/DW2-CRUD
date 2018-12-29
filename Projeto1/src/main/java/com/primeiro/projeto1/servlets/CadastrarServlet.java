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

@WebServlet(name = "CadastrarServlet", urlPatterns = {"/CadastrarServlet"})
public class CadastrarServlet extends HttpServlet implements Serializable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session != null){
            Map<String, String[]> parametros = request.getParameterMap();

            if (parametros.isEmpty()){
                request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                return;
            }

            if (parametros.containsKey("nome") &&
                parametros.containsKey("descricao") &&
                parametros.containsKey("imagem") &&
                parametros.containsKey("estoque") &&
                parametros.containsKey("preco")){

                Produto produto = new Produto(getProdutoID(request),
                                            parametros.get("nome")[0].toString(),
                                            parametros.get("descricao")[0].toString(),
                                            parametros.get("imagem")[0].toString(),
                                            parametros.get("preco")[0].toString().replaceAll("-", ""),
                                            parametros.get("estoque")[0].toString().replaceAll("-", ""));

                List<Produto> lista = criarListaProdutos(request);
                lista.add(produto);
                request.getSession().setAttribute("listaProdutos", lista);

                //request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                response.sendRedirect("index.html");
                return;
            } else {
                response.sendRedirect("index.html");
                return;
            }
        
        }
        else{
            response.sendRedirect("index.html");
        }
        
        
    }
    
    private Integer getProdutoID(HttpServletRequest request) {
        HttpSession session = request.getSession();        
        
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        else {
            count ++;
        }
        
        session.setAttribute("count", count);
        
	return count;
    }
    
    private List<Produto> criarListaProdutos(HttpServletRequest request) {
        
        HttpSession session = request.getSession();
        
        List<Produto> lista = (ArrayList<Produto>) session.getAttribute("listaProdutos");
        if (lista == null) {
            lista = new ArrayList<Produto>();
        }               
        
	return lista;
    }
}
