/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.oliviercailloux.y2017._biblio1.service;

import io.github.oliviercailloux.y2017._biblio1.modele.Work1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mrubrice
 */
@Stateless
public class Work1Facade extends AbstractFacade<Work1> {

    @PersistenceContext(unitName = "_biblio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Work1Facade() {
        super(Work1.class);
    }
    
}
