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
public class servicio {
    
    private Integer id_servicio;
    private String descripcion_servicio;
    private String sql;
    
    public servicio(){
         id_servicio=0;
         descripcion_servicio="";
         sql="";
    }
    
   
    
    public servicio(String descripcion_servicio,Integer consulta) {
        this.descripcion_servicio = descripcion_servicio;
        this.sql = buscar_sql(consulta);
    }
    
    public servicio(Integer id_servicio, String descripcion_servicio,Integer consulta) {
        this.id_servicio = id_servicio;
        this.descripcion_servicio = descripcion_servicio;
        this.sql = buscar_sql(consulta);
    }

    public void consulta_servicio(JTable table_centrocosto){
        Integer i;
        Integer j;
       
        i = 0;
        sql = "select id_servicio,descripcion from tbl_servicio;";
        
        conexion cnn = new conexion(sql,"buscar");
        
        DefaultTableModel modelotabla = (DefaultTableModel) table_centrocosto.getModel();
       
        modelotabla.setRowCount(0);
        /*for(i = modelotabla.getRowCount()-1; i >=0 ;i--){
            modelotabla.removeRow(i);
            table_centrocosto.revalidate();
        } */
        
        if (cnn.estado){
            
            try{
                while(cnn.rs.next()){
                    modelotabla.addRow(new Object[]{
                        cnn.rs.getInt(1),
                        cnn.rs.getString(2)
                     });
                }
     
            } 
            catch (SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());   
                cnn.cerrar();
            }    
        }   
        else{
             cnn.cerrar();
        }
   
   }
    
    public Boolean actualizar_servicio_detalle(){
        
             
           
        conexion cnn = new conexion(sql,"");
        
        if (cnn.estado){
           
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL CENTRO DE COSTO SATISFACTORIA");
            cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN  DEL CENTRO DE COSTO ");
            cnn.cerrar();
            return false;
        }
       
    }
    
    public Boolean buscar_idservicio(){
        
                      
        conexion cnn = new conexion(sql,"buscar");
        
        if (cnn.estado){
            
            try {
                if(cnn.rs.next()){
                    
                    JOptionPane.showMessageDialog(null, "EL NUEVO SERVICIO EXISTE EN LA BASE DE DATOS");                     
                    return false;
                }
                else{
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
        
    }
    
    public Boolean actualizar_servicio(){
        
                      
        conexion cnn = new conexion(sql,"buscar");
        
        if (cnn.estado){
            
            try {
                if(cnn.rs.next()){
                    
                    JOptionPane.showMessageDialog(null, "EL SERVICIO EXISTE EN LA BASE DE DATOS");                     
                    return false;
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
        
        
        this.sql = buscar_sql(1);
        
          
        cnn = new conexion(sql,"");
        
        if (cnn.estado){
           
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL SERVICIO SATISFACTORIA");
             cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL SERVICIO");
            cnn.cerrar();
            return false;
        }
       
    }
    
    public String buscar_sql(Integer sql) {
        String consulta="";
        
        switch (sql){
            case 1:
                 consulta = "INSERT INTO tbl_servicio VALUES(DEFAULT,'"  + descripcion_servicio + "');";
       
                break;  
            case 2:
                 consulta = "SELECT descripcion FROM tbl_servicio WHERE descripcion = '" + descripcion_servicio + "';";
       
                break;    
                
            case 3:
                
                consulta = "UPDATE tbl_servicio SET descripcion='" + descripcion_servicio + "' WHERE id_servicio = " + id_servicio + ";";
                
                break;    
                
            
        }
        return consulta;
         
    }

    public Integer getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    
    
}
