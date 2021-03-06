/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import jxl.write.WriteException;

/**
 *
 * @author ruben
 */
public class frm_auditoria_entrada extends javax.swing.JFrame {

    /**
     * Creates new form frm_auditoria_salidarep
     */
    public frm_auditoria_entrada() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("SISTOCK - TRANSACCIONES SALIDA STOCK REPUESTOS IMPORTACION");
        this.getContentPane().setBackground(Color.WHITE);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_auditoria = new javax.swing.JTable();
        bot_exportar = new javax.swing.JButton();
        bot_cerrar = new javax.swing.JButton();
        lbl_encabezado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_auditoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla_auditoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_bitacora", "transaccion", "usuario", "fecha transaccion", "id_stock", "centro costo", "ocexcel", "nrofactura", "nroguia", "fecha llegada", "sp", "equipo", "codigosap", "descripcion material", "nro parte", "cantidad recibida", "precio unitario", "monto factura", "flete envio", "monto total", "valor dolar", "monto bs", "monto flete", "total general", "cantidad usada", "cantidad disp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_auditoria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 121, 1340, 500));

        bot_exportar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/excel.png"))); // NOI18N
        bot_exportar.setText("EXPORTAR EXCEL");
        bot_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_exportarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_exportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 630, -1, -1));

        bot_cerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        bot_cerrar.setText("CERRAR");
        bot_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 630, -1, -1));

        lbl_encabezado.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_encabezado.setForeground(new java.awt.Color(0, 0, 255));
        lbl_encabezado.setText("TRANSACCIONES REPUESTOS");
        getContentPane().add(lbl_encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        auditoria audi = new auditoria(tabla_auditoria);
        
        audi.log_stock_entrada();
        
    }//GEN-LAST:event_formWindowOpened

    private void bot_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_exportarActionPerformed
        String nombre_archivo;
        
        nombre_archivo = "C:/Documentos_Sistock/Auditoria_entradarep.xls";
        
        
        reporte_excel ex = new reporte_excel(new File(nombre_archivo), "LOG STOCK REP STOCK ENTRADA", tabla_auditoria);
        
        
        try {
            if(ex.excel_export_auditoria_entrada()){
                
                    File archivo_abrir = new File(nombre_archivo);
                    Desktop.getDesktop().open(archivo_abrir);
                
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR EN EXPORTAR ARCHIVO EXCEL");
            }
        } catch (IOException | WriteException ex1) {
            JOptionPane.showMessageDialog(null, "ERROR ABRIR ARCHIVO");
        }
        
      
    }//GEN-LAST:event_bot_exportarActionPerformed

    private void bot_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_cerrarActionPerformed
            this.dispose();
    }//GEN-LAST:event_bot_cerrarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_auditoria_entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_auditoria_entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_auditoria_entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_auditoria_entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_auditoria_entrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bot_cerrar;
    private javax.swing.JButton bot_exportar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_encabezado;
    private javax.swing.JTable tabla_auditoria;
    // End of variables declaration//GEN-END:variables
}
