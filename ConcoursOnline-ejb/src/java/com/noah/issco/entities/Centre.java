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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shelby
 */
@Entity
@Table(name = "centre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centre.findAll", query = "SELECT c FROM Centre c"),
    @NamedQuery(name = "Centre.findByIdcentre", query = "SELECT c FROM Centre c WHERE c.idcentre = :idcentre"),
    @NamedQuery(name = "Centre.findByIntituleCentre", query = "SELECT c FROM Centre c WHERE c.intituleCentre = :intituleCentre"),
    @NamedQuery(name = "Centre.findByCodeCentre", query = "SELECT c FROM Centre c WHERE c.codeCentre = :codeCentre"),
    @NamedQuery(name = "Centre.findByActiveCentre", query = "SELECT c FROM Centre c WHERE c.activeCentre = :activeCentre")})
public class Centre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcentre")
    private Integer idcentre;
    @Size(max = 45)
    @Column(name = "intituleCentre")
    private String intituleCentre;
    @Size(max = 45)
    @Column(name = "codeCentre")
    private String codeCentre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activeCentre")
    private boolean activeCentre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcentre")
    private List<Candidat> candidatList;

    public Centre() {
    }

    public Centre(Integer idcentre) {
        this.idcentre = idcentre;
    }

    public Centre(Integer idcentre, boolean activeCentre) {
        this.idcentre = idcentre;
        this.activeCentre = activeCentre;
    }

    public Integer getIdcentre() {
        return idcentre;
    }

    public void setIdcentre(Integer idcentre) {
        this.idcentre = idcentre;
    }

    public String getIntituleCentre() {
        return intituleCentre;
    }

    public void setIntituleCentre(String intituleCentre) {
        this.intituleCentre = intituleCentre;
    }

    public String getCodeCentre() {
        return codeCentre;
    }

    public void setCodeCentre(String codeCentre) {
        this.codeCentre = codeCentre;
    }

    public boolean getActiveCentre() {
        return activeCentre;
    }

    public void setActiveCentre(boolean activeCentre) {
        this.activeCentre = activeCentre;
    }

    @XmlTransient
    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcentre != null ? idcentre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centre)) {
            return false;
        }
        Centre other = (Centre) object;
        if ((this.idcentre == null && other.idcentre != null) || (this.idcentre != null && !this.idcentre.equals(other.idcentre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.noah.issco.entities.Centre[ idcentre=" + idcentre + " ]";
    }
    
}
