/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mj.cliente.service;

import com.mj.cliente.conexion.Conexion;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;

/**
 *
 * @author M3J2
 */
public class SocketTransfer implements Callable<String> {

    final String HOST = "192.168.34.129";
    final int PUERTO = 5000;
    int codigo;
    Socket sc;

    String nombreFichero = "";
    String rutaArchivo;

    public SocketTransfer(int codigo,String ruta, String nombreFichero) {
        try {
            sc = new Socket(HOST, PUERTO);
            this.codigo = codigo;
            this.nombreFichero = nombreFichero;
            rutaArchivo=ruta;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String Data() {
        String text = null;
        DataInputStream in;
        DataOutputStream out;
        //Objeto
        try {
            //Creo el socket para conectarme con el cliente
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            //Envio un mensaje al cliente
            out.writeInt(codigo);
            text = in.readUTF();
            out.close();
            in.close();
            sc.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return text;
    }

    public void descargaFichero(String ruta,String nombreArchivo) {
        InputStream in = null;
        OutputStream out = null;
        DataOutputStream dout;

        try {
            dout = new DataOutputStream(sc.getOutputStream());
            in = sc.getInputStream();
            out = new FileOutputStream(ruta + nombreArchivo);
            dout.writeInt(codigo);
            //nombreFichero=nombreArchivo;
            dout.writeUTF(nombreArchivo);
            byte[] bytes = new byte[1024];

            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
                System.out.println("Descargando...");
            }
            dout.close();
            out.close();
            in.close();
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no existe: " + e);
        } catch (IOException e) {
            System.err.println("El archivo no se ha podido escribir: " + e);
        }
    }

    private void subeFichero(String ruta,String nombreArchivo) {
        InputStream is = null;
        File file = new File(ruta);
        DataOutputStream dos = null;
        OutputStream out = null;
      
        try {
            is = new FileInputStream(file);
            dos = new DataOutputStream(sc.getOutputStream());
            dos.writeInt(codigo);
            dos.writeUTF(nombreArchivo);
            byte[] bytes = new byte[1024];
            out = sc.getOutputStream();
            int count;
            while ((count = is.read(bytes)) > 0) {
                out.write(bytes, 0, count);
                System.out.println("Subiendo...");
            }
            dos.close();
            is.close();
            out.close();
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("Fichero no encontrado" + fnfe.toString());
        } catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }

    @Override
    public String call() throws Exception {
        String s = null;
        switch (codigo) {
            case 1://Descarga Zip
                rutaArchivo = "C:\\GameWorld\\Juegos\\";
                descargaFichero(rutaArchivo, nombreFichero);
                System.out.println("Finalizo c:");
                break;
            case 2://Sube Zip
                //rutaArchivo="C:\\GameWorld\\Juegos\\";
                subeFichero(rutaArchivo,nombreFichero);
                System.out.println("Finalizo c:");
                break;
            case 3://Descarga Portada
                rutaArchivo = "C:\\GameWorld\\Img\\ImgJuegos\\";
                descargaFichero(rutaArchivo,nombreFichero);
                System.out.println("Finalizo c:");
                break;
            case 4://Sube Portada
                //rutaArchivo="C:\\GameWorld\\Img\\ImgJuegos\\";
                subeFichero(rutaArchivo,nombreFichero);
                System.out.println("Finalizo c:");
                break;
            default:
                System.err.println("La petición no existe o algo ha salido mal");
                break;
        }
        return s;
    }

}
