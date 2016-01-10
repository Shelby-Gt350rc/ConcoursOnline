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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "candidat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidat.findAll", query = "SELECT c FROM Candidat c"),
    @NamedQuery(name = "Candidat.findByIdcandidat", query = "SELECT c FROM Candidat c WHERE c.idcandidat = :idcandidat"),
    @NamedQuery(name = "Candidat.findByNomCandidat", query = "SELECT c FROM Candidat c WHERE c.nomCandidat = :nomCandidat"),
    @NamedQuery(name = "Candidat.findByPrenomCandidat", query = "SELECT c FROM Candidat c WHERE c.prenomCandidat = :prenomCandidat"),
    @NamedQuery(name = "Candidat.findBySexe", query = "SELECT c FROM Candidat c WHERE c.sexe = :sexe"),
    @NamedQuery(name = "Candidat.findByDateNaissanceCandidat", query = "SELECT c FROM Candidat c WHERE c.dateNaissanceCandidat = :dateNaissanceCandidat"),
    @NamedQuery(name = "Candidat.findByLieuNaissanceCandidat", query = "SELECT c FROM Candidat c WHERE c.lieuNaissanceCandidat = :lieuNaissanceCandidat"),
    @NamedQuery(name = "Candidat.findByNationaliteCandidat", query = "SELECT c FROM Candidat c WHERE c.nationaliteCandidat = :nationaliteCandidat"),
    @NamedQuery(name = "Candidat.findByRegionOrigineCandidat", query = "SELECT c FROM Candidat c WHERE c.regionOrigineCandidat = :regionOrigineCandidat"),
    @NamedQuery(name = "Candidat.findByDernierEtablissement", query = "SELECT c FROM Candidat c WHERE c.dernierEtablissement = :dernierEtablissement"),
    @NamedQuery(name = "Candidat.findByTelephoneCandidat", query = "SELECT c FROM Candidat c WHERE c.telephoneCandidat = :telephoneCandidat"),
    @NamedQuery(name = "Candidat.findByEmailCandidat", query = "SELECT c FROM Candidat c WHERE c.emailCandidat = :emailCandidat"),
    @NamedQuery(name = "Candidat.findByLangueCandidat", query = "SELECT c FROM Candidat c WHERE c.langueCandidat = :langueCandidat"),
    @NamedQuery(name = "Candidat.findByActiveCandidat", query = "SELECT c FROM Candidat c WHERE c.activeCandidat = :activeCandidat")})
public class Candidat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcandidat")
    private Integer idcandidat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomCandidat")
    private String nomCandidat;
    @Size(max = 100)
    @Column(name = "prenomCandidat")
    private String prenomCandidat;
    @Size(max = 45)
    @Column(name = "sexe")
    private String sexe;
    @Size(max = 45)
    @Column(name = "dateNaissanceCandidat")
    private String dateNaissanceCandidat;
    @Size(max = 45)
    @Column(name = "lieuNaissanceCandidat")
    private String lieuNaissanceCandidat;
    @Size(max = 45)
    @Column(name = "nationaliteCandidat")
    private String nationaliteCandidat;
    @Size(max = 45)
    @Column(name = "regionOrigineCandidat")
    private String regionOrigineCandidat;
    @Size(max = 45)
    @Column(name = "dernierEtablissement")
    private String dernierEtablissement;
    @Size(max = 45)
    @Column(name = "telephoneCandidat")
    private String telephoneCandidat;
    @Size(max = 45)
    @Column(name = "emailCandidat")
    private String emailCandidat;
    @Size(max = 45)
    @Column(name = "langueCandidat")
    private String langueCandidat;
    @Column(name = "activeCandidat")
    private Boolean activeCandidat;
    @JoinTable(name = "sessionConcours_has_candidat", joinColumns = {
        @JoinColumn(name = "candidat_idcandidat", referencedColumnName = "idcandidat")}, inverseJoinColumns = {
        @JoinColumn(name = "idsessionConcours", referencedColumnName = "idsessionConcours")})
    @ManyToMany
    private List<SessionConcours> sessionConcoursList;
    @JoinColumn(name = "idcentre", referencedColumnName = "idcentre")
    @ManyToOne(optional = false)
    private Centre idcentre;
    @JoinColumn(name = "idDiplome", referencedColumnName = "idDiplome")
    @ManyToOne(optional = false)
    private Diplome idDiplome;
    @JoinColumn(name = "idFiliere", referencedColumnName = "idFiliere")
    @ManyToOne(optional = false)
    private Filiere idFiliere;
    @JoinColumn(name = "idOption", referencedColumnName = "idOption")
    @ManyToOne(optional = false)
    private Option idOption;

    public Candidat() {
    }

    public Candidat(Integer idcandidat) {
        this.idcandidat = idcandidat;
    }

    public Candidat(Integer idcandidat, String nomCandidat) {
        this.idcandidat = idcandidat;
        this.nomCandidat = nomCandidat;
    }

    public Integer getIdcandidat() {
        return idcandidat;
    }

    public void setIdcandidat(Integer idcandidat) {
        this.idcandidat = idcandidat;
    }

    public String getNomCandidat() {
        return nomCandidat;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public String getPrenomCandidat() {
        return prenomCandidat;
    }

    public void setPrenomCandidat(String prenomCandidat) {
        this.prenomCandidat = prenomCandidat;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDateNaissanceCandidat() {
        return dateNaissanceCandidat;
    }

    public void setDateNaissanceCandidat(String dateNaissanceCandidat) {
        this.dateNaissanceCandidat = dateNaissanceCandidat;
    }

    public String getLieuNaissanceCandidat() {
        return lieuNaissanceCandidat;
    }

    public void setLieuNaissanceCandidat(String lieuNaissanceCandidat) {
        this.lieuNaissanceCandidat = lieuNaissanceCandidat;
    }

    public String getNationaliteCandidat() {
        return nationaliteCandidat;
    }

    public void setNationaliteCandidat(String nationaliteCandidat) {
        this.nationaliteCandidat = nationaliteCandidat;
    }

    public String getRegionOrigineCandidat() {
        return regionOrigineCandidat;
    }

    public void setRegionOrigineCandidat(String regionOrigineCandidat) {
        this.regionOrigineCandidat = regionOrigineCandidat;
    }

    public String getDernierEtablissement() {
        return dernierEtablissement;
    }

    public void setDernierEtablissement(String dernierEtablissement) {
        this.dernierEtablissement = dernierEtablissement;
    }

    public String getTelephoneCandidat() {
        return telephoneCandidat;
    }

    public void setTelephoneCandidat(String telephoneCandidat) {
        this.telephoneCandidat = telephoneCandidat;
    }

    public String getEmailCandidat() {
        return emailCandidat;
    }

    public void setEmailCandidat(String emailCandidat) {
        this.emailCandidat = emailCandidat;
    }

    public String getLangueCandidat() {
        return langueCandidat;
    }

    public void setLangueCandidat(String langueCandidat) {
        this.langueCandidat = langueCandidat;
    }

    public Boolean getActiveCandidat() {
        return activeCandidat;
    }

    public void setActiveCandidat(Boolean activeCandidat) {
        this.activeCandidat = activeCandidat;
    }

    @XmlTransient
    public List<SessionConcours> getSessionConcoursList() {
        return sessionConcoursList;
    }

    public void setSessionConcoursList(List<SessionConcours> sessionConcoursList) {
        this.sessionConcoursList = sessionConcoursList;
    }

    public Centre getIdcentre() {
        return idcentre;
    }

    public void setIdcentre(Centre idcentre) {
        this.idcentre = idcentre;
    }

    public Diplome getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Diplome idDiplome) {
        this.idDiplome = idDiplome;
    }

    public Filiere getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Filiere idFiliere) {
        this.idFiliere = idFiliere;
    }

    public Option getIdOption() {
        return idOption;
    }

    public void setIdOption(Option idOption) {
        this.idOption = idOption;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcandidat != null ? idcandidat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.idcandidat == null && other.idcandidat != null) || (this.idcandidat != null && !this.idcandidat.equals(other.idcandidat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.noah.issco.entities.Candidat[ idcandidat=" + idcandidat + " ]";
    }
    
}
