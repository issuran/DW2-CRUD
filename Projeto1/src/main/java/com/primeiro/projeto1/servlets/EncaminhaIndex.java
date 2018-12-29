/*
Trabalho Prático de Desenvolvimento Web 2 (IFSP - ADS, 2015/2)

Desenvolvido por:

    Lucas Masalskas RA: 1101579
    Tiago Oliveira  RA: 1101986
*/

package com.primeiro.projeto1.servlets;

import com.primeiro.projeto1.classes.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "oi", urlPatterns = {"/index.html"})
public class EncaminhaIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	//Encaminha para index.jsp
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);  
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }    
}
