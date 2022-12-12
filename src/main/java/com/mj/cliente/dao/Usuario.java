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
@javax.persistence.Table(name = "usuario", catalog = "qblzuhfb", schema = "public")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @javax.persistence.NamedQuery(name = "Usuario.findByPkusuario", query = "SELECT u FROM Usuario u WHERE u.pkusuario = :pkusuario"),
    @javax.persistence.NamedQuery(name = "Usuario.findByAlias", query = "SELECT u FROM Usuario u WHERE u.alias = :alias"),
    @javax.persistence.NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @javax.persistence.NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @javax.persistence.NamedQuery(name = "Usuario.findByFechanace", query = "SELECT u FROM Usuario u WHERE u.fechanace = :fechanace"),
    @javax.persistence.NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "pkusuario")
    private Integer pkusuario;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "alias")
    private String alias;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "password")
    private String password;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "nombre")
    private String nombre;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "apellidos")
    private String apellidos;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "fechanace")
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private Date fechanace;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "email")
    private String email;
    @javax.persistence.Lob
    @javax.persistence.Column(name = "avatar")
    private byte[] avatar;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "akusuario")
    private List<Biblioteca> bibliotecaList;
    @javax.persistence.JoinColumn(name = "akperfil", referencedColumnName = "pkperfil")
    @javax.persistence.ManyToOne(optional = false)
    private Perfil akperfil;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "akcreador")
    private List<Juego> juegoList;

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

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public List<Biblioteca> getBibliotecaList() {
        return bibliotecaList;
    }

    public void setBibliotecaList(List<Biblioteca> bibliotecaList) {
        this.bibliotecaList = bibliotecaList;
    }

    public Perfil getAkperfil() {
        return akperfil;
    }

    public void setAkperfil(Perfil akperfil) {
        this.akperfil = akperfil;
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
