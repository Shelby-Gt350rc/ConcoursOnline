/*
 * Cette classe permet de generer les rapport de type
 *PDF , EXCEL des candidatures valide
 */
package com.noah.issco.models.facades;

import com.noah.issco.entities.Candidat;
import com.noah.issco.models.GetEmf;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author shelby
 */
public class DocumentFacade extends AbstractFacade<Candidat>{
    private EntityManagerFactory emf;

    public DocumentFacade() {
        super(Candidat.class);
    }
    
    /**
        *Cette Methode permet d'enumerer les types de
        * Systèmes de gestion de Base de données.
        */
    public static enum DatabaseTypes{
        MySql, PostgreSql, Oracle;
    }
    
    /**
        *Cette Methode permet d'enumerer les types de
        * rapports que nous pouvons generer.
        */
    public static enum ReportTypes{
        Pdf,Excel;
    }
    
    public  EntityManager getEntityManager(){
        emf=GetEmf.getEntityMF();
        return emf.createEntityManager();
    }
    
    /**
        *Cette Methode permet de générer la liste au format choisie(Pdf ou Excel)
        * des candidats avant et après les resultats. Elle prend en parametre:
        * @param dbType : type de la base de donnée(Mysql, PostgreSql, Oracle...)
        * @param reporType : type de rapport a générer (Pdf, Excel)
        * @param nomDeLaTable:nom de la table utilisée pour obtenir les infos.
        */
    public static void generateReport(DatabaseTypes dbType, ReportTypes reporType, String nomDeLaTable){
        
    }
}
