package com.mj.cliente.crud;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.dao.Juego;

import javax.persistence.*;
import java.util.List;

public class JuegoCRUD {
    /**
     *
     * @return
     */
    public static List<Juego> verListaJuegos(){
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        List<Juego> lista =null;
        try {
            lista = em.createNamedQuery("Juego.findAll").getResultList();

        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verListaJuegos  " + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return lista;
    }

    /**
     *
     * @param titulo
     * @return
     */
    public static Juego verJuego(String titulo) {
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        Juego juego = null;
        try {
            Query query = em.createNamedQuery("Juego.findByTitulo");
            query.setParameter("titulo",titulo);
            juego = (Juego) query.getSingleResult();
        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verJuego  " + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return juego;
    }

    /**
     *
     * @param juego
     * @return
     */
    public static int nuevoJuego(Juego juego){
        int resultado =0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(juego);
            tx.commit();
            resultado =1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo nuevoJuego" + ex.getLocalizedMessage());
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     *
     * @param viejo
     * @param nuevo
     * @return
     */
    public static int actualizarJuego(Juego viejo, Juego nuevo){
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Juego j = em.merge(viejo);
            j.setTitulo(nuevo.getTitulo());
            j.setDescripcion(nuevo.getDescripcion());
            j.setImagen(nuevo.getImagen());
            j.setAkgenero(nuevo.getAkgenero());
            j.setAknivel(nuevo.getAknivel());
            j.setAkpegi(nuevo.getAkpegi());
            j.setAkcreador(nuevo.getAkcreador());
            j.setFechacreacion(nuevo.getFechacreacion());
            j.setPvp(nuevo.getPvp());
            j.setNumdescargas(nuevo.getNumdescargas());
            em.persist(j);
            tx.commit();
            resultado =1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo actualizarJuego " + ex.getLocalizedMessage());
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     *
     * @param juego
     * @return
     */
    public static int deleteJuego(Juego juego) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Juego j = em.merge(juego);
            em.remove(j);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo deleteJuego " + ex.getLocalizedMessage());
            tx.rollback();
        }
        con.desconecta(em);

        return resultado;
    }
}
