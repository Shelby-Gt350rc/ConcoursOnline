/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noah.issco.models;

import com.noah.issco.entities.Option;
import com.noah.issco.models.facades.AbstractFacade;
import javax.ejb.Stateless;

/**
 *
 * @author shelby
 */
@Stateless
public class OptionFacade extends AbstractFacade<Option>{
    public  OptionFacade(){
        super(Option.class);
    }
}
