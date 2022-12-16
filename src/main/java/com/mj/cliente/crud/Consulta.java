/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.crud;


import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.dao.Usuario;
import java.util.List;
import javax.persistence.EntityManager;



/**
 *
 * @author dam204
 */
public class Consulta {

    /**
     * Metodo que devuelve la lista de clientes de la base de datos
     */
    public static void listaClientes() {
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
       

        //recuperar la lista de clientes a travas de una NamedQuery
        List<Usuario> lista = em.createNamedQuery("Usuario.findAll").getResultList();
        System.out.println("\nDevuelva la lista de clientes de la base de datos.");
        //mostramos el contenido de la lista
        for (Usuario u : lista) {
            System.out.println("Nombre: " + u.getNombre() + " - Apellido: " + u.getApellidos());
        }

        con.desconecta(em);
    }

}
