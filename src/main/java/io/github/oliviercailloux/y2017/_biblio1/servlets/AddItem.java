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
public class AddItem extends HttpServlet {
    
    @EJB
    ItemFacade itmF = new ItemFacade();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create variables 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String provenance,identifier;
        Date dtI=null;
        
        // Get all informations of item
        identifier = request.getParameter("ident");
        provenance = request.getParameter("prov");
        
        try {
            dtI = sdf.parse(request.getParameter("dateI"));
        } catch (ParseException ex) {
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation of Object item to insert into database
        Item itm = new Item(identifier,provenance,dtI);
        itmF.create(itm);
    }

    // redirection to the Additem page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addItem.html").forward(request, response);
    }

    // Redirection to the start page
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }

}
