/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noah.issco.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author shelby
 */
@Named(value = "centreCtrler")
@SessionScoped
public class CentreCtrler implements Serializable {

    /**
     * Creates a new instance of CentreCtrler
     */
    public CentreCtrler() {
    }
    
}
