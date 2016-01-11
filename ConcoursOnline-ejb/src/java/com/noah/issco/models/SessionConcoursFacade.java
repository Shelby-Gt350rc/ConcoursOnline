/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noah.issco.models;

import com.noah.issco.entities.SessionConcours;
import com.noah.issco.models.facades.AbstractFacade;
import javax.ejb.Stateless;

/**
 *
 * @author shelby
 */
@Stateless
public class SessionConcoursFacade extends AbstractFacade<SessionConcours>{
    public SessionConcoursFacade(){
        super(SessionConcours.class);
    }
}
