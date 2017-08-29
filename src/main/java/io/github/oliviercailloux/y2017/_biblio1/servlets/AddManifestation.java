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
public class AddManifestation extends HttpServlet {

    @EJB
    ManifestationFacade maniF = new ManifestationFacade();
     
    @EJB
    ExpressionFacade expF = new ExpressionFacade();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get list of expression from the database
        // To send to the view
        List <Expression> exprs = expF.findAll();
        request.setAttribute("exprs", exprs);
        
        // Get list of person from the database
        // To send to the view
        //List <Person> pers = persF.findAll();
        //request.setAttribute("pers", pers);
        
        getServletContext().getRequestDispatcher("/addManifestation.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Initialization of variables
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String titleM,edition,state,publication,publisher,src,typeF,manID;
        Date dtM=null;
        Long idExpr;
        Expression exp;
        //Long idAuthor;
        //Person person;
        
        // Get all information of a manifestation
        titleM = request.getParameter("titleM");
        edition = request.getParameter("edition");
        state = request.getParameter("state");
        publication = request.getParameter("publication");
        publisher = request.getParameter("publisher");
        typeF = request.getParameter("typeF");
        src = request.getParameter("src");
        manID = request.getParameter("manID");
        
        idExpr = Long.parseLong(request.getParameter("id_Expr"));
        
        try {
            dtM = request.getParameter("dateM").equals("")? null :sdf.parse(request.getParameter("dateM"));
        } catch (ParseException ex) {
            Logger.getLogger(AddManifestation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation of object to insert into database
        Manifestation man = new Manifestation(titleM,edition,state,publication,publisher,dtM,manID,src,typeF);
        exp = expF.find(idExpr);
        exp.getManifs().add(man);
        man.setExpr(exp);
        //maniF.create(man);
        maniF.edit(man);
       
       getServletContext().getRequestDispatcher("/index.html").forward(request, response);
    }

}
