/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author M3J2
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "biblioteca", catalog = "qblzuhfb", schema = "public")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Biblioteca.findAll", query = "SELECT b FROM Biblioteca b"),
    @javax.persistence.NamedQuery(name = "Biblioteca.findByPkbiblioteca", query = "SELECT b FROM Biblioteca b WHERE b.pkbiblioteca = :pkbiblioteca"),
    @javax.persistence.NamedQuery(name = "Biblioteca.findByFecha", query = "SELECT b FROM Biblioteca b WHERE b.fecha = :fecha")})
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pkbiblioteca")
    private Integer pkbiblioteca;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "fecha")
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @javax.persistence.JoinColumn(name = "akusuario", referencedColumnName = "pkusuario")
    @javax.persistence.ManyToOne(optional = false)
    private Usuario akusuario;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "akbiblioteca")
    private List<Descarga> descargaList;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "akbiblioteca")
    private List<Coleccion> coleccionList;

    public Biblioteca() {
    }

    public Biblioteca(Integer pkbiblioteca) {
        this.pkbiblioteca = pkbiblioteca;
    }

    public Biblioteca(Integer pkbiblioteca, Date fecha) {
        this.pkbiblioteca = pkbiblioteca;
        this.fecha = fecha;
    }

    public Integer getPkbiblioteca() {
        return pkbiblioteca;
    }

    public void setPkbiblioteca(Integer pkbiblioteca) {
        this.pkbiblioteca = pkbiblioteca;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getAkusuario() {
        return akusuario;
    }

    public void setAkusuario(Usuario akusuario) {
        this.akusuario = akusuario;
    }

    public List<Descarga> getDescargaList() {
        return descargaList;
    }

    public void setDescargaList(List<Descarga> descargaList) {
        this.descargaList = descargaList;
    }

    public List<Coleccion> getColeccionList() {
        return coleccionList;
    }

    public void setColeccionList(List<Coleccion> coleccionList) {
        this.coleccionList = coleccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkbiblioteca != null ? pkbiblioteca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biblioteca)) {
            return false;
        }
        Biblioteca other = (Biblioteca) object;
        if ((this.pkbiblioteca == null && other.pkbiblioteca != null) || (this.pkbiblioteca != null && !this.pkbiblioteca.equals(other.pkbiblioteca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mj.cliente.dao.Biblioteca[ pkbiblioteca=" + pkbiblioteca + " ]";
    }
    
}
