/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import static java.lang.Math.abs;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ruben
 */
public class frm_salida extends javax.swing.JFrame {

     private Integer entrada;
     private  Integer salida;
     private  Integer disponible;
     
    public frm_salida() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("SISTOCK - DAR SALIDA DE STOCK");
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

        txt_codigosap = new javax.swing.JTextField();
        bot_codigo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_entrada = new javax.swing.JTable();
        lbl_detalle = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        lbl_stockentrada = new javax.swing.JLabel();
        lbl_cantstockentrada = new javax.swing.JLabel();
        bot_salida = new javax.swing.JButton();
        bot_cerrar = new javax.swing.JButton();
        bot_limpiar = new javax.swing.JButton();
        lbl_detallesalida = new javax.swing.JLabel();
        lbl_stocksalida = new javax.swing.JLabel();
        lbl_cantstocksalida = new javax.swing.JLabel();
        lbl_disponible = new javax.swing.JLabel();
        lbl_cantidaddispstock = new javax.swing.JLabel();
        spin_cantidadsalida = new javax.swing.JSpinner();
        lbl_equipo = new javax.swing.JLabel();
        cmb_equipo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_salida = new javax.swing.JTable();
        lbl_centrocosto = new javax.swing.JLabel();
        lbl_descosto = new javax.swing.JLabel();
        lbl_fechasalida = new javax.swing.JLabel();
        date_salida = new com.toedter.calendar.JDateChooser();
        lbl_codigo = new javax.swing.JLabel();
        lbl_tasa = new javax.swing.JLabel();
        lbl_destasa = new javax.swing.JLabel();
        bot_devolverinventario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_codigosap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_codigosap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigosapKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigosapKeyReleased(evt);
            }
        });
        getContentPane().add(txt_codigosap, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 130, -1));

        bot_codigo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_codigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Search.png"))); // NOI18N
        bot_codigo.setText("Buscar");
        bot_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_codigoActionPerformed(evt);
            }
        });
        getContentPane().add(bot_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, -1, -1));

        tabla_entrada.setBackground(new java.awt.Color(240, 255, 255));
        tabla_entrada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabla_entrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_stock", "AREA", "USO EQUIPO", "CODIGO", "DESCRIPCION", "CANT. RECIBIDA", "CANTIDAD USADA", "FECHA LLEGADA", "PRECIO UNITARIO $", "MONTO  ITEM $", "FLETE ITEM $", "MONTO $", "FLETE NAC $", "TOTAL FLETE $", "TOTAL ITEM $", "flete en bs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_entrada);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1250, 110));

        lbl_detalle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_detalle.setForeground(new java.awt.Color(0, 0, 255));
        lbl_detalle.setText("Detalle de Repuesto en Stock");
        getContentPane().add(lbl_detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        lbl_cantidad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_cantidad.setText("Cantidad a dar salida");
        getContentPane().add(lbl_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, -1, -1));

        lbl_stockentrada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_stockentrada.setText("Cantidad Recibida");
        getContentPane().add(lbl_stockentrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        lbl_cantstockentrada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cantstockentrada.setText("0");
        getContentPane().add(lbl_cantstockentrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        bot_salida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/stock.png"))); // NOI18N
        bot_salida.setText("DAR SALIDA");
        bot_salida.setEnabled(false);
        bot_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_salidaActionPerformed(evt);
            }
        });
        getContentPane().add(bot_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, -1, -1));

        bot_cerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        bot_cerrar.setText("CERRAR");
        bot_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 650, -1, -1));

        bot_limpiar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eraser.png"))); // NOI18N
        bot_limpiar.setText("REINICIAR");
        bot_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 650, -1, -1));

        lbl_detallesalida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_detallesalida.setForeground(new java.awt.Color(0, 0, 255));
        lbl_detallesalida.setText("Detalle del Respuesto en Salida");
        getContentPane().add(lbl_detallesalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        lbl_stocksalida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_stocksalida.setText("Cantidad Salida del Respuesto");
        getContentPane().add(lbl_stocksalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        lbl_cantstocksalida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cantstocksalida.setText("0");
        getContentPane().add(lbl_cantstocksalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        lbl_disponible.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_disponible.setForeground(new java.awt.Color(0, 0, 255));
        lbl_disponible.setText("CANTIDAD DISPONIBLE");
        getContentPane().add(lbl_disponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        lbl_cantidaddispstock.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_cantidaddispstock.setForeground(new java.awt.Color(0, 0, 255));
        getContentPane().add(lbl_cantidaddispstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, -1, -1));

        spin_cantidadsalida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spin_cantidadsalida.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(spin_cantidadsalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, 50, -1));

        lbl_equipo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_equipo.setText("Equipo");
        getContentPane().add(lbl_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, -1, -1));

        cmb_equipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmb_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_equipoActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, 180, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("SALIDA DE REPUESTOS DE INVENTARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        tabla_salida.setBackground(new java.awt.Color(240, 255, 255));
        tabla_salida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabla_salida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AREA", "EQUIPO", "CODIGO SAP", "DESCRIPCION", "FECHA SALIDA", "CANTIDAD", "PRECIO UNITARIO $", "MONTO  ITEM $", "FLETE ITEM $", "MONTO $", "FLETE NAC $", "TOTAL FLETE $", "TOTAL ITEM $", "flete en bs", "id_stock", "id_salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_salidaMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_salida);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1250, 110));

        lbl_centrocosto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_centrocosto.setText("Centro de Costo");
        getContentPane().add(lbl_centrocosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, -1, -1));

        lbl_descosto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lbl_descosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 540, -1, -1));

        lbl_fechasalida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_fechasalida.setText("Fecha de Salida");
        getContentPane().add(lbl_fechasalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 580, -1, -1));

        date_salida.setDateFormatString("dd/MM/yyyy");
        date_salida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        date_salida.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_salidaPropertyChange(evt);
            }
        });
        getContentPane().add(date_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 570, 150, 30));

        lbl_codigo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_codigo.setText("Codigo SAP");
        getContentPane().add(lbl_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, -1, -1));

        lbl_tasa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_tasa.setText("TASA EN $");
        getContentPane().add(lbl_tasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 610, -1, -1));

        lbl_destasa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lbl_destasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 610, -1, -1));

        bot_devolverinventario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_devolverinventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/stock.png"))); // NOI18N
        bot_devolverinventario.setText("DEVOLVER A INVENTARIO");
        bot_devolverinventario.setEnabled(false);
        bot_devolverinventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_devolverinventarioActionPerformed(evt);
            }
        });
        getContentPane().add(bot_devolverinventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bot_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_codigoActionPerformed
        String sql;
      
       
       if (!txt_codigosap.getText().trim().equals("")){

            
            stock st = new stock(Integer.parseInt(txt_codigosap.getText().trim()),tabla_entrada,tabla_salida);
       
            entrada = st.buscarstockstatusentrada();
            salida = st.buscarstockstatussalida();
            
            if(entrada.equals(0)){
                 JOptionPane.showMessageDialog(null, "NO HAY DATOS EN LA BASE DE DATOS CON EL CODIGO SAP, O NO SE HA FIJADO TASA EN $ PARA EL MES " + txt_codigosap.getText().trim());
                 lbl_cantstockentrada.setText("0");
                 lbl_cantstocksalida.setText("0");
                 lbl_cantidaddispstock.setText("0");
                 disponible = 0;
            }    
            else{
                lbl_cantstockentrada.setText(entrada.toString());
                if(salida.equals(0)){
                    lbl_cantstocksalida.setText("0");
                    lbl_cantidaddispstock.setText(entrada.toString());
                    disponible = entrada;
                }
                else{
                    disponible = abs(entrada - salida);
                    lbl_cantstocksalida.setText(salida.toString());
                    lbl_cantidaddispstock.setText(disponible.toString());
                    lbl_cantidaddispstock.setText(String.valueOf(disponible));
                }
            }
       }
       else{
           JOptionPane.showMessageDialog(null,"FAVOR INTRODUCIR CODIGO SAP");
       }
    }//GEN-LAST:event_bot_codigoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         String sql;
        
        sql="SELECT id_equipo,equipo FROM tbl_equipo;"; 
       cmb_equipo = funciones.cargar_combo(cmb_equipo,sql,"Seleccione...");
       
       spin_cantidadsalida.setValue(1);
       txt_codigosap.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void bot_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bot_cerrarActionPerformed

    private void bot_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_salidaActionPerformed
      
        String fechasalida = "";
        boolean autorizado = true;
        Integer valortasa;
        Integer confirmar = 0;
        
        try{
            fechasalida = funciones.fecha_convertir_date(date_salida,1);
            
            if (!fechasalida.equals("")){
                tasa tas = new tasa(0,0,0,fechasalida,"",0,"");
                valortasa = tas.consultar_tasa();
                        
                if (!valortasa.equals(0)){
                    if(!funciones.verificar_mes_autorizacion(0,0, funciones.fecha_convertir_date(date_salida, 2))){
                        JOptionPane.showMessageDialog(null, "EL MES DE " + funciones.descripcion_mes(String.valueOf(Integer.parseInt(funciones.fecha_convertir_date(date_salida, 1).substring(5, 7)))) + " ESTA CERRADO CONTABLEMENTE");            
                        autorizado = false;
                    }
                }
                else{
                    autorizado = false;
                }
            } 
            else{
                autorizado = false;
            }
                
        }
        catch(NullPointerException | SQLException ex){
            fechasalida = "";
            autorizado = false;
        }
       
        if (disponible >= Integer.parseInt(spin_cantidadsalida.getValue().toString()) ){
            if (!cmb_equipo.getSelectedItem().equals("Seleccione...") && !fechasalida.equals("")){
                
                stock st = new stock(Integer.parseInt(txt_codigosap.getText().trim()),Integer.parseInt(cmb_equipo.getSelectedItem().toString().substring(0, 3).trim()),Integer.parseInt(lbl_descosto.getText().substring(0, 6).trim()),Integer.parseInt(spin_cantidadsalida.getValue().toString()),tabla_entrada,tabla_salida,funciones.fecha_convertir_date(date_salida,1));
                
                if (autorizado){
                    confirmar = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DAR SALIDA AL CODIGO SAP " + txt_codigosap.getText().trim() + " POR LA CANTIDAD DE " + spin_cantidadsalida.getValue().toString() + " ASIGNADO AL EQUIPO " + cmb_equipo.getSelectedItem().toString().substring(5, cmb_equipo.getSelectedItem().toString().length()).trim());
                    
                    if (confirmar.equals(0)){
                        if(st.actualizar_stock_salida()){
                    
                            st = new stock(Integer.parseInt(txt_codigosap.getText().trim()),tabla_entrada,tabla_salida);
                            entrada = st.buscarstockstatusentrada();
                            salida = st.buscarstockstatussalida();
                            lbl_cantstocksalida.setText(salida.toString());
                            disponible = abs(entrada - salida);
                            lbl_cantidaddispstock.setText(disponible.toString());
                            JOptionPane.showMessageDialog(null, "SE ACTUALIZO EL STOCK DEL REPUESTO CODIGO SAP " + txt_codigosap.getText().trim());
                        }
                    }    
                }
                else{
                    JOptionPane.showMessageDialog(null, "FALTAN DATOS EN COMPLETAR PARA LA SALIDA DE STOCK DEL CODIGO " + txt_codigosap.getText().trim());
                
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "FALTAN DATOS EN COMPLETAR PARA LA SALIDA DE STOCK DEL CODIGO " + txt_codigosap.getText().trim());
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "LA CANTIDAD SOLICITADA DE SALIDA ES SUPERIOR AL DISPONIBLE REGISTRADO EN STOCK. EL DISPONIBLE PARA EL REPUESTO ES " + disponible );
        }
         
    }//GEN-LAST:event_bot_salidaActionPerformed

    private void cmb_equipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_equipoActionPerformed
       try{
            if(evt.getModifiers() != 0){
                if (!cmb_equipo.getSelectedItem().equals("Seleccione...")){
                    equipo eq = new equipo(Integer.parseInt(cmb_equipo.getSelectedItem().toString().substring(0, 3).trim()),5);
            
                    if(eq.buscar_cc_equipo()){
                        lbl_descosto.setText(eq.getId_centrocosto() + " - " + eq.getDescripcion_centrocosto());
                    }
                    
                } 
                else{
                    lbl_descosto.setText("");
                }
            }
        }
        catch(NullPointerException ex){}
    }//GEN-LAST:event_cmb_equipoActionPerformed

    private void date_salidaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_salidaPropertyChange
        String fechasalida;
        Integer valortasa=0;
        
        fechasalida = funciones.fecha_convertir_date(date_salida,1);
            
        if (!fechasalida.equals("")){
            tasa tas = new tasa(0,0,0,fechasalida,"",0,"");
            try {
                valortasa = tas.consultar_tasa();
            } catch (SQLException ex) {
                Logger.getLogger(frm_salida.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!valortasa.equals(0)){
                lbl_destasa.setText(valortasa.toString());
                bot_salida.setEnabled(true);
            }
            else{
                lbl_destasa.setText("SIN TASA EN $ FIJADA");
                bot_salida.setEnabled(false);
            }
        }    
        else{
            lbl_destasa.setText("");
            
        }
    }//GEN-LAST:event_date_salidaPropertyChange

    private void bot_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_limpiarActionPerformed
        frm_salida frm = new frm_salida();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bot_limpiarActionPerformed

    private void bot_devolverinventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_devolverinventarioActionPerformed
      Integer fila;
      Integer id_stock;
      Integer id_salida;
      Integer cantidad_usada;       
      
      fila = tabla_salida.getSelectedRow();
      id_stock = Integer.parseInt(tabla_salida.getValueAt(fila, 14).toString());
      id_salida = Integer.parseInt(tabla_salida.getValueAt(fila, 15).toString());
      cantidad_usada = Integer.parseInt(tabla_salida.getValueAt(fila, 5).toString());
        
      stock st = new stock(id_stock,id_salida,cantidad_usada);
      
      if(st.devolver_a_entrada_stock()){
          JOptionPane.showMessageDialog(null, "SE REALIZO LA TRANSACCION SATISFACTORIAMENTE");
          bot_codigo.doClick();
      }
        
    }//GEN-LAST:event_bot_devolverinventarioActionPerformed

    private void tabla_salidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_salidaMousePressed
        bot_devolverinventario.setEnabled(true);
    }//GEN-LAST:event_tabla_salidaMousePressed

    private void txt_codigosapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigosapKeyPressed
        if (evt.getKeyCode()==10){
            bot_codigo.doClick();
        }
        
        if ( ( (evt.getKeyCode() >= 48 ) && (evt.getKeyCode() <= 57 ) ) || ( (evt.getKeyCode() >= 37 ) && (evt.getKeyCode() <= 40 ) ) || ((evt.getKeyCode() >= 96 ) && (evt.getKeyCode() <= 105 )) || (evt.getKeyCode() == 144) || (evt.getKeyCode() == 127) || (evt.getKeyCode() == 8)  || (evt.getKeyCode() == 10)){       
        }
        else{
            JOptionPane.showMessageDialog(null, "CARACTER NO VALIDO. SOLO NÚMEROS (1..9)", "SISTOCK - SALIDA DE REPUESTO", JOptionPane.ERROR_MESSAGE,null);
            txt_codigosap.setText("");
             
        }
    }//GEN-LAST:event_txt_codigosapKeyPressed

    private void txt_codigosapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigosapKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigosapKeyReleased

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
            java.util.logging.Logger.getLogger(frm_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_salida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_salida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bot_cerrar;
    private javax.swing.JButton bot_codigo;
    private javax.swing.JButton bot_devolverinventario;
    private javax.swing.JButton bot_limpiar;
    private javax.swing.JButton bot_salida;
    private javax.swing.JComboBox cmb_equipo;
    private com.toedter.calendar.JDateChooser date_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_cantidaddispstock;
    private javax.swing.JLabel lbl_cantstockentrada;
    private javax.swing.JLabel lbl_cantstocksalida;
    private javax.swing.JLabel lbl_centrocosto;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_descosto;
    private javax.swing.JLabel lbl_destasa;
    private javax.swing.JLabel lbl_detalle;
    private javax.swing.JLabel lbl_detallesalida;
    private javax.swing.JLabel lbl_disponible;
    private javax.swing.JLabel lbl_equipo;
    private javax.swing.JLabel lbl_fechasalida;
    private javax.swing.JLabel lbl_stockentrada;
    private javax.swing.JLabel lbl_stocksalida;
    private javax.swing.JLabel lbl_tasa;
    private javax.swing.JSpinner spin_cantidadsalida;
    private javax.swing.JTable tabla_entrada;
    private javax.swing.JTable tabla_salida;
    private javax.swing.JTextField txt_codigosap;
    // End of variables declaration//GEN-END:variables
}