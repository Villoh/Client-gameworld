/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dam204
 */
@Entity
@Table(name = "pegi", catalog = "qblzuhfb", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pegi.findAll", query = "SELECT p FROM Pegi p"),
    @NamedQuery(name = "Pegi.findByPkpegi", query = "SELECT p FROM Pegi p WHERE p.pkpegi = :pkpegi"),
    @NamedQuery(name = "Pegi.findByRangopegi", query = "SELECT p FROM Pegi p WHERE p.rangopegi = :rangopegi"),
    @NamedQuery(name = "Pegi.findByObservaciones", query = "SELECT p FROM Pegi p WHERE p.observaciones = :observaciones")})
public class Pegi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pkpegi")
    private Integer pkpegi;
    @Basic(optional = false)
    @Column(name = "rangopegi")
    private String rangopegi;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akpegi")
    private Collection<Juego> juegoCollection;

    public Pegi() {
    }

    public Pegi(Integer pkpegi) {
        this.pkpegi = pkpegi;
    }

    public Pegi(Integer pkpegi, String rangopegi) {
        this.pkpegi = pkpegi;
        this.rangopegi = rangopegi;
    }

    public Integer getPkpegi() {
        return pkpegi;
    }

    public void setPkpegi(Integer pkpegi) {
        this.pkpegi = pkpegi;
    }

    public String getRangopegi() {
        return rangopegi;
    }

    public void setRangopegi(String rangopegi) {
        this.rangopegi = rangopegi;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Juego> getJuegoCollection() {
        return juegoCollection;
    }

    public void setJuegoCollection(Collection<Juego> juegoCollection) {
        this.juegoCollection = juegoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkpegi != null ? pkpegi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pegi)) {
            return false;
        }
        Pegi other = (Pegi) object;
        if ((this.pkpegi == null && other.pkpegi != null) || (this.pkpegi != null && !this.pkpegi.equals(other.pkpegi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mj.cliente.dao.Pegi[ pkpegi=" + pkpegi + " ]";
    }
    
}
