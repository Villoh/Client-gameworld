package com.mj.cliente.OtrasOperacionesBD;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.crud.BibliotecaCRUD;
import com.mj.cliente.dao.Biblioteca;
import com.mj.cliente.dao.Juego;
import com.mj.cliente.dao.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Transacciones {
    
    /**
     * 
     * @param user
     * @param juego
     * @param biblioUser 
     */
    
    public void descargarJuego(Usuario user, Juego juego,Biblioteca biblioUser){
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            BibliotecaCRUD.nuevaBiblioteca(biblioUser);
            tx.commit();
            
        }catch(Exception ex){
            System.err.println("Error"+ex); 
            tx.rollback();
        }
        
    }
}
