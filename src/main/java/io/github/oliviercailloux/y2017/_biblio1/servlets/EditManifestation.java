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
public class EditManifestation extends HttpServlet {

    @EJB
    ExpressionFacade expF = new ExpressionFacade();
    
    @EJB
    ManifestationFacade manF = new ManifestationFacade();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get id of an manifestation
        Long idManif;
        idManif = Long.parseLong(request.getParameter("id_manif"));
        
        // Find the manifestation into database
        // send it to the edit page of manifestation
        Manifestation manif = manF.find(idManif);
        request.setAttribute("manif", manif);
        
        List <Expression> exprs =expF.findAll();
        request.setAttribute("exprs", exprs);
        getServletContext().getRequestDispatcher("/editManifestation.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create variables
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String titleM,edition,state,publication,publisher,src,typeF,manID;
        Date dtM=null;
        Long idManif;
        Manifestation man;
        
        // Get all information of a manifestation
        titleM = request.getParameter("ident");
        edition = request.getParameter("prov");
        state = request.getParameter("state");
        publication = request.getParameter("publication");
        publisher = request.getParameter("publisher");
        typeF = request.getParameter("typeF");
        src = request.getParameter("src");
        manID = request.getParameter("manID");
        idManif = Long.parseLong(request.getParameter("id_manif"));
        
        try {
            dtM = request.getParameter("dateM").equals("")? null :sdf.parse(request.getParameter("dateM"));
        } catch (ParseException ex) {
            Logger.getLogger(EditExpression.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation objects Item to insert into database
        man = manF.find(idManif);
        Expression expr = expF.find(Long.parseLong(request.getParameter("id_Expr")));
        
        // Edit variables of the object Item
        man.setDate(dtM);
        man.setEdition(edition);
        man.setManifestationID(manID);
        man.setPublicationPlace(publication);
        man.setPublisher(publisher);
        man.setSourceAcquisition(src);
        man.setStatementResponsibility(state);
        man.setExpr(expr);
        man.setTitle(titleM);
        man.setTypeFace(typeF);
        
        manF.edit(man);
       
       getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }

}
