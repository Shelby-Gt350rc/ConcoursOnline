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
@Table(name = "option")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Option.findAll", query = "SELECT o FROM Option o"),
    @NamedQuery(name = "Option.findByIdOption", query = "SELECT o FROM Option o WHERE o.idOption = :idOption"),
    @NamedQuery(name = "Option.findByCodeOption", query = "SELECT o FROM Option o WHERE o.codeOption = :codeOption"),
    @NamedQuery(name = "Option.findByIntituleOption", query = "SELECT o FROM Option o WHERE o.intituleOption = :intituleOption"),
    @NamedQuery(name = "Option.findByActiveOption", query = "SELECT o FROM Option o WHERE o.activeOption = :activeOption")})
public class Option implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOption")
    private Integer idOption;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codeOption")
    private String codeOption;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "intituleOption")
    private String intituleOption;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activeOption")
    private boolean activeOption;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOption")
    private List<Candidat> candidatList;
    @JoinColumn(name = "idFiliere", referencedColumnName = "idFiliere")
    @ManyToOne(optional = false)
    private Filiere idFiliere;

    public Option() {
    }

    public Option(Integer idOption) {
        this.idOption = idOption;
    }

    public Option(Integer idOption, String codeOption, String intituleOption, boolean activeOption) {
        this.idOption = idOption;
        this.codeOption = codeOption;
        this.intituleOption = intituleOption;
        this.activeOption = activeOption;
    }

    public Integer getIdOption() {
        return idOption;
    }

    public void setIdOption(Integer idOption) {
        this.idOption = idOption;
    }

    public String getCodeOption() {
        return codeOption;
    }

    public void setCodeOption(String codeOption) {
        this.codeOption = codeOption;
    }

    public String getIntituleOption() {
        return intituleOption;
    }

    public void setIntituleOption(String intituleOption) {
        this.intituleOption = intituleOption;
    }

    public boolean getActiveOption() {
        return activeOption;
    }

    public void setActiveOption(boolean activeOption) {
        this.activeOption = activeOption;
    }

    @XmlTransient
    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    public Filiere getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Filiere idFiliere) {
        this.idFiliere = idFiliere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOption != null ? idOption.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Option)) {
            return false;
        }
        Option other = (Option) object;
        if ((this.idOption == null && other.idOption != null) || (this.idOption != null && !this.idOption.equals(other.idOption))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.noah.issco.entities.Option[ idOption=" + idOption + " ]";
    }
    
}
