/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Tiposorganismos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author danie
 */
@Stateless
public class TiposorganismosFacade extends AbstractFacade<Tiposorganismos> {

    @PersistenceContext(unitName = "MisionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposorganismosFacade() {
        super(Tiposorganismos.class);
    }
    public List<Tiposorganismos> TiposOrganismo(){
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Tiposorganismos.findAll");
        return q.getResultList();
    }
}
