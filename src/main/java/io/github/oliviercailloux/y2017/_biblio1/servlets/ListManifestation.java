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
public class ListManifestation extends HttpServlet {

    @EJB
    ManifestationFacade manF = new ManifestationFacade();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        // Get all objects from the database
        List<Manifestation> manifs = manF.findAll();
        
        // initialize attribute to send to the view
        request.setAttribute("manifs", manifs);
        
        getServletContext().getRequestDispatcher("/listManifestation.jsp").forward(request, response);
    }

}
