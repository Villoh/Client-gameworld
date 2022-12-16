package com.mj.cliente.OtrasOperacionesBD;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.crud.DescargasCRUD;
import com.mj.cliente.crud.JuegoCRUD;
import com.mj.cliente.dao.Biblioteca;
import com.mj.cliente.dao.Descarga;
import com.mj.cliente.dao.Juego;
import com.mj.cliente.dao.Usuario;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class Transacciones {
    
    /**
     * Lo que va ha hacer es crear una nueva descaga
     * @param user
     * @param juego
     * @param biblioUser 
     */
    
    public static void descargarJuego(Juego juego,Biblioteca biblioUser){
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Juego viejo = juego;
            int numdescargas = maxNumDescargas(juego);
            if(numdescargas==-1){
                System.err.println("No ha cogido la cantidad de descagas correctamente");
            }else{
                juego.setNumdescargas(numdescargas);
                JuegoCRUD.actualizarJuego(viejo, juego);
                //Hacemos una nueva descarga
                Descarga descarga = new Descarga();
                descarga.setAkbiblioteca(biblioUser);
                descarga.setAkjuego(juego);
                descarga.setFecha(java.sql.Date.valueOf(LocalDate.now()));
                DescargasCRUD.nuevaDescarga(descarga);
                tx.commit();
            }
            
        }catch(Exception ex){
            System.err.println("Error"+ex); 
            tx.rollback();
        }
        
    }
    /**
     * 
     * @param j
     * @return 
     */
    public static int maxNumDescargas(Juego j){
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        int numDescargas = -1;
        try {
            Query query = em.createNamedQuery("Juego.findByNumdescargas");
            query.setParameter("numdescargas",j.getNumdescargas());
            numDescargas = (int) query.getSingleResult();
            numDescargas++;
        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo verJuego  " + ex.getLocalizedMessage());
            numDescargas =-1;
        }
        con.desconecta(em);
        return numDescargas;
    }
}
