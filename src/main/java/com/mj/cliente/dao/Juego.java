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
@Table(name = "juego", catalog = "qblzuhfb", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j"),
    @NamedQuery(name = "Juego.findByPkjuego", query = "SELECT j FROM Juego j WHERE j.pkjuego = :pkjuego"),
    @NamedQuery(name = "Juego.findByTitulo", query = "SELECT j FROM Juego j WHERE j.titulo = :titulo"),
    @NamedQuery(name = "Juego.findByDescripcion", query = "SELECT j FROM Juego j WHERE j.descripcion = :descripcion"),
    @NamedQuery(name = "Juego.findByImagen", query = "SELECT j FROM Juego j WHERE j.imagen = :imagen"),
    @NamedQuery(name = "Juego.findByFechacreacion", query = "SELECT j FROM Juego j WHERE j.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Juego.findByPvp", query = "SELECT j FROM Juego j WHERE j.pvp = :pvp"),
    @NamedQuery(name = "Juego.findByNumdescargas", query = "SELECT j FROM Juego j WHERE j.numdescargas = :numdescargas")})
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkjuego")
    private Integer pkjuego;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pvp")
    private Float pvp;
    @Basic(optional = false)
    @Column(name = "numdescargas")
    private int numdescargas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akjuego")
    private List<Descarga> descargaList;
    @JoinColumn(name = "akgenero", referencedColumnName = "pkgenero")
    @ManyToOne(optional = false)
    private Genero akgenero;
    @JoinColumn(name = "aknivel", referencedColumnName = "pknivel")
    @ManyToOne(optional = false)
    private Nivel aknivel;
    @JoinColumn(name = "akpegi", referencedColumnName = "pkpegi")
    @ManyToOne(optional = false)
    private Pegi akpegi;
    @JoinColumn(name = "akcreador", referencedColumnName = "pkusuario")
    @ManyToOne(optional = false)
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

    @XmlTransient
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
