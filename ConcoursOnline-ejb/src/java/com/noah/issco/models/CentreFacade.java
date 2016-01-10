/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noah.issco.models;

import com.noah.issco.entities.Centre;
import com.noah.issco.models.facades.AbstractFacade;

/**
 *
 * @author shelby
 */
public class CentreFacade extends AbstractFacade<Centre>{
    
    public CentreFacade(){
        super(Centre.class);
    } 
}
