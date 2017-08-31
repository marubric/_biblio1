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
public class SearchWork extends HttpServlet {
    
    @PersistenceContext
    private EntityManager em;
    
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
            case "date":
                sql = "SELECT W FROM Work W WHERE W.date LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "author":
                sql = "SELECT W FROM Work W INNER JOIN W.pers P WHERE UPPER(P.firstName) LIKE UPPER(:author) OR UPPER(P.lastName) LIKE UPPER(:author)";
                query = em.createQuery(sql).
                setParameter("author", rep);
                break;
            case "form":
                sql = "SELECT W FROM Work W WHERE W.form LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "context":
                sql = "SELECT W FROM Work W WHERE W.context LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "intendAud":
                sql = "SELECT W FROM Work W WHERE W.intendedAudience LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "distCha":
                sql = "SELECT W FROM Work W WHERE W.distinctCharacteristic LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            default:
                sql = "SELECT W FROM Work W WHERE W.title LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
        }
        
        // Get all works from the database associate with the filter value
        // send it to the view
	List<Work> works = query.getResultList();
	request.setAttribute("works", works);
	em.close( );
	emfactory.close( );
   
        getServletContext().getRequestDispatcher("/listWork.jsp").forward(request, response);
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/listWork.jsp").forward(request, response);
    }
}
