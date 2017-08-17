/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import io.github.oliviercailloux.y2017._biblio1.service.*;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AddAuthor extends HttpServlet {

    @EJB
    Person1Facade persF = new Person1Facade();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstName,lastName,design;
        Date dtB=null,dtD=null;
        // Get all informations of person
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        design = request.getParameter("design");
        
        try {
            dtB = sdf.parse(request.getParameter("dateBirth"));
            dtD = sdf.parse(request.getParameter("dateDeath"));
        } catch (ParseException ex) {
            Logger.getLogger(AddWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Person1 pers = new Person1(firstName,lastName,design,dtB,dtD);
        persF.create(pers);
    }

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
        getServletContext().getRequestDispatcher("/addAuthor.jsp").forward(request, response);
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
        processRequest(request, response);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
