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
@Table(name = "diplome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diplome.findAll", query = "SELECT d FROM Diplome d"),
    @NamedQuery(name = "Diplome.findByIdDiplome", query = "SELECT d FROM Diplome d WHERE d.idDiplome = :idDiplome"),
    @NamedQuery(name = "Diplome.findByCodeDiplome", query = "SELECT d FROM Diplome d WHERE d.codeDiplome = :codeDiplome"),
    @NamedQuery(name = "Diplome.findByIntituleDiplome", query = "SELECT d FROM Diplome d WHERE d.intituleDiplome = :intituleDiplome"),
    @NamedQuery(name = "Diplome.findByOptionDiplome", query = "SELECT d FROM Diplome d WHERE d.optionDiplome = :optionDiplome"),
    @NamedQuery(name = "Diplome.findBySpecialiteDiplome", query = "SELECT d FROM Diplome d WHERE d.specialiteDiplome = :specialiteDiplome"),
    @NamedQuery(name = "Diplome.findByActiveDiplome", query = "SELECT d FROM Diplome d WHERE d.activeDiplome = :activeDiplome")})
public class Diplome implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiplome")
    private Integer idDiplome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codeDiplome")
    private String codeDiplome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "intituleDiplome")
    private String intituleDiplome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "optionDiplome")
    private String optionDiplome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "specialiteDiplome")
    private String specialiteDiplome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activeDiplome")
    private boolean activeDiplome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiplome")
    private List<Filiere> filiereList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiplome")
    private List<Candidat> candidatList;
    @JoinColumn(name = "idniveau", referencedColumnName = "idniveau")
    @ManyToOne(optional = false)
    private Niveau idniveau;

    public Diplome() {
    }

    public Diplome(Integer idDiplome) {
        this.idDiplome = idDiplome;
    }

    public Diplome(Integer idDiplome, String codeDiplome, String intituleDiplome, String optionDiplome, String specialiteDiplome, boolean activeDiplome) {
        this.idDiplome = idDiplome;
        this.codeDiplome = codeDiplome;
        this.intituleDiplome = intituleDiplome;
        this.optionDiplome = optionDiplome;
        this.specialiteDiplome = specialiteDiplome;
        this.activeDiplome = activeDiplome;
    }

    public Integer getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Integer idDiplome) {
        this.idDiplome = idDiplome;
    }

    public String getCodeDiplome() {
        return codeDiplome;
    }

    public void setCodeDiplome(String codeDiplome) {
        this.codeDiplome = codeDiplome;
    }

    public String getIntituleDiplome() {
        return intituleDiplome;
    }

    public void setIntituleDiplome(String intituleDiplome) {
        this.intituleDiplome = intituleDiplome;
    }

    public String getOptionDiplome() {
        return optionDiplome;
    }

    public void setOptionDiplome(String optionDiplome) {
        this.optionDiplome = optionDiplome;
    }

    public String getSpecialiteDiplome() {
        return specialiteDiplome;
    }

    public void setSpecialiteDiplome(String specialiteDiplome) {
        this.specialiteDiplome = specialiteDiplome;
    }

    public boolean getActiveDiplome() {
        return activeDiplome;
    }

    public void setActiveDiplome(boolean activeDiplome) {
        this.activeDiplome = activeDiplome;
    }

    @XmlTransient
    public List<Filiere> getFiliereList() {
        return filiereList;
    }

    public void setFiliereList(List<Filiere> filiereList) {
        this.filiereList = filiereList;
    }

    @XmlTransient
    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    public Niveau getIdniveau() {
        return idniveau;
    }

    public void setIdniveau(Niveau idniveau) {
        this.idniveau = idniveau;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiplome != null ? idDiplome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diplome)) {
            return false;
        }
        Diplome other = (Diplome) object;
        if ((this.idDiplome == null && other.idDiplome != null) || (this.idDiplome != null && !this.idDiplome.equals(other.idDiplome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.noah.issco.entities.Diplome[ idDiplome=" + idDiplome + " ]";
    }
    
}
