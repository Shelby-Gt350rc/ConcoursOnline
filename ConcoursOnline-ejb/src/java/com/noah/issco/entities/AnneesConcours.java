/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noah.issco.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shelby
 */
@Entity
@Table(name = "anneesConcours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnneesConcours.findAll", query = "SELECT a FROM AnneesConcours a"),
    @NamedQuery(name = "AnneesConcours.findByIdanneesConcours", query = "SELECT a FROM AnneesConcours a WHERE a.idanneesConcours = :idanneesConcours"),
    @NamedQuery(name = "AnneesConcours.findByAnneeCivil", query = "SELECT a FROM AnneesConcours a WHERE a.anneeCivil = :anneeCivil"),
    @NamedQuery(name = "AnneesConcours.findByAnneesAcademique", query = "SELECT a FROM AnneesConcours a WHERE a.anneesAcademique = :anneesAcademique"),
    @NamedQuery(name = "AnneesConcours.findByActiveAnnee", query = "SELECT a FROM AnneesConcours a WHERE a.activeAnnee = :activeAnnee")})
public class AnneesConcours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idanneesConcours")
    private Integer idanneesConcours;
    @Size(max = 45)
    @Column(name = "anneeCivil")
    private String anneeCivil;
    @Size(max = 45)
    @Column(name = "anneesAcademique")
    private String anneesAcademique;
    @Size(max = 45)
    @Column(name = "activeAnnee")
    private String activeAnnee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idanneesConcours")
    private List<SessionConcours> sessionConcoursList;

    public AnneesConcours() {
    }

    public AnneesConcours(Integer idanneesConcours) {
        this.idanneesConcours = idanneesConcours;
    }

    public Integer getIdanneesConcours() {
        return idanneesConcours;
    }

    public void setIdanneesConcours(Integer idanneesConcours) {
        this.idanneesConcours = idanneesConcours;
    }

    public String getAnneeCivil() {
        return anneeCivil;
    }

    public void setAnneeCivil(String anneeCivil) {
        this.anneeCivil = anneeCivil;
    }

    public String getAnneesAcademique() {
        return anneesAcademique;
    }

    public void setAnneesAcademique(String anneesAcademique) {
        this.anneesAcademique = anneesAcademique;
    }

    public String getActiveAnnee() {
        return activeAnnee;
    }

    public void setActiveAnnee(String activeAnnee) {
        this.activeAnnee = activeAnnee;
    }

    @XmlTransient
    public List<SessionConcours> getSessionConcoursList() {
        return sessionConcoursList;
    }

    public void setSessionConcoursList(List<SessionConcours> sessionConcoursList) {
        this.sessionConcoursList = sessionConcoursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanneesConcours != null ? idanneesConcours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnneesConcours)) {
            return false;
        }
        AnneesConcours other = (AnneesConcours) object;
        if ((this.idanneesConcours == null && other.idanneesConcours != null) || (this.idanneesConcours != null && !this.idanneesConcours.equals(other.idanneesConcours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.noah.issco.entities.AnneesConcours[ idanneesConcours=" + idanneesConcours + " ]";
    }
    
}
