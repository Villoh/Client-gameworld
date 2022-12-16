/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author COLLS
 */
@Entity
@Table(name = "biblioteca", catalog = "qblzuhfb", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biblioteca.findAll", query = "SELECT b FROM Biblioteca b"),
    @NamedQuery(name = "Biblioteca.findByPkbiblioteca", query = "SELECT b FROM Biblioteca b WHERE b.pkbiblioteca = :pkbiblioteca"),
    @NamedQuery(name = "Biblioteca.findByFecha", query = "SELECT b FROM Biblioteca b WHERE b.fecha = :fecha")})
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkbiblioteca")
    private Integer pkbiblioteca;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "akusuario", referencedColumnName = "pkusuario")
    @ManyToOne(optional = false)
    private Usuario akusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akbiblioteca")
    private List<Descarga> descargaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akbiblioteca")
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

    @XmlTransient
    public List<Descarga> getDescargaList() {
        return descargaList;
    }

    public void setDescargaList(List<Descarga> descargaList) {
        this.descargaList = descargaList;
    }

    @XmlTransient
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
