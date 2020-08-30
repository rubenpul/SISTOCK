/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ruben
 */
public class frm_actualizarstatuspkf extends javax.swing.JFrame {

    /**
     * Creates new form frm_actualizarstatuspkf
     */
    public frm_actualizarstatuspkf() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("SISTOCK - ACTUALIZAR ESTATUS SOLICITUDES");
        txt_idservicio.requestFocusInWindow();
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
        lbl_idservicio = new javax.swing.JLabel();
        txt_idservicio = new javax.swing.JTextField();
        bot_buscar = new javax.swing.JButton();
        panel_estatus = new javax.swing.JPanel();
        lbl_cedulasolicitante = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        lbl_nombres = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        lbl_equipo = new javax.swing.JLabel();
        txt_centrocosto = new javax.swing.JTextField();
        lbl_componente = new javax.swing.JLabel();
        txt_componente = new javax.swing.JTextField();
        txt_servicio = new javax.swing.JTextField();
        lbl_servicio = new javax.swing.JLabel();
        lbl_observaciones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_observaciones = new javax.swing.JTextArea();
        lbl_fallapresentada = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_falla = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txt_fechasolicitud = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        panel_servrealizado = new javax.swing.JPanel();
        lbl_serviciopkf = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        area_serviciopkf = new javax.swing.JTextArea();
        lbl_realizado = new javax.swing.JLabel();
        txt_realizado = new javax.swing.JTextField();
        lbl_costototal = new javax.swing.JLabel();
        txt_costototal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl_cedulaentrega = new javax.swing.JLabel();
        txt_empresa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_nombrentregado = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        area_observacionentregado = new javax.swing.JTextArea();
        lbl_observacionservicio = new javax.swing.JLabel();
        lbl_fechaservicio = new javax.swing.JLabel();
        date_servicio = new com.toedter.calendar.JDateChooser();
        lbl_costohoras = new javax.swing.JLabel();
        txt_costohoras = new javax.swing.JTextField();
        lbl_estatus = new javax.swing.JLabel();
        cmb_estatus = new javax.swing.JComboBox<>();
        bot_guardar = new javax.swing.JButton();
        bot_imprimir = new javax.swing.JButton();
        bot_limpiar = new javax.swing.JButton();
        bot_cerrar = new javax.swing.JButton();
        bot_actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_encabezado.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_encabezado.setForeground(new java.awt.Color(0, 0, 255));
        lbl_encabezado.setText("ACTUALIZAR ESTATUS SERVICIOS PKF ");
        getContentPane().add(lbl_encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        lbl_idservicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_idservicio.setText("NRO SERVICIO");
        getContentPane().add(lbl_idservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_idservicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_idservicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idservicioKeyPressed(evt);
            }
        });
        getContentPane().add(txt_idservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 130, -1));

        bot_buscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bot_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Search.png"))); // NOI18N
        bot_buscar.setText("BUSCAR");
        bot_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        panel_estatus.setBackground(new java.awt.Color(240, 255, 255));
        panel_estatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_estatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cedulasolicitante.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_cedulasolicitante.setText("CEDULA SOLICITANTE");
        panel_estatus.add(lbl_cedulasolicitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txt_cedula.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_cedula.setEnabled(false);
        panel_estatus.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 130, -1));

        lbl_nombres.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_nombres.setText("NOMBRES");
        panel_estatus.add(lbl_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txt_nombres.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nombres.setEnabled(false);
        txt_nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombresActionPerformed(evt);
            }
        });
        panel_estatus.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 270, -1));

        lbl_equipo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_equipo.setText("CENTRO DE COSTO");
        panel_estatus.add(lbl_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txt_centrocosto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_centrocosto.setEnabled(false);
        panel_estatus.add(txt_centrocosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 270, -1));

        lbl_componente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_componente.setText("COMPONENTE");
        panel_estatus.add(lbl_componente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txt_componente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_componente.setEnabled(false);
        panel_estatus.add(txt_componente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 270, -1));

        txt_servicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_servicio.setEnabled(false);
        panel_estatus.add(txt_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 270, -1));

        lbl_servicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_servicio.setText("SERVICIO SOLICITADO");
        panel_estatus.add(lbl_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        lbl_observaciones.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_observaciones.setText("OBSERVACIONES AL TALLER");
        panel_estatus.add(lbl_observaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        area_observaciones.setColumns(20);
        area_observaciones.setRows(5);
        area_observaciones.setEnabled(false);
        jScrollPane2.setViewportView(area_observaciones);

        panel_estatus.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 320, -1));

        lbl_fallapresentada.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_fallapresentada.setText("FALLA PRESENTADA");
        panel_estatus.add(lbl_fallapresentada, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, 20));

        area_falla.setColumns(20);
        area_falla.setRows(5);
        area_falla.setEnabled(false);
        jScrollPane1.setViewportView(area_falla);

        panel_estatus.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 320, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("REGISTRO AL TALLER");
        panel_estatus.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        txt_fechasolicitud.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_fechasolicitud.setEnabled(false);
        panel_estatus.add(txt_fechasolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("FECHA SOLICITUD");
        panel_estatus.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        getContentPane().add(panel_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 680, 470));

        panel_servrealizado.setBackground(new java.awt.Color(240, 255, 255));
        panel_servrealizado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_servrealizado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_serviciopkf.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_serviciopkf.setText("SERVICIO PKF");
        panel_servrealizado.add(lbl_serviciopkf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        area_serviciopkf.setColumns(20);
        area_serviciopkf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        area_serviciopkf.setRows(5);
        area_serviciopkf.setEnabled(false);
        jScrollPane3.setViewportView(area_serviciopkf);

        panel_servrealizado.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 260, -1));

        lbl_realizado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_realizado.setText("REALIZADO POR");
        panel_servrealizado.add(lbl_realizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        txt_realizado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_realizado.setEnabled(false);
        panel_servrealizado.add(txt_realizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 260, -1));

        lbl_costototal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_costototal.setText("COSTO TOTAL (Bs)");
        panel_servrealizado.add(lbl_costototal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_costototal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_costototal.setEnabled(false);
        txt_costototal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_costototalKeyPressed(evt);
            }
        });
        panel_servrealizado.add(txt_costototal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 190, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("SERVICIO REALIZADO");
        panel_servrealizado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        lbl_cedulaentrega.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_cedulaentrega.setText("EMPRESA");
        panel_servrealizado.add(lbl_cedulaentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txt_empresa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_empresa.setEnabled(false);
        panel_servrealizado.add(txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 160, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("NOMBRES");
        panel_servrealizado.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txt_nombrentregado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nombrentregado.setEnabled(false);
        panel_servrealizado.add(txt_nombrentregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 260, -1));

        area_observacionentregado.setColumns(20);
        area_observacionentregado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        area_observacionentregado.setRows(5);
        area_observacionentregado.setEnabled(false);
        jScrollPane4.setViewportView(area_observacionentregado);

        panel_servrealizado.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 260, 110));

        lbl_observacionservicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_observacionservicio.setText("OBSERVACIONES");
        panel_servrealizado.add(lbl_observacionservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        lbl_fechaservicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_fechaservicio.setText("FECHA SERVICIO");
        panel_servrealizado.add(lbl_fechaservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        date_servicio.setDateFormatString("dd/MM/yyyy");
        date_servicio.setEnabled(false);
        date_servicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        panel_servrealizado.add(date_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 170, 30));

        lbl_costohoras.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_costohoras.setText("COSTO HORA (Bs)");
        panel_servrealizado.add(lbl_costohoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txt_costohoras.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_costohoras.setEnabled(false);
        txt_costohoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_costohorasKeyPressed(evt);
            }
        });
        panel_servrealizado.add(txt_costohoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 190, -1));

        getContentPane().add(panel_servrealizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 490, 490));

        lbl_estatus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_estatus.setText("ESTATUS");
        getContentPane().add(lbl_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, -1, -1));

        cmb_estatus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "EJECUTADO" }));
        cmb_estatus.setEnabled(false);
        cmb_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_estatusActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 180, -1));

        bot_guardar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/databasesave.png"))); // NOI18N
        bot_guardar.setText("GUARDAR");
        bot_guardar.setEnabled(false);
        bot_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, -1, -1));

        bot_imprimir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/print.png"))); // NOI18N
        bot_imprimir.setText("IMPRIMIR");
        bot_imprimir.setEnabled(false);
        bot_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(bot_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 620, -1, -1));

        bot_limpiar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eraser.png"))); // NOI18N
        bot_limpiar.setText("REINICIAR");
        bot_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, -1, -1));

        bot_cerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        bot_cerrar.setText("CERRAR");
        bot_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 620, -1, -1));

        bot_actualizar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bot_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        bot_actualizar.setText("ACTUALIZAR");
        bot_actualizar.setEnabled(false);
        bot_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(bot_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 620, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombresActionPerformed

    private void bot_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_buscarActionPerformed
        
        Calendar cal = Calendar.getInstance();
        
        if(!txt_idservicio.getText().trim().equals("")){
            
            taller ta = new taller(Integer.parseInt(txt_idservicio.getText().trim()),5);
            
            if(ta.buscaridservicio()){
                
                txt_cedula.setText(ta.getCedula().toString());
                txt_nombres.setText(ta.getNombre());
                txt_centrocosto.setText(ta.getCentrocosto());
                txt_componente.setText(ta.getComponente());
                txt_servicio.setText(ta.getServicio());
                txt_fechasolicitud.setText(funciones.fecha_bd_usuario(ta.getFechasolicitud(),1));
                area_observaciones.setText(ta.getObservaciones());
                area_falla.setText(ta.getFalla());
                cmb_estatus.setSelectedItem(ta.getEstatus());
                
                if(!ta.getEstatus().equals("PENDIENTE")){
                    area_serviciopkf.setText(ta.getServiciopkf());
                    txt_realizado.setText(ta.getRealizadopor());
                    txt_costototal.setText(ta.getCostoservicio().toString());
                    txt_costohoras.setText(ta.getCostohoraservicio().toString());
                    txt_empresa.setText(ta.getEmpresa());
                    txt_nombrentregado.setText(ta.getNombre_entregado());
                    area_observacionentregado.setText(ta.getObservacion_entregado());
                     
                    try {
                        cal.set(Integer.parseInt(ta.getFechaservicio().substring(0, 4)),Integer.parseInt(ta.getFechaservicio().substring(5, 7))-1,Integer.parseInt(ta.getFechaservicio().substring(8,10)));
                        date_servicio.setCalendar(cal);
                    }catch(NullPointerException ex){
                        date_servicio.setDate(null);
                    }

                    //txt_fechaservicio.setText(funciones.fecha_bd_usuario(ta.getFechaservicio(),1));
                    bot_guardar.setEnabled(false);
                    bot_actualizar.setEnabled(true);
                    bot_imprimir.setEnabled(true);
                    
                    if(funciones.verificar_mes_autorizacion(0,0, funciones.fecha_convertir_date(date_servicio, 2))){
                        area_serviciopkf.setEnabled(true);
                        txt_realizado.setEnabled(true);
                        txt_costototal.setEnabled(true);
                        txt_costohoras.setEnabled(true);
                        bot_guardar.setEnabled(false);
                        txt_empresa.setEnabled(true);
                        txt_nombrentregado.setEnabled(true);
                        area_observacionentregado.setEnabled(true);
                        date_servicio.setEnabled(true);
                    }
                    else{
                        area_serviciopkf.setEnabled(false);
                        txt_realizado.setEnabled(false);
                        txt_costototal.setEnabled(false);
                        txt_costohoras.setEnabled(false);
                        bot_guardar.setEnabled(false);
                        txt_empresa.setEnabled(false);
                        txt_nombrentregado.setEnabled(false);
                        area_observacionentregado.setEnabled(false);
                        date_servicio.setEnabled(false);
                        bot_actualizar.setEnabled(false);
                    }
                    
                }
                else{
                   cmb_estatus.setEnabled(true);
                   bot_actualizar.setEnabled(false);
                   bot_imprimir.setEnabled(false);
                   
                   area_serviciopkf.setText("");
                    txt_realizado.setText("");
                    txt_costototal.setText("");
                    txt_costohoras.setText("");
                    txt_empresa.setText("");
                    txt_nombrentregado.setText("");
                    area_observacionentregado.setText("");
                    date_servicio.setDate(null);
                }
            }
            else{
                 JOptionPane.showMessageDialog(null,"NO HAY DATOS CON EL NUMERO DE SERVICIO");
            }
        }
    }//GEN-LAST:event_bot_buscarActionPerformed

    private void cmb_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_estatusActionPerformed
        if(evt.getModifiers() != 0){
           if (cmb_estatus.getSelectedItem().equals("EJECUTADO")){
               area_serviciopkf.setEnabled(true);
               txt_realizado.setEnabled(true);
               txt_costototal.setEnabled(true);
               txt_costohoras.setEnabled(true);
               bot_guardar.setEnabled(true);
               txt_empresa.setEnabled(true);
               txt_nombrentregado.setEnabled(true);
               area_observacionentregado.setEnabled(true);
           }
           else{
               area_serviciopkf.setText("");
               txt_realizado.setText("");
               txt_costototal.setText("");
               txt_costohoras.setText("");
               
               area_serviciopkf.setEnabled(false);
               txt_realizado.setEnabled(false);
               txt_costototal.setEnabled(false);
               txt_costohoras.setEnabled(false);
           }
           
        }
    }//GEN-LAST:event_cmb_estatusActionPerformed

    private void bot_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_guardarActionPerformed
       
       Integer resp; 
       String fechasolicitud;
       
       
       fechasolicitud = funciones.fecha_convertir_date(date_servicio, 1);
       
       if (!fechasolicitud.equals("")){
            if(funciones.verificar_mes_autorizacion(0,0, funciones.fecha_convertir_date(date_servicio, 2))){        
      
                if (cmb_estatus.getSelectedItem().equals("EJECUTADO")){
                    if (!area_serviciopkf.getText().trim().equals("") &&
                        !txt_costototal.getText().trim().equals("") &&
                        !txt_costohoras.getText().trim().equals("") &&
                        !txt_empresa.getText().trim().equals("") &&
                        !fechasolicitud.equals("")){
            
                        taller ta = new taller(Integer.parseInt(txt_idservicio.getText().trim()),6,
                                    Double.parseDouble(txt_costototal.getText()),
                                    Double.parseDouble(txt_costohoras.getText()),    
                                    txt_realizado.getText().trim().toUpperCase(),
                                    area_serviciopkf.getText().trim().toUpperCase(),
                                    fechasolicitud,
                                    cmb_estatus.getSelectedItem().toString(),
                                    txt_empresa.getText().trim(),
                                    txt_nombrentregado.getText().trim().toUpperCase(),
                                    area_observacionentregado.getText().trim().toUpperCase());
            
                        if(ta.actualizar_registrotaller()){
                            if (!txt_idservicio.getText().trim().equals("")){ 
                                taller ta2 = new taller(Integer.parseInt(txt_idservicio.getText().trim()));
                
                                try {
                                    resp = JOptionPane.showConfirmDialog(null, "DESEA IMPRIMIR LA SOLICITUD");
                                    if (resp.equals(0)){
                                        ta2.generar_solicitudejecutadopkf();
                                    }    
                                    bot_guardar.setEnabled(false);
                                    bot_actualizar.setEnabled(true);
                                    bot_limpiar.setEnabled(true);
                                } 
                                catch (DocumentException | IOException ex) {
                                    Logger.getLogger(frm_registropkf.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }              
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"DATOS INCOMPLETOS PARA GUARDAR");
                        }    
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"DATOS INCOMPLETOS PARA GUARDAR");
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "EL MES DE " + funciones.descripcion_mes(String.valueOf(Integer.parseInt(funciones.fecha_convertir_date(date_servicio, 1).substring(5, 7)))) + " ESTA CERRADO CONTABLEMENTE");
            }
        } 
        else{
            JOptionPane.showMessageDialog(null,"DATOS INCOMPLETOS PARA GUARDAR");
        }              
    }//GEN-LAST:event_bot_guardarActionPerformed

    private void bot_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_actualizarActionPerformed
       
       Integer resp; 
       String fechasolicitud;
       
        
            fechasolicitud = funciones.fecha_convertir_date(date_servicio, 1);
       
       if(!fechasolicitud.equals("")){
           
       
       if(funciones.verificar_mes_autorizacion(0,0, funciones.fecha_convertir_date(date_servicio, 2))){
                    
        
       if (cmb_estatus.getSelectedItem().equals("EJECUTADO")){
            if (!area_serviciopkf.getText().trim().equals("") &&
                !txt_costototal.getText().trim().equals("") &&
                !txt_costohoras.getText().trim().equals("") &&    
                !txt_empresa.getText().trim().equals("") &&
                !txt_nombrentregado.getText().trim().equals("")){
            
                taller ta = new taller(Integer.parseInt(txt_idservicio.getText().trim()),6,
                                    Double.parseDouble(txt_costototal.getText()),
                                    Double.parseDouble(txt_costohoras.getText()),
                                    txt_realizado.getText().trim().toUpperCase(),
                                    area_serviciopkf.getText().trim().toUpperCase(),
                                    fechasolicitud,
                                    cmb_estatus.getSelectedItem().toString(),
                                    txt_empresa.getText().trim(),
                                    txt_nombrentregado.getText().trim().toUpperCase(),
                                    area_observacionentregado.getText().trim().toUpperCase());
            
            
            
               
                ta.actualizar_registrotaller();
                
            }
            if (!txt_idservicio.getText().trim().equals("")){ 
                taller ta2 = new taller(Integer.parseInt(txt_idservicio.getText().trim()));
                
                try {
                    resp = JOptionPane.showConfirmDialog(null, "DESEA IMPRIMIR LA SOLICITUD");
                    if (resp.equals(0)){
                        ta2.generar_solicitudejecutadopkf();
                    }    
                    bot_guardar.setEnabled(false);
                    bot_actualizar.setEnabled(true);
                    bot_limpiar.setEnabled(true);
                } catch (DocumentException | IOException ex) {
                    Logger.getLogger(frm_registropkf.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
             }
        }
        else{
            JOptionPane.showMessageDialog(null,"DATOS INCOMPLETOS PARA GUARDAR");
        }
       }
        else{
                JOptionPane.showMessageDialog(null, "EL MES DE " + funciones.descripcion_mes(String.valueOf(Integer.parseInt(funciones.fecha_convertir_date(date_servicio, 1).substring(5, 7)))) + " ESTA CERRADO CONTABLEMENTE");
        }
    } 
    else{
            JOptionPane.showMessageDialog(null,"DATOS INCOMPLETOS PARA GUARDAR");
    }         
 
    }//GEN-LAST:event_bot_actualizarActionPerformed

    private void bot_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_limpiarActionPerformed
        frm_actualizarstatuspkf frm = new frm_actualizarstatuspkf();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bot_limpiarActionPerformed

    private void bot_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bot_cerrarActionPerformed

    private void txt_idservicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idservicioKeyPressed
        if (evt.getKeyCode()==10){
            bot_buscar.doClick();
        }
        
        if ( ( (evt.getKeyCode() >= 48 ) && (evt.getKeyCode() <= 57 ) ) || ( (evt.getKeyCode() >= 37 ) && (evt.getKeyCode() <= 40 ) ) || ((evt.getKeyCode() >= 96 ) && (evt.getKeyCode() <= 105 )) || (evt.getKeyCode() == 144) || (evt.getKeyCode() == 127) || (evt.getKeyCode() == 8)  || (evt.getKeyCode() == 10)){       
        }
        else{
             if (evt.getKeyCode() == 27){
         
                    bot_limpiar.doClick();
                    
             }
             else{
                JOptionPane.showMessageDialog(null, "CARACTER NO VALIDO. SOLO NÚMEROS (1..9)", "SISTOCK - USUARIO", JOptionPane.ERROR_MESSAGE,null);
                txt_idservicio.setText("");
             }   
        }

    }//GEN-LAST:event_txt_idservicioKeyPressed

    private void bot_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_imprimirActionPerformed
       bot_actualizar.doClick();
    }//GEN-LAST:event_bot_imprimirActionPerformed

    private void txt_costototalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costototalKeyPressed
       if ( ( (evt.getKeyCode() >= 48 ) && (evt.getKeyCode() <= 57 ) ) || ( (evt.getKeyCode() >= 37 ) && (evt.getKeyCode() <= 40 ) ) || ((evt.getKeyCode() >= 96 ) && (evt.getKeyCode() <= 105 )) || (evt.getKeyCode() == 144) || (evt.getKeyCode() == 127) || (evt.getKeyCode() == 8)  || (evt.getKeyCode() == 10)){       
        }
        else{
            JOptionPane.showMessageDialog(null, "CARACTER NO VALIDO. SOLO NÚMEROS (1..9)", "SISTOCK - SERVICIOS PKF", JOptionPane.ERROR_MESSAGE,null);
            txt_costototal.setText("");
             
        }
    }//GEN-LAST:event_txt_costototalKeyPressed

    private void txt_costohorasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costohorasKeyPressed
        if ( ( (evt.getKeyCode() >= 48 ) && (evt.getKeyCode() <= 57 ) ) || ( (evt.getKeyCode() >= 37 ) && (evt.getKeyCode() <= 40 ) ) || ((evt.getKeyCode() >= 96 ) && (evt.getKeyCode() <= 105 )) || (evt.getKeyCode() == 144) || (evt.getKeyCode() == 127) || (evt.getKeyCode() == 8)  || (evt.getKeyCode() == 10)){       
        }
        else{
            JOptionPane.showMessageDialog(null, "CARACTER NO VALIDO. SOLO NÚMEROS (1..9)", "SISTOCK - SERVICIOS PKF", JOptionPane.ERROR_MESSAGE,null);
            txt_costohoras.setText("");
             
        }
    }//GEN-LAST:event_txt_costohorasKeyPressed

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
            java.util.logging.Logger.getLogger(frm_actualizarstatuspkf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_actualizarstatuspkf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_actualizarstatuspkf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_actualizarstatuspkf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_actualizarstatuspkf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_falla;
    private javax.swing.JTextArea area_observacionentregado;
    private javax.swing.JTextArea area_observaciones;
    private javax.swing.JTextArea area_serviciopkf;
    private javax.swing.JButton bot_actualizar;
    private javax.swing.JButton bot_buscar;
    private javax.swing.JButton bot_cerrar;
    private javax.swing.JButton bot_guardar;
    private javax.swing.JButton bot_imprimir;
    private javax.swing.JButton bot_limpiar;
    private javax.swing.JComboBox<String> cmb_estatus;
    private com.toedter.calendar.JDateChooser date_servicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_cedulaentrega;
    private javax.swing.JLabel lbl_cedulasolicitante;
    private javax.swing.JLabel lbl_componente;
    private javax.swing.JLabel lbl_costohoras;
    private javax.swing.JLabel lbl_costototal;
    private javax.swing.JLabel lbl_encabezado;
    private javax.swing.JLabel lbl_equipo;
    private javax.swing.JLabel lbl_estatus;
    private javax.swing.JLabel lbl_fallapresentada;
    private javax.swing.JLabel lbl_fechaservicio;
    private javax.swing.JLabel lbl_idservicio;
    private javax.swing.JLabel lbl_nombres;
    private javax.swing.JLabel lbl_observaciones;
    private javax.swing.JLabel lbl_observacionservicio;
    private javax.swing.JLabel lbl_realizado;
    private javax.swing.JLabel lbl_servicio;
    private javax.swing.JLabel lbl_serviciopkf;
    private javax.swing.JPanel panel_estatus;
    private javax.swing.JPanel panel_servrealizado;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_centrocosto;
    private javax.swing.JTextField txt_componente;
    private javax.swing.JTextField txt_costohoras;
    private javax.swing.JTextField txt_costototal;
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_fechasolicitud;
    private javax.swing.JTextField txt_idservicio;
    private javax.swing.JTextField txt_nombrentregado;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_realizado;
    private javax.swing.JTextField txt_servicio;
    // End of variables declaration//GEN-END:variables
}