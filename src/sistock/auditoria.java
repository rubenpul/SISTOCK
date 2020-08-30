/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruben
 */
public class auditoria {
    
    JTable tabla;
    
    public auditoria(JTable tabla){
        this.tabla = tabla;
    }
    
    public void log_stock_tallerpkf(){
        String sql;
        
        DefaultTableModel modelotabla = (DefaultTableModel) tabla.getModel();

        
        sql = "SELECT a.id_bitacora, a.transaccion, a.usuario, a.fecha_transaccion, a.id_solicitud, a.cedula, a.nombres, b.equipo, c.centrocosto, ";
	sql += "a.componente, a.falla, d.descripcion, a.observaciones, a.fecha_solicitud, a.servicio_pkf, a.realizadopor, a.costo_total, ";
        sql += "a.fecha_servicio, a.estatus, a.empresa_entregado, a.nombre_entregado, a.observacion_entregado ";

        sql += "FROM tbl_bitacora_tallerpkf a ";
        sql += "INNER JOIN tbl_equipo b ON ";
        sql += "b.id_equipo = a.id_equipo ";
        sql += "INNER JOIN tbl_centrocosto c ON ";
        sql += "b.fk_centrocosto = c.id_centrocosto ";
        sql += "INNER JOIN tbl_servicio d ON ";
        sql += "a.id_servicio = d.id_servicio ";
        
       
        conexion cnn = new conexion(sql,"buscar");
      
       if (cnn.estado){
             try{
                while(cnn.rs.next()){
                        modelotabla.addRow(new Object[]{
                        cnn.rs.getInt(1),
                        cnn.rs.getString(2),
                        cnn.rs.getString(3),
                        cnn.rs.getString(4),
                        cnn.rs.getInt(5),
                        cnn.rs.getInt(6),
                        cnn.rs.getString(7),
                        cnn.rs.getString(8),
                        cnn.rs.getString(9),
                        cnn.rs.getString(10),
                        cnn.rs.getString(11),
                        cnn.rs.getString(12),
                        cnn.rs.getString(13),
                        cnn.rs.getDate(14),
                        cnn.rs.getString(15),
                        cnn.rs.getString(16),
                        cnn.rs.getDouble(17),
                        cnn.rs.getDate(18),
                        cnn.rs.getString(19),
                        cnn.rs.getString(20),
                        cnn.rs.getString(21),
                        cnn.rs.getString(22)
                        });  
                }
                                      
                cnn.cerrar(); 
                   
               
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
             }

        }
        else{
        }
               
       cnn.cerrar();
   
    
        
        
    }
    
    public void log_stock_salida(){
        String sql;
        
        DefaultTableModel modelotabla = (DefaultTableModel) tabla.getModel();

        
        sql = "SELECT id_bitacora, transaccion, fecha_transaccion, usuario, sap, c.centrocosto, b.equipo, ";
	sql += "fecha_salida, cantidad, precio_unitario, monto, flete, monto_total "; 
        sql += "FROM sistock.tbl_bitacora_salida a ";
        sql += "INNER JOIN tbl_equipo b ON ";
        sql += "b.id_equipo = a.equipo ";
        sql += "INNER JOIN tbl_centrocosto c ON ";
        sql += "c.id_centrocosto = a.centrocosto; ";
        
        conexion cnn = new conexion(sql,"buscar");
      
       if (cnn.estado){
             try{
                while(cnn.rs.next()){
                        modelotabla.addRow(new Object[]{
                        cnn.rs.getInt(1),
                        cnn.rs.getString(2),
                        cnn.rs.getString(3),
                        cnn.rs.getString(4),
                        cnn.rs.getInt(5),
                        cnn.rs.getString(6),
                        cnn.rs.getString(7),
                        cnn.rs.getDate(8),
                        cnn.rs.getInt(9),
                        cnn.rs.getDouble(10),
                        cnn.rs.getDouble(11),
                        cnn.rs.getDouble(12),
                        cnn.rs.getDouble(13)
                        });  
                }
                                      
                cnn.cerrar(); 
                   
               
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
             }

        }
        else{
        }
               
       cnn.cerrar();
   
    }
    
    public void log_stock_entrada(){
        String sql;
        
        DefaultTableModel modelotabla = (DefaultTableModel) tabla.getModel();

        
        sql = "SELECT id_bitacora, transaccion, usuario, fecha_transaccion, id_stock, ";
        sql += "c.centrocosto, ocexcel, nro_factura, nro_guia, fecha_llegada, sp, uso_equipo, ";
        sql += "codigosap, descripcion_material, nro_parte, cantidad_recibida, precio_unitario, "; 
        sql += "monto_factura, flete_envio, monto_total, valor_dolar, monto_bs, monto_flete, ";
        sql += "total_general, cantidad_usada, cantidad_disp ";
        sql += "FROM sistock.tbl_bitacora_entrada a ";
        sql += "INNER JOIN tbl_centrocosto c ON ";
        sql += "c.id_centrocosto = a.id_centrocosto; ";
        
        conexion cnn = new conexion(sql,"buscar");
      
       if (cnn.estado){
             try{
                while(cnn.rs.next()){
                        modelotabla.addRow(new Object[]{
                        cnn.rs.getInt(1),
                        cnn.rs.getString(2),
                        cnn.rs.getString(3),
                        cnn.rs.getString(4),
                        cnn.rs.getInt(5),
                        cnn.rs.getString(6),
                        cnn.rs.getString(7),
                        cnn.rs.getString(8),
                        cnn.rs.getString(9),
                        cnn.rs.getDate(10),
                        cnn.rs.getString(11),
                        cnn.rs.getString(12),
                        cnn.rs.getInt(13),
                        cnn.rs.getString(14),
                        cnn.rs.getString(15),
                        cnn.rs.getInt(16),
                        cnn.rs.getDouble(17),
                        cnn.rs.getDouble(18),
                        cnn.rs.getDouble(19),
                        cnn.rs.getDouble(20),
                        cnn.rs.getDouble(21),
                        cnn.rs.getDouble(22),
                        cnn.rs.getDouble(23),
                        cnn.rs.getDouble(24),
                        cnn.rs.getInt(25),
                        cnn.rs.getInt(26)        
                        });  
                }
                                      
                cnn.cerrar(); 
                   
               
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
             }

        }
        else{
        }
               
       cnn.cerrar();
   
    }
}
