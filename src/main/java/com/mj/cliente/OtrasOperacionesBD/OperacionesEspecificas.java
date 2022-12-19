package com.mj.cliente.OtrasOperacionesBD;

import com.mj.cliente.conexion.Conexion;
import com.mj.cliente.crud.UsuarioCRUD;
import com.mj.cliente.dao.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class OperacionesEspecificas {

    /**
     * Metodo que comprueba si existe un alias en la base de datos
     * @param alias
     * @return Devuelve true si el alias NO EXISTE y false si el Alias EXISTE
     */
    
    public static boolean comprobarAlias(String alias){
        Boolean disponible = true;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        Usuario usuario = null;
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.alias =:alias");
            query.setParameter("alias",alias);
            usuario = (Usuario) query.getSingleResult();
            if(usuario.getAlias().equals(alias)){
                System.out.println(usuario.getAlias().toString());
                //El alias no existe
                disponible = false;
            }else{
                disponible= true;
            }
        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo comprobarAlias" + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return disponible;
    }
    /**
     * 
     * @param alias
     * @return 
     */
       public static boolean comprobarEmail(String email){
        Boolean disponible = true;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        Usuario usuario = null;
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email =:email");
            query.setParameter("email",email);
            usuario = (Usuario) query.getSingleResult();
            if(usuario.getEmail().equals(email)){
                //El email no esta disponible
                disponible = false;
            }else{
                disponible= true;
            }
        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo comprobarAlias" + ex.getLocalizedMessage());
        }
        con.desconecta(em);
        return disponible;
    }
    /**
     * Comprueba un alias y un email y si es correcto llama al metod actualizarUsuario para cambiar la contraseña
     * @param alias 
     * @param email
     * @param pass
     * @return Devuelve si es correcto o no
     */
      public static Boolean cambiarContraseña(String alias, String email,String pass){
        Boolean correcto = false;
        Conexion con = new Conexion();
        EntityManager em = con.conecta();
        EntityTransaction tx = em.getTransaction();
        Usuario viejo = null;
        Usuario nuevo = null;
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.alias =:alias AND u.email=:email");
            query.setParameter("alias",alias);
            query.setParameter("email", email);
            viejo = (Usuario) query.getSingleResult();
            nuevo = viejo;//Igualo para que tengan los mismos valores
            if(viejo.getAlias().equals(alias) && viejo.getEmail().equals(email)){
                //Buscamos un usuario con ese alias y correo y si existe devuelve true
                tx.begin();
                nuevo.setPassword(pass);//Cambio la contraseña
                UsuarioCRUD.actualizarUsuario(viejo, nuevo);
                tx.commit();
                correcto = true;
                return correcto;
            }
        } catch (NoResultException | IllegalArgumentException ex) {
            System.err.println("Excepciones en metodo comprobarAliasYCorreo" + ex.getLocalizedMessage());
            tx.rollback();
        }
        correcto = false;
        con.desconecta(em);
        return correcto;
    }
      


}
