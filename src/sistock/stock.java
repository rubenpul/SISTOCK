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
public class stock {
    
    
    private String fecha_desde;
    private String fecha_hasta;
    private Integer codigosap;
    private String descripcion;
    private Integer centrocosto;
    private String equipo;
    private Integer id_equipo;
    private JTable datos_entrada;
    private JTable datos_salida;
    private Integer cantidad_salida;
    private Integer id_stock;
    private Integer fila;
    private String fecha_salida;
    private String mes;
    private String ano;
    private Integer mes_num;
    private Integer ano_num;
    private String costo;
    private Integer cant_usada;
    private Integer cant_disp;
    private Integer precio_unitario;
    private Double flete;
    private Integer cantidad_recibida;
    private Double flete_bs;
    private Integer id_salida;
    
    public stock(JTable datos_entrada) {
        this.datos_entrada = datos_entrada;
    }

    public stock(String mes,String ano) {
        this.mes = mes;
        this.ano = ano;
    }

    public stock(Integer id_stock, Integer id_salida, Integer cant_usada) {
        this.id_stock = id_stock;
        this.id_salida = id_salida;
        this.cant_usada = cant_usada;
    }
    
 

    public stock(String fecha_desde,String fecha_hasta,Integer mes,Integer ano,String costo,Integer centrocosto,Integer id_equipo){
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.mes_num = mes;
        this.ano_num = ano;
        this.costo = costo;
        this.centrocosto = centrocosto;
        this.id_equipo = id_equipo;
    }
    
    public stock(String fecha_desde, String fecha_hasta, Integer codigosap, String descripcion, Integer centrocosto, String equipo, JTable datos_entrada) {
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.codigosap = codigosap;
        this.descripcion = descripcion;
        this.centrocosto = centrocosto;
        this.equipo = equipo;
        this.datos_entrada = datos_entrada;
    }
    
    public stock(String fecha_desde, String fecha_hasta, Integer codigosap, String descripcion, Integer centrocosto, Integer id_equipo, JTable datos_entrada, JTable datos_salida) {
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.codigosap = codigosap;
        this.descripcion = descripcion;
        this.centrocosto = centrocosto;
        this.id_equipo = id_equipo;
        this.datos_entrada = datos_entrada;
        this.datos_salida = datos_salida;
    }

    public stock(Integer codigosap, JTable datos_entrada, JTable datos_salida) {
        this.codigosap = codigosap;
        this.datos_entrada = datos_entrada;
        this.datos_salida = datos_salida;
    }
    
    public stock(Integer codigosap,Integer id_equipo,Integer centrocosto, Integer cantidad_salida, JTable datos_entrada, JTable datos_salida, String fecha_salida) {
        this.codigosap = codigosap;
        this.centrocosto = centrocosto;
        this.id_equipo = id_equipo;
        this.cantidad_salida = cantidad_salida;
        this.datos_entrada = datos_entrada;
        this.datos_salida = datos_salida;
        this.fecha_salida = fecha_salida;
    }
    
     public stock(JTable datos_entrada, Integer fila, Integer id_stock){
        this.datos_entrada = datos_entrada;
        this.fila = fila;
        this.id_stock = id_stock;
    }

    public void datastockreporte(JTable tabla){
    
       String sql;
       Integer valortasa;
       DefaultTableModel modelotablastock = (DefaultTableModel) tabla.getModel();
      
       modelotablastock.setRowCount(0);
       
        sql = "SELECT sap, "; 
	sql += "descripcion, ";  
        sql += "costo, ";
        sql += "cant_ume, ";
        sql += "UME, ";
        sql += "valor, ";
        sql += "tasa_mes, ";
        sql += "fecha, ";
        sql += "id_equipo, ";
        sql += "equipo, ";
        sql += "cantrecib, ";
        sql += "cantdisp, ";
        sql += "cantidadsalida, "; 
	sql += "precio_unitario, ";
        sql += "subtotal, ";
        sql += "flete, ";
        sql += "MontoTotal, ";
        sql += "estatus, ";
        sql += "id_centrocosto, ";
        sql += "centrocosto, ";
        sql += " 0 as fletenacAct, ";
        sql += " 0 as fleteAct, ";
        sql += " 0 as MontoTotalAct, ";
        sql += " fletebs ";
        
        sql += "FROM( ";
        
        sql += "SELECT codigosap as sap, ";
	sql += "e.descripcion_material as descripcion, ";
        sql += "'REPUESTOS' as costo, ";
        sql += "0 as cant_ume, ";
        sql += "'PZA' as UME, ";
        sql += "0 as valor, ";
        sql += "0 as tasa_mes, ";
        sql += "e.fecha_llegada as fecha, ";
	sql += "g.id_equipo as id_equipo, ";
        sql += "e.uso_equipo as equipo, ";
	sql += "cantidad_recibida as cantrecib, "; 
        sql += "cantidad_disp as cantdisp, ";  
        sql += "0 as cantidadsalida, ";  
        sql += "e.precio_unitario, ";
        sql += "cantidad_disp * e.precio_unitario as subtotal, ";
        sql += "(e.flete_envio/e.cantidad_recibida)* e.cantidad_disp as flete, ";
	sql += "((e.cantidad_disp * e.precio_unitario) + ((e.flete_envio/e.cantidad_recibida) * e.cantidad_disp)) as MontoTotal, "; 
	sql += "'STOCK' as Estatus, ";
	sql += "e.id_centrocosto as id_centrocosto, "; 
        sql += "f.centrocosto as centrocosto, ";
        sql += " 0 as fletenacAct, ";
        sql += " 0 as fleteAct, ";
        sql += " 0 as MontoTotalAct, ";
        sql += "(e.monto_flete/e.cantidad_recibida)* e.cantidad_disp as fletebs ";
        sql += "FROM sistock.tbl_entrada e ";
        sql += "INNER JOIN tbl_centrocosto f ON e.id_centrocosto = f.id_centrocosto ";
        sql += "INNER JOIN tbl_equipo g ON e.uso_equipo = g.equipo ";

        sql += "UNION ALL ";

        sql += "SELECT codigo_sap as sap, "; 
        sql += "a.descripcion as descripcion, ";
        sql += "'REPUESTOS' as costo, ";
        sql += "0 as cant_ume, ";
        sql += "'PZA' as UME, ";
        sql += "0 as valor, ";
        sql += "0 as tasa_mes, ";
        sql += "a.fecha_salida as fecha, ";
        sql += "a.fk_equipo as id_equipo, ";
        sql += "c.equipo as equipo, ";
	sql += "0 as cantrecib, ";
	sql += "0 as cantdisp, ";
        sql += "a.cantidad as cantidadsalida, ";
        sql += "a.precio_unitario as precio_unitario, "; 
        sql += "a.monto as subtotal, ";
        sql += "a.flete as flete, ";
	sql += "a.monto_total as MontoTotal, ";
        sql += "'USADO' as Estatus, ";  
        sql += "a.fk_centrocosto as id_centrocosto, "; 
        sql += "b.centrocosto as centrocosto, ";
        sql += " 0 as fletenacAct, ";
        sql += " 0 as fleteAct, ";
        sql += " 0 as MontoTotalAct, ";
        sql += "a.fleteBs as fleteBs ";
        sql += "FROM sistock.tbl_salida a ";
        sql += "INNER JOIN tbl_centrocosto b ON a.fk_centrocosto = b.id_centrocosto ";
        sql += "INNER JOIN tbl_equipo c ON a.fk_equipo = c.id_equipo) as stock ";

        sql+= "WHERE 1=1 ";
        
       if(!fecha_desde.equals("")){
           sql +="AND fecha BETWEEN '" + fecha_desde + "' AND '" + fecha_hasta + "' ";
       }
       if(codigosap != -1){
           sql+="AND sap = " + codigosap + " ";
       }
       if(!descripcion.equals("")){
           sql+="AND descripcion  LIKE '%" + descripcion + "%' ";
       }
       if(centrocosto != -1){
           sql+="AND id_centrocosto = " + centrocosto + " ";
       }
      
       if(id_equipo != -1){
           sql+="AND id_equipo = " + id_equipo + " ";
       }
 
 
       sql+=" ORDER BY estatus;";
       
       //System.out.println(sql);
       conexion cnn = new conexion(sql,"buscar");
      
       
       valortasa = 1;
       
       if (cnn.estado){
             try{
                
                    while(cnn.rs.next() && !valortasa.equals(0)){
                        
                        tasa tas = new tasa(0,0,0,cnn.rs.getDate(8).toString().trim(),"",0,"");
                        valortasa = tas.consultar_tasa();
                        
                        if (!valortasa.equals(0)){
                                    modelotablastock.addRow(new Object[]{
                                    cnn.rs.getInt(1),
                                    cnn.rs.getString(2),
                                    cnn.rs.getString(3),
                                    cnn.rs.getInt(4),
                                    cnn.rs.getString(5),
                                    cnn.rs.getDouble(6),
                                    valortasa,
                                    funciones.fecha_bd_usuario(cnn.rs.getDate(8).toString().trim(),1),
                                    cnn.rs.getInt(9),
                                    cnn.rs.getString(10),
                                    cnn.rs.getInt(11),
                                    cnn.rs.getInt(12),
                                    cnn.rs.getInt(13),
                                    cnn.rs.getDouble(14),
                                    cnn.rs.getDouble(15),
                                    cnn.rs.getDouble(16),
                                    cnn.rs.getDouble(17),
                                    cnn.rs.getString(18),
                                    cnn.rs.getInt(19),
                                    cnn.rs.getString(20),
                                    String.format("%.2f", cnn.rs.getDouble(24) / valortasa),
                                    String.format("%.2f",(cnn.rs.getDouble(24) / valortasa) + cnn.rs.getDouble(16)),
                                    String.format("%.2f",((cnn.rs.getDouble(24) / valortasa) + cnn.rs.getDouble(16)) + cnn.rs.getDouble(15)),
                                    cnn.rs.getDouble(24)
                                });
                              
                       }
                       else{
                            modelotablastock.setRowCount(0);
                            JOptionPane.showMessageDialog(null,"NO HAY TASA DE CAMBIO ESTABLECIDA EN EL SISTEMA PARA LA FECHA " +  funciones.fecha_bd_usuario(cnn.rs.getDate(8).toString().trim(),1) + ". IR AL MODULO DE ADMINISTRACION -> TASA DE CAMBIO.");
                       } 
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

    public void datastockimp_nac_pkf(JTable tabla){
    
       String sql;
       Integer valortasa;
       String fechamatycon="";
       String fechasalida="";
       String fechapkf="";
       
       DefaultTableModel modelotablastock = (DefaultTableModel) tabla.getModel();
      
       modelotablastock.setRowCount(0);
       
       try{ 
            if(!fecha_desde.equals("")){
                fechamatycon =" AND x.fecha_contab BETWEEN '" + fecha_desde + "' AND '" + fecha_hasta + "' ";
                fechasalida =" AND a.fecha_salida BETWEEN '" + fecha_desde + "' AND '" + fecha_hasta + "' ";
                fechapkf = " AND r.fecha_servicio BETWEEN '" + fecha_desde + "' AND '" + fecha_hasta + "' ";
            }
            
        }    
        catch(NullPointerException ex){
            if((mes_num != -1) && (ano_num != -1)){
                
                fechamatycon =" AND MONTH(x.fecha_contab)= " + mes_num + " AND YEAR(x.fecha_contab)= " + ano_num + " ";
                fechasalida =" AND MONTH(a.fecha_salida)= " + mes_num + " AND YEAR(a.fecha_salida)= " + ano_num + " ";
                fechapkf = " AND MONTH(r.fecha_servicio)= " + mes_num + " AND YEAR(r.fecha_servicio)= " + ano_num + " ";
            }
            else{
                if (ano_num != -1){
                    fechamatycon =" AND YEAR(x.fecha_contab)= " + ano_num + " ";
                    fechasalida =" AND YEAR(a.fecha_salida)= " + ano_num + " ";
                    fechapkf = " AND YEAR(r.fecha_servicio)= " + ano_num + " ";
                }
            }
        }
        
        sql = "SELECT sap, "; 
	sql += "descripcion, ";  
        sql += "costo, ";
        sql += "cant_ume, ";
        sql += "UME, ";
        sql += "valor, ";
        sql += "tasa_mes, ";
        sql += "fecha, ";
        sql += "id_equipo, ";
        sql += "equipo, ";
        sql += "cantrecib, ";
        sql += "cantdisp, ";
        sql += "cantidadsalida, "; 
	sql += "precio_unitario, ";
        sql += "subtotal, ";
        sql += "flete, ";
        sql += "MontoTotal, ";
        sql += "estatus, ";
        sql += "id_centrocosto, ";
        sql += "centrocosto, ";
        sql += " 0 as fletenacAct, ";
        sql += " 0 as fleteAct, ";
        sql += " 0 as MontoTotalAct, ";
        sql += " fletebs ";
        
        sql += "FROM( ";

        sql += "SELECT cod_material as sap, ";
        sql += "descripcion as descripcion, ";
        sql += "costo as costo, ";
        sql += "cantidad as cant_ume, ";
        sql += "unidad_medida as UME, ";
        sql += "valor as valor, ";
        sql += "tasa as tasa_mes, ";
        sql += "fecha_contab as fecha, ";
	sql += "y.id_equipo as id_equipo, ";
        sql += "y.equipo as equipo, ";
	sql += "0 as cantrecib, ";
        sql += "0 as cantdisp, ";
        sql += "0 as cantidadsalida, ";
        sql += "0 as precio_unitario, ";
        sql += "valor as subtotal, ";
        sql += "0 as flete, ";
	sql += "valor as MontoTotal, "; 
	sql += "'MATYCON' as Estatus, ";
	sql += "w.id_centrocosto as id_centrocosto, "; 
        sql += "w.centrocosto as centrocosto, ";
        sql += " 0 as fletenacAct, ";
        sql += " 0 as fleteAct, ";
        sql += " valor as MontoTotalAct, ";
        sql += " 0 as fletebs ";
        sql += "FROM tbl_matycon x ";
        sql += "INNER JOIN tbl_equipo y ON y.equipo = x.equipo ";
        sql += "INNER JOIN tbl_centrocosto w ON x.fk_centrocosto = w.id_centrocosto "; 
        sql += fechamatycon;
       
        sql += "UNION ALL ";

        sql += "SELECT id_solicitud as sap, ";
	sql += "servicio_pkf as descripcion, ";
        sql += "'PKF' as costo, ";
        sql += "1 as cant_ume, ";
        sql += "'UN' as UME, ";
        sql += "costo_total as valor, ";
        sql += "0 as tasa_mes, ";
        sql += "fecha_servicio as fecha, ";
        sql += "r.fk_equipo as id_equipo, ";
        sql += "s.equipo as equipo, ";
        sql += "0 as cantrecib, ";
        sql += "0 as cantdisp, ";
        sql += "0 as cantidadsalida, ";
        sql += "0 as precio_unitario, ";
        sql += "costo_total as subtotal, ";
        sql += "0 as flete, ";
	sql += "costo_total as MontoTotal, "; 
	sql += "'SERVICIO' as Estatus, ";
	sql += "t.id_centrocosto as id_centrocosto, "; 
        sql += "t.centrocosto as centrocosto, ";
        sql += " 0 as fletenacAct, ";
        sql += " 0 as fleteAct, ";
        sql += " costo_total as MontoTotalAct, ";
        sql += " 0 as fletebs ";
        sql += "FROM tbl_tallerpkf r ";
        sql += "INNER JOIN tbl_equipo s ON r.fk_equipo = s.id_equipo ";         
        sql += "INNER JOIN tbl_centrocosto t ON s.fk_centrocosto = t.id_centrocosto "; 
        sql += fechapkf;

        sql += "UNION ALL ";

       /* sql += "SELECT codigosap as sap, ";
	sql += "e.descripcion_material as descripcion, ";
        sql += "'REPUESTOS' as costo, ";
        sql += "0 as cant_ume, ";
        sql += "'PZA' as UME, ";
        sql += "0 as valor, ";
        sql += "0 as tasa_mes, ";
        sql += "e.fecha_llegada as fecha, ";
	sql += "g.id_equipo as id_equipo, ";
        sql += "e.uso_equipo as equipo, ";
	sql += "cantidad_recibida as cantrecib, "; 
        sql += "cantidad_disp as cantdisp, ";  
        sql += "0 as cantidadsalida, ";  
        sql += "e.precio_unitario, ";
        sql += "cantidad_disp * e.precio_unitario as subtotal, ";
        sql += "(e.flete_envio/e.cantidad_recibida)* e.cantidad_disp as flete, ";
	sql += "((e.cantidad_disp * e.precio_unitario) + ((e.flete_envio/e.cantidad_recibida) * e.cantidad_disp)) as MontoTotal, "; 
	sql += "'STOCK' as Estatus, ";
	sql += "e.id_centrocosto as id_centrocosto, "; 
        sql += "f.centrocosto as centrocosto, ";
        sql += " 0 as fletenacAct, ";
        sql += " 0 as fleteAct, ";
        sql += " 0 as MontoTotalAct, ";
        sql += "(e.monto_flete/e.cantidad_recibida)* e.cantidad_disp as fletebs ";
        sql += "FROM sistock.tbl_entrada e ";
        sql += "INNER JOIN tbl_centrocosto f ON e.id_centrocosto = f.id_centrocosto ";
        sql += "INNER JOIN tbl_equipo g ON e.uso_equipo = g.equipo ";

        sql += "UNION ALL ";*/

        sql += "SELECT codigo_sap as sap, "; 
        sql += "a.descripcion as descripcion, ";
        sql += "'REPUESTOS' as costo, ";
        sql += "0 as cant_ume, ";
        sql += "'PZA' as UME, ";
        sql += "0 as valor, ";
        sql += "0 as tasa_mes, ";
        sql += "a.fecha_salida as fecha, ";
        sql += "a.fk_equipo as id_equipo, ";
        sql += "c.equipo as equipo, ";
	sql += "0 as cantrecib, ";
	sql += "0 as cantdisp, ";
        sql += "a.cantidad as cantidadsalida, ";
        sql += "a.precio_unitario as precio_unitario, "; 
        sql += "a.monto as subtotal, ";
        sql += "a.flete as flete, ";
	sql += "a.monto_total as MontoTotal, ";
        sql += "'USADO' as Estatus, ";  
        sql += "a.fk_centrocosto as id_centrocosto, "; 
        sql += "b.centrocosto as centrocosto, ";
        sql += " 0 as fletenacAct, ";
        sql += " 0 as fleteAct, ";
        sql += " 0 as MontoTotalAct, ";
        sql += "a.fleteBs as fleteBs ";
        sql += "FROM sistock.tbl_salida a ";
        sql += "INNER JOIN tbl_centrocosto b ON a.fk_centrocosto = b.id_centrocosto ";
        sql += "INNER JOIN tbl_equipo c ON a.fk_equipo = c.id_equipo ";
        sql += fechasalida;
        sql += ") as stock ";
        sql+= "WHERE 1=1 ";
        
        
        
        if(costo != null){
               sql+=" AND costo = '" + costo + "' ";
        }
        if(centrocosto != -1){
                sql+=" AND id_centrocosto = " + centrocosto + " ";
        }
        if(id_equipo != -1){
                sql+=" AND id_equipo = " + id_equipo + " ";
        }
        
 
       sql+=" ORDER BY centrocosto asc,costo asc;";
       
       
       
       conexion cnn = new conexion(sql,"buscar");
      
       valortasa = 1;
       
       if (cnn.estado){
             try{
                
                    while(cnn.rs.next() && !valortasa.equals(0)){
                        
                        tasa tas = new tasa(0,0,0,cnn.rs.getDate(8).toString().trim(),"",0,"");
                        valortasa = tas.consultar_tasa();
                        
                        if (!valortasa.equals(0)){
                            if (cnn.rs.getString(3).equals("REPUESTOS")){ 
                                    modelotablastock.addRow(new Object[]{
                                    cnn.rs.getInt(1),
                                    cnn.rs.getString(2),
                                    cnn.rs.getString(3),
                                    cnn.rs.getInt(4),
                                    cnn.rs.getString(5),
                                    cnn.rs.getDouble(6),
                                    valortasa,
                                    funciones.fecha_bd_usuario(cnn.rs.getDate(8).toString().trim(),1),
                                    cnn.rs.getInt(9),
                                    cnn.rs.getString(10),
                                    cnn.rs.getInt(11),
                                    cnn.rs.getInt(12),
                                    cnn.rs.getInt(13),
                                    cnn.rs.getDouble(14),
                                    cnn.rs.getDouble(15),
                                    cnn.rs.getDouble(16),
                                    cnn.rs.getDouble(17),
                                    cnn.rs.getString(18),
                                    cnn.rs.getInt(19),
                                    cnn.rs.getString(20),
                                    String.format("%.2f", cnn.rs.getDouble(24) / valortasa),
                                    String.format("%.2f",(cnn.rs.getDouble(24) / valortasa) + cnn.rs.getDouble(16)),
                                    String.format("%.2f",((cnn.rs.getDouble(24) / valortasa) + cnn.rs.getDouble(16)) + cnn.rs.getDouble(15)),
                                    cnn.rs.getDouble(24)
                                });
                            }        
                            else{
                                    modelotablastock.addRow(new Object[]{
                                    cnn.rs.getInt(1),
                                    cnn.rs.getString(2),
                                    cnn.rs.getString(3),
                                    cnn.rs.getInt(4),
                                    cnn.rs.getString(5),
                                    cnn.rs.getDouble(6),
                                    valortasa,
                                    funciones.fecha_bd_usuario(cnn.rs.getDate(8).toString().trim(),1),
                                    cnn.rs.getInt(9),
                                    cnn.rs.getString(10),
                                    cnn.rs.getInt(11),
                                    cnn.rs.getInt(12),
                                    cnn.rs.getInt(13),
                                    cnn.rs.getDouble(14),
                                    cnn.rs.getDouble(15),
                                    cnn.rs.getDouble(16),
                                    cnn.rs.getDouble(17),
                                    cnn.rs.getString(18),
                                    cnn.rs.getInt(19),
                                    cnn.rs.getString(20),
                                    cnn.rs.getDouble(21),
                                    cnn.rs.getDouble(22),
                                    String.format("%.2f",cnn.rs.getDouble(6)/valortasa),
                                    cnn.rs.getDouble(24)
                                });
                            }        
                       }
                       else{
                            modelotablastock.setRowCount(0);
                            JOptionPane.showMessageDialog(null,"NO HAY TASA DE CAMBIO ESTABLECIDA EN EL SISTEMA PARA LA FECHA " +  funciones.fecha_bd_usuario(cnn.rs.getDate(8).toString().trim(),1) + ". IR AL MODULO DE ADMINISTRACION -> TASA DE CAMBIO.");
                       } 
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


    
    public boolean buscarstocknacional(){
        
       String sql;
       
        
       sql = "SELECT mes ";
       sql +="FROM tbl_matycon ";
       sql +="WHERE mes = '" + getMes() + "' AND ano = '" + getAno() + "'";
       sql+=";";
       
       conexion cnn = new conexion(sql,"buscar");
      
       if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    cnn.cerrar();
                    return true;
                }
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                  return false;
             }

        }
         else{
           cnn.cerrar();
           return false;
        }
       
       return false;
      
     
    }
     
     
     
    public void buscarstock(Boolean mensaje){
        
       String sql;
       DefaultTableModel modelotabla = (DefaultTableModel) datos_entrada.getModel();
       
       modelotabla.setRowCount(0);
        
       sql = "SELECT a.id_stock, a.id_centrocosto,b.centrocosto ,a.ocexcel, a.nro_factura, a.nro_guia, a.fecha_llegada, a.sp, a.uso_equipo, a.codigosap, a.descripcion_material, a.nro_parte, a.cantidad_recibida, a.precio_unitario, a.monto_factura, a.flete_envio, a.monto_total, a.valor_dolar, a.monto_bs, a.monto_flete, a.total_general ";
       sql +="FROM tbl_entrada a ";
       sql +="INNER JOIN tbl_centrocosto b ON ";
       sql +="a.id_centrocosto = b.id_centrocosto ";
       sql +="WHERE 1=1 ";
       
       if(!fecha_desde.equals("")){
           sql +="AND a.fecha_llegada BETWEEN '" + fecha_desde + "' AND '" + fecha_hasta + "' ";
       }
       if(codigosap != -1){
           sql+="AND a.codigosap = " + codigosap + " ";
       }
       if(!descripcion.equals("")){
           sql+="AND a.descripcion_material  LIKE '%" + descripcion + "%' ";
       }
       if(centrocosto != -1){
           sql+="AND a.id_centrocosto = " + centrocosto + " ";
       }
       if(!equipo.equals("")){
           sql+="AND a.uso_equipo LIKE '%" + equipo + "%' ";
       }
        sql+=";";
       conexion cnn = new conexion(sql,"buscar");
      
       if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    cnn.rs.previous();
                    while(cnn.rs.next()){
                        modelotabla.addRow(new Object[]{
                        cnn.rs.getInt(1),
                        cnn.rs.getInt(2),
                        cnn.rs.getString(3),
                        cnn.rs.getString(4),
                        cnn.rs.getString(5),
                        cnn.rs.getString(6),
                        cnn.rs.getDate(7),
                        cnn.rs.getString(8),
                        cnn.rs.getString(9),
                        cnn.rs.getInt(10),
                        cnn.rs.getString(11),
                        cnn.rs.getString(12),
                        cnn.rs.getInt(13),
                        cnn.rs.getDouble(14),
                        cnn.rs.getDouble(15),
                        cnn.rs.getDouble(16),
                        cnn.rs.getDouble(17),
                        cnn.rs.getDouble(18),
                        cnn.rs.getDouble(19),
                        cnn.rs.getDouble(20),
                        cnn.rs.getDouble(21)
                        });    
                    }
                                      
                    cnn.cerrar(); 
                   
                }    
                else{
                    cnn.cerrar(); 
                    if(mensaje){
                        JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS EN LA BASE DE DATOS CON EL FILTRO SELECCIONADO");
                    }
                }
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
    
    public Boolean buscarstockentradasalida(Boolean mensaje){
        
       String sql;
       Boolean bandera = true;
       DefaultTableModel modelotablaentrada = (DefaultTableModel) datos_entrada.getModel();
       DefaultTableModel modelotablasalida = (DefaultTableModel) datos_salida.getModel();
       Integer valortasa;
       
       modelotablaentrada.setRowCount(0);
        
       sql = "SELECT b.centrocosto,a.codigosap,a.descripcion_material,a.fecha_llegada,cantidad_recibida, "; 
       sql +=" cantidad_disp as cantidad, ";
       sql +=" a.precio_unitario, ";
       sql +=" cantidad_disp * a.precio_unitario as monto_factura, ";
       sql +=" (a.flete_envio/cantidad_recibida)* cantidad_disp as flete_envio, "; 
       sql +=" ((cantidad_disp * a.precio_unitario) + ((a.flete_envio/cantidad_recibida) * cantidad_disp)) as monto_total, ";
       sql +=" 0 as fletenac, 0 as fletetotal, 0 as montogeneral,";
       sql +=" (a.monto_flete/a.cantidad_recibida)* cantidad_disp as fletebs ";
       
       sql +="FROM tbl_entrada a ";
       
       sql +="INNER JOIN tbl_centrocosto b ON "; 
       sql +="a.id_centrocosto = b.id_centrocosto ";
       
       sql +="WHERE cantidad_disp > 0 ";

         
       if(!fecha_desde.equals("")){
           sql +="AND a.fecha_llegada BETWEEN '" + fecha_desde + "' AND '" + fecha_hasta + "' ";
       }
       if(codigosap != -1){
           sql+="AND a.codigosap = " + codigosap + " ";
       }
       if(!descripcion.equals("")){
           sql+="AND a.descripcion_material  LIKE '%" + descripcion + "%' ";
       }
       if(centrocosto != -1){
           sql+="AND a.id_centrocosto = " + centrocosto ;
       }
      
       sql+=" ORDER BY b.centrocosto;";
       
       
       conexion cnn = new conexion(sql,"buscar");
      
       
       
        valortasa = 1;
        
       if (cnn.estado){
             try{
                
                    while(cnn.rs.next() && !valortasa.equals(0)){
                        tasa tas = new tasa(0,0,0,cnn.rs.getDate(4).toString().trim(),"",0,"");
                        valortasa = tas.consultar_tasa();
                        
                        if (!valortasa.equals(0)){
                            
                        modelotablaentrada.addRow(new Object[]{
                        cnn.rs.getString(1),
                        cnn.rs.getInt(2),
                        cnn.rs.getString(3),
                        funciones.fecha_bd_usuario(cnn.rs.getDate(4).toString().trim(),1),
                        cnn.rs.getInt(5),
                        cnn.rs.getInt(6),
                        cnn.rs.getDouble(7),
                        cnn.rs.getDouble(8),
                        cnn.rs.getDouble(9),
                        cnn.rs.getDouble(10),
                        String.format("%.2f", cnn.rs.getDouble(14) / valortasa),
                        String.format("%.2f",(cnn.rs.getDouble(14) / valortasa) + cnn.rs.getDouble(9)),
                        String.format("%.2f",((cnn.rs.getDouble(14) / valortasa) + cnn.rs.getDouble(9)) + cnn.rs.getDouble(8)),
                        cnn.rs.getDouble(14)
                        });    
                        
                        }
                        else{
                            modelotablaentrada.setRowCount(0);
                            JOptionPane.showMessageDialog(null,"NO HAY TASA DE CAMBIO ESTABLECIDA EN EL SISTEMA PARA LA FECHA " +  funciones.fecha_bd_usuario(cnn.rs.getDate(4).toString().trim(),1) + ". IR AL MODULO DE ADMINISTRACION -> TASA DE CAMBIO.");
                            cantidad_recibida = 0;
                        } 
                    }
                                      
                    cnn.cerrar(); 
                    bandera = true;
                    
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                bandera = false;
             }

        }
         else{
           bandera = false;
        }
       
       
       cnn.cerrar();
       
       if (bandera){
       //SALIDA
       
       valortasa = 1;
       
       modelotablasalida.setRowCount(0);
        
       sql = "SELECT b.centrocosto,c.equipo, a.codigo_sap,a.descripcion, a.fecha_salida,a.cantidad, a.precio_unitario, a.monto, a.flete, a.monto_total, a.fletebs ";
       sql +="FROM tbl_salida a ";
       sql +="INNER JOIN tbl_centrocosto b ON ";
       sql +="a.fk_centrocosto = b.id_centrocosto ";
       sql +="INNER JOIN tbl_equipo c ON ";
       sql +="a.fk_equipo = c.id_equipo ";
       sql +="WHERE 1=1 ";
       
       if(!fecha_desde.equals("")){
           sql +="AND a.fecha_salida BETWEEN '" + fecha_desde + "' AND '" + fecha_hasta + "' ";
       }
       if(codigosap != -1){
           sql+="AND a.codigo_sap = " + codigosap + " ";
       }
       if(!descripcion.equals("")){
           sql+="AND a.descripcion  LIKE '%" + descripcion + "%' ";
       }
       if(centrocosto != -1){
           sql+="AND a.fk_centrocosto = " + centrocosto + " ";
       }
      
       sql+=" ORDER BY b.centrocosto;";
       
       cnn = new conexion(sql,"buscar");
      
       if (cnn.estado){
             try{
                
                    while(cnn.rs.next() && !valortasa.equals(0)){
                        tasa tas = new tasa(0,0,0,cnn.rs.getDate(5).toString().trim(),"",0,"");
                        valortasa = tas.consultar_tasa();
                        
                        if(!valortasa.equals(0)){
                        
                        modelotablasalida.addRow(new Object[]{
                        cnn.rs.getString(1),
                        cnn.rs.getString(2),
                        cnn.rs.getInt(3),
                        cnn.rs.getString(4),
                        cnn.rs.getDate(5),
                        cnn.rs.getInt(6),
                        cnn.rs.getDouble(7),
                        cnn.rs.getDouble(8),
                        cnn.rs.getDouble(9),
                        cnn.rs.getDouble(10),
                        String.format("%.2f", cnn.rs.getDouble(11) / valortasa),
                        String.format("%.2f",(cnn.rs.getDouble(11) / valortasa) + cnn.rs.getDouble(9)),
                        String.format("%.2f",((cnn.rs.getDouble(11) / valortasa) + cnn.rs.getDouble(9)) + cnn.rs.getDouble(8)),
                        cnn.rs.getDouble(11)
                        });    
                        
                        }
                        else{
                            modelotablasalida.setRowCount(0);
                            modelotablasalida.setRowCount(0);
                            JOptionPane.showMessageDialog(null,"NO HAY TASA DE CAMBIO ESTABLECIDA EN EL SISTEMA PARA LA FECHA " +  funciones.fecha_bd_usuario(cnn.rs.getDate(8).toString().trim(),1) + ". IR AL MODULO DE ADMINISTRACION -> TASA DE CAMBIO.");
                            cantidad_recibida = 0;
                        }    
                    }
                                      
                    cnn.cerrar(); 
                    bandera = true;
                             
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                bandera = false;
             }

        }
         else{
           bandera = false;
        }
       
       
       cnn.cerrar();
       
       } 
       return bandera;
    }
    
    public Integer buscarstockstatusentrada(){
        
       String sql;
       DefaultTableModel modelotabla = (DefaultTableModel) datos_entrada.getModel();
       Integer cantidad_recibida = 0;
       Integer valortasa;
       
       modelotabla.setRowCount(0);
        
       sql = "SELECT  id_stock,b.centrocosto,a.uso_equipo,a.codigosap,a.descripcion_material,a.cantidad_recibida,a.cantidad_usada,a.fecha_llegada,a.precio_unitario, a.monto_factura, a.flete_envio, a.monto_total,0 as fletenac, 0 as fletetotal, 0 as montogeneral,a.monto_flete ";
       sql +="FROM tbl_entrada a ";
       sql +="INNER JOIN tbl_centrocosto b ON ";
       sql +="a.id_centrocosto = b.id_centrocosto ";
       sql +="WHERE 1=1 ";
       
       if(codigosap != -1){
           sql+="AND a.codigosap = " + codigosap ;
       }
       
       sql+=" ORDER BY id_stock;";
       conexion cnn = new conexion(sql,"buscar");
       
       valortasa = 1;
       
       if (cnn.estado){
             try{
                while(cnn.rs.next() && !valortasa.equals(0)){
                        tasa tas = new tasa(0,0,0,cnn.rs.getDate(8).toString().trim(),"",0,"");
                        valortasa = tas.consultar_tasa();
                        
                        if (!valortasa.equals(0)){
                    
                    
                        modelotabla.addRow(new Object[]{
                        cnn.rs.getInt(1),
                        cnn.rs.getString(2),
                        cnn.rs.getString(3),
                        cnn.rs.getInt(4),
                        cnn.rs.getString(5),
                        cnn.rs.getInt(6),
                        cnn.rs.getInt(7),
                        cnn.rs.getDate(8),
                        cnn.rs.getDouble(9),
                        cnn.rs.getDouble(10),
                        cnn.rs.getDouble(11),
                        cnn.rs.getDouble(12),
                        String.format("%.2f", cnn.rs.getDouble(16) / valortasa),
                        String.format("%.2f",(cnn.rs.getDouble(16) / valortasa) + cnn.rs.getDouble(11)),
                        String.format("%.2f",((cnn.rs.getDouble(16) / valortasa) + cnn.rs.getDouble(11)) + cnn.rs.getDouble(10)),
                        cnn.rs.getDouble(16)
                        });   
                        cantidad_recibida += cnn.rs.getInt(6);
                        } 
                        else{
                            modelotabla.setRowCount(0);
                            JOptionPane.showMessageDialog(null,"NO HAY TASA DE CAMBIO ESTABLECIDA EN EL SISTEMA PARA LA FECHA " +  funciones.fecha_bd_usuario(cnn.rs.getDate(8).toString().trim(),1) + ". IR AL MODULO DE ADMINISTRACION -> TASA DE CAMBIO.");
                            cantidad_recibida = 0;
                        } 
                }
                                      
                cnn.cerrar(); 
                   
               
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                return cantidad_recibida;
             }

        }
        else{
        }
       
        
       cnn.cerrar();
       return cantidad_recibida;
       
    }
    
    public Integer buscarstockstatussalida(){
        
       String sql;
       DefaultTableModel modelotabla = (DefaultTableModel) datos_salida.getModel();
       Integer cantidad_salida = 0;
       Integer valortasa;
       
       modelotabla.setRowCount(0);
        
       sql = "SELECT  b.centrocosto,c.equipo,a.codigo_sap,a.descripcion,a.fecha_salida,a.cantidad, a.precio_unitario, a.monto, a.flete, a.monto_total,a.fletebs,id_stock,id_salida ";
       sql +="FROM tbl_salida a ";
       sql +="INNER JOIN tbl_centrocosto b ON ";
       sql +="a.fk_centrocosto = b.id_centrocosto ";
       sql +="INNER JOIN tbl_equipo c ON ";
       sql +="a.fk_equipo = c.id_equipo ";
       sql +="WHERE a.codigo_sap = " + codigosap ;
       
       sql +=";";
       conexion cnn = new conexion(sql,"buscar");
      
       valortasa = 1;
       
       if (cnn.estado){
             try{
                while(cnn.rs.next() && !valortasa.equals(0)){
                    
                        tasa tas = new tasa(0,0,0,cnn.rs.getDate(5).toString().trim(),"",0,"");
                        valortasa = tas.consultar_tasa();
                        
                        if (!valortasa.equals(0)){

                        modelotabla.addRow(new Object[]{
                        cnn.rs.getString(1),
                        cnn.rs.getString(2),
                        cnn.rs.getInt(3),
                        cnn.rs.getString(4),
                        cnn.rs.getDate(5),
                        cnn.rs.getInt(6),
                        cnn.rs.getDouble(7),
                        cnn.rs.getDouble(8),
                        cnn.rs.getDouble(9),
                        cnn.rs.getDouble(10),
                        String.format("%.2f", cnn.rs.getDouble(11) / valortasa),
                        String.format("%.2f",(cnn.rs.getDouble(11) / valortasa) + cnn.rs.getDouble(9)),
                        String.format("%.2f",((cnn.rs.getDouble(11) / valortasa) + cnn.rs.getDouble(9)) + cnn.rs.getDouble(8)),
                        cnn.rs.getDouble(11),
                        cnn.rs.getInt(12),
                        cnn.rs.getInt(13)
                        });   
                        cantidad_salida += cnn.rs.getInt(6);
                        } 
                        else{
                            modelotabla.setRowCount(0);
                            JOptionPane.showMessageDialog(null,"NO HAY TASA DE CAMBIO ESTABLECIDA EN EL SISTEMA PARA LA FECHA " +  funciones.fecha_bd_usuario(cnn.rs.getDate(5).toString().trim(),1) + ". IR AL MODULO DE ADMINISTRACION -> TASA DE CAMBIO.");
                            cantidad_salida = 0;
                        } 
                        
                }
                                      
                cnn.cerrar(); 
                   
               
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                return cantidad_salida;
             }

        }
        else{
        }
       
        
       cnn.cerrar();
       return cantidad_salida;
       
    }
    
    public Boolean borrar_mes_stock(Integer mes, Integer ano){
        String sql;
        conexion cnn;
        
        sql = "DELETE FROM tbl_entrada ";
        sql += "WHERE MONTH(fecha_llegada) = " + mes + " and YEAR(fecha_llegada)= " + ano + ";";
        
        cnn = new conexion(sql,"");
        cnn.cerrar();
        
        return true;
    }

    public Boolean borrar_mes_stocknacional(String mes, Integer ano){
        String sql;
        conexion cnn;
        
        sql = "DELETE FROM tbl_matycon ";
        sql += "WHERE mes = '" + mes + "' and ano= " + ano + ";";
        
        cnn = new conexion(sql,"");
        cnn.cerrar();
        
        return true;
    }

    
    public Boolean actualizar_stock_salida(){
        String sql;
        Double monto_total = 0.0;
        Double flete_total;
        Double flete_total_bs;
        Double monto;
        Integer cantidad_reg_entrada;
        Integer i = 0;
        Integer cant_recib;
        Integer cant_us;
        Integer cant;
        cantidad_reg_entrada = datos_entrada.getRowCount();
        
        boolean bandera = true;
        
        
        while ((i < cantidad_reg_entrada) && bandera){
            
            cant_recib = Integer.parseInt(datos_entrada.getValueAt(i, 5).toString().trim());
            cant_us = Integer.parseInt(datos_entrada.getValueAt(i, 6).toString().trim());
            id_stock = Integer.parseInt(datos_entrada.getValueAt(i, 0).toString().trim());
            
            cant_disp = cant_recib - cant_us;
            
            if (getCantidad_salida() > cant_disp){
                cant =  cant_disp;
                setCantidad_salida(getCantidad_salida() - cant);
            }
            else{
                cant = getCantidad_salida();
                bandera = false;
            }
            
                monto_total = Double.parseDouble(datos_entrada.getValueAt(i, 8).toString().trim()) * cant;
        
                setDescripcion(datos_entrada.getValueAt(i, 4).toString().trim());
        
                flete_total = Double.parseDouble(datos_entrada.getValueAt(i, 10).toString().trim()) / Double.parseDouble(datos_entrada.getValueAt(i, 5).toString().trim());
        
                if (flete_total > 0){
                    flete_total = flete_total * cant;
                }
                else{
                    flete_total = 0.0;
                }
                
                flete_total_bs = Double.parseDouble(datos_entrada.getValueAt(i, 15).toString().trim()) / Double.parseDouble(datos_entrada.getValueAt(i, 5).toString().trim());
        
                if (flete_total_bs > 0){
                    flete_total_bs = flete_total_bs * cant;
                }
                else{
                    flete_total_bs = 0.0;
                }
        
                monto = monto_total + flete_total;
                  
            sql = "INSERT INTO tbl_salida VALUES(DEFAULT,";       
            sql += getCodigosap() + ",";
            sql += getCentrocosto() + ",";
            sql += getId_equipo() + ",'";
            sql += getDescripcion() + "','";
            sql += getFecha_salida() + "',";
            sql += cant + ",";
            sql += Double.parseDouble(datos_entrada.getValueAt(i, 8).toString().trim()) + ",";
            sql += monto_total + ",";
            sql += flete_total + ",";
            sql += monto + ","; 
            sql += flete_total_bs + ",'";
            sql += frm_principal.nombre + "',";
            sql += Integer.parseInt(datos_entrada.getValueAt(i, 0).toString().trim()) + ");";
        
            conexion cnn = new conexion(sql,"");
        
            sql =  "UPDATE tbl_entrada ";
            sql += "SET cantidad_usada = cantidad_usada + " + cant + ",cantidad_disp= cantidad_disp - " + cant;
            sql += " WHERE codigosap = " + getCodigosap() + " AND id_stock = " + Integer.parseInt(datos_entrada.getValueAt(i, 0).toString().trim());
        
            cnn = new conexion(sql,"");
        
            cnn.cerrar();
            i++;  
        }
        return true; 
    }
   
    
    
    public Boolean cargar_bd(){
        
        Integer row=0;
        String sql;
        conexion cnn;
      try{    
        
        while(row < datos_entrada.getRowCount()){
            
            sql = "INSERT INTO tbl_entrada VALUES(DEFAULT,";                                           // ID STOCK autoincrement
            
            sql += Integer.parseInt(datos_entrada.getValueAt(row, 0).toString().trim()) + ",'";                    // CC
            sql += datos_entrada.getValueAt(row, 1).toString().trim() + "','";                                      // O/C EXCEL
            sql += datos_entrada.getValueAt(row, 2).toString().trim() + "','";                                      //NRO FACTURA
            sql += datos_entrada.getValueAt(row, 3).toString().trim() + "','";                                      //NRO GUIA
            sql += funciones.fecha_bd_usuario_2(datos_entrada.getValueAt(row, 4).toString().trim(), 2) + "','";       //FECHA LLEGADA
            sql += datos_entrada.getValueAt(row, 5).toString().trim() + "','";                                      //SP
            sql += datos_entrada.getValueAt(row, 6).toString().trim() + "',";                                       //USO EQUIPO
            sql += Integer.parseInt(datos_entrada.getValueAt(row, 7).toString().trim()) + ",'";                    // CODIGO SAP
            sql += datos_entrada.getValueAt(row, 8).toString().trim() + "','";                                      //DESCRIPCION MATERIAL
            sql += datos_entrada.getValueAt(row, 9).toString().trim() + "',";                                       //NRO PARTE
            sql += Integer.parseInt(datos_entrada.getValueAt(row, 10).toString().trim()) + ",";                    //CANT RECIBIDA
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 11).toString().trim()) + ",";                  //PRECIO UNITARIO $
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 12).toString().trim()) + ",";                  //MONTO FACTURA ITEM$
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 13).toString().trim()) + ",";                  //FLETE ENVIO $
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 14).toString().trim()) + ",";                  //MONTO FACTURA TOTAL $
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 15).toString().trim()) + ",";                  //VALOR DOLAR $
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 16).toString().trim()) + ",";                  //MONTO BS
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 17).toString().trim()) + ",";                  //MONTO FLETE BS
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 18).toString().trim()) + ",";                  //TOTAL GENERAL
            
            sql += "0,";                                                                                    //CANT USADA
            sql += Integer.parseInt(datos_entrada.getValueAt(row, 10).toString().trim()) + ",'";                  //CANTIDAD DISP
            
            sql += frm_principal.nombre + "');";
            
            //System.out.println(sql);
            
            cnn = new conexion(sql,"");
            cnn.cerrar();
            
            
           
            
            row++;
           
        }
    }
    catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(null, "ERROR EN DATOS EN LA FILA " + row++);
        return false;
    }
               
        return true;
    }
    
    public void buscar_salida_codigosap_mesano(Integer mes, Integer ano,Integer codsap){
        String sql;
        
        sql = "SELECT sum(cantidad) as cantidad FROM tbl_salida ";
        sql += "WHERE codigo_sap = " + codsap +  " AND MONTH(fecha_salida) = " + mes +  " AND YEAR(fecha_salida) = " + ano +";";
        
        conexion cnn = new conexion(sql,"buscar");
      
       if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    setCant_usada(cnn.rs.getInt(1));
                    cnn.cerrar();
                }
                else{
                    setCant_usada(0);
                    cnn.cerrar();
                }
                
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
             }

        }
         else{
           cnn.cerrar();
        }
        
    }
    
    public void verificar_preciosunitario_salida_entrada(Integer mes,Integer ano,Integer codsap){
        String sql;
        
        sql = "SELECT precio_unitario,cantidad_recibida,flete_envio,monto_flete,id_stock FROM tbl_entrada ";
        sql += "WHERE codigosap = " + codsap +  " AND MONTH(fecha_llegada) = " + mes + " AND YEAR(fecha_llegada) = " + ano + ";";
        
        conexion cnn = new conexion(sql,"buscar");
      
       if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    setPrecio_unitario(cnn.rs.getInt(1));
                    setCantidad_recibida(cnn.rs.getInt(2));
                    setFlete(cnn.rs.getDouble(3));
                    setFlete_bs(cnn.rs.getDouble(4));
                    setId_stock(cnn.rs.getInt(5));
                    cnn.cerrar();
                }
                else{
                    cnn.cerrar();
                }
                
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
             }

        }
         else{
           cnn.cerrar();
        } 
       
           
        sql = "UPDATE tbl_salida";
        sql += " SET precio_unitario = " + getPrecio_unitario() + ",";  
        sql += " monto = cantidad * " + getPrecio_unitario() + ",";
        sql += " flete = cantidad *("  + getFlete() + " / " + " cantidad),";
        sql += " monto_total = monto + flete,";
        sql += " fletebs = " + getFlete_bs() + " / cantidad, " ;
        sql += " id_stock = " + getId_stock();
        sql += " WHERE codigo_sap = " + codsap;
        sql += " AND MONTH(fecha_salida) = " + mes + " AND YEAR(fecha_salida) = " + ano + ";";
        
        cnn = new conexion(sql,"");
        
        cnn.cerrar();

    }
    
    public Boolean cargar_bd_act(Integer mes, Integer ano){
        
        Integer row=0;
        String sql;
        conexion cnn;
        Integer codsap;
        Integer cant_recib;
      try{    
        
        while(row < datos_entrada.getRowCount()){
            codsap = Integer.parseInt(datos_entrada.getValueAt(row, 7).toString().trim());
            cant_recib = Integer.parseInt(datos_entrada.getValueAt(row, 10).toString().trim());
            
            buscar_salida_codigosap_mesano(mes,ano,codsap);  //ACTUALIZA CANTIDAD USADA SI EXISTE SALIDA DEL CODIGO SAP EN EL MES Y ANO SELECCIONADO
            
            

            sql = "INSERT INTO tbl_entrada VALUES(DEFAULT,";                                           // ID STOCK autoincrement
            
            sql += Integer.parseInt(datos_entrada.getValueAt(row, 0).toString().trim()) + ",'";                    // CC
            sql += datos_entrada.getValueAt(row, 1).toString().trim() + "','";                                      // O/C EXCEL
            sql += datos_entrada.getValueAt(row, 2).toString().trim() + "','";                                      //NRO FACTURA
            sql += datos_entrada.getValueAt(row, 3).toString().trim() + "','";                                      //NRO GUIA
            sql += funciones.fecha_bd_usuario_2(datos_entrada.getValueAt(row, 4).toString().trim(), 2) + "','";       //FECHA LLEGADA
            sql += datos_entrada.getValueAt(row, 5).toString().trim() + "','";                                      //SP
            sql += datos_entrada.getValueAt(row, 6).toString().trim() + "',";                                       //USO EQUIPO
            sql += Integer.parseInt(datos_entrada.getValueAt(row, 7).toString().trim()) + ",'";                    // CODIGO SAP
            sql += datos_entrada.getValueAt(row, 8).toString().trim() + "','";                                      //DESCRIPCION MATERIAL
            sql += datos_entrada.getValueAt(row, 9).toString().trim() + "',";                                       //NRO PARTE
            sql += Integer.parseInt(datos_entrada.getValueAt(row, 10).toString().trim()) + ",";                    //CANT RECIBIDA
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 11).toString().trim()) + ",";                  //PRECIO UNITARIO $
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 12).toString().trim()) + ",";                  //MONTO FACTURA ITEM$
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 13).toString().trim()) + ",";                  //FLETE ENVIO $
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 14).toString().trim()) + ",";                  //MONTO FACTURA TOTAL $
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 15).toString().trim()) + ",";                  //VALOR DOLAR $
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 16).toString().trim()) + ",";                  //MONTO BS
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 17).toString().trim()) + ",";                  //MONTO FLETE BS
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 18).toString().trim()) + ",";                  //TOTAL GENERAL
            sql += getCant_usada() + ",";                                                                                    //CANT USADA
            sql += cant_recib - getCant_usada() + ",'";                                                                       //CANTIDAD DISP   
            sql += frm_principal.nombre + "');";
            
            cnn = new conexion(sql,"");
            
            verificar_preciosunitario_salida_entrada(mes,ano,codsap);
            
            cnn.cerrar();
            
            
           
            
            row++;
           
        }
    }
    catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(null, "ERROR EN DATOS EN LA FILA " + row++);
        return false;
    }
               
        return true;
    }
    
    public Boolean cargar_bdnacional(){
        
        Integer row=0;
        String sql;
        conexion cnn;
      
      try{    
        
        while(row < datos_entrada.getRowCount()){
            
            sql = "INSERT INTO tbl_matycon VALUES(DEFAULT,";                                           
            
            sql += Integer.parseInt(datos_entrada.getValueAt(row, 0).toString().trim()) + ",'";                    // ID SALIDA STOCK autoincrement 
            sql += datos_entrada.getValueAt(row, 1).toString().trim() + "','";                                     // COD MATERIAL 
            sql += datos_entrada.getValueAt(row, 2).toString().trim() + "',";                                     // DESCRIPCION
            sql += Integer.parseInt(datos_entrada.getValueAt(row, 3).toString().trim()) + ",'";                    //CANTIDAD
            sql += datos_entrada.getValueAt(row, 4).toString().trim() + "',";                                      //UNIDAD DE MEDIDA
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 5).toString().trim()) + ",";                   //VALOR
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 6).toString().trim()) + ",'";                   //TASA
            sql += datos_entrada.getValueAt(row, 7).toString().trim() + "','";                                       // FECHA
            sql += datos_entrada.getValueAt(row, 8).toString().trim() + "','";                                      //MES
            sql += datos_entrada.getValueAt(row, 9).toString().trim() + "','";                                       //ANO  
            sql += datos_entrada.getValueAt(row, 10).toString().trim() + "',";                                      //EQUIPO
            sql += Double.parseDouble(datos_entrada.getValueAt(row, 11).toString().trim()) + ",";                          //MONTO 
            sql += datos_entrada.getValueAt(row, 12).toString().trim() + ",'";
            sql += frm_principal.nombre + "');";
            
                cnn = new conexion(sql,"");
                cnn.cerrar();
            
            
           
            
            row++;
           
        }
    }
    catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(null, "ERROR EN DATOS EN LA FILA " + row++);
        return false;
    }
               
        return true;
    }



    public Boolean actualizardetallestock(){
        String sql;
        Integer codsap;
        Integer cant_recib;
        
        codsap = Integer.parseInt(datos_entrada.getValueAt(fila, 9).toString().trim());
        mes_num    =   Integer.parseInt(datos_entrada.getValueAt(fila, 6).toString().trim().substring(5, 7));
        ano_num    =   Integer.parseInt(datos_entrada.getValueAt(fila, 6).toString().trim().substring(0, 4));
        cant_recib = Integer.parseInt(datos_entrada.getValueAt(fila, 12).toString().trim());
        
        buscar_salida_codigosap_mesano(mes_num,ano_num,codsap);
        
        cant_disp = cant_recib - getCant_usada(); 
        try{
        
        sql = "UPDATE tbl_entrada SET ";
        
         sql += "id_centrocosto =" + Integer.parseInt(datos_entrada.getValueAt(fila, 1).toString().trim()) + ",";                    // CC
         sql += "ocexcel ='" + datos_entrada.getValueAt(fila, 3).toString().trim() + "',";                                      // O/C EXCEL
         sql += "nro_factura = '" + datos_entrada.getValueAt(fila, 4).toString().trim() + "',";                                      //NRO FACTURA
         sql += "nro_guia = '" + datos_entrada.getValueAt(fila, 5).toString().trim() + "',";                                      //NRO GUIA
         sql += "fecha_llegada = '" + datos_entrada.getValueAt(fila, 6).toString().trim() + "',";       //FECHA LLEGADA
         sql += "sp = '" + datos_entrada.getValueAt(fila, 7).toString().trim() + "',";                                      //SP
         sql += "uso_equipo = '" + datos_entrada.getValueAt(fila, 8).toString().trim() + "',";                                       //USO EQUIPO
         sql += "codigosap = " + Integer.parseInt(datos_entrada.getValueAt(fila, 9).toString().trim()) + ",";                    // CODIGO SAP
         sql += "descripcion_material = '" + datos_entrada.getValueAt(fila, 10).toString().trim() + "',";                                      //DESCRIPCION MATERIAL
         sql += "nro_parte = '" + datos_entrada.getValueAt(fila, 11).toString().trim() + "',";                                       //NRO PARTE
         sql += "cantidad_recibida = " + Integer.parseInt(datos_entrada.getValueAt(fila, 12).toString().trim()) + ",";                    //CANT RECIBIDA
         sql += "precio_unitario = " + Double.parseDouble(datos_entrada.getValueAt(fila, 13).toString().trim()) + ",";                  //PRECIO UNITARIO $
         sql += "monto_factura = " + Double.parseDouble(datos_entrada.getValueAt(fila, 14).toString().trim()) + ",";                  //MONTO FACTURA ITEM$
         sql += "flete_envio = " + Double.parseDouble(datos_entrada.getValueAt(fila, 15).toString().trim()) + ",";                  //FLETE ENVIO $
         sql += "monto_total = " + Double.parseDouble(datos_entrada.getValueAt(fila, 16).toString().trim()) + ",";                  //MONTO FACTURA TOTAL $
         sql += "valor_dolar = " + Double.parseDouble(datos_entrada.getValueAt(fila, 17).toString().trim()) + ",";                  //VALOR DOLAR $
         sql += "monto_bs = " + Double.parseDouble(datos_entrada.getValueAt(fila, 18).toString().trim()) + ",";                  //MONTO BS
         sql += "monto_flete=" + Double.parseDouble(datos_entrada.getValueAt(fila, 19).toString().trim()) + ",";                  //MONTO FLETE BS
         sql += "cantidad_disp=" + cant_disp + ",";
         sql += "usuario='" + frm_principal.nombre + "',";
         sql += "total_general=" + Double.parseDouble(datos_entrada.getValueAt(fila, 20).toString().trim());                    //TOTAL GENERAL
                
         sql += " WHERE id_stock = " + id_stock + ";";        
                                   
         conexion  cnn = new conexion(sql,"");
         
         verificar_preciosunitario_salida_entrada(mes_num,ano_num,codsap);
         
         cnn.cerrar();
        
         return true;
    }
    catch(NumberFormatException  ex){
        JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACION DE DATOS ");
        return false;
    }
         
        
    }
    
    public Boolean devolver_a_entrada_stock(){
        String sql;
        
        sql = "DELETE FROM tbl_salida WHERE id_salida = "  + getId_salida() + ";"; 
        
        conexion  cnn = new conexion(sql,"");
        
        sql =  "UPDATE tbl_entrada ";
        sql += "SET cantidad_usada = cantidad_usada - " + getCant_usada() + ",cantidad_disp= cantidad_disp + " + getCant_usada();
        sql += " WHERE id_stock = " + getId_stock();
        
        cnn = new conexion(sql,"");
        
        cnn.cerrar();
        
        
        
        return true;
    }

    public Integer getId_stock() {
        return id_stock;
    }

    public void setId_stock(Integer id_stock) {
        this.id_stock = id_stock;
    }

    public Double getFlete_bs() {
        return flete_bs;
    }

    public void setFlete_bs(Double flete_bs) {
        this.flete_bs = flete_bs;
    }

    
    
    public Double getFlete() {
        return flete;
    }

    public void setFlete(Double flete) {
        this.flete = flete;
    }

    public Integer getCantidad_recibida() {
        return cantidad_recibida;
    }

    public void setCantidad_recibida(Integer cantidad_recibida) {
        this.cantidad_recibida = cantidad_recibida;
    }

    
    
    public Integer getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Integer precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    
    
    
    public Integer getCant_usada() {
        return cant_usada;
    }

    public void setCant_usada(Integer cant_usada) {
        this.cant_usada = cant_usada;
    }

    public Integer getCant_disp() {
        return cant_disp;
    }

    public void setCant_disp(Integer cant_disp) {
        this.cant_disp = cant_disp;
    }

    
    
    public Integer getMes_num() {
        return mes_num;
    }

    public void setMes_num(Integer mes_num) {
        this.mes_num = mes_num;
    }

    public Integer getAno_num() {
        return ano_num;
    }

    public void setAno_num(Integer ano_num) {
        this.ano_num = ano_num;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    
    
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    

    public Integer getCantidad_salida() {
        return cantidad_salida;
    }

    public void setCantidad_salida(Integer cantidad_salida) {
        this.cantidad_salida = cantidad_salida;
    }

    public String getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(String fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public String getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(String fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public Integer getCodigosap() {
        return codigosap;
    }

    public void setCodigosap(Integer codigosap) {
        this.codigosap = codigosap;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCentrocosto() {
        return centrocosto;
    }

    public void setCentrocosto(Integer centrocosto) {
        this.centrocosto = centrocosto;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public JTable getTabla_resumen() {
        return datos_entrada;
    }

    public void setTabla_resumen(JTable datos_entrada) {
        this.datos_entrada = datos_entrada;
    }

    public Integer getId_salida() {
        return id_salida;
    }

    public void setId_salida(Integer id_salida) {
        this.id_salida = id_salida;
    }
    
    
    
    public JTable getDatos_entrada() {
        return datos_entrada;
    }

    public void setDatos_salida(JTable datos_entrada) {
        this.datos_entrada = datos_entrada;
    }

    public JTable getDatos_salida() {
        return datos_salida;
    }

    public void setDatos_entrada(JTable datos_entrada) {
        this.datos_entrada = datos_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    
    
}
