/*
 * Classe facade pour les années des concours.
 */
package com.noah.issco.models;

import com.noah.issco.entities.AnneesConcours;
import com.noah.issco.models.facades.AbstractFacade;
import javax.ejb.Stateless;

/**
 *
 * @author shelby
 */
@Stateless
public class AnneesConcoursFacade extends AbstractFacade<AnneesConcours>{
    public AnneesConcoursFacade(){
            super(AnneesConcours.class);
    }
}
