/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ruben
 */
public class frm_actualizarstockimp extends javax.swing.JFrame {

    /**
     * Creates new form frm_actualizarstockimp
     */
    public frm_actualizarstockimp() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("SISTOCK - ACTUALIZAR ESTATUS STOCK DE IMPORTACION");
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_encabezado = new javax.swing.JLabel();
        bot_buscar = new javax.swing.JButton();
        lbl_datos = new javax.swing.JLabel();
        bot_actualizar = new javax.swing.JButton();
        bot_limpiar = new javax.swing.JButton();
        bot_cerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_resumen = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        check_fecha = new javax.swing.JCheckBox();
        check_sap = new javax.swing.JCheckBox();
        check_descripcion = new javax.swing.JCheckBox();
        check_area = new javax.swing.JCheckBox();
        check_equipo = new javax.swing.JCheckBox();
        date_desde = new com.toedter.calendar.JDateChooser();
        date_hasta = new com.toedter.calendar.JDateChooser();
        txt_sap = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        cmb_centrocosto = new javax.swing.JComboBox();
        lbl_desde = new javax.swing.JLabel();
        lbl_hasta = new javax.swing.JLabel();
        cmb_equipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_encabezado.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_encabezado.setForeground(new java.awt.Color(0, 0, 255));
        lbl_encabezado.setText("MÓDULO DE ACTUALIZACIÓN DE DATOS DE STOCK DE IMPORTACIÓN");
        getContentPane().add(lbl_encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 30));

        bot_buscar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Search.png"))); // NOI18N
        bot_buscar.setText("BUSCAR");
        bot_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 160, 40));

        lbl_datos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_datos.setForeground(new java.awt.Color(0, 0, 255));
        lbl_datos.setText("DATOS STOCK IMPORTACIÓN");
        getContentPane().add(lbl_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        bot_actualizar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        bot_actualizar.setText("ACTUALIZAR");
        bot_actualizar.setEnabled(false);
        bot_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, -1, -1));

        bot_limpiar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eraser.png"))); // NOI18N
        bot_limpiar.setText("REINICIAR");
        bot_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, -1, -1));

        bot_cerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        bot_cerrar.setText("CERRAR");
        bot_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 620, -1, -1));

        table_resumen.setBackground(new java.awt.Color(240, 255, 255));
        table_resumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "C.C", "AREA", "O/C EXCEL", "NRO FACTURA", "NRO GUIA", "FECHA LLEGADA", "SP", "USO EQUIPO", "CODIGOSAP", "DESCRIPCION", "NRO PARTE", "CANTIDAD RECIBIDA", "PRECIO UNITARIO", "MONTO FACTURA", "FLETE ENVIO", "MONTO TOTAL FACTURA", "VALOR DOLAR", "MONTO BS", "MONTO FLETE", "TOTAL GENERAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, true, true, false, true, true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_resumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_resumenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_resumen);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 1350, 210));

        jPanel1.setBackground(new java.awt.Color(240, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        check_fecha.setBackground(new java.awt.Color(240, 255, 255));
        check_fecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        check_fecha.setText("FECHA");
        check_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_fechaActionPerformed(evt);
            }
        });
        jPanel1.add(check_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        check_sap.setBackground(new java.awt.Color(240, 255, 255));
        check_sap.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        check_sap.setText("CÓDIGO SAP");
        check_sap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_sapActionPerformed(evt);
            }
        });
        jPanel1.add(check_sap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        check_descripcion.setBackground(new java.awt.Color(240, 255, 255));
        check_descripcion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        check_descripcion.setText("DESCRIPCIÓN");
        check_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_descripcionActionPerformed(evt);
            }
        });
        jPanel1.add(check_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        check_area.setBackground(new java.awt.Color(240, 255, 255));
        check_area.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        check_area.setText("CENTRO DE COSTO");
        check_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_areaActionPerformed(evt);
            }
        });
        jPanel1.add(check_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        check_equipo.setBackground(new java.awt.Color(240, 255, 255));
        check_equipo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        check_equipo.setText("EQUIPO");
        check_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_equipoActionPerformed(evt);
            }
        });
        jPanel1.add(check_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        date_desde.setBackground(new java.awt.Color(240, 255, 255));
        date_desde.setDateFormatString("d/MM/yyyy");
        date_desde.setEnabled(false);
        date_desde.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(date_desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 160, 30));

        date_hasta.setBackground(new java.awt.Color(240, 255, 255));
        date_hasta.setDateFormatString("d/MM/yyyy");
        date_hasta.setEnabled(false);
        date_hasta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(date_hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 160, 30));

        txt_sap.setBackground(new java.awt.Color(240, 255, 255));
        txt_sap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_sap.setEnabled(false);
        txt_sap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_sapKeyPressed(evt);
            }
        });
        jPanel1.add(txt_sap, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 180, 30));

        txt_descripcion.setBackground(new java.awt.Color(240, 255, 255));
        txt_descripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descripcion.setEnabled(false);
        jPanel1.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 280, 30));

        cmb_centrocosto.setBackground(new java.awt.Color(240, 255, 255));
        cmb_centrocosto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmb_centrocosto.setEnabled(false);
        jPanel1.add(cmb_centrocosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 370, 30));

        lbl_desde.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_desde.setText("Desde");
        jPanel1.add(lbl_desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        lbl_hasta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_hasta.setText("Hasta");
        jPanel1.add(lbl_hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        cmb_equipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmb_equipo.setEnabled(false);
        jPanel1.add(cmb_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 370, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 660, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void check_sapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_sapActionPerformed
        if (check_sap.isSelected()){
            txt_sap.setEnabled(true);
        }
        else{
            txt_sap.setEnabled(false);
            
        }
        
       txt_sap.setText("");
    }//GEN-LAST:event_check_sapActionPerformed

    private void check_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_descripcionActionPerformed
        if (check_descripcion.isSelected()){
            txt_descripcion.setEnabled(true);
        }
        else{
            txt_descripcion.setEnabled(false);
        }
        
        txt_descripcion.setText("");
        
    }//GEN-LAST:event_check_descripcionActionPerformed

    private void check_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_areaActionPerformed
        if (check_area.isSelected()){
             cmb_centrocosto.setEnabled(true);
        }
        else{
            cmb_centrocosto.setEnabled(false);
        }
        
       
    }//GEN-LAST:event_check_areaActionPerformed

    private void check_equipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_equipoActionPerformed
        if (check_equipo.isSelected()){
            cmb_equipo.setEnabled(true);
        }
        else{
            cmb_equipo.setEnabled(false);
        }
        cmb_equipo.setSelectedItem("Seleccione...");
    }//GEN-LAST:event_check_equipoActionPerformed

    private void check_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_fechaActionPerformed
       if (check_fecha.isSelected()){
            date_desde.setEnabled(true);
            date_hasta.setEnabled(true);
        }
        else{
            date_desde.setEnabled(false);
            date_hasta.setEnabled(false);
        }
       
        date_desde.setDate(null);
        date_hasta.setDate(null);
    }//GEN-LAST:event_check_fechaActionPerformed

    private void bot_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_limpiarActionPerformed
        frm_actualizarstockimp frm = new frm_actualizarstockimp();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bot_limpiarActionPerformed

    private void bot_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_cerrarActionPerformed
       this.dispose();
    }//GEN-LAST:event_bot_cerrarActionPerformed

    private void bot_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_buscarActionPerformed
       String sql;
       Integer centrocosto=0;
       String equipo="";
       Boolean autorizado = false;
       String fechadesde="";
       String fechahasta="";
       
       if (txt_sap.getText().trim().equals("")){
           txt_sap.setText("-1");
       }
       else{
           autorizado= true;
       }
       
       if (!cmb_centrocosto.getSelectedItem().equals("Seleccione...")){
           centrocosto = Integer.parseInt(cmb_centrocosto.getSelectedItem().toString().substring(0,6));
           autorizado= true;
       }
       else{
           centrocosto = -1;
       }
       
       if (!cmb_equipo.getSelectedItem().equals("Seleccione...")){
           equipo = cmb_equipo.getSelectedItem().toString().substring(4,cmb_equipo.getSelectedItem().toString().length()).trim();
           autorizado= true;
       }
       else{
           equipo = "";
       }
       
       try{
          fechadesde =  funciones.fecha_convertir_date(date_desde, 1);
          fechahasta =  funciones.fecha_convertir_date(date_hasta, 1);
          autorizado = true;
       }
       catch(NullPointerException ex){
           
       }
       
       if (autorizado){
            stock st = new stock(fechadesde,fechahasta,Integer.parseInt(txt_sap.getText()),txt_descripcion.getText(),centrocosto,equipo,table_resumen);
       
            st.buscarstock(true);
       }
       else{
           JOptionPane.showMessageDialog(null, "SELECCIONAR AL MENOS UNA OPCION PARA LA CONSULTA", "SISTOCK - ACTUALIZAR STOCK IMPORTACION", JOptionPane.INFORMATION_MESSAGE,null);
       }
       
    }//GEN-LAST:event_bot_buscarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       String sql;
        
        sql="SELECT id_centrocosto,centrocosto FROM tbl_centrocosto;"; 
       cmb_centrocosto = funciones.cargar_combo(cmb_centrocosto,sql,"Seleccione...");
        
        sql="SELECT id_equipo,equipo FROM tbl_equipo;"; 
        cmb_equipo = funciones.cargar_combo(cmb_equipo,sql,"Seleccione...");
    }//GEN-LAST:event_formWindowOpened

    private void bot_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_actualizarActionPerformed
       Integer fila;
       
       fila =  table_resumen.getSelectedRow();
      
       stock st = new stock(table_resumen,fila,Integer.parseInt(table_resumen.getValueAt(fila, 0).toString()));
       
       if (st.actualizardetallestock()){
           JOptionPane.showMessageDialog(null, "ACTUALIZACION DE LOS DATOS SATISFACTORIO");
       }
       else{
           JOptionPane.showMessageDialog(null, "ERROR EN ACTUALIZACION DE DATOS");
       }
       
       
       
       
       
    }//GEN-LAST:event_bot_actualizarActionPerformed

    private void table_resumenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_resumenMouseClicked
        bot_actualizar.setEnabled(true);
    }//GEN-LAST:event_table_resumenMouseClicked

    private void txt_sapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sapKeyPressed
        if ( ( (evt.getKeyCode() >= 48 ) && (evt.getKeyCode() <= 57 ) ) || ( (evt.getKeyCode() >= 37 ) && (evt.getKeyCode() <= 40 ) ) || ((evt.getKeyCode() >= 96 ) && (evt.getKeyCode() <= 105 )) || (evt.getKeyCode() == 144) || (evt.getKeyCode() == 127) || (evt.getKeyCode() == 8)  || (evt.getKeyCode() == 10)){       
        }
        else{
            JOptionPane.showMessageDialog(null, "CARACTER NO VALIDO. SOLO NÚMEROS (1..9)", "SISTOCK - CARGA DATOS STOCK IMPORTACION", JOptionPane.ERROR_MESSAGE,null);
            txt_sap.setText("");
             
        }
    }//GEN-LAST:event_txt_sapKeyPressed

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
            java.util.logging.Logger.getLogger(frm_actualizarstockimp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_actualizarstockimp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_actualizarstockimp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_actualizarstockimp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_actualizarstockimp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bot_actualizar;
    private javax.swing.JButton bot_buscar;
    private javax.swing.JButton bot_cerrar;
    private javax.swing.JButton bot_limpiar;
    private javax.swing.JCheckBox check_area;
    private javax.swing.JCheckBox check_descripcion;
    private javax.swing.JCheckBox check_equipo;
    private javax.swing.JCheckBox check_fecha;
    private javax.swing.JCheckBox check_sap;
    private javax.swing.JComboBox cmb_centrocosto;
    private javax.swing.JComboBox<String> cmb_equipo;
    private com.toedter.calendar.JDateChooser date_desde;
    private com.toedter.calendar.JDateChooser date_hasta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_datos;
    private javax.swing.JLabel lbl_desde;
    private javax.swing.JLabel lbl_encabezado;
    private javax.swing.JLabel lbl_hasta;
    private javax.swing.JTable table_resumen;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_sap;
    // End of variables declaration//GEN-END:variables
}
