/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noah.issco.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shelby
 */
@Entity
@Table(name = "sessionConcours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SessionConcours.findAll", query = "SELECT s FROM SessionConcours s"),
    @NamedQuery(name = "SessionConcours.findByIdsessionConcours", query = "SELECT s FROM SessionConcours s WHERE s.idsessionConcours = :idsessionConcours"),
    @NamedQuery(name = "SessionConcours.findByNomSession", query = "SELECT s FROM SessionConcours s WHERE s.nomSession = :nomSession"),
    @NamedQuery(name = "SessionConcours.findByActive", query = "SELECT s FROM SessionConcours s WHERE s.active = :active")})
public class SessionConcours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsessionConcours")
    private Integer idsessionConcours;
    @Size(max = 45)
    @Column(name = "nomSession")
    private String nomSession;
    @Size(max = 45)
    @Column(name = "active")
    private String active;
    @ManyToMany(mappedBy = "sessionConcoursList")
    private List<Candidat> candidatList;
    @JoinColumn(name = "idanneesConcours", referencedColumnName = "idanneesConcours")
    @ManyToOne(optional = false)
    private AnneesConcours idanneesConcours;

    public SessionConcours() {
    }

    public SessionConcours(Integer idsessionConcours) {
        this.idsessionConcours = idsessionConcours;
    }

    public Integer getIdsessionConcours() {
        return idsessionConcours;
    }

    public void setIdsessionConcours(Integer idsessionConcours) {
        this.idsessionConcours = idsessionConcours;
    }

    public String getNomSession() {
        return nomSession;
    }

    public void setNomSession(String nomSession) {
        this.nomSession = nomSession;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @XmlTransient
    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    public AnneesConcours getIdanneesConcours() {
        return idanneesConcours;
    }

    public void setIdanneesConcours(AnneesConcours idanneesConcours) {
        this.idanneesConcours = idanneesConcours;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsessionConcours != null ? idsessionConcours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SessionConcours)) {
            return false;
        }
        SessionConcours other = (SessionConcours) object;
        if ((this.idsessionConcours == null && other.idsessionConcours != null) || (this.idsessionConcours != null && !this.idsessionConcours.equals(other.idsessionConcours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.noah.issco.entities.SessionConcours[ idsessionConcours=" + idsessionConcours + " ]";
    }
    
}
