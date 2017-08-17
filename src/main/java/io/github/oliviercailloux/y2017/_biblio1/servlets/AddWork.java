/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.github.oliviercailloux.y2017._biblio1.service.*;
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
    Work1Facade workF = new Work1Facade();
    
    @EJB
    Person1Facade persF = new Person1Facade();
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List <Person1> authors = persF.findAll();
        
        Logger.getLogger(AddWork.class.getName()).log(Level.SEVERE, null, "TEST");
        
        request.setAttribute("authors", authors);
        
        getServletContext().getRequestDispatcher("/addWork.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String title,indentA,context,form,distCha;
        Date dtW=null;
        Long idAuthor;
        
        Person1 person;
        
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
        
        // Instanciation of objects
        Work1 wk = new Work1(title,form,dtW,context,distCha,indentA);
        
        person = (Person1) persF.find(idAuthor);
        wk.getPers().add(person);
        workF.create(wk);
       
       getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
}
