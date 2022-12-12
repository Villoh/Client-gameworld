/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author M3J2
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "descarga", catalog = "qblzuhfb", schema = "public")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Descarga.findAll", query = "SELECT d FROM Descarga d"),
    @javax.persistence.NamedQuery(name = "Descarga.findByPkdescarga", query = "SELECT d FROM Descarga d WHERE d.pkdescarga = :pkdescarga"),
    @javax.persistence.NamedQuery(name = "Descarga.findByFecha", query = "SELECT d FROM Descarga d WHERE d.fecha = :fecha")})
public class Descarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pkdescarga")
    private Integer pkdescarga;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "fecha")
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @javax.persistence.JoinColumn(name = "akbiblioteca", referencedColumnName = "pkbiblioteca")
    @javax.persistence.ManyToOne(optional = false)
    private Biblioteca akbiblioteca;
    @javax.persistence.JoinColumn(name = "akjuego", referencedColumnName = "pkjuego")
    @javax.persistence.ManyToOne(optional = false)
    private Juego akjuego;

    public Descarga() {
    }

    public Descarga(Integer pkdescarga) {
        this.pkdescarga = pkdescarga;
    }

    public Descarga(Integer pkdescarga, Date fecha) {
        this.pkdescarga = pkdescarga;
        this.fecha = fecha;
    }

    public Integer getPkdescarga() {
        return pkdescarga;
    }

    public void setPkdescarga(Integer pkdescarga) {
        this.pkdescarga = pkdescarga;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Biblioteca getAkbiblioteca() {
        return akbiblioteca;
    }

    public void setAkbiblioteca(Biblioteca akbiblioteca) {
        this.akbiblioteca = akbiblioteca;
    }

    public Juego getAkjuego() {
        return akjuego;
    }

    public void setAkjuego(Juego akjuego) {
        this.akjuego = akjuego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkdescarga != null ? pkdescarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descarga)) {
            return false;
        }
        Descarga other = (Descarga) object;
        if ((this.pkdescarga == null && other.pkdescarga != null) || (this.pkdescarga != null && !this.pkdescarga.equals(other.pkdescarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mj.cliente.dao.Descarga[ pkdescarga=" + pkdescarga + " ]";
    }
    
}
