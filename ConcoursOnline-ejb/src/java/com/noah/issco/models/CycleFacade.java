/*
 *C.
 */
package com.noah.issco.models;

import com.noah.issco.entities.Cycle;
import com.noah.issco.models.facades.AbstractFacade;
import javax.ejb.Stateless;

/**
 *
 * @author shelby
 */
@Stateless
public class CycleFacade extends AbstractFacade<Cycle>{
    public CycleFacade(){
        super(Cycle.class);
    }
    
}
