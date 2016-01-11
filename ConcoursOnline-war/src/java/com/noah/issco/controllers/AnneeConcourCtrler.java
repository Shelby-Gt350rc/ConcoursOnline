/*
 * Controller pour l'entité Annee Concours
 */
package com.noah.issco.controllers;

import com.noah.issco.models.AnneesConcoursFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author shelby
 */
@Named(value = "anneeConcourCtrler")
@SessionScoped
public class AnneeConcourCtrler implements Serializable {

    @EJB
    private AnneesConcoursFacade anneesConcoursFacade;

    /**
     * Creates a new instance of AnneeConcourCtrler
     */
    public AnneeConcourCtrler() {
    }
    
}
