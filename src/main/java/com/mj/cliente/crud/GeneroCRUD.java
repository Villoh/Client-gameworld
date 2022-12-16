package com.mj.cliente.crud;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.dao.Genero;

import javax.persistence.*;
import java.util.List;

public class GeneroCRUD {

    /**
     * Recogemos todos los generos de una lista
     * @return
     */
    public static List<Genero> verListaGeneros(){
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        List<Genero> lista =null;
        try {
           lista = em.createNamedQuery("Genero.findAll").getResultList();

        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verListaGeneros " + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return lista;
    }
    /**
     * Metodo para sacar un generando utilizando una PK
     * @param pkgenero PK del genero a buscar
     * @return Genero que vamos a devolver
     */
    public static Genero verGenero(String pkgenero) {//<--La PK es un String
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        Genero genero = null;
        try {
            Query query = em.createNamedQuery("Genero.findByPkgenero");
            query.setParameter("pkgenero",pkgenero);
            genero = (Genero) query.getSingleResult();
        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verGenero " + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return genero;
    }

    /**
     * Metodo que reciber un genero y lo guarda en la base de datos
     * @param genero Genero recibido
     */
    public static int nuevoGenero(Genero genero){
        int resultado =0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(genero);
            tx.commit();
            resultado =1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo nuevoGenero " + ex.getLocalizedMessage());
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     * Metodo para actualizar un genero
     * @param viejo Le pasamos el genero que vamos a actualizar
     * @param nuevo El genero con los datos nuevos
     */
    public static int actualizarGenero(Genero viejo, Genero nuevo){
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Genero g = em.merge(viejo);
            g.setPkgenero(nuevo.getPkgenero());
            g.setNombre(nuevo.getNombre());
            g.setDescripcion(nuevo.getDescripcion());
            em.persist(g);
            tx.commit();
            resultado =1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo actualizarGenero  " + ex.getLocalizedMessage());
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     * Metodo para borrar un genero en especifico
     * @param genero
     * @return
     */
    public static int deleteGenero(Genero genero) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Genero g = em.merge(genero);
            em.remove(g);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo deleteGenero  " + ex.getLocalizedMessage());
            tx.rollback();
        }
        con.desconecta(em);

        return resultado;
    }
}
