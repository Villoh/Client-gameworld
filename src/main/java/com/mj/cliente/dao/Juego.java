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
@javax.persistence.Table(name = "juego", catalog = "qblzuhfb", schema = "public")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j"),
    @javax.persistence.NamedQuery(name = "Juego.findByPkjuego", query = "SELECT j FROM Juego j WHERE j.pkjuego = :pkjuego"),
    @javax.persistence.NamedQuery(name = "Juego.findByTitulo", query = "SELECT j FROM Juego j WHERE j.titulo = :titulo"),
    @javax.persistence.NamedQuery(name = "Juego.findByDescripcion", query = "SELECT j FROM Juego j WHERE j.descripcion = :descripcion"),
    @javax.persistence.NamedQuery(name = "Juego.findByImagen", query = "SELECT j FROM Juego j WHERE j.imagen = :imagen"),
    @javax.persistence.NamedQuery(name = "Juego.findByFechacreacion", query = "SELECT j FROM Juego j WHERE j.fechacreacion = :fechacreacion"),
    @javax.persistence.NamedQuery(name = "Juego.findByPvp", query = "SELECT j FROM Juego j WHERE j.pvp = :pvp"),
    @javax.persistence.NamedQuery(name = "Juego.findByNumdescargas", query = "SELECT j FROM Juego j WHERE j.numdescargas = :numdescargas")})
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pkjuego")
    private Integer pkjuego;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "titulo")
    private String titulo;
    @javax.persistence.Column(name = "descripcion")
    private String descripcion;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "imagen")
    private String imagen;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "fechacreacion")
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private Date fechacreacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Column(name = "pvp")
    private Float pvp;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "numdescargas")
    private int numdescargas;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "akjuego")
    private List<Descarga> descargaList;
    @javax.persistence.JoinColumn(name = "akgenero", referencedColumnName = "pkgenero")
    @javax.persistence.ManyToOne(optional = false)
    private Genero akgenero;
    @javax.persistence.JoinColumn(name = "aknivel", referencedColumnName = "pknivel")
    @javax.persistence.ManyToOne(optional = false)
    private Nivel aknivel;
    @javax.persistence.JoinColumn(name = "akpegi", referencedColumnName = "pkpegi")
    @javax.persistence.ManyToOne(optional = false)
    private Pegi akpegi;
    @javax.persistence.JoinColumn(name = "akcreador", referencedColumnName = "pkusuario")
    @javax.persistence.ManyToOne(optional = false)
    private Usuario akcreador;

    public Juego() {
    }

    public Juego(Integer pkjuego) {
        this.pkjuego = pkjuego;
    }

    public Juego(Integer pkjuego, String titulo, String imagen, Date fechacreacion, int numdescargas) {
        this.pkjuego = pkjuego;
        this.titulo = titulo;
        this.imagen = imagen;
        this.fechacreacion = fechacreacion;
        this.numdescargas = numdescargas;
    }

    public Integer getPkjuego() {
        return pkjuego;
    }

    public void setPkjuego(Integer pkjuego) {
        this.pkjuego = pkjuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Float getPvp() {
        return pvp;
    }

    public void setPvp(Float pvp) {
        this.pvp = pvp;
    }

    public int getNumdescargas() {
        return numdescargas;
    }

    public void setNumdescargas(int numdescargas) {
        this.numdescargas = numdescargas;
    }

    public List<Descarga> getDescargaList() {
        return descargaList;
    }

    public void setDescargaList(List<Descarga> descargaList) {
        this.descargaList = descargaList;
    }

    public Genero getAkgenero() {
        return akgenero;
    }

    public void setAkgenero(Genero akgenero) {
        this.akgenero = akgenero;
    }

    public Nivel getAknivel() {
        return aknivel;
    }

    public void setAknivel(Nivel aknivel) {
        this.aknivel = aknivel;
    }

    public Pegi getAkpegi() {
        return akpegi;
    }

    public void setAkpegi(Pegi akpegi) {
        this.akpegi = akpegi;
    }

    public Usuario getAkcreador() {
        return akcreador;
    }

    public void setAkcreador(Usuario akcreador) {
        this.akcreador = akcreador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkjuego != null ? pkjuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juego)) {
            return false;
        }
        Juego other = (Juego) object;
        if ((this.pkjuego == null && other.pkjuego != null) || (this.pkjuego != null && !this.pkjuego.equals(other.pkjuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mj.cliente.dao.Juego[ pkjuego=" + pkjuego + " ]";
    }
    
}
