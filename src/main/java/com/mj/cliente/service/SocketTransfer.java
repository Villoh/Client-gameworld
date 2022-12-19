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

    final String HOST = "localhost";
    final int PUERTO = 5000;
    int codigo;
    Socket sc;

    public SocketTransfer(int codigo) {
        try {
            sc = new Socket(HOST, PUERTO);
            this.codigo = codigo;
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

    public void descargaFichero(String nombreArchivo) {
        InputStream in = null;
        OutputStream out = null;
        DataOutputStream dout;
        try {
            dout = new DataOutputStream(sc.getOutputStream());
            in = sc.getInputStream();
            out = new FileOutputStream("C:\\GameWorld\\Juegos\\"+nombreArchivo);
            dout.writeInt(codigo);
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

    private void subeFichero(String nombreArchivo) {
        InputStream is = null;
        File file = new File("D:\\Users\\dam224\\Downloads\\prueba2.zip");
        DataOutputStream dos = null;
        OutputStream out = null;
        // Get the size of the file

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
            case 1:
                descargaFichero("prueba.zip");
                System.out.println("Finalizo c:");
                break;
            case 2:
                subeFichero("prueba2.zip");
                System.out.println("Finalizo c:");
                break;
            default:
                System.err.println("La petición no existe o algo ha salido mal");
                break;
        }
        return s;
    }

}
