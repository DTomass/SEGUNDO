/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Sedes;
import Entidades.Tiposentidades;
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
public class SedesFacade extends AbstractFacade<Sedes> {

    @PersistenceContext(unitName = "MisionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SedesFacade() {
        super(Sedes.class);
    }
    public List<Sedes> obtener_entidades(Sedes codOrg){
        EntityManager em = getEntityManager();
        Query q;
        if(codOrg != null){
            q = em.createNamedQuery("Sedes.findSedes").setParameter("codSede", codOrg);
            return q.getResultList();
        }
        return null;
    }
}
