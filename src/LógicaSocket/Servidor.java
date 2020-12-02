
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LógicaSocket;

import Lógica.Juego;
import java.io.*;
import java.net.*;

/**
 *
 * @author Axel
 */
public class Servidor {

    private ServerSocket servidor;
    private Socket socket;
    private int PUERTO;
    private ObjectInputStream recibe;
    private ObjectOutputStream emite;

    public Servidor(int puerto) {
        this.PUERTO = puerto;
        conexion(PUERTO);
    }

    public void conexion(int puerto) {
        try {
            this.servidor = new ServerSocket(puerto);
            this.socket = servidor.accept();
            emite = new ObjectOutputStream(socket.getOutputStream());
            recibe = new ObjectInputStream(socket.getInputStream());
        } catch (Exception ex) {
            System.err.println("NO PUDO CONECTAR POR: " + ex.getMessage());
        }
    }

    public void enviar(Object Juego) {
        try {
            emite.reset();
            emite.writeObject(Juego);
            emite.flush();
            System.out.println("ENVIANDO DESDE SERVIDOR...");
        } catch (Exception ex) {
            System.err.println("NO PUDO ENVIAR POR: " + ex.getMessage());
        }
    }

    public Object recibir() {
        Object sal = "";
        System.out.println("RECIBIENDO DE CLIENTE ESTOY EN SERVER...");
        try {
            sal = recibe.readObject();
        } catch (Exception ex) {
            System.err.println("NO PUDO RECIBIR POR: " + ex.getMessage());
        }
        return sal;
    }

    public static void main(String[] args) {
        Servidor server = new Servidor(6000);
        Juego ms = new Juego();
        server.enviar(ms);
        System.out.println(server.recibir());
    }
}
