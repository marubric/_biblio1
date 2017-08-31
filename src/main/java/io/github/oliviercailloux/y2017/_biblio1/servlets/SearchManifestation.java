package io.github.oliviercailloux.y2017._biblio1.servlets;

import io.github.oliviercailloux.y2017._biblio1.modele.Manifestation;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mrubrice
 */
public class SearchManifestation extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
                sql = "SELECT M FROM Manifestation M WHERE M.date LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "expr":
                sql = "SELECT M FROM Manifestation M INNER JOIN Expression E WHERE UPPER(E.title) LIKE UPPER(:expression) OR UPPER(E.form) LIKE UPPER(:expression) OR UPPER(E.context) LIKE UPPER(:expression)";
                query = em.createQuery(sql).
                setParameter("expression", rep);
                break;
            case "itm":
                sql = "SELECT M FROM Manifestation M INNER JOIN Item I WHERE UPPER(I.identifier) LIKE UPPER(:item) OR UPPER(I.provenance) LIKE UPPER(:item)";
                query = em.createQuery(sql).
                setParameter("item", rep);
                break;
            case "edition":
                sql = "SELECT M FROM Manifestation M WHERE M.edition LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "publisher":
                sql = "SELECT M FROM Manifestation M WHERE M.publisher LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "publication":
                sql = "SELECT M FROM Manifestation M WHERE M.publicationPlace LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "manID":
                sql = "SELECT M FROM Manifestation M WHERE M.manifestationID LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "srcA":
                sql = "SELECT M FROM Manifestation M WHERE M.sourceAcquisition LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            case "typeF":
                sql = "SELECT M FROM Manifestation M WHERE M.typeFace LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
            default:
                sql = "SELECT M FROM Manifestation M WHERE M.title LIKE :title";
                query = em.createQuery(sql).
                setParameter("title", rep);
                break;
        }
        
        // Get all expression associate of the value of the filter
        // send it to the view
	List<Manifestation> manifs = query.getResultList();
	request.setAttribute("manifs", manifs);
	em.close( );
	emfactory.close( );
        
        getServletContext().getRequestDispatcher("/listManifestation.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/listManifestation.jsp").forward(request, response);
    }

}
