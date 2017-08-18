package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import io.github.oliviercailloux.y2017._biblio1.service.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author mrubrice
 */
public class AddWork extends HttpServlet {

    @EJB
    WorkFacade workF = new WorkFacade();
    
    @EJB
    PersonFacade persF = new PersonFacade();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Vérifier si je rentre bien ici
        //Logger.getLogger(AddWork.class.getName()).log(Level.SEVERE, null, "TEST");
        
        // Get list of persons from the database
        // To send to the view
        List <Person> authors = persF.findAll();
        request.setAttribute("authors", authors);
        
        getServletContext().getRequestDispatcher("/addWork.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Initialization of variables
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String title,indentA,context,form,distCha;
        Date dtW=null;
        Long idAuthor;
        Person person;
        
        // Get all information of work
        title = request.getParameter("title");
        indentA = request.getParameter("indendA");
        context = request.getParameter("context");
        form = request.getParameter("form");
        distCha = request.getParameter("distCha");
        idAuthor = Long.parseLong(request.getParameter("id_author"));
        
        try {
            dtW = request.getParameter("dateW").equals("")? null :sdf.parse(request.getParameter("dateW"));
        } catch (ParseException ex) {
            Logger.getLogger(AddWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation of objects to insert into database
        Work wk = new Work(title,form,dtW,context,distCha,indentA);
        person = (Person) persF.find(idAuthor);
        wk.getPers().add(person);
        workF.create(wk);
       
       getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
}
