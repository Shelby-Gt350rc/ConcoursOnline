/*
 * Gestionnaire de persitance.
 */
package com.noah.issco.models;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author shelby
 */
public class GetEmf {
    private static final String persistenceName="ConcoursOnline-ejbPU";
     
     public static EntityManagerFactory getEntityMF(){ 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        return emf;
    }
}
