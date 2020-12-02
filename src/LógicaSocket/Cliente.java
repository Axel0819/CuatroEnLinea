/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LógicaSocket;

import Lógica.Juego;
import java.net.*;
import java.io.*;

/**
 *
 * @author Axel
 */
public class Cliente {

    private Socket socket;
    private String IP;
    private int PUERTO;
    private ObjectOutputStream emite;
    private ObjectInputStream recibe;

    public Cliente(String ip, int puerto) {
        this.IP = ip;
        this.PUERTO = puerto;
        conexion(IP, PUERTO);
    }

    public void conexion(String ip, int puerto) {
        try {
            this.socket = new Socket(ip, puerto);
            recibe = new ObjectInputStream(socket.getInputStream());
            emite = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            System.err.println("NO CONECTA POR: " + ex.getMessage());
        }
    }

    public void enviar(Object juego) {
        try {
            //emite.reset();
            emite.writeObject(juego);
            //emite.flush();
            System.out.println("ENVIANDO DESDE CLIENTE...");
        } catch (Exception ex) {
            System.err.println("NO PUDO ENVIAR POR: " + ex.getMessage());
        }
    }

    public Object recibir() {
        Object sal = "";
        try {
            sal = recibe.readObject();
            System.out.println("RECIBIENDO DE SERVER ESTOY EN CLIENTE...");
        } catch (Exception ex) {
            System.err.println("NO PUDO RECIBIR POR: " + ex.getMessage());
        }
        return sal;
    }

    public static void main(String[] args) {
        Cliente cli = new Cliente("localhost", 6000);
        System.out.println(cli.recibir());
        Juego m = new Juego();
        cli.enviar(m);
    }
}
