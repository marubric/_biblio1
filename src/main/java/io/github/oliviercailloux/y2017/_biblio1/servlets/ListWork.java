/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import io.github.oliviercailloux.y2017._biblio1.service.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mrubrice
 */
public class ListWork extends HttpServlet {

    @EJB
    WorkFacade workF = new WorkFacade();
    
    @EJB
    PersonFacade persF = new PersonFacade();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        // Get all works from the database
        List<Work> works = workF.findAll();
        
        // initialize attribute to send to the view
        request.setAttribute("works", works);
        
        getServletContext().getRequestDispatcher("/listWork.jsp").forward(request, response);
    }

}
