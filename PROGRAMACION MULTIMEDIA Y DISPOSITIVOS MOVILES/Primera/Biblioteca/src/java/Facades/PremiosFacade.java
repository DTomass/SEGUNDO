/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Premios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author danie
 */
@Stateless
public class PremiosFacade extends AbstractFacade<Premios> {

    @PersistenceContext(unitName = "BibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PremiosFacade() {
        super(Premios.class);
    }
    public List<Premios> premiosLibros(){
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Premios.findTipoLibro");
        return q.getResultList();
    }
    public List<Premios> premiosAutores(){
        em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Premios.findTipoAutor");
        return q.getResultList();
    }
}
