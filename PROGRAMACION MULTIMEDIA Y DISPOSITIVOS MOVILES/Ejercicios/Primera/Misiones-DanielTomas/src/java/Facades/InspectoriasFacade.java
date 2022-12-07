/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Inspectorias;
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
public class InspectoriasFacade extends AbstractFacade<Inspectorias> {

    @PersistenceContext(unitName = "MisionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InspectoriasFacade() {
        super(Inspectorias.class);
    }
    public List<Inspectorias> obtener_sedes(Sedes codOrg){
        EntityManager em = getEntityManager();
        Query q;
        if(codOrg != null){
            q = em.createNamedQuery("Sedes.findSedes").setParameter("codSede", codOrg);
            return q.getResultList();
        }
        return null;
    }
    
}
