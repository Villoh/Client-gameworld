/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author COLLS
 */
@Entity
@Table(name = "descarga", catalog = "qblzuhfb", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descarga.findAll", query = "SELECT d FROM Descarga d"),
    @NamedQuery(name = "Descarga.findByPkdescarga", query = "SELECT d FROM Descarga d WHERE d.pkdescarga = :pkdescarga"),
    @NamedQuery(name = "Descarga.findByFecha", query = "SELECT d FROM Descarga d WHERE d.fecha = :fecha")})
public class Descarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkdescarga")
    private Integer pkdescarga;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "akbiblioteca", referencedColumnName = "pkbiblioteca")
    @ManyToOne(optional = false)
    private Biblioteca akbiblioteca;
    @JoinColumn(name = "akjuego", referencedColumnName = "pkjuego")
    @ManyToOne(optional = false)
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
