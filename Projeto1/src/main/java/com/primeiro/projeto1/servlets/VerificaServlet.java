/*
Trabalho Prático de Desenvolvimento Web 2 (IFSP - ADS, 2015/2)

Desenvolvido por:

    Lucas Masalskas RA: 1101579
    Tiago Oliveira  RA: 1101986
*/

package com.primeiro.projeto1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
                                            
@WebServlet(name = "VerificaServlet", urlPatterns = {"/VerificaServlet"})
public class VerificaServlet extends HttpServlet {    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        
        HttpSession session = request.getSession();
                        
        try{
            if(request.getParameter("acao")==null )
                request.getRequestDispatcher("index.html").forward(request, response);            
            else if (request.getParameter("acao").equals("editar"))
                request.getRequestDispatcher("/WEB-INF/editar.jsp").forward(request, response);
            else if (request.getParameter("acao").equals("cadastrar"))
                request.getRequestDispatcher("/WEB-INF/cadastrar.jsp").forward(request, response);
            else if (request.getParameter("acao").equals("invalidate")){
                session.invalidate();
                request.getRequestDispatcher("index.html").forward(request, response);            
            }
            else           
                request.getRequestDispatcher("index.html").forward(request, response);
        }
        catch(ExceptionInInitializerError e) {                 
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String[]> parametros = request.getParameterMap();
	if (parametros.containsKey("btcadastro")) {
	    try {
                
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	    } catch (NumberFormatException e) {
		System.out.println("Botao errado inválida!");
	    }
	}
        else
            request.getRequestDispatcher("index.html").forward(request, response);
    }

}
