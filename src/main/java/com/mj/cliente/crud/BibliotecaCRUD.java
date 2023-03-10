package com.mj.cliente.crud;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.dao.Biblioteca;

import javax.persistence.*;
import java.util.List;

public class BibliotecaCRUD {

    /**
     * Devuelve una lista de todas las bibliotecas de la base de datos
     *
     * @return
     */
    public static List<Biblioteca> verListaBiblioteca() {
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        List<Biblioteca> lista = null;
        try {
            lista = em.createNamedQuery("Biblioteca.findAll").getResultList();

        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verListaBiblioteca " + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return lista;
    }

    /**
     * Busca una biblioteca segun su pk
     *
     * @param pkbiblioteca
     * @return
     */
    public static Biblioteca verBiblioteca(int pkbiblioteca) {
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        Biblioteca biblioteca = null;
        try {
            Query query = em.createNamedQuery("Biblioteca.findByPkbiblioteca");
            query.setParameter("pkbiblioteca", pkbiblioteca);
            biblioteca = (Biblioteca) query.getSingleResult();
        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verBiblioteca" + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return biblioteca;
    }

    /**
     * Crea una nueva bliblioteca
     *
     * @param biblioteca
     * @return
     */
    public static int nuevaBiblioteca(Biblioteca biblioteca) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(biblioteca);
            em.flush();
            em.refresh(biblioteca);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo nuevaBiblioteca " + ex.getLocalizedMessage());
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     * Acualiza los datos de una biblioteca
     *
     * @param viejo
     * @param nuevo
     * @return
     */
    public static int actualizarBiblioteca(Biblioteca viejo, Biblioteca nuevo) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Biblioteca b = em.merge(viejo);
            b.setAkusuario(nuevo.getAkusuario());
            b.setFecha(nuevo.getFecha());
            em.persist(b);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo actualizarBiblioteca" + ex.getLocalizedMessage());
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     * Borra una biblioteca
     *
     * @param biblioteca
     * @return
     */
    public static int deleteBiblioteca(Biblioteca biblioteca) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Biblioteca b = em.merge(biblioteca);
            em.persist(b);
            em.remove(b);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo deleteBiblioteca " + ex.getLocalizedMessage());
            tx.rollback();
        }
        con.desconecta(em);

        return resultado;
    }
}
