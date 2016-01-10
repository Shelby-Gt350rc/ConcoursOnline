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
@Table(name = "cycle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cycle.findAll", query = "SELECT c FROM Cycle c"),
    @NamedQuery(name = "Cycle.findByIdCycle", query = "SELECT c FROM Cycle c WHERE c.idCycle = :idCycle"),
    @NamedQuery(name = "Cycle.findByCodeCycle", query = "SELECT c FROM Cycle c WHERE c.codeCycle = :codeCycle"),
    @NamedQuery(name = "Cycle.findByIntituleCycle", query = "SELECT c FROM Cycle c WHERE c.intituleCycle = :intituleCycle")})
public class Cycle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCycle")
    private Integer idCycle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codeCycle")
    private String codeCycle;
    @Size(max = 45)
    @Column(name = "intituleCycle")
    private String intituleCycle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCycle")
    private List<Niveau> niveauList;

    public Cycle() {
    }

    public Cycle(Integer idCycle) {
        this.idCycle = idCycle;
    }

    public Cycle(Integer idCycle, String codeCycle) {
        this.idCycle = idCycle;
        this.codeCycle = codeCycle;
    }

    public Integer getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(Integer idCycle) {
        this.idCycle = idCycle;
    }

    public String getCodeCycle() {
        return codeCycle;
    }

    public void setCodeCycle(String codeCycle) {
        this.codeCycle = codeCycle;
    }

    public String getIntituleCycle() {
        return intituleCycle;
    }

    public void setIntituleCycle(String intituleCycle) {
        this.intituleCycle = intituleCycle;
    }

    @XmlTransient
    public List<Niveau> getNiveauList() {
        return niveauList;
    }

    public void setNiveauList(List<Niveau> niveauList) {
        this.niveauList = niveauList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCycle != null ? idCycle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cycle)) {
            return false;
        }
        Cycle other = (Cycle) object;
        if ((this.idCycle == null && other.idCycle != null) || (this.idCycle != null && !this.idCycle.equals(other.idCycle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.noah.issco.entities.Cycle[ idCycle=" + idCycle + " ]";
    }
    
}
