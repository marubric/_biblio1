package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import io.github.oliviercailloux.y2017._biblio1.service.*;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DeleteManifestation extends HttpServlet {

    @EJB
    ManifestationFacade manF = new ManifestationFacade();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get id of a Manifestation
        Long idManif;
        idManif = Long.parseLong(request.getParameter("id_manif"));
        
        // Find the manifestation into database
        // and remove it
        Manifestation man = manF.find(idManif);
        manF.remove(man);
        
        // Get all manifestation from database
        // to send it to the page for list
        List <Manifestation> manifs = manF.findAll();
        request.setAttribute("manifs", manifs);
        
        getServletContext().getRequestDispatcher("/listManifestation.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }
    
}
