/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Lógica.Juego;
import LógicaSocket.*;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Administrador
 */
public class GUI1 extends javax.swing.JFrame {

    private Juego juego;
    private Cliente cliente;
    private Servidor servidor;
    private boolean es_server;
    private int columna;
    private String ganador;
    private String pivotNombre;

    private Thread hilo;

    public GUI1() {
        juego = new Juego();
        this.columna = 0;
        this.ganador = this.pivotNombre = "";
        initComponents();
        iniciarGrid();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void verGanador() {
        if (es_server) {
            if (juego.ganar().equalsIgnoreCase("Alguien ganó")) {
                this.ganador = juego.getJugador1();
                JOptionPane.showMessageDialog(null, "GANASTE 😊: " + ganador);
            }
        } else {
            if (juego.ganar().equalsIgnoreCase("Alguien ganó")) {
                JOptionPane.showMessageDialog(null, "GANASTE 😊: " + pivotNombre);
            }
        }

    }

    public void recibirJuego() {
        new Thread(new Runnable() {
            public void run() {
                while (juego.ganar().equalsIgnoreCase("NO")) {
                    if (es_server) {
                        juego = (Juego) servidor.recibir();
                        refrescar();
                    } else {
                        juego = (Juego) cliente.recibir();

                        refrescar();
                    }
                }

            }
        }).start();
    }

    public void refrescar() {
        miPanel.removeAll();
        iniciarGrid();
        miPanel.revalidate();
        miPanel.repaint();
    }

    public void iniciarGrid() {
        for (int i = 0; i < juego.getFilas(); i++) {
            for (int j = 0; j < juego.getColumnas(); j++) {
                JLabel etiqueta = new JLabel();
                etiqueta.setOpaque(true);

                if (juego.getMatrizJuego()[i][j].equals("1")) {
                    etiqueta.setBackground(Color.BLUE);
                }
                if (juego.getMatrizJuego()[i][j].equals(juego.getJugador1())) {
                    etiqueta.setBackground(Color.ORANGE);
                } else if (juego.getMatrizJuego()[i][j].equals(juego.getJugador2())) {
                    etiqueta.setBackground(Color.GREEN);
                }
                miPanel.add(etiqueta);
            }
        }
    }

    public void iniciarJ() {

        hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (es_server) {
                        if (juego.getTurno() == true) {

                        } else if (juego.getTurno() == false) {

                        }

                    } else {
                        if (juego.getTurno() == true) {

                        } else if (juego.getTurno() == false) {

                        }
                    }
                }
            }
        });

        hilo.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        panelPrincipal = new javax.swing.JPanel();
        miPanel = new javax.swing.JPanel();
        inputCol = new javax.swing.JTextField();
        titulo2Label = new javax.swing.JLabel();
        colLabel = new javax.swing.JLabel();
        serverBoton = new javax.swing.JButton();
        clienteBoton = new javax.swing.JButton();
        nombreJugador = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelJuego.setBackground(new java.awt.Color(204, 204, 204));

        panelPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        panelPrincipal.setLayout(null);

        miPanel.setBackground(new java.awt.Color(51, 51, 51));
        miPanel.setMinimumSize(new java.awt.Dimension(406, 316));
        miPanel.setLayout(new java.awt.GridLayout(juego.getFilas(), juego.getColumnas(), 1, 1));
        panelPrincipal.add(miPanel);
        miPanel.setBounds(80, 0, 640, 400);

        inputCol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputColKeyPressed(evt);
            }
        });

        titulo2Label.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        titulo2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2Label.setText("Cuatro en Línea");

        colLabel.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        colLabel.setText("Columna");

        serverBoton.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        serverBoton.setText("Servidor");
        serverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverBotonActionPerformed(evt);
            }
        });

        clienteBoton.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        clienteBoton.setText("Cliente");
        clienteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteBotonActionPerformed(evt);
            }
        });

        nombreJugador.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N

        btnReset.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(colLabel)
                        .addGap(18, 18, 18)
                        .addComponent(inputCol, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233)
                        .addComponent(serverBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clienteBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset))
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(nombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(titulo2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJuegoLayout.createSequentialGroup()
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titulo2Label)
                            .addComponent(nombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(colLabel)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJuegoLayout.createSequentialGroup()
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(serverBoton)
                            .addComponent(clienteBoton)
                            .addComponent(inputCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputColKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputColKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (es_server) {
                columna = Integer.parseInt(inputCol.getText());
                juego.jugar(juego.getJugador1(), columna);
                refrescar();

                juego.setTurno(true);
                this.servidor.enviar(juego);
                inputCol.setText("");

                verGanador();

            } else {
                columna = Integer.parseInt(inputCol.getText());
                juego.jugar(juego.getJugador2(), columna);
                refrescar();

                juego.setTurno(false);
                this.cliente.enviar(juego);
                inputCol.setText("");
                verGanador();
            }
        }
    }//GEN-LAST:event_inputColKeyPressed

    private void clienteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteBotonActionPerformed
        juego.setJugador2(JOptionPane.showInputDialog("Player: "));
        nombreJugador.setText(juego.getJugador2());
        pivotNombre = nombreJugador.getText();
        this.cliente = new Cliente("localhost", 6000);
        this.es_server = false;
        recibirJuego();

        clienteBoton.setEnabled(false);
        serverBoton.setEnabled(false);
        iniciarJ();

        //TURNO == 0--->SERVIDOR !! CLIENTE---->inputCol.setEnable(false)

    }//GEN-LAST:event_clienteBotonActionPerformed

    private void serverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverBotonActionPerformed
        juego.setJugador1(JOptionPane.showInputDialog("Player: "));
        nombreJugador.setText(juego.getJugador1());
        this.servidor = new Servidor(6000);
        this.es_server = true;
        recibirJuego();

        serverBoton.setEnabled(false);
        clienteBoton.setEnabled(false);
        iniciarJ();
    }//GEN-LAST:event_serverBotonActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        juego.iniciarTablero();
        refrescar();
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton clienteBoton;
    private javax.swing.JLabel colLabel;
    private javax.swing.JTextField inputCol;
    private javax.swing.JPanel miPanel;
    private javax.swing.JLabel nombreJugador;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton serverBoton;
    private javax.swing.JLabel titulo2Label;
    // End of variables declaration//GEN-END:variables
}