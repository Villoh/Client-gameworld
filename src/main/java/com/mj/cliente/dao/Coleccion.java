/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;

/**
 *
 * @author M3J2
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "coleccion", catalog = "qblzuhfb", schema = "public")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Coleccion.findAll", query = "SELECT c FROM Coleccion c"),
    @javax.persistence.NamedQuery(name = "Coleccion.findByPkcoleccion", query = "SELECT c FROM Coleccion c WHERE c.pkcoleccion = :pkcoleccion"),
    @javax.persistence.NamedQuery(name = "Coleccion.findByNombre", query = "SELECT c FROM Coleccion c WHERE c.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "Coleccion.findByDescripcion", query = "SELECT c FROM Coleccion c WHERE c.descripcion = :descripcion")})
public class Coleccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pkcoleccion")
    private Integer pkcoleccion;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "nombre")
    private String nombre;
    @javax.persistence.Column(name = "descripcion")
    private String descripcion;
    @javax.persistence.JoinColumn(name = "akbiblioteca", referencedColumnName = "pkbiblioteca")
    @javax.persistence.ManyToOne(optional = false)
    private Biblioteca akbiblioteca;

    public Coleccion() {
    }

    public Coleccion(Integer pkcoleccion) {
        this.pkcoleccion = pkcoleccion;
    }

    public Coleccion(Integer pkcoleccion, String nombre) {
        this.pkcoleccion = pkcoleccion;
        this.nombre = nombre;
    }

    public Integer getPkcoleccion() {
        return pkcoleccion;
    }

    public void setPkcoleccion(Integer pkcoleccion) {
        this.pkcoleccion = pkcoleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Biblioteca getAkbiblioteca() {
        return akbiblioteca;
    }

    public void setAkbiblioteca(Biblioteca akbiblioteca) {
        this.akbiblioteca = akbiblioteca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkcoleccion != null ? pkcoleccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coleccion)) {
            return false;
        }
        Coleccion other = (Coleccion) object;
        if ((this.pkcoleccion == null && other.pkcoleccion != null) || (this.pkcoleccion != null && !this.pkcoleccion.equals(other.pkcoleccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mj.cliente.dao.Coleccion[ pkcoleccion=" + pkcoleccion + " ]";
    }
    
}
