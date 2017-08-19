package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import io.github.oliviercailloux.y2017._biblio1.service.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class AddAuthor extends HttpServlet {

    @EJB
    PersonFacade persF = new PersonFacade();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create variables 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstName,lastName,design;
        Date dtB=null,dtD=null;
        
        // Get all informations of person
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        design = request.getParameter("design");
        
        try {
            dtB = sdf.parse(request.getParameter("dateBirth"));
            dtD = sdf.parse(request.getParameter("dateDeath"));
        } catch (ParseException ex) {
            Logger.getLogger(AddWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation of Object Person to insert into database
        Person pers = new Person(firstName,lastName,design,dtB,dtD);
        persF.create(pers);
    }

    // redirection to the Addauthor page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addAuthor.html").forward(request, response);
    }

    // Redirection to the start page
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }

}
