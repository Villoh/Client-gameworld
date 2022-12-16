/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.crud;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.dao.Perfil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author dam204
 */
public class PerfilCRUD2 {
    
        public static Perfil readPerfil(int pk) {

        Perfil perfil = new Perfil();
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        try {
            Query query = em.createNamedQuery("Perfil.findByPkperfil");
            query.setParameter("pkperfil", pk);
            perfil = (Perfil) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println(">>> No encuentro el usuario - " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println(">>> Error de argumento - " + ex.getMessage());
        }
        con.desconecta(em);
        return perfil;
    }
    
}
