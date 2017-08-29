package io.github.oliviercailloux.y2017._biblio1.service;

import io.github.oliviercailloux.y2017._biblio1.modele.Manifestation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mrubrice
 */
@Stateless
public class ManifestationFacade extends AbstractFacade<Manifestation> {

    @PersistenceContext(unitName = "_biblio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ManifestationFacade() {
        super(Manifestation.class);
    }
    
}
