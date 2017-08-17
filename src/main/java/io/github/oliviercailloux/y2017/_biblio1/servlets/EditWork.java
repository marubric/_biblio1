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
public class EditWork extends HttpServlet {

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
        Long idWork;
        
        idWork = Long.parseLong(request.getParameter("id_work"));
        
        Work1 work = workF.find(idWork);
        
        request.setAttribute("work", work);
        
        getServletContext().getRequestDispatcher("/editWork.jsp").forward(request, response);
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
        Long idWork;
        
        idWork = Long.parseLong(request.getParameter("id_work"));
        
        // Get all information of work
        title = request.getParameter("title");
        indentA = request.getParameter("indendA");
        context = request.getParameter("context");
        form = request.getParameter("form");
        distCha = request.getParameter("distCha");
        
        try {
            dtW = request.getParameter("dateW").equals("")? null :sdf.parse(request.getParameter("dateW"));
        } catch (ParseException ex) {
            Logger.getLogger(EditWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation of objects
        Work1 wk = workF.find(idWork);
        
        wk.setTitle(title);
        wk.setIntendedAudience(indentA);
        wk.setContext(context);
        wk.setDistinctCharacteristic(distCha);
        wk.setDate(dtW);
        
        workF.edit(wk);
       
       getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
}
