/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mj.cliente.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author M3J2
 */
public class Conexion {

    String unitname = "com.mj.cliente_Cliente_jar_1.0-SNAPSHOTPU";

    public Conexion() {

    }

    public EntityManager conecta() {
        EntityManager entitymanager = null;
        try {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(unitname);
            entitymanager = emfactory.createEntityManager();
        } catch (PersistenceException ex) {
            System.err.println("ERROR al conectar. " + ex.getLocalizedMessage());
        }
        return entitymanager;
    }
    
    public void desconecta(EntityManager em){
        if (em!=null){
            em.close();
        }
    }

}
