/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ruben
 */
public class equipo {
    
    private Integer id_equipo;
    private String equipo;
    private String codigofapco;
    private String marca;
    private String modelo;
    private String ubicacion;
    private String carroceria;
    private Integer id_centrocosto;
    private Integer area; 
    private String descripcion_centrocosto;
    private Integer estatus; 
    private String descripcion_estatus;
    private Integer propiedad;
    private String descripcion_propiedad;
    private String sql;

    public equipo(String equipo, Integer consulta) {
        this.equipo = equipo;
        this.sql = buscar_sql(consulta);
    }

    public equipo(Integer id_equipo, Integer consulta) {
        this.id_equipo = id_equipo;
        this.sql = buscar_sql(consulta);
    }
   
    
    
    public equipo(String equipo, String codigofapco, String marca, String modelo, String ubicacion, String carroceria,Integer id_centrocosto, Integer estatus, Integer propiedad, Integer consulta) {
        this.equipo = equipo;
        this.codigofapco = codigofapco;
        this.marca = marca;
        this.modelo = modelo;
        this.ubicacion = ubicacion;
        this.carroceria = carroceria;
        this.id_centrocosto = id_centrocosto;
        this.estatus = estatus;
        this.propiedad = propiedad;
        this.sql = buscar_sql(consulta);
    }

    public Boolean buscar_equipo(){
        
        conexion cnn = new conexion(sql,"buscar");
        
         if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    equipo = cnn.rs.getString(1);
                    codigofapco = cnn.rs.getString(2);
                    marca = cnn.rs.getString(3);
                    modelo = cnn.rs.getString(4);
                    ubicacion = cnn.rs.getString(5);
                    carroceria = cnn.rs.getString(6);
                    descripcion_centrocosto = cnn.rs.getString(7);
                    descripcion_estatus = cnn.rs.getString(8);
                    descripcion_propiedad = cnn.rs.getString(9);
                    cnn.cerrar(); 
                    return true;
                }    
                else{
                    cnn.cerrar(); 
                    JOptionPane.showMessageDialog(null, "EL EQUIPO NO EXISTE EN LA BASE DE DATOS");
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
             return false;
         }
    }    
    
    public Boolean buscar_cc_equipo(){
        
        conexion cnn = new conexion(sql,"buscar");
        
         if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    id_centrocosto = cnn.rs.getInt(1);
                    descripcion_centrocosto = cnn.rs.getString(2);
                    cnn.cerrar(); 
                    return true;
                }    
                else{
                    cnn.cerrar(); 
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
             return false;
         }
    }    
    
    
    public Boolean actualizar_equipo_detalle(){
        
             
           
        conexion cnn = new conexion(sql,"");
        
        if (cnn.estado){
           
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL EQUIPO SATISFACTORIA");
            cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL EQUIPO");
            cnn.cerrar();
            return false;
        }
       
    }
    
    
    public Boolean actualizar_equipo(){
        
                      
        conexion cnn = new conexion(sql,"buscar");
        
        if (cnn.estado){
            
            try {
                if(cnn.rs.next()){
                    
                    JOptionPane.showMessageDialog(null, "EL EQUIPO EXISTE EN LA BASE DE DATOS");                     
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
           
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL EQUIPO SATISFACTORIA");
             cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL EQUIPO");
            cnn.cerrar();
            return false;
        }
       
    }
    
    public boolean buscar_descripcion_equipo(){
        
        conexion cnn = new conexion(sql,"buscar");
        
        if (cnn.estado){
            
            try {
                if(cnn.rs.next()){
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
    
     public String buscar_sql(Integer sql) {
        String consulta="";
        
        switch (sql){
            case 1:
                 consulta = "INSERT INTO tbl_equipo VALUES(DEFAULT,'" + equipo + "','"  + codigofapco + "','" + marca + "','" + modelo + "','" + ubicacion + "','" + carroceria + "'," + id_centrocosto + "," + estatus + "," + propiedad + ");";
                 
                break;  
            case 2:
                 consulta = "SELECT equipo FROM tbl_equipo WHERE equipo = '" + equipo + "';";
       
                break;    
                
            case 3:
                
                consulta = "UPDATE tbl_equipo SET equipo ='" + equipo + "',codigofapco='" + codigofapco + "',marca='" + marca + "',modelo='" + modelo + "',ubicacion='" + ubicacion + "',carroceria='" + carroceria + "',fk_centrocosto=" + id_centrocosto + ",fk_estatus=" + estatus + ",fk_propiedad=" + propiedad + " WHERE equipo = '" + equipo + "';";
                
                break;    
                
            case 4:
                
                consulta = "SELECT equipo,codigofapco,marca,modelo,ubicacion,carroceria,b.centrocosto as descripcion_centrocosto,";
                consulta += "c.descripcion as descripciona_estatus,d.descripcion as descripcion_propiedad "; 
                consulta +="FROM tbl_equipo a ";
                consulta +="INNER JOIN tbl_centrocosto b ON ";
                consulta +="a.fk_centrocosto = b.id_centrocosto ";
                consulta +="INNER JOIN tbl_estatus c ON ";
                consulta +="a.fk_estatus = c.id_estatus ";
                consulta +="INNER JOIN tbl_propiedad d ON ";
                consulta +="a.fk_propiedad = d.id_propiedad ";
                consulta +="WHERE equipo = '" + equipo + "';";
                
                break;  
                
            case 5:
                
                consulta = "SELECT a.fk_centrocosto,b.centrocosto "; 
                consulta += "FROM tbl_equipo a ";
                consulta += "INNER JOIN tbl_centrocosto b ON ";
                consulta += "a.fk_centrocosto = b.id_centrocosto ";
                consulta += "WHERE a.id_equipo = " + id_equipo + ";"; 
       
                break;     
           
             case 6:
                
                consulta = "SELECT a.fk_centrocosto,b.centrocosto "; 
                consulta += "FROM tbl_equipo a ";
                consulta += "INNER JOIN tbl_centrocosto b ON ";
                consulta += "a.fk_centrocosto = b.id_centrocosto ";
                consulta += "WHERE a.equipo = '" + equipo + "';"; 
       
                break;        
                
        }
        return consulta;
         
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

  
    public String getDescripcion_estatus() {
        return descripcion_estatus;
    }

    public void setDescripcion_estatus(String descripcion_estatus) {
        this.descripcion_estatus = descripcion_estatus;
    }

    public String getDescripcion_propiedad() {
        return descripcion_propiedad;
    }

    public void setDescripcion_propiedad(String descripcion_propiedad) {
        this.descripcion_propiedad = descripcion_propiedad;
    }

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getCodigofapco() {
        return codigofapco;
    }

    public void setCodigofapco(String codigofapco) {
        this.codigofapco = codigofapco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Integer getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Integer propiedad) {
        this.propiedad = propiedad;
    }
    
    
    
    
}
