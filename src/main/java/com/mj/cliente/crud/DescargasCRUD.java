package com.mj.cliente.crud;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.dao.Descarga;

import javax.persistence.*;
import java.util.List;

public class DescargasCRUD {

    /**
     * Devuelve una lista de todas las descargas de la base de datos
     *
     * @return
     */
    public static List<Descarga> verListaDescargas() {
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        List<Descarga> lista = null;
        try {
            lista = em.createNamedQuery("Descarga.findAll").getResultList();

        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verListaDescargas " + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return lista;
    }

    /**
     * Busca una descarga segun su pk
     *
     * @param pkdescarga
     * @return
     */
    public static Descarga verDescarga(int pkdescarga) {
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        Descarga descarga = null;
        try {
            Query query = em.createNamedQuery("Descarga.findByPkdescarga");
            query.setParameter("pkdescarga", pkdescarga);
            descarga = (Descarga) query.getSingleResult();
        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verDescarga" + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return descarga;
    }

    /**
     * Crea una nueva descarga
     *
     * @param descarga
     * @return
     */
    public static int nuevaDescarga(Descarga descarga) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(descarga);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo nuevaDescarga " + ex.getLocalizedMessage());
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     * Acualiza los datos de una Descarga
     *
     * @param viejo
     * @param nuevo
     * @return
     */
    public static int actualizardescarga(Descarga viejo, Descarga nuevo) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Descarga d = em.merge(viejo);
            d.setAkbiblioteca(nuevo.getAkbiblioteca());
            d.setAkjuego(nuevo.getAkjuego());
            d.setFecha(nuevo.getFecha());
            em.persist(d);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo actualizardescarga " + ex.getLocalizedMessage());
            tx.rollback();
        }

        con.desconecta(em);
        return resultado;
    }

    /**
     * Borra una descarga
     *
     * @param descarga
     * @return
     */
    public static int deleteDescarga(Descarga descarga) {
        int resultado = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Descarga d = em.merge(descarga);
            em.persist(d);
            em.remove(d);
            tx.commit();
            resultado = 1;
        } catch (IllegalArgumentException | PersistenceException ex) {
            System.err.println("Excepciones en metodo deleteDescarga " + ex.getLocalizedMessage());
            tx.rollback();
        }
        con.desconecta(em);

        return resultado;
    }
}
