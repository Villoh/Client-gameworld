/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author M3J2
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "pegi", catalog = "qblzuhfb", schema = "public")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Pegi.findAll", query = "SELECT p FROM Pegi p"),
    @javax.persistence.NamedQuery(name = "Pegi.findByPkpegi", query = "SELECT p FROM Pegi p WHERE p.pkpegi = :pkpegi"),
    @javax.persistence.NamedQuery(name = "Pegi.findByRangopegi", query = "SELECT p FROM Pegi p WHERE p.rangopegi = :rangopegi"),
    @javax.persistence.NamedQuery(name = "Pegi.findByObservaciones", query = "SELECT p FROM Pegi p WHERE p.observaciones = :observaciones")})
public class Pegi implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pkpegi")
    private Integer pkpegi;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "rangopegi")
    private String rangopegi;
    @javax.persistence.Column(name = "observaciones")
    private String observaciones;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "akpegi")
    private List<Juego> juegoList;

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

    public List<Juego> getJuegoList() {
        return juegoList;
    }

    public void setJuegoList(List<Juego> juegoList) {
        this.juegoList = juegoList;
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
