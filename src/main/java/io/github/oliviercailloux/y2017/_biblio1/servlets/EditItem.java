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
public class EditItem extends HttpServlet {

   
    @EJB
    ExpressionFacade exprF = new ExpressionFacade();
    
    @EJB
    ItemFacade itmF = new ItemFacade();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get id of an item
        Long idItem;
        idItem = Long.parseLong(request.getParameter("id_item"));
        
        // Find the item into database
        // send it to the edit page of work
        Item item = itmF.find(idItem);
        request.setAttribute("item", item);
        getServletContext().getRequestDispatcher("/editItem.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Create variables
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String provenance,identifier;
        Date dtI=null;
        Long idItem;
        Item itm;
        
        // Get all information of an expression
        provenance = request.getParameter("prov");
        identifier = request.getParameter("ident");
        idItem = Long.parseLong(request.getParameter("id_item"));
        
        try {
            dtI = request.getParameter("dtI").equals("")? null :sdf.parse(request.getParameter("dtI"));
        } catch (ParseException ex) {
            Logger.getLogger(EditItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation objects Item to insert into database
        itm = itmF.find(idItem);
        
        // Edit variables of the object Item
        itm.setExhibitionDate(dtI);
        itm.setIdentifier(identifier);
        itm.setProvenance(provenance);
        
        itmF.edit(itm);
       
       getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        
    }

}
