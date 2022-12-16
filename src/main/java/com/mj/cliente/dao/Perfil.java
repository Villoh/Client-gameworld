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
 * @author dam107
 */
@Entity
@Table(name = "perfil", catalog = "gameworld", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByPkperfil", query = "SELECT p FROM Perfil p WHERE p.pkperfil = :pkperfil"),
    @NamedQuery(name = "Perfil.findByRol", query = "SELECT p FROM Perfil p WHERE p.rol = :rol")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pkperfil")
    private Integer pkperfil;
    @Column(name = "rol")
    private String rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akperfil")
    private List<Usuario> usuarioList;

    public Perfil() {
    }

    public Perfil(Integer pkperfil) {
        this.pkperfil = pkperfil;
    }

    public Integer getPkperfil() {
        return pkperfil;
    }

    public void setPkperfil(Integer pkperfil) {
        this.pkperfil = pkperfil;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkperfil != null ? pkperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.pkperfil == null && other.pkperfil != null) || (this.pkperfil != null && !this.pkperfil.equals(other.pkperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mj.cliente.dao.Perfil[ pkperfil=" + pkperfil + " ]";
    }
    
}
