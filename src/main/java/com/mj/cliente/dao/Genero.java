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
@javax.persistence.Table(name = "genero", catalog = "qblzuhfb", schema = "public")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @javax.persistence.NamedQuery(name = "Genero.findByPkgenero", query = "SELECT g FROM Genero g WHERE g.pkgenero = :pkgenero"),
    @javax.persistence.NamedQuery(name = "Genero.findByNombre", query = "SELECT g FROM Genero g WHERE g.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "Genero.findByDescripcion", query = "SELECT g FROM Genero g WHERE g.descripcion = :descripcion")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pkgenero")
    private String pkgenero;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "nombre")
    private String nombre;
    @javax.persistence.Column(name = "descripcion")
    private String descripcion;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "akgenero")
    private List<Juego> juegoList;

    public Genero() {
    }

    public Genero(String pkgenero) {
        this.pkgenero = pkgenero;
    }

    public Genero(String pkgenero, String nombre) {
        this.pkgenero = pkgenero;
        this.nombre = nombre;
    }

    public String getPkgenero() {
        return pkgenero;
    }

    public void setPkgenero(String pkgenero) {
        this.pkgenero = pkgenero;
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

    public List<Juego> getJuegoList() {
        return juegoList;
    }

    public void setJuegoList(List<Juego> juegoList) {
        this.juegoList = juegoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkgenero != null ? pkgenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.pkgenero == null && other.pkgenero != null) || (this.pkgenero != null && !this.pkgenero.equals(other.pkgenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mj.cliente.dao.Genero[ pkgenero=" + pkgenero + " ]";
    }
    
}
