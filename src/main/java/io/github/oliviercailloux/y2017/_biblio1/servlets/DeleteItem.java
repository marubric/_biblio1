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
public class DeleteItem extends HttpServlet {

   @EJB
    ItemFacade itmF = new ItemFacade();
    ManifestationFacade manif = new ManifestationFacade();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get id of a Item
        Long idItem;
        idItem = Long.parseLong(request.getParameter("id_item"));
        
        // Find the item into database
        // and remove it
        Item item = itmF.find(idItem);
        itmF.remove(item);
        
        // Get all manifestation from database
        // to send it to the page for list
        List <Item> items = itmF.findAll();
        request.setAttribute("items", items);
       
        getServletContext().getRequestDispatcher("/listItem.jsp").forward(request, response);
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }

}
