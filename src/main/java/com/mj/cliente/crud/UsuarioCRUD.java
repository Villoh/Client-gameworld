package com.mj.cliente.crud;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.dao.Biblioteca;
import com.mj.cliente.dao.Juego;
import com.mj.cliente.dao.Perfil;
import com.mj.cliente.dao.Usuario;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.List;

public class UsuarioCRUD {

    /**
     * Devuelve una lista de todos los usuarios de la base de datos
     *
     * @return
     */
    public static List<Usuario> verListaUsuarios() {
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        List<Usuario> lista = null;
        try {
            lista = em.createNamedQuery("Usuario.findAll").getResultList();

        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verListaUsuarios " + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return lista;
    }

    /**
     * Metodo que busca un usuario usando su alias y password
     *
     * @param alias
     * @param password
     * @return Devuelve el usuario encontrado
     */
    public static Usuario verUsuario(String alias, String password) {
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        Usuario usuario = null;
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.alias =:alias and u.password=:password");
            query.setParameter("alias", alias);
            query.setParameter("password", password);
            usuario = (Usuario) query.getSingleResult();
        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verUsuario" + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return usuario;
    }

    /**
     * Crea un nuevo Usuario
     *
     * @param usuario
     * @param perfil
     * @return
     */
    public static int nuevoUsuario(Usuario usuario, Perfil perfil) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        Biblioteca biblio = new Biblioteca();
        EntityTransaction tx = em.getTransaction();
        System.out.println("Usuario: " + usuario.getAlias() + usuario.getPassword());
        System.out.println("Pefil: " + perfil.toString());
        usuario.setAkperfil(perfil);
        try {
            tx.begin();
            em.persist(usuario);
            em.flush();
            em.refresh(usuario);
            biblio.setAkusuario(usuario);
            biblio.setFecha(java.sql.Date.valueOf(LocalDate.now()));
            em.persist(biblio);
            em.flush();
            em.refresh(biblio);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo nuevoUsuario " + ex);
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     * Actualiza un usuario
     *
     * @param viejo
     * @param nuevo
     * @return
     */
    public static int actualizarUsuario(Usuario viejo, Usuario nuevo) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Usuario u = em.merge(viejo);
            u.setAlias(nuevo.getAlias());
            u.setPassword(nuevo.getPassword());
            u.setNombre(nuevo.getNombre());
            u.setApellidos(nuevo.getApellidos());
            u.setFechanace(nuevo.getFechanace());
            u.setEmail(nuevo.getEmail());
            u.setAkperfil(nuevo.getAkperfil());
            u.setAvatar(nuevo.getAvatar());
            em.persist(u);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo actualizarUsuario " + ex.getLocalizedMessage());
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     * Borra un usuario
     *
     * @param juego
     * @return
     */
    public static int deleteUsuario(Juego juego) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Juego j = em.merge(juego);
            em.persist(j);
            em.remove(j);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo deleteUsuario " + ex.getLocalizedMessage());
            tx.rollback();
        }
        con.desconecta(em);

        return resultado;
    }
}
