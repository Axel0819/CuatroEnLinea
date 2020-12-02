/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lógica;

import java.io.*;

/**
 *
 * I Avance, Cuatro en Linea, Grupo Turquesa
 */
public class Juego implements Serializable {

    private String matrizJuego[][];
    private String jugador1;
    private String jugador2;
    private boolean gano;
    private int filas;
    private int columnas;
    
    private boolean turno;

    public Juego() {
        filas = 6;
        columnas = 7;
        this.matrizJuego = new String[filas][columnas];
        this.jugador1 = "";
        this.jugador2 = "";
        this.gano = false;
        this.turno = false;
        iniciarTablero();
    }

    public String[][] getMatrizJuego() {
        return matrizJuego;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public boolean getGano() {
        return this.gano;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public boolean isGano() {
        return gano;
    }

    public void setGano(boolean gano) {
        this.gano = gano;
    }

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    

    public void iniciarTablero() {
        for (int i = 0; i < matrizJuego.length; i++) {
            for (int j = 0; j < matrizJuego[0].length; j++) {
                matrizJuego[i][j] = "1";
            }
        }
    }

//    public void jugar(int posI, int posJ, String jugador) {
//        //String ganador = "";
//        this.matrizJuego[posI][posJ] = jugador;
//    }
    public void jugar(String ficha, int columna) {
        String vacio = "1";

        if (columna <= matrizJuego[0].length - 1 && columna >= 0) {

            for (int i = matrizJuego.length - 1; i >= 0; i--) {
                if (matrizJuego[i][columna].equals(vacio)) {
                    matrizJuego[i][columna] = ficha;
                    return;
                }
            }

        } else {
            System.out.println("No existe la columna");
        }
    }

    public String ganar() {
        String sal = "NO";
        if (compruebaHorizontal() || compruebaVertical() || verificarDiagonalesPrincipales() || verificarDiagonalesSecundarias()) {
            sal = "Alguien ganó";
            this.gano = true;
        }
        return sal;
    }

    public boolean compruebaHorizontal() {
        boolean sal = false;
        for (int i = filas - 1; i >= 0; i--) {
            if ((matrizJuego[i][0].equalsIgnoreCase(jugador1) && matrizJuego[i][1].equalsIgnoreCase(jugador1)
                    && matrizJuego[i][2].equalsIgnoreCase(jugador1) && matrizJuego[i][3].equalsIgnoreCase(jugador1))
                    || (matrizJuego[i][0].equalsIgnoreCase(jugador2) && matrizJuego[i][1].equalsIgnoreCase(jugador2)
                    && matrizJuego[i][2].equalsIgnoreCase(jugador2) && matrizJuego[i][3].equalsIgnoreCase(jugador2))) {
                sal = true;
            }

            if ((matrizJuego[i][1].equalsIgnoreCase(jugador1) && matrizJuego[i][2].equalsIgnoreCase(jugador1)
                    && matrizJuego[i][3].equalsIgnoreCase(jugador1) && matrizJuego[i][4].equalsIgnoreCase(jugador1))
                    || (matrizJuego[i][1].equalsIgnoreCase(jugador2) && matrizJuego[i][2].equalsIgnoreCase(jugador2)
                    && matrizJuego[i][3].equalsIgnoreCase(jugador2) && matrizJuego[i][4].equalsIgnoreCase(jugador2))) {
                sal = true;
            }
            if ((matrizJuego[i][2].equalsIgnoreCase(jugador1) && matrizJuego[i][3].equalsIgnoreCase(jugador1)
                    && matrizJuego[i][4].equalsIgnoreCase(jugador1) && matrizJuego[i][5].equalsIgnoreCase(jugador1))
                    || (matrizJuego[i][2].equalsIgnoreCase(jugador2) && matrizJuego[i][3].equalsIgnoreCase(jugador2)
                    && matrizJuego[i][4].equalsIgnoreCase(jugador2) && matrizJuego[i][5].equalsIgnoreCase(jugador2))) {
                sal = true;
            }
            if ((matrizJuego[i][3].equalsIgnoreCase(jugador1) && matrizJuego[i][4].equalsIgnoreCase(jugador1)
                    && matrizJuego[i][5].equalsIgnoreCase(jugador1) && matrizJuego[i][6].equalsIgnoreCase(jugador1))
                    || (matrizJuego[i][3].equalsIgnoreCase(jugador2) && matrizJuego[i][4].equalsIgnoreCase(jugador2)
                    && matrizJuego[i][5].equalsIgnoreCase(jugador2) && matrizJuego[i][6].equalsIgnoreCase(jugador2))) {
                sal = true;
            }

        }
        return sal;
    }

    public boolean compruebaVertical() {
        boolean sal = false;
        for (int i = 0; i < columnas; i++) {
            if ((matrizJuego[5][i].equalsIgnoreCase(jugador1) && matrizJuego[4][i].equalsIgnoreCase(jugador1)
                    && matrizJuego[3][i].equalsIgnoreCase(jugador1) && matrizJuego[2][i].equalsIgnoreCase(jugador1))
                    || (matrizJuego[5][i].equalsIgnoreCase(jugador2) && matrizJuego[4][i].equalsIgnoreCase(jugador2)
                    && matrizJuego[3][i].equalsIgnoreCase(jugador2) && matrizJuego[2][i].equalsIgnoreCase(jugador2))) {
                sal = true;
            }
            if ((matrizJuego[4][i].equalsIgnoreCase(jugador1) && matrizJuego[3][i].equalsIgnoreCase(jugador1)
                    && matrizJuego[2][i].equalsIgnoreCase(jugador1) && matrizJuego[1][i].equalsIgnoreCase(jugador1))
                    || (matrizJuego[4][i].equalsIgnoreCase(jugador2) && matrizJuego[3][i].equalsIgnoreCase(jugador2)
                    && matrizJuego[2][i].equalsIgnoreCase(jugador2) && matrizJuego[1][i].equalsIgnoreCase(jugador2))) {
                sal = true;
            }
            if ((matrizJuego[3][i].equalsIgnoreCase(jugador1) && matrizJuego[2][i].equalsIgnoreCase(jugador1)
                    && matrizJuego[1][i].equalsIgnoreCase(jugador1) && matrizJuego[0][i].equalsIgnoreCase(jugador1))
                    || (matrizJuego[3][i].equalsIgnoreCase(jugador2) && matrizJuego[2][i].equalsIgnoreCase(jugador2)
                    && matrizJuego[1][i].equalsIgnoreCase(jugador2) && matrizJuego[0][i].equalsIgnoreCase(jugador2))) {
                sal = true;
            }
        }
        return sal;
    }

    public boolean diagonalPrincipal(int num) {
        int contFichasA = 0;
        int contFichasB = 0;
        boolean sal = false;

        for (int i = matrizJuego.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrizJuego[0].length; j++) {
                if (i - j == num) {
                    if (matrizJuego[i][j].equals(jugador1)) {
                        contFichasA++;
                        if (contFichasA == 4) {
                            sal = true;
                        }

                    } else {
                        contFichasA = 0;
                    }

                    if (matrizJuego[i][j].equals(jugador2)) {
                        contFichasB++;
                        if (contFichasB == 4) {
                            sal = true;
                        }

                    } else {
                        contFichasB = 0;
                    }
                }
            }
        }
        return sal;
    }

    public boolean verificarDiagonalesPrincipales() {
        int array[] = {2, 1, 0, -1, -2, -3};

        for (int i = 0; i < array.length; i++) {
            if (diagonalPrincipal(array[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean diagonalSecundaria(int num) {
        int contFichasA = 0;
        int contFichasB = 0;
        boolean sal = false;

        for (int i = 0; i < matrizJuego.length; i++) {
            for (int j = matrizJuego[0].length - 1; j >= 0; j--) {
                if (i + j == matrizJuego.length - num) {
                    if (matrizJuego[i][j].equals(jugador1)) {
                        contFichasA++;
                        if (contFichasA == 4) {
                            sal = true;
                        }
                    } else {
                        contFichasA = 0;
                    }

                    if (matrizJuego[i][j].equals(jugador2)) {
                        contFichasB++;
                        if (contFichasB == 4) {
                            sal = true;
                        }
                    } else {
                        contFichasB = 0;
                    }
                }
            }
        }
        return sal;
    }

    public boolean verificarDiagonalesSecundarias() {
        int array[] = {-2, -1, 0, 1, 2, 3};

        for (int i = 0; i < array.length; i++) {
            if (diagonalSecundaria(array[i])) {
                return true;
            }
        }
        return false;
    }

    public void imprimir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("[" + matrizJuego[i][j] + "]");
            }
            System.out.println();
        }
    }
}
