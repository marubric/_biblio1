package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import io.github.oliviercailloux.y2017._biblio1.service.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mrubrice
 */
public class AddExpression extends HttpServlet {
    
    @EJB
    ExpressionFacade expF = new ExpressionFacade();
    
    @EJB
    WorkFacade workF = new WorkFacade();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get list of works from the database
        // To send to the view
        List <Work> works = workF.findAll();
        request.setAttribute("works", works);
        
        // Get list of person from the database
        // To send to the view
        //List <Person> pers = persF.findAll();
        //request.setAttribute("pers", pers);
        
        getServletContext().getRequestDispatcher("/addExpression.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Initialization of variables
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String title,context,form,lang,distCha,criticRep;
        Date dtE=null;
        Long idWork;
        Work wk;
        //Long idAuthor;
        //Person person;
        
        // Get all information of an expression
        title = request.getParameter("titleE");
        lang = request.getParameter("lang");
        context = request.getParameter("contextE");
        form = request.getParameter("formE");
        distCha = request.getParameter("distChaE");
        criticRep = request.getParameter("rep");
        idWork = Long.parseLong(request.getParameter("id_Work"));
        
        try {
            dtE = request.getParameter("dateE").equals("")? null :sdf.parse(request.getParameter("dateE"));
        } catch (ParseException ex) {
            Logger.getLogger(AddExpression.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation of object to insert into database
        Expression exp = new Expression(title,form,dtE,lang,distCha,context,criticRep);
        //person = persF.find(idAuthor);
        //exp.getPers().add(person);
        wk = workF.find(idWork);
        exp.setWork(wk);
        
        expF.create(exp);
       
       getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }

}
