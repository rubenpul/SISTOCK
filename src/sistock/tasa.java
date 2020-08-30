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
public class tasa {
    
    private Integer id_tasa;
    private Integer mes;
    private Integer ano;
    private String fechadesde;
    private String fechahasta;
    private Integer tasa;
    private String usuario;
    private String sql;
    
    public tasa(Integer id_tasa, Integer mes, Integer ano, String fechadesde, String fechahasta, Integer tasa, String usuario) {
        this.id_tasa = id_tasa;
        this.mes = mes;
        this.ano = ano;
        this.fechadesde = fechadesde;
        this.fechahasta = fechahasta;
        this.tasa = tasa;
        this.usuario = usuario;
        this.sql = "";
    }
    
    public tasa buscar_tasa() throws SQLException{
        
        buscar_sql(1);
        conexion cnn = new conexion(sql,"buscar");
        tasa modelo_tasa = new tasa(0,0,0,"","",0,"");
        
      
        
        if (cnn.estado){
            if(cnn.rs.next()){
                modelo_tasa.setId_tasa(cnn.rs.getInt(1));
                modelo_tasa.setFechadesde(cnn.rs.getString(2));
                modelo_tasa.setFechahasta(cnn.rs.getString(3));
                modelo_tasa.setTasa(cnn.rs.getInt(4));
            }
            else{
                modelo_tasa.setId_tasa(0);
            }
            cnn.cerrar();
                    
            return modelo_tasa;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL REGISTRO A TALLER");
            cnn.cerrar();
            modelo_tasa.setId_tasa(0);
            return modelo_tasa;
        }
        
    }

    public Boolean guardar_tasa(){
        buscar_sql(2);
        
        conexion cnn = new conexion(sql,"");
        
        if (cnn.estado){
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL REGISTRO DE LA TASA SATISFACTORIA");
            cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL REGISTRO DE LA TASA");
            cnn.cerrar();
        
            return false;
        }
        
        
    }
    
        public Boolean actualizar_tasa(){
        buscar_sql(3);
        
        conexion cnn = new conexion(sql,"");
        
        if (cnn.estado){
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL REGISTRO DE LA TASA SATISFACTORIA");
            cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL REGISTRO DE LA TASA");
            cnn.cerrar();
        
            return false;
        }
        
        
    }
    
    public Integer consultar_tasa() throws SQLException{
        buscar_sql(4);
        
        conexion cnn = new conexion(sql,"buscar"); 
        
        if (cnn.estado){
            if(cnn.rs.next()){
                setTasa(cnn.rs.getInt(1));
            }
            else{
                setTasa(0);
            }
            cnn.cerrar();
           
            return getTasa();
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN CONSULTA DE LA TASA EN LA BASE DE DATOS");
            cnn.cerrar();
            setTasa(0);
            return  getTasa();
        }
      
    }
    
    public void buscar_sql(Integer consulta){
        
        switch (consulta){
            case 1: sql = "SELECT id_tasa,fechadesde,fechahasta,tasa FROM tbl_tasa WHERE mes = " + getMes() + " AND ano =  " + getAno() + ";";
            break;
            
            case 2: sql = "INSERT INTO tbl_tasa VALUES(DEFAULT," + getMes() + "," + getAno() + ",'" + getFechadesde() + "','" + getFechahasta() + "'," + getTasa() + ",'" + getUsuario() + "');";
            break;
            
            case 3: sql = "UPDATE tbl_tasa SET fechadesde = '" + getFechadesde() + "',fechahasta='" + getFechahasta() + "',tasa=" + getTasa() + ",usuario='" + getUsuario() + "' WHERE id_tasa = " + getId_tasa() + ";";
            break;
            
            case 4: sql = "SELECT tasa ";
                    sql += "FROM tbl_tasa ";
                    sql += "WHERE '" + getFechadesde() + "' BETWEEN fechadesde  AND fechahasta; ";
                    
            break;


        }
    }
    public Integer getId_tasa() {
        return id_tasa;
    }

    public void setId_tasa(Integer id_tasa) {
        this.id_tasa = id_tasa;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getFechadesde() {
        return fechadesde;
    }

    public void setFechadesde(String fechadesde) {
        this.fechadesde = fechadesde;
    }

    public String getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(String fechahasta) {
        this.fechahasta = fechahasta;
    }

    public Integer getTasa() {
        return tasa;
    }

    public void setTasa(Integer tasa) {
        this.tasa = tasa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
