/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.crud;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.dao.Usuario;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author dam204
 */
public class UsuarioCRUD2 {
    
    public static int createUsuario(Usuario usuario) {
        int create = 0;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(usuario);
            tx.commit();
            create = 1;
        } catch (EntityExistsException ex) {
            System.err.println("Error, ya existe la entidad - " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.err.println("Error, en el argumento - " + ex.getMessage());
        } catch (PersistenceException ex) {
            tx.rollback();
            System.err.println("Error, realizando Rollback - " + ex.getMessage());
        }
        con.desconecta(em);
        return create;
    }
    
}
