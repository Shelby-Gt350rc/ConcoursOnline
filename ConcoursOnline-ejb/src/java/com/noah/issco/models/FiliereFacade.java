/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noah.issco.models;

import com.noah.issco.entities.Filiere;
import com.noah.issco.models.facades.AbstractFacade;
import javax.ejb.Stateless;

/**
 *
 * @author shelby
 */
@Stateless
public class FiliereFacade extends AbstractFacade<Filiere>{
    public FiliereFacade(){
        super(Filiere.class);
    }
}
