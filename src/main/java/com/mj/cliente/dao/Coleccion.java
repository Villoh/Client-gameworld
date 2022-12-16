/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
<<<<<<< HEAD
 * @author dam204
=======
 * @author dam107
>>>>>>> 0481ad552b1d05809e1dd54c6b23c0f119456b48
 */
@Entity
@Table(name = "coleccion", catalog = "gameworld", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coleccion.findAll", query = "SELECT c FROM Coleccion c"),
    @NamedQuery(name = "Coleccion.findByPkcoleccion", query = "SELECT c FROM Coleccion c WHERE c.pkcoleccion = :pkcoleccion"),
    @NamedQuery(name = "Coleccion.findByNombre", query = "SELECT c FROM Coleccion c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Coleccion.findByDescripcion", query = "SELECT c FROM Coleccion c WHERE c.descripcion = :descripcion")})
public class Coleccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkcoleccion")
    private Integer pkcoleccion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "akbiblioteca", referencedColumnName = "pkbiblioteca")
    @ManyToOne(optional = false)
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
