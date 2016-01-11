/*
 * Controller pour les centres d'examen
 *agrée.
 */
package com.noah.issco.controllers;

 
import com.noah.issco.controllers.utils.JsfUtil;
import com.noah.issco.controllers.utils.JsfUtil.PersistAction;
import com.noah.issco.entities.Centre;
import com.noah.issco.models.CentreFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;

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
    
    
    public Centre prepareCreate() {
        selectioner = new Centre();
        return selectioner;
    }
    
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CentreCreated"));
        if (!JsfUtil.isValidationFailed()) {
            element = null;    // Invalidation de la  liste des elements.
        }
    }
    
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CentreUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CentreDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selectioner = null; // Suppresion de la selection
            element = null;    // Invalidation de la  liste des elements.
        }
    }
      
      
    public void persist(PersistAction persistAction, String successMessage){
       if (selectioner != null) {
            //setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getCentreFacade().edit(selectioner);
                } else {
                     getCentreFacade().remove(selectioner);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }
      
      
      
}
