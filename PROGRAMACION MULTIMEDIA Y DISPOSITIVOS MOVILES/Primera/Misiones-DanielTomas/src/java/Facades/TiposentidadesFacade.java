/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

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
public class TiposentidadesFacade extends AbstractFacade<Tiposentidades> {

    @PersistenceContext(unitName = "MisionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposentidadesFacade() {
        super(Tiposentidades.class);
    }
    public List<Tiposentidades> obtener_entidades(Tiposorganismos codOrg){
        EntityManager em = getEntityManager();
        Query q;
        if(codOrg != null){
            q = em.createNamedQuery("Tiposentidades.findEntidades").setParameter("elOrg", codOrg);
            return q.getResultList();
        }
        return null;
    }
}
