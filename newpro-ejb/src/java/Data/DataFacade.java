/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kishore
 */
@Stateless
public class DataFacade extends AbstractFacade<Data> implements DataFacadeLocal {

    @PersistenceContext(unitName = "newpro-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DataFacade() {
        super(Data.class);
    }
    
}
