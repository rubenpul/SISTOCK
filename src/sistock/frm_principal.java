/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JOptionPane;
import static sistock.frm_login.txt_usuario;

/**
 *
 * @author ruben
 */
public class frm_principal extends javax.swing.JFrame {

   
    protected static String usuario;
    protected static String nombre;
    protected static Boolean administrador = false;
    
    public frm_principal() {
        initComponents();
        String sql;
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);

        this.setExtendedState(MAXIMIZED_BOTH);
        
        usuario = frm_login.txt_usuario.getText().trim();
        
        usuario obj = new usuario(usuario,"");
                
        nombre = obj.buscar_nombre();
        
        this.setTitle("SISTOCK - BIENVENIDO " + usuario + " - " + nombre);
        
        sql = "select a.cedula from tbl_usuario a where a.usuario = '";
        usuario us = new usuario(usuario,sql);
        us.getnivelusuario();
        if (us.getnivel().equals(1)){
            administrador = true;
        } 
        else{
            administrador = false;
        }
        
                             
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_foto = new javax.swing.JLabel();
        menu_sistock = new javax.swing.JMenuBar();
        menu_inicio = new javax.swing.JMenu();
        item_usuario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        item_cerrarsesion = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        item_salir = new javax.swing.JMenuItem();
        menu_administracion = new javax.swing.JMenu();
        item_centrocosto = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        item_equipo = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        item_servicio = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        item_tasadecambio = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        menu_importacion = new javax.swing.JMenu();
        item_actualizarmesimp = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        item_cargaimp = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        item_salidaresp = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        item_verstock = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menu_crear = new javax.swing.JMenu();
        item_cargamesnacional = new javax.swing.JMenuItem();
        menu_serviciopkf = new javax.swing.JMenu();
        item_registrotaller = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        item_estatustaller = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        item_actualizarstatustaller = new javax.swing.JMenuItem();
        menu_reporte = new javax.swing.JMenu();
        menuitem_reporte = new javax.swing.JMenuItem();
        submenu_auditoria = new javax.swing.JMenu();
        item_auditoria_repuesto_stock = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        item_auditoria_repuesto_usado = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        item_auditoriataller = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SEMACA_VER3.0.jpg"))); // NOI18N
        lbl_foto.setToolTipText("");
        getContentPane().add(lbl_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menu_inicio.setText("Inicio");
        menu_inicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        item_usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        item_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        item_usuario.setText("Usuario");
        item_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_usuarioActionPerformed(evt);
            }
        });
        menu_inicio.add(item_usuario);
        menu_inicio.add(jSeparator1);

        item_cerrarsesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        item_cerrarsesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_cerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/session.png"))); // NOI18N
        item_cerrarsesion.setText("Cerrar Sesión");
        item_cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_cerrarsesionActionPerformed(evt);
            }
        });
        menu_inicio.add(item_cerrarsesion);
        menu_inicio.add(jSeparator2);

        item_salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        item_salir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        item_salir.setText("Salir");
        item_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_salirActionPerformed(evt);
            }
        });
        menu_inicio.add(item_salir);

        menu_sistock.add(menu_inicio);

        menu_administracion.setText("Administración");
        menu_administracion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        item_centrocosto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_centrocosto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/centrocosto.png"))); // NOI18N
        item_centrocosto.setText("Centro de Costo");
        item_centrocosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_centrocostoActionPerformed(evt);
            }
        });
        menu_administracion.add(item_centrocosto);
        menu_administracion.add(jSeparator8);

        item_equipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_equipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/equipment.png"))); // NOI18N
        item_equipo.setText("Equipos");
        item_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_equipoActionPerformed(evt);
            }
        });
        menu_administracion.add(item_equipo);
        menu_administracion.add(jSeparator12);

        item_servicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/service.png"))); // NOI18N
        item_servicio.setText("Servicio");
        item_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_servicioActionPerformed(evt);
            }
        });
        menu_administracion.add(item_servicio);
        menu_administracion.add(jSeparator13);

        item_tasadecambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_tasadecambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dollar.png"))); // NOI18N
        item_tasadecambio.setText("Tasa de Cambio");
        item_tasadecambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_tasadecambioActionPerformed(evt);
            }
        });
        menu_administracion.add(item_tasadecambio);
        menu_administracion.add(jSeparator10);

        menu_sistock.add(menu_administracion);

        menu_importacion.setText("Importación");
        menu_importacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        item_actualizarmesimp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_actualizarmesimp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/preload.png"))); // NOI18N
        item_actualizarmesimp.setText("Actualizar Mes Stock");
        item_actualizarmesimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_actualizarmesimpActionPerformed(evt);
            }
        });
        menu_importacion.add(item_actualizarmesimp);
        menu_importacion.add(jSeparator3);

        item_cargaimp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_cargaimp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/stock.png"))); // NOI18N
        item_cargaimp.setText("Cargar Mes Stock");
        item_cargaimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_cargaimpActionPerformed(evt);
            }
        });
        menu_importacion.add(item_cargaimp);
        menu_importacion.add(jSeparator4);

        item_salidaresp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_salidaresp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salidastock.png"))); // NOI18N
        item_salidaresp.setText("Salida a Repuesto");
        item_salidaresp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_salidarespActionPerformed(evt);
            }
        });
        menu_importacion.add(item_salidaresp);
        menu_importacion.add(jSeparator9);

        item_verstock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_verstock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/verstock.png"))); // NOI18N
        item_verstock.setText("Ver Stock");
        item_verstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_verstockActionPerformed(evt);
            }
        });
        menu_importacion.add(item_verstock);
        menu_importacion.add(jSeparator6);

        menu_sistock.add(menu_importacion);

        menu_crear.setText("Nacional");
        menu_crear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        item_cargamesnacional.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_cargamesnacional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/material.png"))); // NOI18N
        item_cargamesnacional.setText("Carga Mes Stock");
        item_cargamesnacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_cargamesnacionalActionPerformed(evt);
            }
        });
        menu_crear.add(item_cargamesnacional);

        menu_sistock.add(menu_crear);

        menu_serviciopkf.setText("Servicio PKF");
        menu_serviciopkf.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        item_registrotaller.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_registrotaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/taller.png"))); // NOI18N
        item_registrotaller.setText("Registro a Taller");
        item_registrotaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_registrotallerActionPerformed(evt);
            }
        });
        menu_serviciopkf.add(item_registrotaller);
        menu_serviciopkf.add(jSeparator14);

        item_estatustaller.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_estatustaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/status.png"))); // NOI18N
        item_estatustaller.setText("Estatus Taller");
        item_estatustaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_estatustallerActionPerformed(evt);
            }
        });
        menu_serviciopkf.add(item_estatustaller);
        menu_serviciopkf.add(jSeparator15);

        item_actualizarstatustaller.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_actualizarstatustaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        item_actualizarstatustaller.setText("Actualizar Estatus Servicios");
        item_actualizarstatustaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_actualizarstatustallerActionPerformed(evt);
            }
        });
        menu_serviciopkf.add(item_actualizarstatustaller);

        menu_sistock.add(menu_serviciopkf);

        menu_reporte.setText("Reporte");
        menu_reporte.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        menuitem_reporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuitem_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/transport.png"))); // NOI18N
        menuitem_reporte.setText("Informe de Gestión");
        menuitem_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_reporteActionPerformed(evt);
            }
        });
        menu_reporte.add(menuitem_reporte);

        submenu_auditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/report.png"))); // NOI18N
        submenu_auditoria.setText("Auditoria");
        submenu_auditoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        item_auditoria_repuesto_stock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_auditoria_repuesto_stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salidastock.png"))); // NOI18N
        item_auditoria_repuesto_stock.setText("Repuestos de Importacion Stock");
        item_auditoria_repuesto_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_auditoria_repuesto_stockActionPerformed(evt);
            }
        });
        submenu_auditoria.add(item_auditoria_repuesto_stock);
        submenu_auditoria.add(jSeparator7);

        item_auditoria_repuesto_usado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_auditoria_repuesto_usado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/stock.png"))); // NOI18N
        item_auditoria_repuesto_usado.setText("Repuestos de Importacion Usado");
        item_auditoria_repuesto_usado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_auditoria_repuesto_usadoActionPerformed(evt);
            }
        });
        submenu_auditoria.add(item_auditoria_repuesto_usado);
        submenu_auditoria.add(jSeparator16);

        item_auditoriataller.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        item_auditoriataller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/taller.png"))); // NOI18N
        item_auditoriataller.setText("Taller PKF");
        item_auditoriataller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_auditoriatallerActionPerformed(evt);
            }
        });
        submenu_auditoria.add(item_auditoriataller);
        submenu_auditoria.add(jSeparator5);

        jMenuItem1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/material.png"))); // NOI18N
        jMenuItem1.setText("Materiales y Respuestos");
        submenu_auditoria.add(jMenuItem1);

        menu_reporte.add(submenu_auditoria);

        menu_sistock.add(menu_reporte);

        setJMenuBar(menu_sistock);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void item_cargaimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_cargaimpActionPerformed
        
       //if (administrador){
            frm_cargaimp frame = new frm_cargaimp();
            frame.setVisible(true); 
        /* }
        else{
            JOptionPane.showMessageDialog(null, "USUARIO " + login + " NO TIENE PRIVILEGIOS PARA ESTA ACCIÓN", "SISBAL - USUARIO", JOptionPane.WARNING_MESSAGE,null);
        }   */ 
    }//GEN-LAST:event_item_cargaimpActionPerformed

    private void item_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_usuarioActionPerformed
        //if (administrador){
            frm_usuario frame = new frm_usuario();
            frame.setVisible(true); 
        /*}
        else{
            JOptionPane.showMessageDialog(null, "USUARIO " + login + " NO TIENE PRIVILEGIOS PARA ESTA ACCIÓN", "SISBAL - USUARIO", JOptionPane.WARNING_MESSAGE,null);
        }*/
    }//GEN-LAST:event_item_usuarioActionPerformed

    private void item_cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_cerrarsesionActionPerformed
        
            frm_login frame = new frm_login();
            frame.setVisible(true); 
            this.dispose();
            
    }//GEN-LAST:event_item_cerrarsesionActionPerformed

    private void item_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_salirActionPerformed
            this.dispose();
    }//GEN-LAST:event_item_salirActionPerformed

    private void item_cargamesnacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_cargamesnacionalActionPerformed
            frm_carganacional frame = new frm_carganacional();
            frame.setVisible(true); 
           
    }//GEN-LAST:event_item_cargamesnacionalActionPerformed

    private void item_verstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_verstockActionPerformed
         frm_verstockimp frame = new frm_verstockimp();
         frame.setVisible(true); 
    
    }//GEN-LAST:event_item_verstockActionPerformed

    private void item_actualizarmesimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_actualizarmesimpActionPerformed
        
            frm_actualizarstockimp frame = new frm_actualizarstockimp();
            frame.setVisible(true); 
    }//GEN-LAST:event_item_actualizarmesimpActionPerformed

    private void item_salidarespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_salidarespActionPerformed
            frm_salida frame = new frm_salida();
            frame.setVisible(true);
    }//GEN-LAST:event_item_salidarespActionPerformed

    private void item_equipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_equipoActionPerformed
            frm_equipo frame = new frm_equipo();
            frame.setVisible(true);
    }//GEN-LAST:event_item_equipoActionPerformed

    private void item_registrotallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_registrotallerActionPerformed
            frm_registropkf frame = new frm_registropkf();
            frame.setVisible(true);
    }//GEN-LAST:event_item_registrotallerActionPerformed

    private void item_estatustallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_estatustallerActionPerformed
            frm_estatusregistropkf frame = new frm_estatusregistropkf();
            frame.setVisible(true);
    }//GEN-LAST:event_item_estatustallerActionPerformed

    private void item_centrocostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_centrocostoActionPerformed
            frm_centrocosto frame = new frm_centrocosto();
            frame.setVisible(true);
    }//GEN-LAST:event_item_centrocostoActionPerformed

    private void item_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_servicioActionPerformed
            frm_servicio frame = new frm_servicio();
            frame.setVisible(true);
    }//GEN-LAST:event_item_servicioActionPerformed

    private void item_actualizarstatustallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_actualizarstatustallerActionPerformed
            frm_actualizarstatuspkf frame = new frm_actualizarstatuspkf();
            frame.setVisible(true);
    }//GEN-LAST:event_item_actualizarstatustallerActionPerformed

    private void item_auditoria_repuesto_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_auditoria_repuesto_stockActionPerformed
        frm_auditoria_entrada frame = new frm_auditoria_entrada();
        frame.setVisible(true);
    }//GEN-LAST:event_item_auditoria_repuesto_stockActionPerformed

    private void item_auditoriatallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_auditoriatallerActionPerformed
        frm_auditoria_tallerpkf frame = new frm_auditoria_tallerpkf();
        frame.setVisible(true);
    }//GEN-LAST:event_item_auditoriatallerActionPerformed

    private void menuitem_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_reporteActionPerformed
        frm_reporte frame = new frm_reporte();
        frame.setVisible(true);
    }//GEN-LAST:event_menuitem_reporteActionPerformed

    private void item_auditoria_repuesto_usadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_auditoria_repuesto_usadoActionPerformed
        frm_auditoria_salidarep frm = new frm_auditoria_salidarep();
        frm.setVisible(true);
    }//GEN-LAST:event_item_auditoria_repuesto_usadoActionPerformed

    private void item_tasadecambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_tasadecambioActionPerformed
        frm_tasa frm = new frm_tasa();
        frm.setVisible(true);
    }//GEN-LAST:event_item_tasadecambioActionPerformed

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
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem item_actualizarmesimp;
    private javax.swing.JMenuItem item_actualizarstatustaller;
    private javax.swing.JMenuItem item_auditoria_repuesto_stock;
    private javax.swing.JMenuItem item_auditoria_repuesto_usado;
    private javax.swing.JMenuItem item_auditoriataller;
    private javax.swing.JMenuItem item_cargaimp;
    private javax.swing.JMenuItem item_cargamesnacional;
    private javax.swing.JMenuItem item_centrocosto;
    private javax.swing.JMenuItem item_cerrarsesion;
    private javax.swing.JMenuItem item_equipo;
    private javax.swing.JMenuItem item_estatustaller;
    private javax.swing.JMenuItem item_registrotaller;
    private javax.swing.JMenuItem item_salidaresp;
    private javax.swing.JMenuItem item_salir;
    private javax.swing.JMenuItem item_servicio;
    private javax.swing.JMenuItem item_tasadecambio;
    private javax.swing.JMenuItem item_usuario;
    private javax.swing.JMenuItem item_verstock;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lbl_foto;
    private javax.swing.JMenu menu_administracion;
    private javax.swing.JMenu menu_crear;
    private javax.swing.JMenu menu_importacion;
    private javax.swing.JMenu menu_inicio;
    private javax.swing.JMenu menu_reporte;
    private javax.swing.JMenu menu_serviciopkf;
    private javax.swing.JMenuBar menu_sistock;
    private javax.swing.JMenuItem menuitem_reporte;
    private javax.swing.JMenu submenu_auditoria;
    // End of variables declaration//GEN-END:variables
}
