/*
 * Classe Facade pour les centre d'examens.
 */
package com.noah.issco.models;

import com.noah.issco.entities.Centre;
import com.noah.issco.models.facades.AbstractFacade;
import javax.ejb.Stateless;

/**
 *
 * @author shelby
 */
@Stateless
public class CentreFacade extends AbstractFacade<Centre>{
    
    public CentreFacade(){
        super(Centre.class);
    } 
}
