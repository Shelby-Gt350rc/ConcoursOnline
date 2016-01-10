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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "niveau")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n"),
    @NamedQuery(name = "Niveau.findByIdniveau", query = "SELECT n FROM Niveau n WHERE n.idniveau = :idniveau"),
    @NamedQuery(name = "Niveau.findByCodeNiveau", query = "SELECT n FROM Niveau n WHERE n.codeNiveau = :codeNiveau"),
    @NamedQuery(name = "Niveau.findByIntituleNiveau", query = "SELECT n FROM Niveau n WHERE n.intituleNiveau = :intituleNiveau"),
    @NamedQuery(name = "Niveau.findByActiveNiveau", query = "SELECT n FROM Niveau n WHERE n.activeNiveau = :activeNiveau")})
public class Niveau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idniveau")
    private Integer idniveau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codeNiveau")
    private String codeNiveau;
    @Size(max = 45)
    @Column(name = "intituleNiveau")
    private String intituleNiveau;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activeNiveau")
    private boolean activeNiveau;
    @ManyToMany(mappedBy = "niveauList")
    private List<Filiere> filiereList;
    @JoinColumn(name = "idCycle", referencedColumnName = "idCycle")
    @ManyToOne(optional = false)
    private Cycle idCycle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idniveau")
    private List<Diplome> diplomeList;

    public Niveau() {
    }

    public Niveau(Integer idniveau) {
        this.idniveau = idniveau;
    }

    public Niveau(Integer idniveau, String codeNiveau, boolean activeNiveau) {
        this.idniveau = idniveau;
        this.codeNiveau = codeNiveau;
        this.activeNiveau = activeNiveau;
    }

    public Integer getIdniveau() {
        return idniveau;
    }

    public void setIdniveau(Integer idniveau) {
        this.idniveau = idniveau;
    }

    public String getCodeNiveau() {
        return codeNiveau;
    }

    public void setCodeNiveau(String codeNiveau) {
        this.codeNiveau = codeNiveau;
    }

    public String getIntituleNiveau() {
        return intituleNiveau;
    }

    public void setIntituleNiveau(String intituleNiveau) {
        this.intituleNiveau = intituleNiveau;
    }

    public boolean getActiveNiveau() {
        return activeNiveau;
    }

    public void setActiveNiveau(boolean activeNiveau) {
        this.activeNiveau = activeNiveau;
    }

    @XmlTransient
    public List<Filiere> getFiliereList() {
        return filiereList;
    }

    public void setFiliereList(List<Filiere> filiereList) {
        this.filiereList = filiereList;
    }

    public Cycle getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(Cycle idCycle) {
        this.idCycle = idCycle;
    }

    @XmlTransient
    public List<Diplome> getDiplomeList() {
        return diplomeList;
    }

    public void setDiplomeList(List<Diplome> diplomeList) {
        this.diplomeList = diplomeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idniveau != null ? idniveau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveau)) {
            return false;
        }
        Niveau other = (Niveau) object;
        if ((this.idniveau == null && other.idniveau != null) || (this.idniveau != null && !this.idniveau.equals(other.idniveau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.noah.issco.entities.Niveau[ idniveau=" + idniveau + " ]";
    }
    
}
