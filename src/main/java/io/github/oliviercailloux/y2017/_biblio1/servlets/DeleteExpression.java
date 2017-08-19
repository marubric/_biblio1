package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import io.github.oliviercailloux.y2017._biblio1.service.*;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mrubrice
 */
public class DeleteExpression extends HttpServlet {

     @EJB
     ExpressionFacade exprF = new ExpressionFacade(); 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get id of an expression
        Long idExpr;
        idExpr = Long.parseLong(request.getParameter("id_expr"));
        
        // Find the expression into database
        // and remove it
        Expression expr = exprF.find(idExpr);
        exprF.remove(expr);
        
        // Get all expression from database
        // to send it to the page for list
        List <Expression> exprs = exprF.findAll();
        request.setAttribute("exprs", exprs);
        
        getServletContext().getRequestDispatcher("/listExpression.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }

}
