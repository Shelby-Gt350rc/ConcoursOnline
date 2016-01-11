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
    private Centre leCentre = new Centre();
            
    

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

    public Centre getLeCentre() {
        return leCentre;
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
    
    public void setLeCentre(Centre leCentre) {
        this.leCentre = leCentre;
    }
    
    
    
    
    /**
     * Cette methode permet de rafraichir apres insersion ou modification(mise a jour) 
     * de la table
     */
    public void rafraichir(){
        this.leCentre = new  Centre();
    }
    
    public Centre prepareCreate() {
        leCentre = new Centre();
        return leCentre;
    }
    
    /**
     * La methode ajouterCentre permet d'inserer un centre dans la bd
     * @return 
     */ 
    public String ajouterCentre() {
       this.centreFacade.create(this.leCentre);
       rafraichir();
       return "index";
    }
    
     /**
     * la methode eltPrMiseAJr permet de faire la mis ea jour d'un elt precis:
     * l'element selectionner(le parametre p) est recupperer pour etre mis a jour
     * @param c
     * @return 
     */
    public String eltPrMiseAJrCentre(Centre c){
        this.leCentre = c;
        return "update";
    }
     /**
     * La methode miseAJour permet de faire une mise ajour des
     * informations que nous disposons dans notre bd 
     * @return 
     */
    public String miseAJourCentre(){
        this.centreFacade.edit(this.leCentre);
        rafraichir();
        return "index";
    }
   
    /**
     * la methode supprimer(p) permet d'effectuer la suppression d'un element selectionner 
     * @param c 
     */
    public void supprimer(Centre c){
        this.centreFacade.remove(c);
    }
      
      
      
}
