
package sistock;


import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class usuario {
    
    private  Integer cedula;
    private  String nombres;
    private  String usuario;
    private  String password;
    private  String sql;
    private  Integer nivel;
    private  Boolean status;


    public String buscar_nombre(){
        
  
        sql = "SELECT nombres FROM tbl_usuario WHERE usuario = '" + usuario + "';";
       
      
        conexion cnn = new conexion(sql,"buscar");
        
         if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    nombres = cnn.rs.getString(1);
                    cnn.cerrar(); 
                    return nombres;
                }    
                else{
                    cnn.cerrar(); 
                    return null;
                }
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                return null;
             }

         }
         else{
             return null;
         }
    }   
    
    
    private  String encriptar(String cadena){
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword("uniquekey");
        return s.encrypt(cadena);
    }
  
    private  String desencriptar(String cadena){
        
        
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword("uniquekey");
        String cadena_original="";
        
        try{
            cadena_original = s.decrypt(cadena);
        }
        catch(Exception e){
            
        }
        
        return cadena_original;
    }

    public  boolean actualizar_usuario(){
        
        
        sql = "select usuario from tbl_usuario where usuario = '" + usuario.trim() + "'";
        
        conexion cnn = new conexion(sql,"buscar");
        
        if (cnn.estado){
            
            try {
                if(cnn.rs.next()){
                    
                    JOptionPane.showMessageDialog(null, "EL USUARIO EXISTE EN LA BASE DE DATOS");                     
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
        
        
        this.sql = "insert into tbl_usuario values(" + cedula + ",'" + nombres.toUpperCase() + "','"  + usuario + "','" + encriptar(password) + "'," + nivel + "," + status + ")" ;
        
          
        cnn = new conexion(sql,"");
        
        if (cnn.estado){
           
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL USUARIO SATISFACTORIA");
             cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL USUARIO");
            cnn.cerrar();
            return false;
        }
       
    }
    
    public  boolean actualizar_usuario_detalle(){
        
             
        this.sql = this.sql + "'" + encriptar(password) +  "',nivel=" + nivel +  ",status=" + status + " where usuario = '" + usuario + "'";
        
        System.out.println(sql);     
        conexion cnn = new conexion(sql,"");
        
        if (cnn.estado){
           
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL USUARIO SATISFACTORIA");
            cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL USUARIO");
            cnn.cerrar();
            return false;
        }
       
    }

      
    
   public  Boolean buscar_cedula_usuario(){
        
  
        sql = sql + cedula ;
       
        conexion cnn = new conexion(sql,"buscar");
        
         if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    cedula = cnn.rs.getInt(1);
                    nombres = cnn.rs.getString(2);
                    usuario = cnn.rs.getString(3);
                    password = this.desencriptar(cnn.rs.getString(4));
                    status = cnn.rs.getBoolean(5);
                    nivel = cnn.rs.getInt(6);
                    
                    cnn.cerrar(); 
                    return true;
                }    
                else{
                    cnn.cerrar(); 
                    JOptionPane.showMessageDialog(null, "EL USUARIO NO EXISTE EN LA BASE DE DATOS");
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
    
   
   public  Boolean actualizar_usuario_status(){
   
        this.sql = this.sql + cedula;
        
          
        conexion cnn = new conexion(sql,"");
        
        if (cnn.estado){
           
            JOptionPane.showMessageDialog(null, "ACTUALIZACIÓN DEL USUARIO SATISFACTORIA");
             cnn.cerrar();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR EN LA ACTUALIZACIÓN DEL USUARIO");
            cnn.cerrar();
            return false;
        }
   
   }
    
   public  Integer getnivelusuario(){
   
      
         sql = "select a.nivel from tbl_usuario a where a.usuario = '" + usuario + "';" ;
       
        conexion cnn = new conexion(sql,"buscar");
        
         if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    nivel = cnn.rs.getInt(1);
                    cnn.cerrar(); 
                    return nivel;
                    
                }
                else{
                    cnn.cerrar();
                    return 2;                 
                }
                
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                return 2;
            }

         }
         else{
             return 2;
         }
   
   }
   
    public Integer getcedulausuario(){
   
      
         sql += usuario + "';";
       
        conexion cnn = new conexion(sql,"buscar");
        
         if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    cedula = cnn.rs.getInt(1);
                    cnn.cerrar(); 
                    return cedula;
                    
                }
                else{
                    cnn.cerrar();
                    return 0;                 
                }
                
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                return 0;
            }

         }
         else{
             return 2;
         }
   
   }
    
     public Integer getcedulanombres(){
   
      
         sql = "select a.cedula from tbl_usuario a where a.nombres = '" + nombres.trim() + "'" ;
       
        conexion cnn = new conexion(sql,"buscar");
        
         if (cnn.estado){
             try{
                if(cnn.rs.next()){
                    cedula = cnn.rs.getInt(1);
                    cnn.cerrar(); 
                    return cedula;
                    
                }
                else{
                    cnn.cerrar();
                    return 0;                 
                }
                
             }
             catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                cnn.cerrar();
                return 0;
            }

         }
         else{
             return 2;
         }
   
   }
   
   
   
    public  Boolean verificar(){
        
       
                
        sql = sql + "a.usuario = '" + usuario + "'" + " and status=true" ;
       
        conexion cnn = new conexion(sql,"buscar");
        
         if (cnn.estado){
             try{
                if(cnn.rs.next()){
                   
                    if (this.desencriptar(cnn.rs.getString(1)).equals(password)){
                        cnn.cerrar(); 
                        return true;
                    }    
                    else{
                        cnn.cerrar(); 
                        return false;
                    }
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

    public usuario(String usuario,String sql) {
        this.usuario = usuario;
        this.sql = sql;
    }

    public usuario(String nombres) {
        this.nombres = nombres;
    }
     
  
    
    
    
     public usuario(String usuario, String password, String sql){
        this.usuario = usuario;
        this.password = password;
        this.sql = sql;
    }
    
    public usuario(Integer cedula,String nombres,String usuario, String password,Integer nivel,Boolean status, String sql){
        this.cedula = cedula;
        this.nombres = nombres;
        this.usuario = usuario;
        this.password = password;
        this.nivel = nivel;
        this.status = status;
        this.sql = sql;
    }
    
    public usuario(Integer cedula, String sql){
        this.cedula = cedula;
        this.sql = sql;
    } 
    
    
    public  Integer getcedula(){
        return cedula;
    }

    public  void setcedula(Integer cedula){
        this.cedula = cedula;
    }
    
    public  String getusuario(){
        return usuario;
    }

    public  void setusuario(String usuario){
        this.usuario = usuario;
    }

    public  String getpassword(){
        return password;
    }

    public  void setpassword(String password){
        this.password = password;
    }
    
    public  Boolean getstatus(){
        return status;
    }

    public  void setstatus(Boolean status){
        this.status = status;
    }

    public  Integer getnivel(){
        return nivel;
    }

    public  void setnivel(Integer nivel){
        this.nivel = nivel;
    }
    
     public  String getNombres() {
        return nombres;
    }

    public  void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
   
}
