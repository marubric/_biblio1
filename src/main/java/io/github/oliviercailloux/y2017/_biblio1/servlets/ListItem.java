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
public class ListItem extends HttpServlet {

   @EJB
    ItemFacade itmF = new ItemFacade();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        // Get all works from the database
        List<Item> items = itmF.findAll();
        
        // initialize attribute to send to the view
        request.setAttribute("items", items);
        
        getServletContext().getRequestDispatcher("/listItem.jsp").forward(request, response);
    }
}
