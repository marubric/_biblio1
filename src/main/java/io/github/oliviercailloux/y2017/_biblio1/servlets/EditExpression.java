package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import io.github.oliviercailloux.y2017._biblio1.service.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author mrubrice
 */
public class EditExpression extends HttpServlet {
    
    @EJB
    ExpressionFacade exprF = new ExpressionFacade();
    
    @EJB
    WorkFacade workF = new WorkFacade();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get id of a work
        Long idExpr;
        idExpr = Long.parseLong(request.getParameter("id_expr"));
        
        // Find the work into database
        // send it to the edit page of work
        Expression expr = exprF.find(idExpr);
        request.setAttribute("expr", expr);
        getServletContext().getRequestDispatcher("/editExpression.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Create variables
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String title,context,form,lang,distCha,criticRep;
        Date dtE=null;
        Long idExpr;
        Expression exp;
        
        // Get all information of an expression
        title = request.getParameter("titleE");
        lang = request.getParameter("lang");
        context = request.getParameter("contextE");
        form = request.getParameter("formE");
        distCha = request.getParameter("distChaE");
        criticRep = request.getParameter("rep");
        idExpr = Long.parseLong(request.getParameter("id_expr"));
        
        try {
            dtE = request.getParameter("dateE").equals("")? null :sdf.parse(request.getParameter("dateE"));
        } catch (ParseException ex) {
            Logger.getLogger(EditExpression.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation objects Expression to insert into database
        exp = exprF.find(idExpr);
        
        // Edit variables of the object Expression
        exp.setTitle(title);
        exp.setLanguage(lang);
        exp.setContext(context);
        exp.setDistinctCharacteristic(distCha);
        exp.setForm(form);
        exp.setCriticalResponse(criticRep);
        exp.setDate(dtE);
        exprF.edit(exp);
       
       getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        
    }
}
