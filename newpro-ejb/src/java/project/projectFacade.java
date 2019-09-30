/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 18mx263
 */
@Stateless
public class projectFacade extends AbstractFacade<project> implements projectFacadeLocal {

    @PersistenceContext(unitName = "newpro-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public projectFacade() {
        super(project.class);
    }
    
}
