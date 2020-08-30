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
public class centrocosto {
    
    private Integer id_centrocosto_actual;
    private Integer id_centrocosto;
    private String descripcion_centrocosto;
    private String sql;
    
    public centrocosto(){
         id_centrocosto=0;
         descripcion_centrocosto="";
         sql="";
    }
    
    public centrocosto(Integer id_centrocosto,Integer consulta) {
        this.id_centrocosto = id_centrocosto;
        this.sql = buscar_sql(consulta);
    }
    
    public centrocosto(Integer id_centrocosto_actual,Integer id_centrocosto,String descripcion_centrocosto,Integer consulta) {
        this.id_centrocosto = id_centrocosto;
        this.id_centrocosto_actual = id_centrocosto_actual;
        this.descripcion_centrocosto = descripcion_centrocosto;
        this.sql = buscar_sql(consulta);
    }
    
    public centrocosto(Integer id_centrocosto, String descripcion_centrocosto,Integer consulta) {
        this.id_centrocosto = id_centrocosto;
        this.descripcion_centrocosto = descripcion_centrocosto;
        this.sql = buscar_sql(consulta);
    }

    public void consulta_cc(JTable table_centrocosto){
        Integer i;
        Integer j;
       
        i = 0;
        sql = "select id_centrocosto,centrocosto from tbl_centrocosto;";
        
        conexion cnn = new conexion(sql,"buscar");
        
        DefaultTableModel modelotabla = (DefaultTableModel) table_centrocosto.getModel();
       
        for(i = modelotabla.getRowCount()-1; i >=0 ;i--){
            modelotabla.removeRow(i);
            table_centrocosto.revalidate();
        } 
        
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
    
    public Boolean actualizar_centrocosto_detalle(){
        
             
           
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
    
    public Boolean buscar_idcentrocosto(){
        
                      
        conexion cnn = new conexion(sql,"buscar");
        
        if (cnn.estado){
            
            try {
                if(cnn.rs.next()){
                    
                    JOptionPane.showMessageDialog(null, "EL NUEVO CODIGO DE CENTRO DE COSTO EXISTE EN LA BASE DE DATOS");                     
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
    
    public Boolean actualizar_centrocosto(){
        
                      
        conexion cnn = new conexion(sql,"buscar");
        
        if (cnn.estado){
            
            try {
                if(cnn.rs.next()){
                    
                    JOptionPane.showMessageDialog(null, "EL CENTRO DE COSTO EXISTE EN LA BASE DE DATOS");                     
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
           
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL CENTRO DE COSTO SATISFACTORIA");
             cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL CENTRO DE COSTO");
            cnn.cerrar();
            return false;
        }
       
    }
    
    public String buscar_sql(Integer sql) {
        String consulta="";
        
        switch (sql){
            case 1:
                 consulta = "INSERT INTO tbl_centrocosto VALUES(" + id_centrocosto + ",'"  + descripcion_centrocosto + "');";
       
                break;  
            case 2:
                 consulta = "SELECT centrocosto FROM tbl_centrocosto WHERE id_centrocosto = " + id_centrocosto + ";";
       
                break;    
                
            case 3:
                
                consulta = "UPDATE tbl_centrocosto SET id_centrocosto =" + id_centrocosto + ",centrocosto='" + descripcion_centrocosto + "' WHERE id_centrocosto = '" + id_centrocosto_actual + "';";
                
                break;    
                
            /*case 4:
                
                consulta = "SELECT equipo,codigofapco,marca,modelo,ubicacion,carroceria,b.centrocosto as descripcion_centrocosto,b.descripcion as descripciona_area,";
                consulta += "c.descripcion as descripciona_estatus,d.descripcion as descripcion_propiedad "; 
                consulta +="FROM tbl_equipo a ";
                consulta +="INNER JOIN tbl_centrocosto b ON ";
                consulta +="a.fk_centrocosto = b.id_centrocosto ";
                consulta +="INNER JOIN tbl_estatus c ON ";
                consulta +="a.fk_estatus = c.id_estatus ";
                consulta +="INNER JOIN tbl_propiedad d ON ";
                consulta +="a.fk_propiedad = d.id_propiedad ";
                consulta +="WHERE equipo = '" + equipo + "';";
                
                break; */   
                
        }
        return consulta;
         
    }

    public Integer getId_centrocosto_actual() {
        return id_centrocosto_actual;
    }

    public void setId_centrocosto_actual(Integer id_centrocosto_actual) {
        this.id_centrocosto_actual = id_centrocosto_actual;
    }
    
    
    public Integer getId_centrocosto() {
        return id_centrocosto;
    }

    public void setId_centrocosto(Integer id_centrocosto) {
        this.id_centrocosto = id_centrocosto;
    }

    public String getDescripcion_centrocosto() {
        return descripcion_centrocosto;
    }

    public void setDescripcion_centrocosto(String descripcion_centrocosto) {
        this.descripcion_centrocosto = descripcion_centrocosto;
    }
    
    
}
