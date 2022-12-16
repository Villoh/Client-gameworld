/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
<<<<<<< HEAD
 * @author dam204
=======
 * @author dam107
>>>>>>> 0481ad552b1d05809e1dd54c6b23c0f119456b48
 */
@Entity
@Table(name = "usuario", catalog = "gameworld", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByPkusuario", query = "SELECT u FROM Usuario u WHERE u.pkusuario = :pkusuario"),
    @NamedQuery(name = "Usuario.findByAlias", query = "SELECT u FROM Usuario u WHERE u.alias = :alias"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByFechanace", query = "SELECT u FROM Usuario u WHERE u.fechanace = :fechanace"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByAvatar", query = "SELECT u FROM Usuario u WHERE u.avatar = :avatar")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkusuario")
    private Integer pkusuario;
    @Basic(optional = false)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "fechanace")
    @Temporal(TemporalType.DATE)
    private Date fechanace;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akusuario")
    private Collection<Biblioteca> bibliotecaCollection;
    @JoinColumn(name = "akperfil", referencedColumnName = "pkperfil")
    @ManyToOne(optional = false)
    private Perfil akperfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akcreador")
    private Collection<Juego> juegoCollection;

    public Usuario() {
    }

    public Usuario(Integer pkusuario) {
        this.pkusuario = pkusuario;
    }

    public Usuario(Integer pkusuario, String alias, String password, String nombre, String apellidos, Date fechanace, String email) {
        this.pkusuario = pkusuario;
        this.alias = alias;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanace = fechanace;
        this.email = email;
    }

    public Integer getPkusuario() {
        return pkusuario;
    }

    public void setPkusuario(Integer pkusuario) {
        this.pkusuario = pkusuario;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechanace() {
        return fechanace;
    }

    public void setFechanace(Date fechanace) {
        this.fechanace = fechanace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Collection<Biblioteca> getBibliotecaCollection() {
        return bibliotecaCollection;
    }

    public void setBibliotecaCollection(Collection<Biblioteca> bibliotecaCollection) {
        this.bibliotecaCollection = bibliotecaCollection;
    }

    public Perfil getAkperfil() {
        return akperfil;
    }

    public void setAkperfil(Perfil akperfil) {
        this.akperfil = akperfil;
    }

    @XmlTransient
    public Collection<Juego> getJuegoCollection() {
        return juegoCollection;
    }

    public void setJuegoCollection(Collection<Juego> juegoCollection) {
        this.juegoCollection = juegoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkusuario != null ? pkusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.pkusuario == null && other.pkusuario != null) || (this.pkusuario != null && !this.pkusuario.equals(other.pkusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mj.cliente.dao.Usuario[ pkusuario=" + pkusuario + " ]";
    }
    
}
