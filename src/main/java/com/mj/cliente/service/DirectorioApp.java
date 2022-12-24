/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author M3J2
 */
public class DirectorioApp {

    /**
     * Crea las rutas donde se almacenan los datos de la aplicacion en local
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

    public static void unzip(String zipRuta) {

        File path = new File("C:\\GameWorld\\Juegos\\");
        String destDir = "C:\\\\GameWorld\\\\Juegos\\\\";

        File[] allfiles = path.listFiles();
        for (File f : allfiles) {
            if (f.getName().equals(zipRuta)) {
                System.out.println("Ruta juego :" + destDir + zipRuta);
                File dir = new File(destDir);
                // Crea el directorio si no existe
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                FileInputStream fis;
                //buffer para leer los datos
                byte[] buffer = new byte[1024];
                try {
                    fis = new FileInputStream(f);
                    ZipInputStream zis = new ZipInputStream(fis);
                    ZipEntry ze = zis.getNextEntry();
                    while (ze != null) {
                        String fileName = ze.getName();
                        File newFile = new File(destDir + File.separator + fileName);
                        System.out.println("Descomprimiendo " + newFile.getAbsolutePath());
                        //create directories for sub directories in zip
                        new File(newFile.getParent()).mkdirs();
                        FileOutputStream fos = new FileOutputStream(newFile);
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                        fos.close();
                        //cierra ZipEntry
                        zis.closeEntry();
                        ze = zis.getNextEntry();
                    }
                    //close last ZipEntry
                    zis.closeEntry();
                    zis.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
