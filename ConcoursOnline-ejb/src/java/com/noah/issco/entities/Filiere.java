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
import javax.persistence.JoinTable;
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
@Table(name = "filiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filiere.findAll", query = "SELECT f FROM Filiere f"),
    @NamedQuery(name = "Filiere.findByIdFiliere", query = "SELECT f FROM Filiere f WHERE f.idFiliere = :idFiliere"),
    @NamedQuery(name = "Filiere.findByCodeFiliere", query = "SELECT f FROM Filiere f WHERE f.codeFiliere = :codeFiliere"),
    @NamedQuery(name = "Filiere.findByIntituleFiliere", query = "SELECT f FROM Filiere f WHERE f.intituleFiliere = :intituleFiliere"),
    @NamedQuery(name = "Filiere.findByActiveFiliere", query = "SELECT f FROM Filiere f WHERE f.activeFiliere = :activeFiliere")})
public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFiliere")
    private Integer idFiliere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codeFiliere")
    private String codeFiliere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "intituleFiliere")
    private String intituleFiliere;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activeFiliere")
    private boolean activeFiliere;
    @JoinTable(name = "niveau_has_filiere", joinColumns = {
        @JoinColumn(name = "filiere_idFiliere", referencedColumnName = "idFiliere")}, inverseJoinColumns = {
        @JoinColumn(name = "niveau_idniveau", referencedColumnName = "idniveau")})
    @ManyToMany
    private List<Niveau> niveauList;
    @JoinColumn(name = "idDiplome", referencedColumnName = "idDiplome")
    @ManyToOne(optional = false)
    private Diplome idDiplome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFiliere")
    private List<Candidat> candidatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFiliere")
    private List<Option> optionList;

    public Filiere() {
    }

    public Filiere(Integer idFiliere) {
        this.idFiliere = idFiliere;
    }

    public Filiere(Integer idFiliere, String codeFiliere, String intituleFiliere, boolean activeFiliere) {
        this.idFiliere = idFiliere;
        this.codeFiliere = codeFiliere;
        this.intituleFiliere = intituleFiliere;
        this.activeFiliere = activeFiliere;
    }

    public Integer getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Integer idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }

    public String getIntituleFiliere() {
        return intituleFiliere;
    }

    public void setIntituleFiliere(String intituleFiliere) {
        this.intituleFiliere = intituleFiliere;
    }

    public boolean getActiveFiliere() {
        return activeFiliere;
    }

    public void setActiveFiliere(boolean activeFiliere) {
        this.activeFiliere = activeFiliere;
    }

    @XmlTransient
    public List<Niveau> getNiveauList() {
        return niveauList;
    }

    public void setNiveauList(List<Niveau> niveauList) {
        this.niveauList = niveauList;
    }

    public Diplome getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Diplome idDiplome) {
        this.idDiplome = idDiplome;
    }

    @XmlTransient
    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    @XmlTransient
    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFiliere != null ? idFiliere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiere)) {
            return false;
        }
        Filiere other = (Filiere) object;
        if ((this.idFiliere == null && other.idFiliere != null) || (this.idFiliere != null && !this.idFiliere.equals(other.idFiliere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.noah.issco.entities.Filiere[ idFiliere=" + idFiliere + " ]";
    }
    
}
