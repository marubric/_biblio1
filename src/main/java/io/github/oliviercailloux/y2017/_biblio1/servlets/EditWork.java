package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import java.io.IOException;
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
    WorkFacade workF = new WorkFacade();
    
    @EJB
    PersonFacade persF = new PersonFacade();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get id of a work
        Long idWork;
        idWork = Long.parseLong(request.getParameter("id_work"));
        
        // Find the work into database
        // send it to the edit page of work
        Work work = workF.find(idWork);
        request.setAttribute("work", work);
        getServletContext().getRequestDispatcher("/editWork.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Create variables
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String title,indentA,context,form,distCha;
        Date dtW=null;
        Long idWork;
        
        // Get all information of work
        title = request.getParameter("title");
        indentA = request.getParameter("indendA");
        context = request.getParameter("context");
        form = request.getParameter("form");
        distCha = request.getParameter("distCha");
        idWork = Long.parseLong(request.getParameter("id_work"));
        
        try {
            dtW = request.getParameter("dateW").equals("")? null :sdf.parse(request.getParameter("dateW"));
        } catch (ParseException ex) {
            Logger.getLogger(EditWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Instanciation objects Works to insert into database
        Work wk = workF.find(idWork);
        
        // Edit variables of the object Works
        wk.setTitle(title);
        wk.setIntendedAudience(indentA);
        wk.setContext(context);
        wk.setDistinctCharacteristic(distCha);
        wk.setDate(dtW);
        workF.edit(wk);
       
       getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
}
