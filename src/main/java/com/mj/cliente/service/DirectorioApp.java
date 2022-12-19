/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.service;

import java.io.File;

/**
 *
 * @author M3J2
 */
public class DirectorioApp {

    /**
     * Crea las rutas donde se almacena los datos de la aplicacion en local
     */
    public static void crearDirectorio() {
        File directorio = new File("C:\\GameWorld");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                directorio = new File("C:\\GameWorld\\Juegos");
                directorio.mkdirs();
                directorio = new File("C:\\GameWorld\\Img\\Avatar");
                directorio.mkdirs();
                directorio = new File("C:\\GameWorld\\Img\\ImgJuegos");
                directorio.mkdirs();
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }

}
