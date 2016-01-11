/*
 * Controller pour les centres d'examen
 *agrée.
 */
package com.noah.issco.controllers;

import com.noah.issco.entities.Centre;
import com.noah.issco.models.CentreFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author shelby
 */
@Named(value = "centreCtrler")
@SessionScoped
public class CentreCtrler implements Serializable {

    @EJB
    private CentreFacade centreFacade;
    private List<Centre> element =null;
    private Centre selectioner;
            
    

    /**
     * Creates a new instance of CentreCtrler
     */
    public CentreCtrler() {
    }

    public CentreFacade getCentreFacade() {
        return centreFacade;
    }

    public void setCentreFacade(CentreFacade centreFacade) {
        this.centreFacade = centreFacade;
    }

    public List<Centre> getElement() {
        if(element==null){
            element = getCentreFacade().findAll();
        }
        return element;
    }
      
    public void setElement(List<Centre> element) {
        this.element = element;
    }

    public Centre getSelectioner() {
        return selectioner;
    }

    //obtenir les infos du centre connaissant un id
    public Centre getCentre(java.lang.Integer id) {
        return getCentreFacade().find(id);
    }
    
     public List<Centre> getElementAvailableSelectMany() {
        return getCentreFacade().findAll();
    }

    public List<Centre> getElementAvailableSelectOne() {
        return getCentreFacade().findAll();
    }
    
    public void setSelectioner(Centre selectioner) {
        this.selectioner = selectioner;
    }
    
    
}
