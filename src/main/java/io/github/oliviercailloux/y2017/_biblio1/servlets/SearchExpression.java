package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.*;
import io.github.oliviercailloux.y2017._biblio1.service.*;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
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
public class SearchExpression extends HttpServlet {

    @EJB
    WorkFacade workF = new WorkFacade();
    @EJB
    ExpressionFacade exprF = new ExpressionFacade();
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Creation fo variables
        Query query= null;
        String sql;
        String choice = request.getParameter("filter");
        String rep = request.getParameter("content");
        
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("_biblio1PU");
	EntityManager em = emfactory.createEntityManager( );
        
        // requete depend on the value of filter
        switch(choice){
            case "date":
                sql = "SELECT E FROM Expression E WHERE E.date LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "work":
                sql = "SELECT E FROM Expression E INNER JOIN Work W WHERE UPPER(W.title) LIKE UPPER(:work)";
                query = em.createQuery(sql).
                setParameter("work", rep);
                break;
            case "form":
                sql = "SELECT WE FROM Expression E WHERE E.form LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "context":
                sql = "SELECT E FROM Expression E WHERE E.context LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "lang":
                sql = "SELECT E FROM Expression E WHERE E.language LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "criticalrep":
                sql = "SELECT E FROM Expression E WHERE E.criticalReponse LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "distCha":
                sql = "SELECT E FROM Expression E WHERE E.distinctCharacteristic LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            default:
                sql = "SELECT E FROM Expression E WHERE E.title LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
        }
        
        // Get all expression associate of the value of the filter
        // send it to the view
	List<Expression> exprs = query.getResultList();
	request.setAttribute("exprs", exprs);
	em.close( );
	emfactory.close( );
   
        getServletContext().getRequestDispatcher("/listExpression.jsp").forward(request, response);
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/listExpression.jsp").forward(request, response);
    }
}
