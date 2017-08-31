package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mrubrice
 */
public class SearchItem extends HttpServlet {


    @PersistenceContext
    private EntityManager em;
  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/listItem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Creation of variables
        Query query= null;
        String sql;
        String choice = request.getParameter("filter");
        String rep = request.getParameter("content");
        
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("_biblio1PU");
	EntityManager em = emfactory.createEntityManager( );
        
        // Do the requête function of the filter value
        switch(choice){
            case "exhibitionDate":
                sql = "SELECT I FROM Item I WHERE I.exhibitionDate LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "manif":
                sql = "SELECT I FROM Item I INNER JOIN I.manifs M WHERE UPPER(M.title) LIKE UPPER(:manif) OR UPPER(M.publicationPlace) LIKE UPPER(:manif)";
                query = em.createQuery(sql).
                setParameter("manif", rep);
                break;
            case "identifier":
                sql = "SELECT I FROM Item I WHERE I.identifier LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            default:
                sql = "SELECT I FROM Item I WHERE I.provenance LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
        }
        
        // Get all items from the database associate with the filter value
        // send it to the view
        List<Item> items = query.getResultList();
        request.setAttribute("items", items);
        em.close();
        emfactory.close();
        
       getServletContext().getRequestDispatcher("/listItem.jsp").forward(request, response);
    }

   

}
