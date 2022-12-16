/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author COLLS
 */
@Entity
@Table(name = "nivel", catalog = "qblzuhfb", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n"),
    @NamedQuery(name = "Nivel.findByPknivel", query = "SELECT n FROM Nivel n WHERE n.pknivel = :pknivel"),
    @NamedQuery(name = "Nivel.findByNombre", query = "SELECT n FROM Nivel n WHERE n.nombre = :nombre")})
public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pknivel")
    private String pknivel;
    @Basic(optional = false)
    @Column(name = "nombre")
    private int nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aknivel")
    private List<Juego> juegoList;

    public Nivel() {
    }

    public Nivel(String pknivel) {
        this.pknivel = pknivel;
    }

    public Nivel(String pknivel, int nombre) {
        this.pknivel = pknivel;
        this.nombre = nombre;
    }

    public String getPknivel() {
        return pknivel;
    }

    public void setPknivel(String pknivel) {
        this.pknivel = pknivel;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Juego> getJuegoList() {
        return juegoList;
    }

    public void setJuegoList(List<Juego> juegoList) {
        this.juegoList = juegoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pknivel != null ? pknivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.pknivel == null && other.pknivel != null) || (this.pknivel != null && !this.pknivel.equals(other.pknivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mj.cliente.dao.Nivel[ pknivel=" + pknivel + " ]";
    }
    
}
