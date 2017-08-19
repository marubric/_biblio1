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
public class DeleteWork extends HttpServlet {

     @EJB
     WorkFacade workF = new WorkFacade(); 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get id of a work
        Long idWork;
        idWork = Long.parseLong(request.getParameter("id_work"));
        
        // Find the work into database
        // and remove it
        Work work = workF.find(idWork);
        workF.remove(work);
        
        // Get all works from database
        // to send it to the page for list
        List <Work> works = workF.findAll();
        request.setAttribute("works", works);
        
        getServletContext().getRequestDispatcher("/listWork.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }

}
